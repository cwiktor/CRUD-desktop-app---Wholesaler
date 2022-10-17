package DAO;

import Config.HibernateConfig;
import org.hibernate.Session;
import java.util.List;
public class DAOGeneric<E> implements IDAOGeneric<E>{
    private final String type;
    public DAOGeneric(Class classType){
        this.type=classType.getName();
    }

    @Override
    public void add(E entity) {
        Session session= HibernateConfig.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public E update(E entity) {
        Session session=HibernateConfig.openSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public void remove(E entity) {
        Session session=HibernateConfig.openSession();
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<E> getAll() {
        Session session=HibernateConfig.openSession();
        session.beginTransaction();
        List<E> e=(List<E>)session.createQuery("from "+type).list();
        session.getTransaction().commit();
        session.close();
        return e;
    }
}
