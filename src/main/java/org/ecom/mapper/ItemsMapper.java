package org.ecom.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.ecom.entity.Items;

import java.util.List;
@Mapper
public interface ItemsMapper {

    List<Items> findAll();

    Items find(Integer goodsID);

    int toAdd(Items items);

    int toEdit(Items items);
    // Random selection for front page
    List<Items> findRandom(Integer size);
    // find items by category
    List<Items> findItemByCategory(Integer categoryID);

}
