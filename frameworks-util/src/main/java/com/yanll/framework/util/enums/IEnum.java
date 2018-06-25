package com.yanll.framework.util.enums;

import java.util.Map;

public interface IEnum {

    public enum YESNO {
        Y("1", "是"), N("0", "否");
        private String key;
        private String value;

        private YESNO(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return this.value;
        }

    }

    public enum SYSTEM_PORTAL {
        AUTH_CONSOLE("auth_console", "授权控制台"),
        MONITOR_CONSOLE("monitor_console", "监控控制台");
        private String key;
        private String value;

        private SYSTEM_PORTAL(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return this.value;
        }

    }

    public static void main(String[] args) {
        Map<String, String> map = EnumUtil.toMap(SYSTEM_PORTAL.class);
        System.out.println(EnumUtil.exists("0", YESNO.class));

    }

}


