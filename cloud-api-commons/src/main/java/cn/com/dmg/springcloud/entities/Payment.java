package cn.com.dmg.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor  //全参构造方法
@NoArgsConstructor  //无参构造方法
public class Payment implements Serializable {//序列化在分布式部署的时候可能会用到
    private long id;
    private String serial;
}
