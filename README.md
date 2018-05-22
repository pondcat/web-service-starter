# web-service-starter
web-service-starter, with spring boot 2.x  
版本号如何处理, 是否加入到访问路径中, 如www.xxx.com/v1.2/..., 方便在同一台电脑上同时测试启动多个不同的后台版本进行测试, 如果加进去的话, 又怎么保证前端新旧版本同时访问后台呢
url路径中的?xxx=yyy这些参数, 无论请求头Content-Type是多少,java servlet中都可以通过request.getParameter获取. 不清楚nginx能否根据这个进行跳转?
对请求头Content-Type=application/json的request才打印payload日志

# extra params
参数查询优先级: cookie, header, request param
token, 保存用户id, 令牌及及所使用的客户端(android,ios,web), 每个用户在每个客户端上只保留最后一次登录  
ver, 客户端版本号, 后端测试发包时, 不同版本不同端口号, 由nginx根据ver进行转发  
