package cn.com.dmg.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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

}
