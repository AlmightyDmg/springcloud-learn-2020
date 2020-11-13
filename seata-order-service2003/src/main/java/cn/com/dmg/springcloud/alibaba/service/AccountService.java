package cn.com.dmg.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface AccountService {
    /**     * 扣减账户余额     */
    void decrease(@RequestParam("userId") Long userId,
                  @RequestParam("money") BigDecimal money);
}