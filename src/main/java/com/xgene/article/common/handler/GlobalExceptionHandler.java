package com.xgene.article.common.handler;

import com.xgene.article.controller.XgeneResponse;
import com.xgene.article.common.exception.ErrorInfo;
import com.xgene.article.common.exception.ErrorStatusCode;
import com.xgene.article.common.exception.SystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler extends XgeneResponse {
//    /**
//     * 返回html页面
//     * 通过@ExceptionHandler配置异常类型，不同的Exception映射到不同的异常处理页面
//     * @param request
//     * @param e
//     * @return
//     * @throws Exception
//     */
//    @ExceptionHandler(value = Exception.class)   //定义函数针对的异常类型
//    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception{
//        ModelAndView model=new ModelAndView();
//        model.addObject("exception",e);
//        model.addObject("url",request.getServletPath()+":"+request.getServerPort());
//        model.addObject("method",request.getMethod());
//        model.setViewName(default_error_view);
//        return model;
//    }

    /**
     * 返回Json格式信息
     * 不同的异常类型匹配@ExceptionHandler中配置的异常类型来匹配错误映射和处理
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> exceptionHandler(HttpServletRequest request, Exception e) {
        ErrorInfo<String> data=new ErrorInfo<>();
        e.printStackTrace();
        if (e instanceof IllegalArgumentException) {
            System.out.println(e.getMessage());
        }
        data.setMessage("服務器發生錯誤，請稍候片刻重新發送請求或聯繫客服！！"+e.getMessage());
        data.setStatusCode(ErrorStatusCode.SYSTEM_UNKNOWN_ERROR);
        return data;
    }
    /**
     * 返回Json格式信息
     * 不同的异常类型匹配@ExceptionHandler中配置的异常类型来匹配错误映射和处理
     * @param request
     * @param fe
     * @return
     * @throws SystemException
     */
//    @ExceptionHandler(value = SystemException.class)
//    @ResponseBody
//    public ErrorInfo<String> systemExceptionHandler(HttpServletRequest request, SystemException fe) throws SystemException {
//        ErrorInfo<String> data=new ErrorInfo<>();
//        if(fe!=null){
//            data.setMessage(fe.getMessage());
//        }
//        data.setStatusCode(fe.getStatusCode());
//        return data;
//    }
//
    @ExceptionHandler(value = SystemException.class)
    @ResponseBody
    public String systemExceptionHandler(HttpServletRequest request, SystemException fe)throws SystemException {
        return failure(fe.getStatusCode(), fe.getMessage());
    }
}
