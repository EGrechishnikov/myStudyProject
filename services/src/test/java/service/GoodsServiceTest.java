package service;

import bean.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.GoodsServiceInterface;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration("/beans-services.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class GoodsServiceTest {
    @Autowired
    private GoodsServiceInterface serviceInterface;

    @Test
    public void saveGoods() {
        Goods goods = new Goods("oldName", "abc", "10x10", "old wallpaper", "Russia", "124114", "link", 235, 30);
        List<Goods> list = serviceInterface.getAll();
        int sizeBefore = list.size();
        serviceInterface.saveOrUpdate(goods);
        list = serviceInterface.getAll();
        int sizeAfter = list.size();
        assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getGoodsById() {
        Goods goods = serviceInterface.get(1);
        assertEquals("Not got", "Andrea Rossi", goods.getName());
    }

    @Test
    public void deleteGoods() {
        List<Goods> list = serviceInterface.getAll();
        int sizeBefore = list.size();
        Goods roleEntity = serviceInterface.get(4);
        serviceInterface.delete(roleEntity);
        list = serviceInterface.getAll();
        int sizeAfter = list.size();
        assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }

    @Test
    public void allCountryGoods() {
        String country = "Россия";
        List<Goods> tmp = serviceInterface.searchAll(country, 1, 2);
        assertNotNull(tmp);
        assertEquals(tmp.size(), 2);
        assertEquals(tmp.get(0).getCountry(), country);
        assertEquals(tmp.get(1).getCountry(), country);
    }

    @Test
    public void countGoods() {
        long allCount = serviceInterface.getAllCount();
        long saleCount = serviceInterface.getAllSaleCount();
        assertNotEquals(allCount, saleCount);
    }

    @Test
    public void notNul() {
        String country = "Италия";
        assertNotNull(serviceInterface.getAll(country, 1, 1));
        assertNotNull(serviceInterface.getAllCountryCount(country));
        assertNotNull(serviceInterface.getAllSearchCount(country));
        assertNotNull(serviceInterface.getAllSale(1, 1));
        assertNotNull(serviceInterface.getAll(country, 1, 1));
    }

    @Test
    public void allGoods() {
        List<Goods> tmp = serviceInterface.getAll(1, 2);
        assertNotNull(tmp);
        assertEquals(tmp.size(), 2);
    }
}