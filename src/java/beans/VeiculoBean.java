package beans;


import entities.Veiculo;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import services.VeiculoService;

@Named(value = "veiculoBean")
@ViewScoped

public class VeiculoBean implements Serializable {
 
    @EJB
    private VeiculoService veiculoService;
    
    @Inject
    private RequestParameters parameters;
    private boolean consultar;
    private Veiculo value;
    List<Veiculo> veiculosFiltrados;

    public List<Veiculo> completaVeiculos(String prefixo) {
        return veiculoService.filter(prefixo);
    }
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) {
            value = new Veiculo();
        } else {
            value = veiculoService.find(Long.valueOf(id));
        }
    }
    public SelectItem[] getEstado(boolean filtrar) {
        SelectItem[] items;
        int n = 0;
        if (filtrar) {
            items = new SelectItem[3];
            items[0] = new SelectItem("", "");
            n++;
        } else 
            items = new SelectItem[2];{
        items[n ++] = new SelectItem("novo", "Novo");
        items[n] = new SelectItem("usado", "Usado");
        }
        return items;
    }
    
    public SelectItem[] getTipos(boolean filtrar) {
        SelectItem[] items;
        int length = Veiculo.TipoVeiculo.values().length;
        int n = 0;
        
        if (filtrar) {
            items = new SelectItem[length + 1];
            items[0] = new SelectItem("", "");
            n++;
        } else items = new SelectItem[length];
        
        for(Veiculo.TipoVeiculo tipo : Veiculo.TipoVeiculo.values()) {
            items[n++] = new SelectItem(tipo, tipo.getLabel());
        }
        
        return items;
    }
    
   public void consultar(Veiculo value) {
        setValue(value);
        this.consultar = true;
    }

    public Veiculo getValue() {
        return value;
    }

    public void setValue(Veiculo value) {
        this.value = value;
    }

    public void reset() {
        value = new Veiculo();
    }

    public void inserir() {
        reset();
        if(this.consultar) this.consultar = false;
    }

    public List<Veiculo> getAll() {
        return veiculoService.getAll();
    }

    public String save() {
        veiculoService.create(value);
        reset();
        return null;
    }

    public String update() {
        veiculoService.edit(value);
        return null;
    }

    public String delete() {
        veiculoService.remove(value);
        
        return null;
    }

    public VeiculoService getVeiculoService() {
        return veiculoService;
    }

    public void setVeiculoService(VeiculoService diretorService) {
        this.veiculoService = diretorService;
    }

    public RequestParameters getParameters() {
        return parameters;
    }

    public void setParameters(RequestParameters parameters) {
        this.parameters = parameters;
    }

    public boolean isConsultar() {
        boolean consultar = this.consultar;
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<Veiculo> getVeiculosFiltrados() {
        return veiculosFiltrados;
    }

    public void setVeiculosFiltrados(List<Veiculo> veiculosFiltrados) {
        this.veiculosFiltrados = veiculosFiltrados;
    }
    

 }
