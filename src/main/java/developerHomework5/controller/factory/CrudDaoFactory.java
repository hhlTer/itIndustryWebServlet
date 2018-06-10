package developerHomework5.controller.factory;

import developerHomework5.controller.service.HibernateSessionCreater;
import developerHomework5.controller.service.RepositoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
