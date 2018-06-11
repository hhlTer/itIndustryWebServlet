package developerHomework5.controller.service;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStream;


public class HibernateSessionCreater {
    private SessionFactory sessionFactory;

    public HibernateSessionCreater(){
        try (InputStream in = HibernateSessionCreater.class.getResourceAsStream("/hibernate.cfg.xml")) {
            Configuration configuration = new Configuration().addInputStream(in).configure();
            sessionFactory =  configuration.configure().buildSessionFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        sessionFactory =  new Configuration().configure().buildSessionFactory();
        System.out.println("test");
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
