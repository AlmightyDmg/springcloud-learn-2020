package cn.com.dmg.springcloud.service;

import cn.com.dmg.springcloud.entities.CommonResult;
import cn.com.dmg.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    /**
     * 结合@FeignClient(value = "CLOUD-PAYMENT-SERVICE") 注解 使用的含义是：
     * 调用 服务为“CLOUD-PAYMENT-SERVICE”下的地址为“/payment/get/{id}”的方法
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
