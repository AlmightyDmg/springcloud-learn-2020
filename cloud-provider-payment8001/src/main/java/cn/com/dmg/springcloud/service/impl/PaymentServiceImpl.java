package cn.com.dmg.springcloud.service.impl;

import cn.com.dmg.springcloud.dao.PaymentDao;
import cn.com.dmg.springcloud.entities.Payment;
import cn.com.dmg.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource   //Autowired是spring的 Resource是Java自带的 效果一样
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return this.paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return this.paymentDao.getPaymentById(id);
    }
}
