package com.yanll.framework.facade.domain;

import java.io.File;
import java.io.Serializable;
import java.util.Date;


public class DTOEntity implements Serializable {
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


    public static void main(String[] args) {
        File ds = new File("D:\\workspace\\platforms-ui\\auth-ui\\node_modules\\accepts");
        //if(true)return;

        File d = new File("D:\\workspace\\platforms-ui\\auth-ui\\node_modules");
        File[] fs = d.listFiles();
        for (File f : fs) {
            if (f.isDirectory()) {
                //System.out.println(f.getPath());
            } else {
                if (f.getName().startsWith(".")) continue;
                System.out.println("cnpm install " + f.getName());
            }
        }
    }

}
