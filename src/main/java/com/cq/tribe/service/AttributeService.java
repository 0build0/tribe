package com.cq.tribe.service;

import com.cq.tribe.common.AttrKeyBean;
import com.cq.tribe.common.AttrValueBean;

public interface AttributeService {
    void addAttrKey(AttrKeyBean key);
    void addAttrVal(AttrValueBean val);
}
