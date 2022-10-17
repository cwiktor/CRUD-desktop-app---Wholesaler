package DAO;

import java.util.List;

public interface IDAOGeneric<E>{
    void add(E entity);
    E update(E entity);
    void remove(E entity);
    List<E> getAll();
}