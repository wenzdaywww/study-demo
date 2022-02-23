# 项目简介
## Spring Cloud 学习Demo
# 项目内容
## common: 服务接口的POJO类
## consumer-ribbon: 服务消费者(ribbon负载均衡，Spring Cloud 2020.x.x版本以后推荐使用loadbalancer)
## provider1、provider2、provider3为同一项目，实际部署只需根据profiles设置不同打包部署即可
## provider1：服务提供者1
## provider2：服务提供者2
## provider3：服务提供者3
## eureka-server-cluster1、eureka-server-cluster2、eureka-server-cluster3为同一项目，实际部署只需根据profiles设置不同打包部署即可
## eureka-server-cluster1：eureka服务注册中心集群1
## eureka-server-cluster2：eureka服务注册中心集群2
## eureka-server-cluster3：eureka服务注册中心集群3
## hystrix-dashboard：Hystrix Dashboard（熔断仪表盘）监控数据服务
## config-server: spring cloud config服务端
## config-client: spring cloud config客户端