package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.ItemDescMapper;
import com.jt.pojo.ItemDesc;
import com.jt.vo.EasyUITable;
import com.jt.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.mapper.ItemMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ItemDescMapper itemDescMapper;

//    @Override
//    public EasyUITable findAllFromMapper(Integer page, Integer rows) {
//        int total = itemMapper.selectCount(null);
//        int start = (page - 1) * rows;
//        List<Item> itemList = itemMapper.findAllItemFromData(start, rows);
//        return new EasyUITable(total, itemList);
//    }

    /**
     * 利用MP的方式查询数据记录
     * current:查询第几页
     * size: 每页记录数
     */
    @Override
    public EasyUITable findAllFromMapper(Integer page, Integer rows) {
        //1.定义分页对象
        Page<Item> mpPage = new Page<Item>(page, rows);
        //2.定义条件构造器
        QueryWrapper<Item> queryWrapper = new QueryWrapper<Item>();
        //3.要求:按照更新时间,进行排序  降序排列.
        queryWrapper.orderByDesc("updated");
        //执行分页操作,之后封装Page对象数据
        mpPage = itemMapper.selectPage(mpPage, queryWrapper);
        int total = (int) mpPage.getTotal();
        List<Item> itemsList = mpPage.getRecords();//获取当前分页记录
        return new EasyUITable(total, itemsList);

    }

    //控制数据事务
    @Transactional
    @Override
    public void saveItemToMapper(Item item, ItemDesc itemDesc) {
        item.setStatus(1).setCreated(new Date()).setUpdated(item.getCreated());
        itemMapper.insert(item);
        itemDesc.setItemId(item.getId()).setUpdated(item.getUpdated()).setCreated(item.getCreated());
        itemDescMapper.insert(itemDesc);
    }

    @Transactional
    @Override
    public void updateItemToMapper(Item item, ItemDesc itemDesc) {
        item.setUpdated(new Date());
        itemMapper.updateById(item);
        itemDesc.setItemId(item.getId())
                .setUpdated(item.getUpdated());
        itemDescMapper.updateById(itemDesc);
    }

    @Transactional
    @Override
    public void deleteItemToMapper(Long[] ids) {
        List<Long> idsLIst = Arrays.asList(ids);
        itemMapper.deleteBatchIds(idsLIst);
        itemDescMapper.deleteBatchIds(idsLIst);
    }

    @Transactional
    @Override
    public void changeStatusItemToMapper(Integer status, Long[] ids) {
        UpdateWrapper<Item> itemUpdataWrapper = new UpdateWrapper<Item>();
        //itemUpdataWrapper.setSql("status="+status+",updated=now()");
        itemUpdataWrapper.set("status", status).set("updated", new Date());
        itemUpdataWrapper.in("id", Arrays.asList(ids));
        itemMapper.update(null, itemUpdataWrapper);
    }

    @Override
    public ItemDesc findItemDescByIdFromMapper(Long itemId) {
               return  itemDescMapper.selectById(itemId);
    }

}
