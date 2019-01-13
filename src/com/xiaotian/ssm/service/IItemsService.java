package com.xiaotian.ssm.service;

import com.xiaotian.ssm.model.Items;
import java.util.List;

public interface IItemsService {

    public List<Items> findAllItems();
    public Items findById(Integer id);
    public void saveOrUpdate(Items items);
    public void deleteById(Integer id);
}
