package com.cq.tribe.service.impl;

import com.cq.tribe.common.GoodsBean;
import com.cq.tribe.dao.GoodsInfoMapper;
import com.cq.tribe.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsInfoMapper goodsInfoMapper;


    @Override
    public List<GoodsBean> goodsListPage() {
        List<GoodsBean> goodsPage = goodsInfoMapper.getGoodsPage();
        return goodsPage;
    }
}
