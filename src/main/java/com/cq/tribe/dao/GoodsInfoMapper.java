package com.cq.tribe.dao;

import com.cq.tribe.common.GoodsBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsInfoMapper {
    List<GoodsBean> getGoodsPage();
}
