package cn.com.dmg.springcloud.config;

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
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
