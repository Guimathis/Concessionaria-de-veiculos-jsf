package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Venda implements Serializable, PersistentEntity {
    @Temporal(TemporalType.TIME) private Date dataHora = new Date();
    
    public enum FormaPagamento{
        dinheiro("Dinheiro"), cartao("Cartão"), cheque("Cheque"), financiamento("Financiamento"), pix("Pix");
        private final String label;

        private FormaPagamento(String label) {
            this.label = label;
        }

        public String getLabel() {
            return this.label;
        }
    };

    private FormaPagamento formaPagamento;
    private boolean possuiGarantia;
    
    
    @ManyToOne
    private Cliente cliente;

    @ManyToMany
    private List<Veiculo> veiculos;
    
    
     public void addVeiculo(Veiculo veiculo) { veiculos.add(veiculo); }
      
      
     
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }


    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public boolean isPossuiGarantia() {
        return possuiGarantia;
    }

    public void setPossuiGarantia(boolean possuiGarantia) {
        this.possuiGarantia = possuiGarantia;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
    
    
 
    
}
    
