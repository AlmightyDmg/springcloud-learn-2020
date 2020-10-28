# springcloud-learn-2020
## 技术选型
- java8
- spring boot 2.2.2RELEASE
- spring cloud Hoxton.SR1
- spring cloud Alibaba 2.2.1.RELEASE
- lombok
- spring cloud eureka-service
- spring cloud eureka-client
- zookeeper 3.6.2
- consul
- Ribbon
- OpenFeign
- Hystrix
- GateWay
- SpringCloud Config
- SpringCloud Bus
- SpringCloud Stream


## 各项目简介
- springcloud-learn-2020 父项目
- cloud-api-commons 公用项目
- cloud-provider-payment8001 支付生产者
- cloud-consumer-order80 订单消费者
- cloud-eureka-server7001 Eureka单机服务
- cloud-eureka-server7002 与7001组成Eureka service集群
- cloud-provider-payment8002 支付生产者8002与8001组成集群
- cloud-provider-payment8004 注册进zookeeper的provider
- cloud-consumerzk-order80 注册进zookeeper的consumer
- cloud-providerconsul-payment8006 注册进Consul的provider
- cloud-consumerconsul-order80 注册进Consul的consumer
- cloud-consumer-feign-order80 使用OpenFeign进行服务调用
- cloud-provider-hystrix-payment8001 使用Hystrix的provider
- cloud-consumer-feign-hystrix-order80 使用Hystrix的consumer
- cloud-consumer-hystrix-dashboard9001 使用Hystrix的Dashboard监控功能
- cloud-gateway-gateway9527 集成使用GateWay网关
- cloud-config-center-3344 使用springcloud-config服务端
- cloud-config-client-3355 使用springcloud-config客户端
- cloud-config-client-3366 使用springcloud-config客户端配合测试Bus
- cloud-stream-rabbitmq-provider8801 消息驱动stream生产者
- cloud-stream-rabbitmq-consumer8802 消息驱动stream消费者8802
- cloud-stream-rabbitmq-consumer8803 消息驱动stream消费者8803