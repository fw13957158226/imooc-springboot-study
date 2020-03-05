package com.imooc.springboot.study.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义事件端点
 * Created by fengwei on 2020/3/5.
 */
@Endpoint(id="datetime")
public class DateTimeEndPoint {

    private String format="yyyy-MM-dd HH:mm:ss";

    public Map<String ,Object> info(){
        Map<String ,Object> info=new HashMap<>();
        info.put("name","fengwei");
        info.put("age","19");
        info.put("datetime",new SimpleDateFormat(format).format(new Date()));

        return info;

    }
    @WriteOperation
    public void setFormat(String format){
        this.format=format;
    }
}
