package com.cq.tribe.dao;

import com.cq.tribe.common.AttrKeyBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CqAttributeValueMapper {
    Integer addAttributeValue(AttrKeyBean key);
    List<AttrKeyBean> attrValueList(@Param("id") Integer id);
}
