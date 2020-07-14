package com.jt.controller;

import com.jt.pojo.ItemCat;
import com.jt.service.ItemCatService;
import com.jt.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @auther Zangyiyi
 * @date 2020/7/7 - 17:08
 */
@RestController
@RequestMapping("/item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    //      Request URL: http://localhost:8091/item/cat/queryItemName?itemCatId=3
    //           返回值商品分类
    @GetMapping("/queryItemName")
    public String findItemCatFromService(Long itemCatId) {
        return itemCatService.findItemCatFromMapper(itemCatId).getName();
    }

    /**
     * Request URL: http://localhost:8091/item/cat/list
     * 无参
     * 返回值:EasyUITree
     * sql语句:一级商品分类(parent_id=0)
     */
    @PostMapping("/list")
    public List<EasyUITree> findItemCatTreeByParentIdFromService(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        //初始化时应该设定默认值.
        //1.查询一级商品分类信息
        //Long parentId = id==null?0L:id;

        //1.查询parent_id=0
        return itemCatService.findItemCatTreeByParentIdFromMapper(parentId);
    }

}
