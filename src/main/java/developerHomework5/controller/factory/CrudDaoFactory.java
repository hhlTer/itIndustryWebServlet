package developerHomework5.controller.factory;

import developerHomework5.controller.service.HibernateSessionCreater;
import developerHomework5.controller.service.RepositoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class CrudDaoFactory<T, K> {
    private Class<T> clazz;
    private SessionFactory sessionFactory;

    public CrudDaoFactory(Class initClazz){
        this.clazz = initClazz;
//        HibernateSessionCreater sessionCreater = RepositoryService.getINSTANCE().getService(HibernateSessionCreater.class);
        HibernateSessionCreater sessionCreater = new HibernateSessionCreater();
        sessionFactory = sessionCreater.getSessionFactory();
    }

    public void create(T t){
        Session session = openTrancatSession();
        session.save(t);
        closeTrancatSession(session);
    }

    public T getById(K k){
        Session session = openSession();
        T result = session.get(clazz, (Serializable) k);
        session.close();
        return result;
    }

    private Session openSession(){
        return sessionFactory.openSession();
    }

    private Session openTrancatSession(){
        Session session = openSession();
        session.beginTransaction();
        return session;
    }

    private void closeTrancatSession(Session session){
        session.getTransaction().commit();
        session.close();
    }
}
