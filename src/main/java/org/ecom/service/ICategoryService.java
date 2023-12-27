package org.ecom.service;

import org.ecom.entity.Category;

import java.util.List;


public interface ICategoryService {
    // Search the category list
    List<Category> list();
    // Add categories
    int insert(Category category);
    // Search the category
    Category find(Integer categoryID);
    // Edit the category
    int update(Category category);
}
