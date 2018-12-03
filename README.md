# java 学习的一些demo,个人学习的笔记

1. java-spi-study01 是关于java spi机制学习的demo
spi-service 提供Search接口和加载实现Search接口的静态类SearchManager
db-search 是b厂商实现的Search功能,依赖spi-service
file-seach 是a厂商实现的Seach功能,依赖spi-service
spi-invoker 是服务调用方
