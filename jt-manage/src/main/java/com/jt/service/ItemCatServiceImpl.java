package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemCatMapper;
import com.jt.pojo.Item;
import com.jt.pojo.ItemCat;
import com.jt.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Zangyiyi
 * @date 2020/7/7 - 17:06
 */
@Service
public class ItemCatServiceImpl implements ItemCatService{

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public ItemCat findItemCatFromMapper(Long itemCatId) {
        return itemCatMapper.selectById(itemCatId);
    }

    @Override
    public List<EasyUITree> findItemCatTreeByParentIdFromMapper(Long parentId) {
        QueryWrapper<ItemCat> queryWrapper = new QueryWrapper();
        queryWrapper.eq("parent_id" , parentId);
        List<ItemCat> itemCatList = itemCatMapper.selectList(queryWrapper);
        List<EasyUITree> easyUITreeList = new ArrayList<EasyUITree>();
        //将数据库记录转化为VO数据
        for(ItemCat itemCat:itemCatList){
            EasyUITree easyUITree = new EasyUITree(itemCat.getId(), itemCat.getName(), itemCat.getIsParent()?"closed":"open");
            easyUITreeList.add(easyUITree);
        }
        return easyUITreeList;
    }
}
