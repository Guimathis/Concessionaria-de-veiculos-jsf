package converters;

import entities.Veiculo;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Veiculo.class)
@Named
public class VeiculoConverter extends EntityConverter<Veiculo> {

    public VeiculoConverter() {
        super(Veiculo.class);
    }
}