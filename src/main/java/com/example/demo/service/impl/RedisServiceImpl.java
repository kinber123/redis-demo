package com.example.demo.service.impl;

import com.example.demo.service.RedisService;
import com.example.demo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;


/**
 * \* @author wcy
 * \* @date: 2020-05-28 14:40
 * \* Description:  类
 * \
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate template;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Object getRedis(String id) {
        return template.opsForValue().get(id);
    }

    @Override
    public Object setRedis(String id, String value) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put(id,value);
        try {
            template.opsForValue().set(id,hashMap);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return template.opsForValue().get(id);
    }

    @Override
    public Object ugetRedis(String id) {
        return redisUtils.get(id);
    }

    @Override
    public Object usetRedis(String id, String value) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put(id,value);
        redisUtils.set(id,value);
        return redisUtils.get(id);
    }

    @Override
    public Object usetRedisTime(String id, String value, Integer time) {
        // time 指定时间类型是 秒
        redisUtils.set(id,value,time);
        //获取过期时间
        return redisUtils.getExpire(id);
    }
}
