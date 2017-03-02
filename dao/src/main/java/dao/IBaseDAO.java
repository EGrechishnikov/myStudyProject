package dao;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface IBaseDAO<Type> {
    /**
     * save bean or update
     *
     * @param obj - bean
     */
    void saveOrUpdate(Type obj);

    /**
     * get bean from db
     *
     * @param id - bean's index
     */
    Type get(Serializable id);

    /**
     * delete bean from db
     *
     * @param obj - bean
     */
    void delete(Type obj);

    /**
     * get all bean from db
     *
     * @return list beans
     */
    List<Type> getAll();

    /**
     * Getter for Hibernate session
     *
     * @return session
     */
    Session getSession();
}