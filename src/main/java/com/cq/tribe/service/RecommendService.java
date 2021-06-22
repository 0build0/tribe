package com.cq.tribe.service;


import com.cq.tribe.common.MediaBean;
import com.cq.tribe.common.MediaVo;
import com.cq.tribe.common.PageMediaInfo;
import com.github.pagehelper.PageInfo;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface RecommendService {

    PageMediaInfo videoList(int pageNum, int pageSize) throws UnsupportedEncodingException;

}
