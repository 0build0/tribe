package com.cq.tribe.controller;

import com.cq.tribe.common.GoodsBean;
import com.cq.tribe.service.GoodsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @GetMapping("/list")
    public List<GoodsBean> goodsBeanList() {
        return goodsService.goodsListPage();
    }

}
