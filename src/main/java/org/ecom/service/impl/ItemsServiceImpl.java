package org.ecom.service.impl;

import org.ecom.entity.Items;
import org.ecom.mapper.ItemsMapper;
import org.ecom.service.ICategoryService;
import org.ecom.service.IItemsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemsServiceImpl implements IItemsService {
    @Resource
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> list() {
        return itemsMapper.findAll();
    }

    @Override
    public int insert(Items items) {
        return itemsMapper.toAdd(items);
    }

    @Override
    public Items find(Integer goodsID) {
        return itemsMapper.find(goodsID);
    }

    @Override
    public int update(Items items) {
        return itemsMapper.toEdit(items);
    }

    @Override
    public List<Items> findRandom(Integer size) {
        return itemsMapper.findRandom(size);
    }

    @Override
    public List<Items> findItemsByCategory(Integer categoryID){
        return itemsMapper.findItemByCategory(categoryID);
    }



}
