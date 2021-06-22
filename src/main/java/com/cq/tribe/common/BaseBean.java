package com.cq.tribe.common;
import lombok.Data;
import java.util.Date;

@Data
public abstract class BaseBean {
    private Integer isDelete;
    private Date createTime;
    private Date updateTime;
    private String createUser;
    private String updateUser;
    private Date ts;
}
