package com.example.demo.service;

/**
 * \* @author wcy
 * \* @date: 2020-05-28 14:39
 * \* Description:  接口
 * \
 */
public interface RedisService {

    /**
     * 根据id 获取redis 的数据
     *
     * @param id
     * @return
     */
    Object getRedis(String id);

    /**
     * Redis设置数据
     *
     * @param id
     * @param value
     * @return
     */
    Object setRedis(String id, String value);

    /**
     * 根据id 调用工具类型获取redis 的数据
     *
     * @param id
     * @return
     */
    Object ugetRedis(String id);

    /**
     * 调用工具类 Redis设置数据
     *
     * @param id
     * @param value
     * @return
     */
    Object usetRedis(String id, String value);

    /**
     * 调用工具类 实现数据存储时间
     * @param id  key 值
     * @param value
     * @param time 指定秒
     * @return
     */
    Object usetRedisTime(String id,String value,Integer time);

}
