# springcloud-learn-2020

## 学习脑图
![](https://gitee.com/dmg0020/draw-bed/raw/master/imgs/20220109174309.png)
获取完整的学习脑图，请搜索或扫描下方我二维码关注公众号【开源小分队】回复关键字【dddd108】

![](https://gitee.com/dmg0020/draw-bed/raw/master/imgs/20220109180100.png)

## Java 学习路线
另外给大家推荐一个一站式Java学习路线，从入门到大神再到封神的各个阶段全都包括了：
![](https://gitee.com/dmg0020/draw-bed/raw/master/imgs/20220109180613.png)

获取完整的 Java 学习路线，请搜索或扫描下方我二维码关注公众号【开源小分队】回复关键字【dddd104】

![](https://gitee.com/dmg0020/draw-bed/raw/master/imgs/20220109180100.png)

## Java 面试学习资料
最近又赶上跳槽的高峰期（招聘旺季），找阿里朋友整理一份内部资料《第6版：互联网大厂面试题》并分类 4 份 PDF，累计 926 页！

整个资料包，包括 Spring、Spring Boot/Cloud、Dubbo、JVM、集合、多线程、JPA、MyBatis、MySQL、大数据、Nginx、Git、Docker、GitHub、Servlet、JavaWeb、IDEA、Redis、算法、面试题等几乎覆盖了 Java 基础和阿里巴巴等大厂面试题等、等技术栈！

搜索微信公众号【乔治学java】或扫描下方二维码，关注公众号，回复关键字【666】，获得面试资料
![](https://gitee.com/dmg0020/draw-bed/raw/master/imgs/20220109181242.png)

## 技术选型
- java8
- lombok
- spring boot 2.2.2RELEASE
- spring cloud Hoxton.SR1
- spring cloud Alibaba 2.2.1.RELEASE
- spring cloud eureka
- zookeeper
- consul
- Ribbon
- OpenFeign
- Hystrix
- GateWay
- SpringCloud Config
- SpringCloud Bus
- SpringCloud Stream
- SpringCloud Sleuth
- SpringCloud Alibaba Nacos
- SpringCloud Alibaba Sentinel
- SpringCloud Alibaba Seata


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
- cloudalibaba-provider-payment9001 springcloud alibaba nacos 服务提供者9001
- cloudalibaba-provider-payment9002 springcloud alibaba nacos 服务提供者9002
- cloudalibaba-consumer-nacos-order83 springcloud alibaba nacos 服务消费者83
- cloudalibaba-config-nacos-client3377 springcloud alibaba nacos 配置中心
- cloudalibaba-sentinel-service8401 springcloud alibaba sentinel
- cloudalibaba-provider-payment9003 springcloud alibaba sentinel 整合Ribbon和OpenFeign生产者
- cloudalibaba-provider-payment9004 springcloud alibaba sentinel 整合Ribbon和OpenFeign生产者
- cloudalibaba-consumer-nacos-order84 springcloud alibaba sentinel 整合Ribbon和OpenFeign消费者
- seata-order-service2001 springcloud alibaba 整合使用seata之Order模块订单端
- seata-order-service2002 springcloud alibaba 整合使用seata之Order模块库存端
- seata-order-service2003 springcloud alibaba 整合使用seata之Order模块账户端
