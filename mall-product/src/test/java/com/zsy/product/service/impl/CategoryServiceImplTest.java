package com.zsy.product.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.UUID;

/**
 * @author Lucas
 * @create 2023-08-27 1:56
 */
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void queryPage() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("hello", "workd" + UUID.randomUUID());
        String hello = ops.get("hello");
        System.out.println(hello);
    }
}