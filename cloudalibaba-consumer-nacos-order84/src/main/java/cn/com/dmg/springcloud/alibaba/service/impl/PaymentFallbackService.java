package cn.com.dmg.springcloud.alibaba.service.impl;
import cn.com.dmg.springcloud.alibaba.service.PaymentService;
import cn.com.dmg.springcloud.entities.CommonResult;
import cn.com.dmg.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id)    {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}