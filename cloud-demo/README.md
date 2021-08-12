# 项目简介
## Spring Cloud 学习Demo
# 项目内容
## cloud-data: 服务接口的POJO类
## cloud-consumer-ribbon: 服务消费者(ribbon负载均衡，Spring Cloud 2020.x.x版本以后推荐使用loadbalancer)
## cloud-provider1、cloud-provider2、cloud-provider3为同一项目，实际部署只需根据profiles设置不同打包部署即可
## cloud-provider1：服务提供者1
## cloud-provider2：服务提供者2
## cloud-provider3：服务提供者3
## cloud-eureka-server-cluster1、cloud-eureka-server-cluster2、cloud-eureka-server-cluster3为同一项目，实际部署只需根据profiles设置不同打包部署即可
## cloud-eureka-server-cluster1：eureka服务注册中心集群1
## cloud-eureka-server-cluster2：eureka服务注册中心集群2
## cloud-eureka-server-cluster3：eureka服务注册中心集群3
## cloud-hystrix-dashboard：Hystrix Dashboard（熔断仪表盘）监控数据服务
## cloud-config-server: spring cloud config服务端