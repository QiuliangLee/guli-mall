package com.zsy;

import com.zsy.product.entity.BrandEntity;
import com.zsy.product.service.BrandService;
import com.zsy.product.test.factorStragerModel.AbstractHandler;
import com.zsy.product.test.factorStragerModel.Factory;
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

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("HuaWei");
        brandService.save(brandEntity);
        System.out.println("save successfully!");
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void queryPage() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("hello", "workd" + UUID.randomUUID());
        String hello = ops.get("hello");
        System.out.println(hello);
    }

    @Autowired
    RedissonClient redissonClient;

    @Test
    public void test2() {
        System.out.println(redissonClient);
    }

    @Test
    public void test3() {
        String name = "b";
        AbstractHandler abstractHandler = Factory.get(name);
        abstractHandler.BBB(name);
        name = "a";
        AbstractHandler abstractHandler1 = Factory.get(name);
        abstractHandler1.AAA(name);
    }

}
