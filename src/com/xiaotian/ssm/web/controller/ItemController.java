package com.xiaotian.ssm.web.controller;

import com.xiaotian.ssm.model.Items;
import com.xiaotian.ssm.service.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("items")
public class ItemController {

    @Autowired//由spring装入service
    private IItemsService itemsService;

    @RequestMapping("list")
    public String list(Model model){
        //查数据
        List<Items> itemsList = itemsService.findAllItems();
        //存数据
        model.addAttribute("itemsList",itemsList);
        return "/item/list";
    }

    @RequestMapping("save")
    public String save(){

        //创建商品
        Items items = new Items();
        items.setName("IPhone8Plus");
        items.setPrice(8888.88F);
        items.setCreatetime(new Date());
        items.setDetail("贵手机");
        System.out.println(items);
        //保存数据
        itemsService.saveOrUpdate(items);

        return "/item/save";
    }

    @RequestMapping("delete")
    public String delete(Integer id){

        //删除商品
        itemsService.deleteById(id);
        return "forward:list.do";
    }

    @RequestMapping("edit")
    public String edit(Integer id,Model model){
        //找到更新的商品
        Items items = itemsService.findById(id);
        if(items != null){
            model.addAttribute("items",items);
        }
        return "/item/edit";
    }

    @RequestMapping("update")
    public String update(Items items){
        System.out.println(items);
        //更新商品
        items.setCreatetime(new Date());
        itemsService.saveOrUpdate(items);
        return "forward:list.do";
    }
}
