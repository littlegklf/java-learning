package com.example.redis.controller;

import com.example.redis.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kuanglifang
 * @date 2021/3/10 16:56
 */
@Slf4j
@RestController
public class RedisTestController {

    @Autowired
    private RedisUtil redisUtil;
    @GetMapping("/{id}")
    public String hello(@PathVariable String id) {
        boolean hasKey = redisUtil.hasKey(id);
        String str = "";
        if (hasKey) {
            Object object = redisUtil.get(id);
            log.info("从缓存中获取的数据" + object);
            str = object.toString();
        }else {
            log.info("从数据库中获取数据");
            str = "hello";
            redisUtil.set(id, str);
            log.info("数据插入缓存 " + str);
        }
        return str;
    }
}
