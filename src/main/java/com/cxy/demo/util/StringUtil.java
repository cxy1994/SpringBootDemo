package com.cxy.demo.util;

public class StringUtil {

    public String NullToBlank(String str){
        if(str == null || "".equals(str)){
            return "";
        }
        return str;
    }


}
