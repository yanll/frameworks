package com.yanll.framework.data.domain;

import java.io.Serializable;
import java.util.Date;


public class POEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Date createTime;        //创建时间
    private Date modifyTime;        //修改时间

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
