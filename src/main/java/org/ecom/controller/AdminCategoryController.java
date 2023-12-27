package org.ecom.controller;


import org.ecom.entity.Category;
import org.ecom.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/admin/category")
@Controller
public class AdminCategoryController {
    @Resource
    private ICategoryService categoryService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Category> categoryList = categoryService.list();
        model.addAttribute("categoryList", categoryList);
        return "/admin/category_list";
    }
    @RequestMapping("/add_show")
    public String add_show(){
        return "/admin/category_add";
    }

    @RequestMapping("/add_submit")
    public String add_submit(Category category){
        categoryService.insert(category);
        return "redirect:/admin/category/list";
    }

    @RequestMapping("/edit_show")
    public String edit_show(Integer categoryID, Model model){
        Category category = categoryService.find(categoryID);
        model.addAttribute("category", category);
        return "/admin/category_edit";
    }

    @RequestMapping("/edit_submit")
    public String edit_submit(Category category){
        categoryService.update(category);
        return "redirect:/admin/category/list";
    }
}
