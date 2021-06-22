package com.cq.tribe.dao;

import com.cq.tribe.common.MediaBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CqMediaInfoMapper {
    Integer addMedia(MediaBean media);
    /**
     * 分页查询
     * @return
     */
    List<MediaBean> selectPage();

}
