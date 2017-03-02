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
 * Search controller
 */
@Controller
public class SearchController {
    @Autowired
    private IGoodsService goodsService;
    static final int amount = Integer.parseInt(ResourceBundle.getBundle("config").getString("goodsPerPage"));

    /**
     * Do search and show it on JSP
     * @param searchLine - search line
     * @param index - page's index
     * @return - link
     */
    @RequestMapping("/search")
    public String searchPage(@RequestParam("search") String searchLine,
                             @RequestParam(value = "page", required = false) String index,
                             Model model) {
        int page = 1;
        int startIndex = 1;
        if (StringUtils.isNotEmpty(index)) {
            page = Integer.parseInt(index);
            startIndex = (page - 1) * amount + 1;
        }

        long allCount;
        if (StringUtils.isEmpty(searchLine)) {
            //if search is empty then show all catalog
            List<Goods> catalog = goodsService.getAll(startIndex, amount);
            model.addAttribute("result", catalog);
            allCount = goodsService.getAllCount();

        } else {
            List<Goods> result = goodsService.searchAll(searchLine, startIndex, amount);
            model.addAttribute("result", result);
            allCount = goodsService.getAllSearchCount(searchLine);
            model.addAttribute("search", searchLine);
        }
        long pagesCount = allCount % amount == 0 ? allCount / amount : allCount / amount + 1;
        model.addAttribute("pagesCount", pagesCount);
        model.addAttribute("page", page);
        return "search";
    }
}
