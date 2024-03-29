package cn.com.dmg.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 这个类就相当于之前的spring项目中的applicationConteext.xml文件
 * 而@Bean注解就相当于之前的
 * <bean id="" class=""></bean>
 */

@Configuration
public class ApplicationContextConfig {
    @Bean
    //@LoadBalanced //开启负载均衡 默认轮询
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
