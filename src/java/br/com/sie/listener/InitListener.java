package br.com.sie.listener;


import br.com.sie.util.dao.HibernateSession;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Marcos Costa
 */
public class InitListener implements ServletContextListener {
    /**
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {       
       new HibernateSession();    
    }
    /**
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {     
        HibernateSession.destroy();
    }
}
