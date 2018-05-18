package com.yanll.framework.web.filter;

import com.yanll.framework.facade.domain.AjaxResult;
import com.yanll.framework.facade.exception.BizCode;
import com.yanll.framework.facade.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author
 * @Description: 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public AjaxResult bizExceptionHandler(BizException bizException) {
        AjaxResult result = new AjaxResult();
        result.setCode(bizException.getCode());
        if (bizException.getMsg() != null && bizException.getMsg().length() != 0) {
            result.setDesc(bizException.getMsg());
        }
        String mes = "[" + bizException.getCode() + "," + bizException.getMsg() + "]";
        if (bizException.getCode() != BizCode.DEFAULT_BIZ_ERROR.getValue().intValue()) {
            logger.error(mes, bizException);
        } else {
            logger.error(mes);
        }
        return result;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public AjaxResult runtimeExceptionHandler(RuntimeException runtimeException) {
        AjaxResult result = new AjaxResult();
        result.setCode(BizCode.INTERNAL_SERVER_ERROR.getValue());
        result.setDesc(BizCode.INTERNAL_SERVER_ERROR.getDesc());
        String runtime_err = BizCode.INTERNAL_SERVER_ERROR.getDesc();
        if (runtimeException.getMessage() != null && runtimeException.getMessage().length() > 0) {
            runtime_err = runtimeException.getMessage();
        }
        logger.error(runtime_err, runtimeException);
        return result;
    }

}
