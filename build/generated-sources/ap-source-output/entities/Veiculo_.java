package entities;

import entities.Veiculo.TipoVeiculo;
import entities.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150916-rNA", date="2024-10-22T09:15:24")
@StaticMetamodel(Veiculo.class)
public class Veiculo_ { 

    public static volatile SingularAttribute<Veiculo, String> estado;
    public static volatile SingularAttribute<Veiculo, TipoVeiculo> tipo;
    public static volatile ListAttribute<Veiculo, Venda> vendas;
    public static volatile SingularAttribute<Veiculo, Long> id;
    public static volatile SingularAttribute<Veiculo, String> modelo;

}