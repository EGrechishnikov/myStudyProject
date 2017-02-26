package dao.interfaces;

import bean.Goods;

import java.util.List;

public interface GoodsDAOInterface extends BaseDAOInterface<Goods> {
    /**
     * Get all goods from db for pagination
     *
     * @param startIndex - from this index
     * @param amount     - amount goods
     * @return - list goods
     */
    List<Goods> getAll(int startIndex, int amount);

    /**
     * Like previous, but with field - country
     *
     * @param country - additional field for search
     */
    List<Goods> getAll(String country, int startIndex, int amount);

    /**
     * Find all goods by search line
     *
     * @param searchLine - line for search
     * @param startIndex - from this index
     * @param amount     - amount goods
     * @return - list goods
     */
    List<Goods> searchAll(String searchLine, int startIndex, int amount);

    /**
     * Find all sale goods
     *
     * @param startIndex - from this index
     * @param amount     - amount goods
     * @return - list goods
     */
    List<Goods> getAllSale(int startIndex, int amount);

    /**
     * Count goods by search line
     *
     * @param searchLine - line for search
     * @return count
     */
    long getAllSearchCount(String searchLine);

    /**
     * Count all sale goods
     *
     * @return count
     */
    long getAllSaleCount();

    /**
     * Count all goods
     *
     * @return count
     */
    long getAllCount();

    /**
     * Count all goods by country
     *
     * @param country - country name
     * @return count
     */
    long getAllCountryCount(String country);
}
