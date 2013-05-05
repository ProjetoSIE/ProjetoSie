/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sie.listener;

import br.com.sie.beans.Persistent;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Marcos Costa
 */
public class SecurityListener implements PhaseListener{
    private static final String LOGIN = "login";
    /**
     *
     * @param event
     */
    @Override  
    public void afterPhase(PhaseEvent event) {          
        FacesContext fc = event.getFacesContext();
        ExternalContext ext = fc.getExternalContext();  
        HttpSession session = (HttpSession) ext.getSession(false);        
        Persistent persistent =  session != null? (Persistent) session.getAttribute("user") : null;
        boolean timedout = session == null || session.isNew() || persistent == null;               
        if (timedout && !event.getFacesContext().getViewRoot().getViewId().contains("login")) {  
            try {
                 NavigationHandler nh = fc.getApplication()  
                .getNavigationHandler();
                 nh.handleNavigation(fc, null, LOGIN);               
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }  
    }  
 
    /**
     *
     * @param event
     */
    @Override  
    public void beforePhase(PhaseEvent event) {  
        
    }  

    /**
     *
     * @return
     */
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
