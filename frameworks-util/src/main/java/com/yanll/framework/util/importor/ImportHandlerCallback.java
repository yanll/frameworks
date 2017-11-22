package com.yanll.framework.util.importor;


/**
 * 文件导入数据预处理
 * Created by yanll on 2016/12/7.
 *
 * @param <V>
 */
@FunctionalInterface
public interface ImportHandlerCallback<V> {

    /**
     * 数据校验、VO构建
     *
     * @param error_index 出现错误或警告的行索引
     * @param values      根据数据行解析出的数组
     * @return
     */
    V preHandle(int error_index, String[] values);

}
