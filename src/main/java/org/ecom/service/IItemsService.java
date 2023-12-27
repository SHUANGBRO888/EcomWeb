package org.ecom.service;

import org.ecom.entity.Items;

import java.util.List;


public interface IItemsService {
    // find random items
    List<Items> findRandom(Integer size);
    // Search the category list
    List<Items> list();
    // Add categories
    int insert(Items items);
    // Search the category
    Items find(Integer goodsID);
    // Edit the category
    int update(Items items);
    // find item by category
    List<Items> findItemsByCategory(Integer categoryID);
}
