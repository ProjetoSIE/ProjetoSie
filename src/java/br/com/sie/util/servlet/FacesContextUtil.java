package br.com.sie.util.servlet;

//import utilidades.AdemFaceletViewHandler;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author denisd
 */
public class FacesContextUtil implements java.io.Serializable {
            
    public FacesContext fc() {
        return FacesContext.getCurrentInstance();
    }
    
    protected String getContextParam(String name) {
        return (String) fc().getExternalContext().getApplicationMap().get(name);
    }
    
    public HttpSession getSession(boolean create) {
        return (HttpSession) fc().getExternalContext().getSession(create);
    }
    
    private Map<String, Object> sessionMap() {
        fc().getExternalContext().getSession(false);
        return fc().getExternalContext().getSessionMap();
    }

    public void putOnSessionMap(String key, Object value) {
        synchronized (this) {
            sessionMap().put(key, value);
        }
    }
    
    public Object getFromSessionMap(String key) {
        synchronized (this) {
            return sessionMap().get(key);
        }
    }
    
    public Object removeFromSessionMap(String key) {
        synchronized (this) {
            return sessionMap().remove(key);
        }
    }
    
    public HttpServletRequest request() {
        return (HttpServletRequest) fc().getExternalContext().getRequest();
    }
    
    public void forwardRequestDispatcher(String outcome) {
        try {
            request().getRequestDispatcher(outcome).forward(request(), response());
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } catch (ServletException sex) {
            sex.printStackTrace();
        }
    }       
    
    public Object getRequestAttribute(String key){
        return request().getAttribute(key);
    }
    
    public Locale getLocale(){
        return request().getLocale();
    }            
    
    public HttpServletResponse response() {
        return (HttpServletResponse) fc().getExternalContext().getResponse();
    }
    
    public void sendRedirect(String location) {
        try {
            response().sendRedirect(location);
            fc().responseComplete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    public String getNavigationUrl() {        
        return fc().getViewRoot().getViewId();
    }
    
    public void handleNavigation(String outcome) {
        fc().getApplication().getNavigationHandler().handleNavigation(fc(), null, outcome);
    } 
}
