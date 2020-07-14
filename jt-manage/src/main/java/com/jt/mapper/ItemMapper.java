package com.jt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.Item;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItemMapper extends BaseMapper<Item> {
    @Select("select * from tb_item order by updated desc LIMIT #{start},#{rows}")
    List<Item> findAllItemFromData(Integer start, Integer rows);
}
