package dao;

import bean.Goods;
import dao.interfaces.GoodsDAOInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration("/beans-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class GoodsDAOTest {
    @Autowired
    private GoodsDAOInterface goodsDAO;

    @Test
    public void saveGoods() {
        Goods goods = new Goods("oldName", "abc", "10x10", "old wallpaper", "Russia", "124114", "link", 235, 30);
        List<Goods> list = goodsDAO.getAll();
        int sizeBefore = list.size();
        goodsDAO.saveOrUpdate(goods);
        list = goodsDAO.getAll();
        int sizeAfter = list.size();
        assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getGoodsById() {
        Goods goods = goodsDAO.get(1);
        assertEquals("Not got", "Andrea Rossi", goods.getName());
    }

    @Test
    public void deleteGoods() {
        List<Goods> list = goodsDAO.getAll();
        int sizeBefore = list.size();
        Goods roleEntity = goodsDAO.get(4);
        goodsDAO.delete(roleEntity);
        list = goodsDAO.getAll();
        int sizeAfter = list.size();
        assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }

    @Test
    public void allCountryGoods() {
        String country = "Россия";
        List<Goods> tmp = goodsDAO.searchAll(country, 1, 2);
        assertNotNull(tmp);
        assertEquals(tmp.size(), 2);
        assertEquals(tmp.get(0).getCountry(), country);
        assertEquals(tmp.get(1).getCountry(), country);
    }

    @Test
    public void countGoods() {
        long allCount = goodsDAO.getAllCount();
        long saleCount = goodsDAO.getAllSaleCount();
        assertNotEquals(allCount, saleCount);
    }

    @Test
    public void notNul() {
        String country = "Италия";
        assertNotNull(goodsDAO.getAll(country, 1, 1));
        assertNotNull(goodsDAO.getAllCountryCount(country));
        assertNotNull(goodsDAO.getAllSearchCount(country));
        assertNotNull(goodsDAO.getAllSale(1, 1));
        assertNotNull(goodsDAO.getAll(country, 1, 1));
    }

    @Test
    public void allGoods() {
        List<Goods> tmp = goodsDAO.getAll(1, 2);
        assertNotNull(tmp);
        assertEquals(tmp.size(), 2);
    }
}
