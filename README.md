# web-service-starter
web-service-starter, with spring boot 2.x

# extra params
参数查询优先级: cookie, header, request param
token, 保存用户id, 令牌及及所使用的客户端(android,ios,web), 每个用户在每个客户端上只保留最后一次登录  
ver, 客户端版本号, 后端测试发包时, 不同版本不同端口号, 由nginx根据ver进行转发  
