package service.interfaces;

import java.io.Serializable;
import java.util.List;

public interface BaseServiceInterface<Type> {
    /**
     * save bean or update
     *
     * @param obj - bean
     */
    void saveOrUpdate(Type obj);

    /**
     * get bean from db
     *
     * @param obj - bean
     */
    Type get(Serializable obj);

    /**
     * get bean from db
     *
     * @param id - index in db
     */
    Type get(int id);

    /**
     * Delete bean in db by id
     *
     * @param type - bean
     */
    void delete(Type type);

    /**
     * get all bean from db
     *
     * @return list beans
     */
    List<Type> getAll();
}
