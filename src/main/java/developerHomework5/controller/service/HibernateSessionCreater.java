package developerHomework5.controller.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSessionCreater {
    private SessionFactory sessionFactory;

    public HibernateSessionCreater(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
        System.out.println("test");
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
