package com.cq.tribe.common;

import lombok.Data;

@Data
public class AttrValueBean extends BaseBean{
    private Integer id;
    private Integer attrId;
    private String value;
}
