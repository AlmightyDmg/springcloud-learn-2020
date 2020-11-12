package cn.com.dmg.springcloud.alibaba.controller;

import cn.com.dmg.springcloud.alibaba.domain.CommonResult;
import cn.com.dmg.springcloud.alibaba.domain.Order;
import cn.com.dmg.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
@RestController
public class OrderController{
    @Resource
    private OrderService orderService;
    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}