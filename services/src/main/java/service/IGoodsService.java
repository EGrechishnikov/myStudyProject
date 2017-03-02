package service;

import bean.Goods;

import java.util.List;

public interface IGoodsService extends IBaseService<Goods> {
    /**
     * Get goods for pagination
     *
     * @param startIndex - start index
     * @param amount     - amount of goods
     * @return list
     */
    List<Goods> getAll(int startIndex, int amount);

    /**
     * Get goods by country for pagination
     *
     * @param country    - country name
     * @param startIndex - start index
     * @param amount     - amount of goods
     * @return - list
     */
    List<Goods> getAll(String country, int startIndex, int amount);

    /**
     * Get goods by search line for pagination
     *
     * @param searchLine - search
     * @param startIndex - start index
     * @param amount     - amount of goods
     * @return - list
     */
    List<Goods> searchAll(String searchLine, int startIndex, int amount);

    /**
     * Get all goods with sale for pagination
     *
     * @param startIndex - start index
     * @param amount     - amount of goods
     * @return - list
     */
    List<Goods> getAllSale(int startIndex, int amount);

    /**
     * Get count of goods by search line
     *
     * @param searchLine - search
     * @return count
     */
    long getAllSearchCount(String searchLine);

    /**
     * Get all count of goods
     *
     * @return count
     */
    long getAllCount();

    /**
     * Get all goods count with sale
     *
     * @return - count
     */
    long getAllSaleCount();

    /**
     * Get all goods count by country
     *
     * @param country - country name
     * @return - count
     */
    long getAllCountryCount(String country);
}
