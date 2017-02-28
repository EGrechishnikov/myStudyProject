package controller;

import bean.Goods;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.interfaces.GoodsServiceInterface;

import java.util.List;
import java.util.ResourceBundle;

/**
 * Sale controller
 */
@Controller
public class SaleController {
    private static Logger logger = Logger.getLogger(SaleController.class);
    static final int amount = Integer.parseInt(ResourceBundle.getBundle("config").getString("goodsPerPage"));
    @Autowired
    private GoodsServiceInterface goodsService;

    /**
     * Search and show all search goods
     * @param index - page's index
     * @return - link
     */
    @RequestMapping("/sale")
    public String salePage(@RequestParam(value = "page", required = false) String index, Model model) {
        int page = 1;
        int startIndex = 1;
        if (StringUtils.isNotEmpty(index)) {
            page = Integer.parseInt(index);
            startIndex = (page - 1) * amount + 1;
        }

        List<Goods> catalog = goodsService.getAllSale(startIndex, amount);
        logger.error("Sale catalog: " + catalog);
        long allCount = goodsService.getAllSaleCount();
        long pagesCount = allCount % amount == 0 ? allCount / amount : allCount / amount + 1;

        model.addAttribute("catalog", catalog);
        model.addAttribute("pagesCount", pagesCount);
        model.addAttribute("page", page);
        return "sale";
    }
}
