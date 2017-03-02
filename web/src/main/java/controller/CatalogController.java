package controller;

import bean.Goods;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.IGoodsService;

import java.util.List;
import java.util.ResourceBundle;

/**
 * Catalog controller.
 */
@Controller
public class CatalogController {
    @Autowired
    private IGoodsService goodsService;
    //Amount of goods per page
    static final int amount = Integer.parseInt(ResourceBundle.getBundle("config").getString("goodsPerPage"));

    /**
     * Get all goods and add them in Model to show in jsp.
     * @param index - page's index
     * @param country - country name
     * @return - link
     */
    @RequestMapping(value = "/catalog")
    public String catalogPage(@RequestParam(value = "page", required = false) String index,
                              @RequestParam(value = "country", required = false, defaultValue = "") String country,
                              Model model) {
        int page = 1;
        int startIndex = 1;
        if (StringUtils.isNotEmpty(index)) {
            page = Integer.parseInt(index);
            startIndex = (page - 1) * amount + 1;
        }
        List<Goods> catalog;
        long allCount;
        if (StringUtils.isEmpty(country)) {
            catalog = goodsService.getAll(startIndex, amount);
            allCount = goodsService.getAllCount();
        } else {
            catalog = goodsService.getAll(country, startIndex, amount);
            allCount = goodsService.getAllCountryCount(country);
        }
        long pagesCount = allCount % amount == 0 ? allCount / amount : allCount / amount + 1;
        model.addAttribute("catalog", catalog);
        model.addAttribute("pagesCount", pagesCount);
        model.addAttribute("country", country);
        model.addAttribute("page", page);
        return "catalog";
    }
}