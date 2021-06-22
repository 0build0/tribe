package com.cq.tribe.common;

import lombok.Data;
import java.util.List;

@Data
public class PageMediaInfo {
    private Long total;
    private List<MediaVo> data;
    private Integer pages;
}
