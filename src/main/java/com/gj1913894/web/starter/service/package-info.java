/**
 * <p>所有服务相关, 服务间可交叉调用. 交叉调用时, 避免构造器注入造成死循环.</p>
 * <p>禁止在service当中手写http接口调用, 请将http调用通过feign或retrofit或resttemplate的方式写到http包中.</p>
 * <p>请按需使用接口与实现分离的方式, 不做过度设计, 正常情况下直接class XxxService即可.
 * 仅在存在多种实现时, 或确有必要时, 再采用接口+实现分离的方式</p>
 *
 * @author gejian
 */
package com.gj1913894.web.starter.service;