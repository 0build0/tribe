package com.cq.tribe.common;

import lombok.Data;

@Data
public class MediaVo {
    private Long id;
    private String url;
    private String mediaName;
    private String mediaDesc;
    private String createTime;
}
