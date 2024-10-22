package services;

import entities.Venda;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class VendaService extends EntityService<Venda> {
    public VendaService() { super(Venda.class); }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }

   
}