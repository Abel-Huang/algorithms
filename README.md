# Common Collection
[![@Abel-Huang](https://img.shields.io/sonar/http/sonar.petalslink.com/org.ow2.petals%3Apetals-se-ase/coverage.svg)](https://github.com/Abel-Huang/common-collection)
[![@Abel-Huang](https://img.shields.io/packagist/l/doctrine/orm.svg)](https://github.com/Abel-Huang/common-collection)
[![@Abel-Huang](https://img.shields.io/uptimerobot/status/m778918918-3e92c097147760ee39d02d36.svg)](https://github.com/Abel-Huang/common-collection)


## 安装
用于练习和实现一些常用的数据结构和算法。实现时主要参考jdk和Redis的方式，参考资料为《算法》和《算法导论》。
## collection包 容器集合
参考java.util和Redis底层数据结构实现的一些常用容器
### list
线性表，主要分为两类，一类基于数组实现，一类基于链表实现。
### map
key-value映射，实现了Redis风格的哈希表
### set
集合，基于map实现
### 并查集
基础的并查集和相关的优化

## commons包 通用组件
定义的一些常量和通用组件

## search包 搜索
常用的搜索算法，以及树相关的操作

## sort包 排序
常用的排序算法及其优化

## util包 工具类
实现的一些工具类