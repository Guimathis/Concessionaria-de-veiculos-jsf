package entities;

import entities.Cliente;
import entities.Veiculo;
import entities.Venda.FormaPagamento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150916-rNA", date="2024-10-22T09:15:24")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, FormaPagamento> formaPagamento;
    public static volatile SingularAttribute<Venda, Cliente> cliente;
    public static volatile ListAttribute<Venda, Veiculo> veiculos;
    public static volatile SingularAttribute<Venda, Long> id;
    public static volatile SingularAttribute<Venda, Boolean> possuiGarantia;
    public static volatile SingularAttribute<Venda, Date> dataHora;

}