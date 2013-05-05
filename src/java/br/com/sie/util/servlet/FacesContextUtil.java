package br.com.sie.util.servlet;

//import utilidades.AdemFaceletViewHandler;
import java.io.IOException;
import java.util.Map;
import javax.el.ValueExpression;
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

    /**
     *
     * @param managedBeanName
     * @param clazz
     * @return
     */
    public synchronized Object getFacesBean(String managedBeanName, Class<? extends Object> clazz) {
        if (managedBeanName == null) {
            throw new IllegalArgumentException("o nome enviado para criacao do bean e null");
        }

        ValueExpression ve = fc().getApplication().getExpressionFactory().createValueExpression(fc().getELContext(), "#{" + managedBeanName + "}", clazz);

        return ve.getValue(fc().getELContext());
    }

    /**
     *
     * @param name
     * @return
     */
    protected String getContextParam(String name) {
        return (String) fc().getExternalContext().getApplicationMap().get(name);
    }

    /**
     *
     * @param key
     * @param value
     */
    public void putOnSessionMap(String key, Object value) {
        synchronized (this) {
            sessionMap().put(key, value);
        }
    }

    /**
     *
     * @param key
     * @return
     */
    public Object getFromSessionMap(String key) {
        synchronized (this) {
            return sessionMap().get(key);
        }
    }

    /**
     *
     * @param key
     * @return
     */
    public Object removeFromSessionMap(String key) {
        synchronized (this) {
            return sessionMap().remove(key);
        }
    }

    /**
     *
     * @param outcome
     */
    public void handleNavigation(String outcome) {
        fc().getApplication().getNavigationHandler().handleNavigation(fc(), null, outcome);
    }

    /**
     *
     * @param location
     */
    public void sendRedirect(String location) {
        try {
            response().sendRedirect(location);
            fc().responseComplete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param outcome
     */
    public void forwardRequestDispatcher(String outcome) {
        try {
            request().getRequestDispatcher(outcome).forward(request(), response());
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } catch (ServletException sex) {
            sex.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public FacesContext fc() {
        return FacesContext.getCurrentInstance();
    }

    private Map<String, Object> sessionMap() {
        fc().getExternalContext().getSession(false);
        return fc().getExternalContext().getSessionMap();
    }

    /**
     *
     * @param create
     * @return
     */
    public HttpSession getSession(boolean create) {
        return (HttpSession) fc().getExternalContext().getSession(create);
    }

    /**
     *
     * @return
     */
    public HttpServletRequest request() {
        return (HttpServletRequest) fc().getExternalContext().getRequest();
    }

    /**
     *
     * @return
     */
    public HttpServletResponse response() {
        return (HttpServletResponse) fc().getExternalContext().getResponse();
    }

    /**
     *
     * @return
     */
    public String getNavigationUrl() {        
        return fc().getViewRoot().getViewId();
    }    
}
