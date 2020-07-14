package com.jt.controller;

import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.service.ItemService;
import com.jt.vo.EasyUITable;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    /**
     * Request URL: http://localhost:8091/item/query?page=1&rows=20
     */
    @Autowired
    private ItemService itemService;

    @RequestMapping("/query")
    public EasyUITable findAllItemFromService(Integer page, Integer rows) {
        return itemService.findAllFromMapper(page, rows);
    }

    //Request URL: http://localhost:8091/item/save
    @PostMapping("/save")
    public SysResult saveItemToService(Item item, ItemDesc itemDesc) {
//		try {
        itemService.saveItemToMapper(item, itemDesc);
//    	int a = 1/0;
        return SysResult.success();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return SysResult.fail();
//        }
    }

    @RequestMapping("/update")
    public SysResult updateItemToService(Item item, ItemDesc itemDesc) {
        itemService.updateItemToMapper(item, itemDesc);
        return SysResult.success();
    }

    //Request URL: http://localhost:8091/item/delete

    /**
     * 补充：Springmvc框架
     * 页面中传递什么样的数据，后端才能接受什么样的数据，但是要求name属性名称必须一致
     *
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    public SysResult deleteItemToService(Long[] ids) {
        itemService.deleteItemToMapper(ids);
        return SysResult.success();
    }

    //    Request URL: http://localhost:8091/item/instock

    /**
     * SpringMVC底层实现servlet,数据传输协议https/http一般传递的数据是String结构。
     * SpringMVC优化：
     * 1.可以自动的根据参数类型进行转化，String转化为具体类型
     * 2.
     *
     * @param status
     * @param ids
     * @return
     */
    @PostMapping("/{status}")//下架
    public SysResult changeStatusItemToService(@PathVariable Integer status, Long[] ids) {
        itemService.changeStatusItemToMapper(status, ids);
        return SysResult.success();
    }

    /**
     * 根据itemId查询商品详情信息
     * Request URL: http://localhost:8091/item/query/item/desc/1474391968
     */
    @GetMapping("/query/item/desc/{itemId}")
    public SysResult findItemDescByIdFromService(@PathVariable Long itemId) {
        ItemDesc itemDesc = itemService.findItemDescByIdFromMapper(itemId);
        return SysResult.success(itemDesc);
    }
}
