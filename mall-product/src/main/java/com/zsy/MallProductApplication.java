package com.zsy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author ZSY
 */
@EnableRedisHttpSession
@EnableFeignClients
@MapperScan("com.zsy.product.dao")
@EnableDiscoveryClient
@SpringBootApplication
/**
 * 3、JSR03
 * 1)、给Bean添加校验注解：java.validation.constraints,并定义自己的message提示
 * 2）、开启校验功能@valid。效果：校验错误以后会有默认的相应
 * 3）、给校验的bean后紧跟一个BindingResult，就可以获取到校验的结果
 *4）、统一的异常处理
 *  @ControllerAdvice
 * 1）、@NotBlank(message="品牌名必须提交"， groups={AddGroup.Class, UpdateGroup.class}) 给校验注解标注什么情况需要进行校验
 * 2）、@validated（{AddGroup.class}）
 * 3)、默认没有指定分株的校验注解@NotBlank，在分组校验情况下不生效，只会在@Validated生效；
 * 5）、自定义校验
 *      1）、编写一个自定义的校验注解
 *      2）、编写一个自定义的校验器 ConstraintValidator
 *      3）、关联自定义的校验器和自定义的校验注解
 */
public class MallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallProductApplication.class, args);
    }

}
