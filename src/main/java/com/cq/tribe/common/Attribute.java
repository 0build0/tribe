package com.cq.tribe.common;

import lombok.Data;
import java.util.List;

@Data
public class Attribute {
    private List<AttrKeyBean> keyList;
    private List<AttrValueBean> valueList;
}
