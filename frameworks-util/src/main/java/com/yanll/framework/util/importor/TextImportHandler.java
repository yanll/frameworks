//package com.yanll.framework.util.importor;
//
//import com.yanll.framework.facade.exception.BizException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Consumer端的文本文件预处理类
// * Created by yanll on 2016/12/7.
// *
// * @param <V>
// */
//public class TextImportHandler<V> extends ImportHandler<V> {
//
//    private static final Logger logger = LoggerFactory.getLogger(TextImportHandler.class);
//
//    /**
//     * todo-yll-fixme
//     *
//     * @param separator             分割符
//     * @param filename              文件名
//     * @param is                    InputStream
//     * @param importHandlerCallback
//     * @return
//     */
//    @Override
//    public List<V> handle(String separator, String filename, InputStream is, ImportHandlerCallback<V> importHandlerCallback) {
//        if (filename == null || filename.length() == 0) throw new BizException("文件名为空，导入操作失败！");
//        logger.info("开始解析文本文件：" + filename);
//        if (is == null) throw new BizException("文件流为空，导入操作失败！");
//        if (importHandlerCallback == null) throw new BizException("无预处理参数配置，导入操作失败！");
//        List<V> preExecution = new ArrayList<V>();
//        V v = (V) importHandlerCallback.preHandle(0, null);
//        preExecution.add(v);
//        return preExecution;
//    }
//
//}
