/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sie.util.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Marcos Costa
 */
public class HibernateSession {

    private static final SessionFactory sessionFactory;
    private static ThreadLocal<Session> threadSession = new ThreadLocal<Session>();

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     *
     * @return
     */
    public static SessionFactory getSessionFactory() {
        System.out.println(sessionFactory);
        return sessionFactory;
    }

    /**
     *
     * @return
     */
    public static Session openSession() {
        if (threadSession.get() != null) {
            System.out.println("Alguem nao fechou uma já aberta!!");
        }
        threadSession.set(sessionFactory.openSession());
        return threadSession.get();
    }

    /**
     *
     */
    public static void closeCurrentSession() {
        threadSession.get().close();
        threadSession.set(null);
    }

    /**
     *
     * @return
     */
    public static Session currentSession() {
        return threadSession.get();
    }

    /**
     *
     */
    public static void beginTransaction() {
        threadSession.get().beginTransaction();
    }

    /**
     *
     */
    public static void commitTransaction() {
        if (isTransactionOpen()) {
            threadSession.get().getTransaction().commit();
        }
    }

    /**
     *
     */
    public static void rollbackTransaction() {
        if (isTransactionOpen()) {
            threadSession.get().getTransaction().rollback();
        }
    }

    /**
     *
     */
    public static void destroy() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public static boolean isTransactionOpen() {
        return currentSession().getTransaction() != null && currentSession().getTransaction().isActive();
    }

    public static Transaction currentTransaction() {
        return currentSession().getTransaction();
    }
}
