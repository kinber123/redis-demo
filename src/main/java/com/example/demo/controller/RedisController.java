package com.example.demo.controller;

import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* @author wcy
 * \* @date: 2020-05-28 14:37
 * \* Description:  类
 * \
 */
@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    /**
     *   简单使用
     * @param id
     * @return
     */
    @RequestMapping(value = "/get")
    public  Object getRedis(String id){
        return   redisService.getRedis(id);
    }

    @RequestMapping(value = "/set")
    public  Object setRedis(String id,String value){
        return   redisService.setRedis(id,value);
    }

    /**
     * 调用工具类使用
     * @param id
     * @return
     */
    @RequestMapping(value = "/uget")
    public  Object ugetRedis(String id){
        return redisService.ugetRedis(id);
    }

    @RequestMapping(value = "/uset")
    public  Object usetRedis(String id,String value){
       return redisService.usetRedis(id,value);
    }
    @RequestMapping(value = "/usetTime")
    public Object usetRedisTime(String id ,String value,Integer time){
        return redisService.usetRedisTime(id,value,time);
    }

}
