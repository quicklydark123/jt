package com.jt.service;

import com.jt.pojo.ItemCat;
import com.jt.vo.EasyUITree;

import java.util.List;

/**
 * @auther Zangyiyi
 * @date 2020/7/7 - 17:06
 */
public interface ItemCatService {
    ItemCat findItemCatFromMapper(Long itemCatId);

    List<EasyUITree> findItemCatTreeByParentIdFromMapper(Long parentId);
}
