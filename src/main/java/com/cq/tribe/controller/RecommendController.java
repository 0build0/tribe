package com.cq.tribe.controller;

import com.cq.tribe.common.MediaBean;
import com.cq.tribe.common.MediaVo;
import com.cq.tribe.common.PageMediaInfo;
import com.cq.tribe.service.RecommendService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendController {

    @Resource
    private RecommendService recommendService;

    @GetMapping("/video/list")
    public  PageMediaInfo videoList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) throws UnsupportedEncodingException {

        PageMediaInfo mediaBeanPageInfo = recommendService.videoList(pageNum, pageSize);

        return mediaBeanPageInfo;
    }


}
