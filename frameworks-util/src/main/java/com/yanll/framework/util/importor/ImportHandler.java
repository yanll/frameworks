package com.yanll.framework.util.importor;

import java.io.InputStream;
import java.util.List;

/**
 * 文件导入预处理
 * Created by yanll on 2016/12/7.
 *
 * @param <V>
 */
public abstract class ImportHandler<V> {

    /**
     * @param separator             分割符
     * @param filename              文件名
     * @param is                    InputStream
     * @param importHandlerCallback
     * @return
     */
    public abstract List<V> handle(String separator, String filename, InputStream is, ImportHandlerCallback<V> importHandlerCallback);

}
