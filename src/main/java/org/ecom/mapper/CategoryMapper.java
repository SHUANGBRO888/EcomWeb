package org.ecom.mapper;




import org.apache.ibatis.annotations.Mapper;
import org.ecom.entity.Category;

import java.util.List;


@Mapper
public interface CategoryMapper {
    // find All
    List<Category> findAll();
    // add a new category
    int toAdd(Category category);
    // search for a category
    Category find(Integer categoryID);
    // to Update
    int toUpdate(Category category);





}
