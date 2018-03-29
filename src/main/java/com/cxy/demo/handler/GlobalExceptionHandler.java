package com.cxy.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(HttpServletRequest req,Exception e){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success",false);
        map.put("message",e.getMessage());
        return map;
    }

}
