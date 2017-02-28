package service;

import bean.Goods;
import dao.interfaces.GoodsDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.GoodsServiceInterface;

import java.io.Serializable;
import java.util.List;

/**
 * Service for goods.
 */
@Service("goodsService")
@Transactional
public class GoodsService implements GoodsServiceInterface {
    @Autowired
    private GoodsDAOInterface goodsDAO;

    @Override
    public void saveOrUpdate(Goods bean) {
        goodsDAO.saveOrUpdate(bean);
    }

    @Override
    public Goods get(int id) {
        return goodsDAO.get(id);
    }

    @Override
    public Goods get(Serializable obj) {
        return goodsDAO.get(obj);
    }

    @Override
    public void delete(Goods goods) {
        goodsDAO.delete(goods);
    }

    @Override
    public List<Goods> getAll() {
        return goodsDAO.getAll();
    }

    public List<Goods> getAll(int startIndex, int amount) {
        return goodsDAO.getAll(startIndex, amount);
    }

    public List<Goods> getAll(String country, int startIndex, int amount) {
        return goodsDAO.getAll(country, startIndex, amount);
    }

    public List<Goods> searchAll(String searchLine, int startIndex, int amount) {
        return goodsDAO.searchAll(searchLine, startIndex, amount);
    }

    public List<Goods> getAllSale(int startIndex, int amount) {
        return goodsDAO.getAllSale(startIndex, amount);
    }

    public long getAllSearchCount(String searchLine) {
        return goodsDAO.getAllSearchCount(searchLine);
    }

    public long getAllCount() {
        return goodsDAO.getAllCount();
    }

    public long getAllSaleCount() {
        return goodsDAO.getAllSaleCount();
    }

    public long getAllCountryCount(String country) {
        return goodsDAO.getAllCountryCount(country);
    }
}