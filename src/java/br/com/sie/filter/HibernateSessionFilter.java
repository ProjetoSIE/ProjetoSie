/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sie.filter;

import br.com.sie.util.dao.HibernateSession;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Marcos Costa
 */
public class HibernateSessionFilter implements Filter {  
      
    /**
     *
     * @param req
     * @param res
     * @param fc
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)    
            throws IOException, ServletException {      
        HibernateSession.openSession();    
        try {    
            HibernateSession.beginTransaction();    
            fc.doFilter(req, res);    
            HibernateSession.commitTransaction();    
        } catch (Exception e) {
            HibernateSession.rollbackTransaction();                
            e.printStackTrace();               
            System.out.println(e.getMessage());
        } finally {  
            HibernateSession.closeCurrentSession();    
        }    
    }  
  
  
  
    /**
     *
     * @param c
     */
    @Override
    public void init(FilterConfig c) {  
  
    }  
  
  
  
    /**
     *
     */
    @Override
    public void destroy() {  
  
    }  
}  
