package org.ecom.controller;

import org.ecom.entity.Category;
import org.ecom.entity.Items;
import org.ecom.service.ICategoryService;
import org.ecom.service.IItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/admin/items")
@Controller
public class AdminItemsController {
    @Resource
    private ICategoryService iCategoryService;
    @Resource
    private IItemsService iItemsService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Items> itemsList = iItemsService.list();
        model.addAttribute("itemsList", itemsList);
        return "/admin/items_list";
    }

    @RequestMapping("/add_show")
    public String add_show(Model model){
        List<Category> categoryList = iCategoryService.list();
        model.addAttribute("categoryList", categoryList);
        return "/admin/items_add";
    }

    @RequestMapping("/edit_show")
    public String edit_show(Integer goodsID, Model model){
        Items items = iItemsService.find(goodsID);
        List<Category> categoryList = iCategoryService.list();

        model.addAttribute("items", items);
        model.addAttribute("categoryList", categoryList);

        return "/admin/items_edit";
    }

    @RequestMapping("/add_submit")
    public String add_submit(Items items, MultipartFile file){
        String imgFile = null;

        // Upload the image
        if(file.isEmpty()) {
            // No upload image
            imgFile = "/img/items.png";
        }else{
            String newFile = UUID.randomUUID()+"-"+file.getOriginalFilename();
            File f = new File("/Users/gezi/Desktop/Personal Project/SpringBootEcomWeb/demo/proj_img", newFile);
            // parent directory is not existing
            if(!f.getParentFile().exists()){
                f.mkdirs();
            }
            try{
                // save the image to default path
                file.transferTo(f);
                // save to Database
                imgFile = "/upfile/"+newFile;
            }catch(IOException e){
                e.printStackTrace();
            }

        }
        items.setPicture(imgFile);
        iItemsService.insert(items);
        return "redirect:/admin/items/list";
    }

    @RequestMapping("/edit_submit")
    public String edit_submit(Items items, MultipartFile file){
        if(!file.isEmpty()) {
            String newFile = UUID.randomUUID()+"-"+file.getOriginalFilename();
            File f = new File("/Users/gezi/Desktop/Personal Project/SpringBootEcomWeb/demo/proj_img", newFile);
            // parent directory is not existing
            if(!f.getParentFile().exists()){
                f.mkdirs();
            }
            try{
                // save the image to default path
                file.transferTo(f);
                items.setPicture("/upfile/"+newFile);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        iItemsService.update(items);
        return "redirect:/admin/items/list";
    }


}
