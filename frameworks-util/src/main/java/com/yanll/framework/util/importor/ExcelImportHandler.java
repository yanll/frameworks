//package com.yanll.framework.util.importor;
//
//import com.yanll.framework.facade.exception.BizException;
//import com.yanll.framework.util.poi.excel.ExcelUtil;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
///**
// * Consumer端的Excel文件预处理类
// * Created by yanll on 2016/12/7.
// *
// * @param <V>
// */
//public class ExcelImportHandler<V> extends ImportHandler<V> {
//
//    private static final Logger logger = LoggerFactory.getLogger(ExcelImportHandler.class);
//
//    /**
//     * @param separator             分割符
//     * @param filename              文件名
//     * @param is                    InputStream
//     * @param importHandlerCallback
//     * @return
//     */
//    @Override
//    public List<V> handle(String separator, String filename, InputStream is, ImportHandlerCallback<V> importHandlerCallback) {
//        if (filename == null || filename.length() == 0) throw new BizException("文件名为空，导入操作失败！");
//        logger.info("开始解析Excel文件：" + filename);
//        if (is == null) throw new BizException("文件流为空，导入操作失败！");
//        if (importHandlerCallback == null) throw new BizException("无预处理参数配置，导入操作失败！");
//        Workbook workBook = null;
//        try {
//            String file_suffix = ExcelUtil.getExtensionName(filename);
//            if (!ExcelUtil.isExcel(file_suffix)) throw new BizException("请上传后缀:[xls,xlsx]文件！");
//            workBook = ExcelUtil.getWeebWork(is, file_suffix);
//        } catch (IOException e) {
//            throw new BizException("读取文件工作簿失败，导入操作失败！");
//        }
//        if (workBook == null) throw new BizException("工作簿为空，导入操作失败！");
//        Sheet sheet = workBook.getSheetAt(0);
//        if (sheet == null) throw new BizException("Sheet为空，导入操作失败！");
//        // 获取表格中的数据，按数据行构造VOList对象
//        List<V> preExecution = new ArrayList<V>();
//        Iterator<Row> it = sheet.rowIterator();
//        int row_index = 0;
//        int cell_count = 0;
//        while (it.hasNext()) {
//            Row row = it.next();
//            //跳过第一行
//            if (row.getRowNum() == 0) {
//                row_index++;
//                cell_count = row.getLastCellNum();
//                continue;
//            }
//            String[] tmp = new String[cell_count];
//            for (int i = 0; i < cell_count; i++) {
//                Cell cell = row.getCell(i);
//                String value = ExcelUtil.getCellValue(cell);
//                if (value == null || value.length() == 0)
//                    logger.warn("Excel解析空数据警告。【行索引：" + (row_index + 1) + "，列索引：" + (i + 1) + "】");
//                tmp[i] = value;
//            }
//            V v = (V) importHandlerCallback.preHandle((row_index + 1), tmp);
//            row_index++;
//            preExecution.add(v);
//        }
//        return preExecution;
//    }
//
//}
