#primefaces-ultima-demo
PrimeFaces的Ultima布局与主题的演示程序

## 项目说明
primefaces-ultima与primefaces-ultima-demo是对[官网ultima演示程序](http://www.primefaces.org/ultima/)进行分析，通过逆向工程得到的。
换句话说，就是crack，没钱的程序员想[吃霸王餐](http://www.primefaces.org/layouts/ultima.html)。
这两个项目现在已经可以运行了 :-)
欢迎其他人员加入，大家一起交流、测试、改进、试用，都欢迎。

* QQ群名：primefaces（QQ群号：31551213）
* QQ群名：JSF/EJB/JPA技术交流群（QQ群号：84376982）
* QQ群名：Java EE 7（QQ群号：335997118）

## 项目介绍
Ultima（创世纪）是一个高度可定制的高级应用程序模板，具有3种菜单模式、12种主题配色、明暗两种菜单和2种用户配置模式，总共有144种可能的布局组合。
它基于[material design](https://material.google.com/)（材料设计）语言，是完全响应式的，并进行了触摸优化，采用[SASS](http://www.sass-zh.com/)、[CSS3](https://www.w3.org/Style/CSS/)和[HTML5](https://www.w3.org/TR/html5/)构建。

首先，其实有两个项目：

一个是[primefaces-ultima](http://git.oschina.net/ratking/primefaces-ultima)，它提供Ultima响应式页面布局(layout)与主题风格(theme)，
最后会生成一个primefaces-ultima.jar包，供基于PrimeFaces的Web项目使用。
使用的技术包括[JSF](https://jcp.org/en/jsr/detail?id=344)、[jQuery](http://jqueryui.org/)、[CSS](https://www.w3.org/Style/CSS/)……

另一个是[primefaces-ultima-demo](http://git.oschina.net/ratking/primefaces-ultima-demo)，这是一个使用primefaces-ultima.jar的web演示程序，
最后会生成一个primefaces-ultima-demo.war包，可以部署到[Java EE 6或Java EE 7应用服务器](http://www.oracle.com/technetwork/java/javaee/overview/compatibility-jsp-136984.html)（比如[GlassFish](https://glassfish.java.net/) 4.x、[Payara](http://www.payara.fish/) 4.1.x或[WildFly](http://wildfly.org/) 10.x）里运行。
使用的技术主要是[JSF](https://javaserverfaces.java.net/) 2.x、[PrimeFaces](http://www.primefaces.org/) 6.x、[CDI](http://cdi-spec.org/) 1.x、[OmniFaces](http://omnifaces.org/) 2.x、一点儿HTML 5……

## Ultima布局与主题预览
<p align="center"><img src="http://www.primefaces.org/images/market/ultima/ultima.png" alt="Ultima布局与主题"/></p>

完全响应式布局：
<p align="center"><img src="http://www.primefaces.org/images/market/ultima/feature-1.png" alt="完全响应式布局"/></p>

3种菜单模式、明暗两种菜单、2种用户配置模式：
<p align="center"><img src="http://www.primefaces.org/images/market/ultima/feature-7.png" alt="3种菜单模式、明暗两种菜单、2种用户配置模式"/></p>

12种主题配色：
<p align="center"><img src="http://www.primefaces.org/images/market/ultima/feature-3.gif" alt="12种主题配色"/></p>

增强手机体验：
<p align="center"><img src="http://www.primefaces.org/images/market/ultima/feature-native.png" alt="增强手机体验"/></p>
<p align="center"><img src="http://www.primefaces.org/images/market/ultima/mobile.png" alt="增强手机体验"/></p>

模板页面：
<p align="center"><img src="http://www.primefaces.org/images/market/ultima/feature-4.png" alt="模板页面"/></p>

Material Design（材料设计）
<p align="center"><img src="http://www.primefaces.org/images/market/ultima/feature-8.png" alt="材料设计（Material Design）"/></p>

Sass（语法很好的样式表）：
<p align="center"><img src="http://www.primefaces.org/images/market/ultima/feature-2.png" alt="Sass"/></p>

## 源码地址
primefaces-ultima的GIT源代码位于

    http://git.oschina.net/ratking/primefaces-ultima

primefaces-ultima-demo的GIT源代码位于

    http://git.oschina.net/ratking/primefaces-ultima-demo

## 官网原址
关于Ultima的官方介绍，详见

    http://www.primefaces.org/layouts/ultima.html

关于Ultima的官方演示程序，详见

    http://www.primefaces.org/ultima/

## 编译步骤
使用GIT客户端软件（比如git命令行或TortoiseGIT图形界面）下载上面的两个项目源代码后，
还需要maven编译打包，使用命令行：

    git clone http://git.oschina.net/ratking/primefaces-ultima
    cd primefaces-ultima
    mvn clean install

    git clone http://git.oschina.net/ratking/primefaces-ultima-demo
    cd primefaces-ultima-demo
    mvn clean package

也可以不用maven而使用NetBeans或Eclipse来编译打包。
