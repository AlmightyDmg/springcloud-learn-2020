package cn.com.dmg.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_ok(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_ok，id：" + id ;
    }

    /**
     *
     * 超时访问的方法
     * @param id
     * @return
     */
    //这句话的意思是当“paymentInfo_timeout”方法出现问题的时候，使用“paymentInfoTimeoutHandler”进行兜底
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",commandProperties = {
            //设置该线程在3秒钟之内的相应是正常的，超过3秒则不正常
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_timeout(Integer id){
        Integer time = 3;
        //int a = 1/0;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_timeout，id：" + id + "，耗时"+ time + "秒钟";
    }

    public String paymentInfoTimeoutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " 系统繁忙或程序报错，请稍后再试，id：" + id + "，o(╥﹏╥)o";
    }


    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            /**
             * 请求次数 一个rolling window内最小的请求数。如果设为20，那么当一个rolling window的时间内
             * （比如说1个rolling window是10秒）收到19个请求，即使19个请求都失败，也不会触发circuit break。默认20
             */
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围 当触发熔断之后，会在10秒钟之内拒绝所有请求
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }

}
