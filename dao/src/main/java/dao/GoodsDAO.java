package dao;

import bean.Goods;
import dao.interfaces.GoodsDAOInterface;
import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO for goods
 */
@Repository
public class GoodsDAO extends BaseDAO<Goods> implements GoodsDAOInterface {
    @Autowired
    public GoodsDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Goods> getAll(int startIndex, int amount) {
        Criteria criteria = getSession().createCriteria(Goods.class);
        criteria.setFirstResult(startIndex - 1);
        criteria.setMaxResults(amount);
        return criteria.list();
    }

    public List<Goods> getAll(String country, int startIndex, int amount) {
        Criteria criteria = getSession().createCriteria(Goods.class);
        criteria.add(Restrictions.eq("country", country));
        criteria.setFirstResult(startIndex - 1);
        criteria.setMaxResults(amount);
        List<Goods> list = criteria.list();
        return list;
    }

    public List<Goods> searchAll(String searchLine, int startIndex, int amount) {
        Criteria criteria = getSession().createCriteria(Goods.class);
        criteria.add(Restrictions.or(
                Restrictions.eq("name", searchLine),
                Restrictions.eq("description", searchLine),
                Restrictions.eq("country", searchLine),
                Restrictions.eq("collection", searchLine),
                Restrictions.eq("vendorCode", searchLine)
        ));
        criteria.setFirstResult(startIndex - 1);
        criteria.setMaxResults(amount);
        return criteria.list();
    }

    public List<Goods> getAllSale(int startIndex, int amount) {
        Criteria criteria = getSession().createCriteria(Goods.class);
        criteria.add(Restrictions.gt("sale", 0));
        criteria.setFirstResult(startIndex - 1);
        criteria.setMaxResults(amount);
        return criteria.list();
    }

    public long getAllSearchCount(String searchLine) {
        Criteria criteria = getSession().createCriteria(Goods.class);
        criteria.add(Restrictions.or(
                Restrictions.eq("name", searchLine),
                Restrictions.eq("description", searchLine),
                Restrictions.eq("country", searchLine),
                Restrictions.eq("collection", searchLine),
                Restrictions.eq("vendorCode", searchLine)
        ));
        criteria.setProjection(Projections.rowCount());
        return (long) criteria.uniqueResult();
    }

    public long getAllSaleCount() {
        Criteria criteria = getSession().createCriteria(Goods.class);
        criteria.add(Restrictions.gt("sale", 0));
        criteria.setProjection(Projections.rowCount());
        return (long) criteria.uniqueResult();
    }

    public long getAllCount() {
        Criteria criteria = getSession().createCriteria(Goods.class);
        criteria.setProjection(Projections.rowCount());
        return (long) criteria.uniqueResult();
    }

    public long getAllCountryCount(String country) {
        Criteria criteria = getSession().createCriteria(Goods.class);
        criteria.add(Restrictions.eq("country", country));
        criteria.setProjection(Projections.rowCount());
        return (long) criteria.uniqueResult();
    }
}
