package com.cq.tribe.common;
import lombok.Data;

import java.util.Date;

@Data
public class GoodsBean extends BaseBean{
    private Integer id;
    private String name;
    private Integer sex;
    private Integer father;
    private Integer mother;
    private Date birth;
}
