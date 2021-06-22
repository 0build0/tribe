package com.cq.tribe.common;

import lombok.Data;

@Data
public class MediaBean extends BaseBean{

    private Long id;
    private String mediaType;
    private String mediaName;
    private String mediaDesc;
    private Long cqId;
    private Integer sort;
}
