package cn.com.dmg.springcloud.alibaba.service;
import cn.com.dmg.springcloud.alibaba.service.impl.PaymentFallbackService;
import cn.com.dmg.springcloud.entities.CommonResult;
import cn.com.dmg.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService{
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}