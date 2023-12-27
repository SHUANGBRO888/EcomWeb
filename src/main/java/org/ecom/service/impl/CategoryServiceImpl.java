package org.ecom.service.impl;


import org.ecom.entity.Category;
import org.ecom.mapper.CategoryMapper;
import org.ecom.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        return categoryMapper.findAll();
    }

    @Override
    public int insert(Category category) {
        return categoryMapper.toAdd(category);
    }

    @Override
    public Category find(Integer categoryID) {
        return categoryMapper.find(categoryID);
    }

    @Override
    public int update(Category category) {
        return categoryMapper.toUpdate(category);
    }

}
