package converters;

import entities.PersistentEntity;
import services.EntityFinder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public abstract class EntityConverter<T> implements Converter {

    EntityFinder entityFinder = lookupEntityFinder();
    private Class<T> entityClass;

    public EntityConverter(Class<T> entityClass) {
        this.entityClass = entityClass;

    }

    private EntityFinder lookupEntityFinder() {
        try {
            Context c = new InitialContext();
            return (EntityFinder) c.lookup("java:global/ConcessionariaVeiculosOR/EntityFinder!services.EntityFinder");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);

        }
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Long id = Long.valueOf(value);
            return entityFinder.find(entityClass, id);
        }catch (NumberFormatException e) { throw new ConverterException ("formato de ID invalido", e) ; }
    }
           
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((PersistentEntity) value) .getId () . toString ();    
    }
    
    
    
    
    
    
}
