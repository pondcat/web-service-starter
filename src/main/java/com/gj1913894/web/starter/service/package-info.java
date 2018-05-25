/**
 * 所有服务相关, 服务间可交叉调用. 交叉调用时, 避免构造器注入造成死循环.
 * 禁止在service当中手写http接口调用, 请将http调用通过feign或retrofit或resttemplate的方式写到http包中.
 * 推荐采用接口与实现分离的方式, 实现类名在接口类名后加impl, 如DemoService和DemoServiceImpl.
 *
 * @author gejian
 */
package com.gj1913894.web.starter.service;