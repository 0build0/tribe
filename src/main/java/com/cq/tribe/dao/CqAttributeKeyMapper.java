package com.cq.tribe.dao;

import com.cq.tribe.common.AttrKeyBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CqAttributeKeyMapper {
    Integer addAttribute(AttrKeyBean key);
    List<AttrKeyBean> attrList();
}
