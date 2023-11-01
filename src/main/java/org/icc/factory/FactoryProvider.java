package org.icc.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {

    private static SessionFactory sessionFactory;

    private FactoryProvider() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null)
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        return sessionFactory;
    }

    public static void closeFactory() {
        if (sessionFactory.isOpen()) sessionFactory.close();
    }
}
