package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @auther Zangyiyi
 * @date 2020/7/7 - 16:49
 */
//!!!POJO的实体对象,一般都是用包装类型

@Data
@Accessors(chain = true)
@TableName("tb_item_cat")//关联商品分类
public class ItemCat extends BasePojo {
    @TableId(type = IdType.AUTO)//自增主键
    private Long id;
    private Long parentId;
    private String name;
    private Integer status;//1.正常 2.删除
    private Integer sortOrder;//排序号
    private Boolean isParent;//0 false   1 true


}
