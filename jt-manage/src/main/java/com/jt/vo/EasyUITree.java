package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @auther Zangyiyi
 * @date 2020/7/8 - 11:27
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class EasyUITree {
    private Long id;//id与ItemCat的Id一致
    private String text;//文本信息ItemCat的name一致
    private String state;//状态 打开:open 关闭closed
}
