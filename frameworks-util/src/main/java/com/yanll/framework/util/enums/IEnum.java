package com.yanll.framework.util.enums;

import java.util.Map;

public interface IEnum {

    public enum YESNO {
        Y(1, "是"), N(0, "否");
        private Integer value;
        private String desc;

        private YESNO(Integer value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public Integer getValue() {
            return this.value;
        }

        public String getDesc() {
            return desc;
        }

    }

    public static void main(String[] args) {
        Map<Integer, String> map = EnumUtil.toMap(YESNO.class);

        System.out.println(EnumUtil.exists(2, YESNO.class));

    }

}


