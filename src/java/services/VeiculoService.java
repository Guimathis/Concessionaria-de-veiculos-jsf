package services;

import entities.Veiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Stateless
public class VeiculoService extends EntityService<Veiculo> {
    public VeiculoService() { super(Veiculo.class); }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
    public List<Veiculo> filter(String prefix) {
        prefix += "%";
        Query query = em.createQuery("SELECT veiculo from Veiculo veiculo WHERE veiculo.modelo LIKE :prefix");
        query.setParameter("prefix", prefix);
        return query.getResultList();
    }

   
}