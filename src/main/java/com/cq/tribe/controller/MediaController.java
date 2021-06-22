package com.cq.tribe.controller;

import com.cq.tribe.common.Media;
import com.cq.tribe.common.MediaBean;
import com.cq.tribe.dao.CqMediaInfoMapper;
import com.cq.tribe.service.UpdateMediaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;

@RestController
@RequestMapping("/media")
public class MediaController {

    @Resource
    private UpdateMediaService updateMediaService;
    @Resource
    private CqMediaInfoMapper cqMediaInfoMapper;

    @PostMapping("/upload")
    public String uploadMedia(Media media) {

        try{
            MediaBean mediaBean = new MediaBean();
            MultipartFile file = media.getFile();
            String name = file.getOriginalFilename();
            String contentType = media.getFile().getContentType();
            if (StringUtils.isNotBlank(contentType) && contentType.contains("/")) {
                contentType = contentType.split("/")[0];
            }
            mediaBean.setMediaDesc(media.getMediaDesc());
            mediaBean.setMediaType(contentType);
            mediaBean.setCqId(0L);
            mediaBean.setSort(1);
            mediaBean.setMediaName(name);
            mediaBean.setCreateUser("f");
            mediaBean.setUpdateUser("f");
            InputStream inputStream = media.getFile().getInputStream();
            boolean uploadSuccess = updateMediaService.updateMedia(inputStream, name);
            if (uploadSuccess) {
                Integer integer = cqMediaInfoMapper.addMedia(mediaBean);
                System.out.println(integer);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "成功";
    }



}
