package cn.com.dmg.springcloud.controller;

import cn.com.dmg.springcloud.entities.CommonResult;
import cn.com.dmg.springcloud.entities.Payment;
import cn.com.dmg.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    //读取application.yml文件中配置的port
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    //参数这里不加RequestBody注解，在80调用的时候，serial的值不会自动封装到实体
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        if(result > 0){
            return new CommonResult(200,"插入数据库成功,serverPort：" + serverPort,result);
        } else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果：" + payment);
        if(payment != null){
            return new CommonResult(200,"查询成功，serverPort：" + serverPort,payment);
        } else {
            return new CommonResult(444,"查询失败,查询id为" + id,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        //获得Eureka中注册的所有服务名称
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("**********service:" + service);
        }
        //根据服务名称获得该服务下所有的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
