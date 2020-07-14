package com.jt.service;

import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.vo.EasyUITable;

public interface ItemService {
    EasyUITable findAllFromMapper(Integer start, Integer rows);

    void saveItemToMapper(Item item, ItemDesc itemDesc);

    void updateItemToMapper(Item item, ItemDesc itemDesc);

    void deleteItemToMapper(Long[] ids);

    void changeStatusItemToMapper(Integer status, Long[] ids);

    ItemDesc findItemDescByIdFromMapper(Long itemId);
}
