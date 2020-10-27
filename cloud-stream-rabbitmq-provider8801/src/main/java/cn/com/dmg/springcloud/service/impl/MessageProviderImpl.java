package cn.com.dmg.springcloud.service.impl;

import cn.com.dmg.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)//定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;//消息发送通道

    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        //这段代码参考官网示例
        output.send(MessageBuilder.withPayload(s).build());
        System.out.println("**********" + s);
        return null;
    }
}
