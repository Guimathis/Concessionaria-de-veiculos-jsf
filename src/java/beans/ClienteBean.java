package beans;

import entities.Cliente;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.FlowEvent;
import services.ClienteService;

@Named(value = "clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {

    @EJB
    private ClienteService clienteService;
    @Inject
    private RequestParameters parameters;
    private Cliente value;
    private boolean consultar;
    List<Cliente> clientesFiltrados;

    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) {
            value = new Cliente();
        } else {
            value = clienteService.find(Long.valueOf(id));
        }
    }
    public List<Cliente> completaClientes(String prefixo) {
        return clienteService.filter(prefixo);
    }
    public List<Cliente> getClientesFiltrados() {
        return clientesFiltrados;
    }

    public void setClientesFiltrados(List<Cliente> amigosFiltrados) {
        this.clientesFiltrados = amigosFiltrados;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService amigoService) {
        this.clienteService = amigoService;
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

    public void consultar(Cliente value) {
        setValue(value);
        this.consultar = true;
    }

    public Cliente getValue() {
        return value;
    }

    public void setValue(Cliente value) {
        this.value = value;
    }

    public void reset() {
        value = new Cliente();
    }

    public void inserir() {
        if(this.consultar) this.consultar = false;
        reset();
    }

    public List<Cliente> getAll() {
        return clienteService.getAll();
    }

    public String save() {
        clienteService.create(value);
        reset();
        return null;
    }

    public String update() {
        clienteService.edit(value);
        return null;
    }

    public String delete() {
        clienteService.remove(value);
        if(this.consultar) this.consultar = false;
        return null;
    }

    public SelectItem[] getEstadosCivis(boolean filtrar) {
        SelectItem[] items;
        int length = Cliente.EstadoCivil.values().length;
        int n = 0;
        if (filtrar) {
            items = new SelectItem[length + 1];
            items[0] = new SelectItem("", "");
            n++;
        } else {
            items = new SelectItem[length];
        }
        for (Cliente.EstadoCivil estado_Civil : Cliente.EstadoCivil.values()) {
            items[n++] = new SelectItem(estado_Civil, estado_Civil.getLabel());
        }
        return items;
    }

    public SelectItem[] getSexo(boolean filtrar) {
        SelectItem[] items;
        int n = 0;
        if (filtrar) {
            items = new SelectItem[3];
            items[0] = new SelectItem("", "");
            n++;
        } else 
            items = new SelectItem[2];{
        items[n ++] = new SelectItem("feminino", "Feminino");
        items[n] = new SelectItem("masculino", "Masculino");
        }
        return items;
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

}
