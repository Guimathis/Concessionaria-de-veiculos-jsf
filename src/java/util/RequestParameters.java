package util;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

public class RequestParameters implements Serializable {

    private Map<String, String> params;

    @PostConstruct
    public void init() {
        FacesContext faces_context = FacesContext.getCurrentInstance();
        params = faces_context.getExternalContext().getRequestParameterMap();
    }
    public String get(String param) {
        return params.get(param);
    }
}
