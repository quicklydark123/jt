package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ImageVO {
    private Integer error;
    private String url;
    private Integer width;
    private Integer height;

    public static com.jt.vo.ImageVO fail() {
        return new com.jt.vo.ImageVO(1, null, null, null);
    }

    public static com.jt.vo.ImageVO successful(String url) {
        return new com.jt.vo.ImageVO(0, url, null, null);
    }

    public static com.jt.vo.ImageVO successful(String url, Integer width, Integer height) {
        return new com.jt.vo.ImageVO(0, url, width, height);
    }

}

