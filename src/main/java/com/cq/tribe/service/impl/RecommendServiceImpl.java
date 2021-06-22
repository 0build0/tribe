package com.cq.tribe.service.impl;

import com.cq.tribe.common.MediaBean;
import com.cq.tribe.common.MediaVo;
import com.cq.tribe.common.PageMediaInfo;
import com.cq.tribe.dao.CqMediaInfoMapper;
import com.cq.tribe.service.RecommendService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Resource
    private CqMediaInfoMapper cqMediaInfoMapper;

    @Override
    public PageMediaInfo videoList(int pageNum, int pageSize) throws UnsupportedEncodingException {
        PageMediaInfo pageMediaInfo = new PageMediaInfo();
        String accessKey = "cp0ycHI57QxC0LrjHx6yR_E6hfZkEwfF585thf2Y";
        String secretKey = "8MnWaPV00mWOtMnbzJCOVxOJ0wmV7ZR9guiFwDB_";
        String bucket = "cqtribe";
        String domain = "http://quwnj69of.hb-bkt.clouddn.com";

        PageHelper.startPage(pageNum,pageSize);
        List<MediaBean> mediaBeans = cqMediaInfoMapper.selectPage();
        List<MediaVo> voList = new ArrayList<>();
        for(int i=0,l=mediaBeans.size();i<l;i++) {
            MediaBean mediaBean = mediaBeans.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(domain);
            sb.append("/");
            sb.append(URLEncoder.encode(mediaBean.getMediaName(),"utf-8").replace("+","%20"));
            Auth auth = Auth.create(accessKey, secretKey);
            long expireInSeconds = 3600;
            String downloadUrl = auth.privateDownloadUrl(sb.toString(),expireInSeconds);
            MediaVo vo = new MediaVo();
            vo.setId(mediaBean.getId());
            vo.setMediaName(mediaBean.getMediaName());
            vo.setMediaDesc(mediaBean.getMediaDesc());
            vo.setUrl(downloadUrl);
            voList.add(vo);
        }
        PageInfo<MediaBean> pageInfo = new PageInfo<>(mediaBeans);
        pageMediaInfo.setPages(pageInfo.getPages());
        pageMediaInfo.setTotal(pageInfo.getTotal());
        pageMediaInfo.setData(voList);

        return pageMediaInfo;
    }
}
