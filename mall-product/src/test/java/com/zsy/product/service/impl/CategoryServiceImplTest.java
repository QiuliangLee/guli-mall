package com.zsy.product.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
        String str = "2012-12-03";
        LocalDate localDate = LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        ZoneId zoneId = ZoneId.of("UTC+8");
        Date from = Date.from(localDate.atStartOfDay().atZone(zoneId).toInstant());
        System.out.println(from);
    }
}