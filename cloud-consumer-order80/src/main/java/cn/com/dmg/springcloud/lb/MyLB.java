package cn.com.dmg.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyLB implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
            /**
             * 如果当前值==给定的值，则将该值原子设置为新的值
             * 就是：如果atomicInteger.get() == current  将atomicInteger的值设置为next
             */
        } while (!this.atomicInteger.compareAndSet(current,next));
        log.info("**********第几次访问，next:" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        //访问次数 % 服务数量
        int index = this.getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }


}
