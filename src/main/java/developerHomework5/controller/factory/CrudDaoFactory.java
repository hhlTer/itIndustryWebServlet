package developerHomework5.controller.factory;

import developerHomework5.controller.service.HibernateSessionCreater;
import developerHomework5.controller.service.RepositoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    public List<T> getList(){
        Session session = openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery((Class<T>) clazz);
        Root<T> root = criteriaQuery.from((Class<T>)clazz);
        criteriaQuery.select(root);
        Query<T> query = session.createQuery(criteriaQuery);
        return (List<T>) query.getResultList();
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
