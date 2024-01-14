package com.zsy;

import com.zsy.product.Season;
import com.zsy.product.entity.BrandEntity;
import com.zsy.product.service.AttrService;
import com.zsy.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.UUID;

@SpringBootTest
class MallProductApplicationTests {

    @Autowired
    BrandService brandService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedissonClient redissonClient;
    @Autowired
    private AttrService attrService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("HuaWei");
        brandService.save(brandEntity);
        System.out.println("save successfully!");
    }

    @Test
    public void queryPage() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("hello", "workd" + UUID.randomUUID());
        String hello = ops.get("hello");
        System.out.println("d234");
    }

    @Test
    public void test2() {
        System.out.println(redissonClient);
    }

    @Test
    public void test4() {
        Integer i = 2;
        Season.SPRING.getCode();
        System.out.println(Season.getFromCode(i).getDesc());
    }
}
