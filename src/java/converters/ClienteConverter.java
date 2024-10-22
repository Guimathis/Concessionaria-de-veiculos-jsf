package converters;

import entities.Cliente;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Cliente.class)
@Named
public class ClienteConverter extends EntityConverter<Cliente> {
    
    public ClienteConverter() {
        super(Cliente.class);
    }
}
