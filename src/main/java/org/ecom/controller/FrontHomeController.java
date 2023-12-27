package org.ecom.controller;

import org.ecom.entity.Category;
import org.ecom.entity.Items;
import org.ecom.service.ICategoryService;
import org.ecom.service.IItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Controller
public class FrontHomeController {
    @Resource
    private ICategoryService categoryService;
    @Resource
    private IItemsService itemsService;
    @RequestMapping("/")
    public String index(Model model) {
        // find random item
        List<Items> itemsList = itemsService.findRandom(8);
        model.addAttribute("itemsList", itemsList);
        // show the category
        List<Category> categoryList = categoryService.list();
        model.addAttribute("categoryList", categoryList);
        return "/front/index";
    }
    @RequestMapping("/sub")
    public String findItemByCategory(Integer categoryID, Model model){
        List<Category> categoryList = categoryService.list();
        List<Items> itemsList = itemsService.findItemsByCategory(categoryID);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("itemsList", itemsList);
        model.addAttribute("categoryID", categoryID);
        return "/front/sub";
    }

}
