package cn.com.dmg.springcloud.alibaba.myhandler;

import cn.com.dmg.springcloud.entities.CommonResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(444, "自定义限流处理信息....CustomerBlockHandler");
    }

    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(444, "自定义限流处理信息....CustomerBlockHandler-------2");
    }
}
