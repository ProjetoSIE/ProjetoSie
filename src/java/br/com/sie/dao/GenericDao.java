/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sie.dao;

import br.com.sie.beans.Persistent;
import br.com.sie.util.dao.HibernateSession;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @param <E> 
 * @author Marcos Costa
 */
public class GenericDao<E extends Persistent> {
    private Class clazz;
    
    /**
     *
     * @param clazz
     */
    public GenericDao(Class clazz) {
        this.clazz = clazz;
    }
                
    /**
     *
     * @param id
     * @return
     */
    public E load(Object id){
        Session session = HibernateSession.currentSession();
        E object= (E) session.createCriteria(clazz)
                    .add(Restrictions.idEq(id)).uniqueResult();   
        return object;
    }
    
    /**
     *
     * @param persistent
     */
    public void save(E persistent){        
        Session session = HibernateSession.currentSession();
        session.save(persistent);        
    }
    
    /**
     *
     * @param persistent
     */
    public void update(E persistent){
        Session session = HibernateSession.currentSession();
        session.merge(persistent);        
    }
    
    /**
     *
     * @param persistent
     */
    public void delete(E persistent){
        Session session = HibernateSession.currentSession();
        session.delete(persistent);        
    }
    
    /**
     *
     * @return
     */
    public List<E> list(){
        Session session = HibernateSession.currentSession();
        List<E> list = session.createCriteria(clazz).list();           
        return list;
    }                        
}
