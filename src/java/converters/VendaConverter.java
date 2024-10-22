package converters;

import entities.Venda;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Venda.class)
@Named
public class VendaConverter extends EntityConverter<Venda> {
    
    public VendaConverter() {
        super(Venda.class);
    }
}