package beans;


import entities.Venda;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import services.VendaService;

@Named(value = "vendaBean")
@ViewScoped
public class VendaBean implements Serializable {

    @EJB
    private VendaService vendaService;
    @Inject
    private RequestParameters parameters;
    private boolean consultar;
    private Venda value;
    
    List<Venda> vendasFiltradas;

    public SelectItem[] getOptionsPossuiGarantia() {
        return new SelectItem[]{
            new SelectItem(String.valueOf(""), ""),
            new SelectItem(Boolean.TRUE.toString(), "sim"),
            new SelectItem(Boolean.FALSE.toString(), "não")
        };
    }

    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) {
            value = new Venda();
        } else {
            value = vendaService.find(Long.valueOf(id));
        }
    }

    public SelectItem[] getFormaPagamento(boolean filtrar) {
        SelectItem[] items;
        int length = Venda.FormaPagamento.values().length;
        int n = 0;

        if (filtrar) {
            items = new SelectItem[length + 1];
            items[0] = new SelectItem("", "");
            n++;
        } else {
            items = new SelectItem[length];
        }

        for (Venda.FormaPagamento tipo : Venda.FormaPagamento.values()) {
            items[n++] = new SelectItem(tipo, tipo.getLabel());
        }

        return items;
    }
    
    


    public void reset() {
        value = new Venda();
    }

    public void inserir() {
        if (this.consultar) {
            this.consultar = false;
        }
        reset();
    }

    public List<Venda> getAll() {
        return vendaService.getAll();
    }

    public String save() {
        vendaService.create(value);
        reset();
        return null;
    }

    public String update() {
        vendaService.edit(value);
        return null;
    }

    public String delete() {
        vendaService.remove(value);
        return null;
    }

  

    public void setParameters(RequestParameters parameters) {
        this.parameters = parameters;
    }

    public void consultar(Venda value) {
        setValue(value);
        this.consultar = true;
    }

    public VendaService getVendaService() {
        return vendaService;
    }

    public void setVendaService(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public Venda getValue() {
        return value;
    }

    public void setValue(Venda value) {
        this.value = value;
    }

    public List<Venda> getVendasFiltradas() {
        return vendasFiltradas;
    }

    public void setVendasFiltradas(List<Venda> vendasFiltradas) {
        this.vendasFiltradas = vendasFiltradas;
    }

}
