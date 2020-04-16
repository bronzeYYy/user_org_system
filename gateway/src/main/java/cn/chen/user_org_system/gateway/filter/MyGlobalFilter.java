package cn.chen.user_org_system.gateway.filter;

import cn.chen.user_org_system.common.entity.User;
import cn.chen.user_org_system.gateway.login.UserContainer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

import java.util.List;
import java.util.Properties;

@Slf4j
@Component
public class MyGlobalFilter implements GlobalFilter {
    @Autowired
    private UserContainer userContainer;
    @Autowired
    @Qualifier("roleProperties")
    private Properties properties;
    private static final Logger logger = LoggerFactory.getLogger(MyGlobalFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("uri -> {}", exchange.getRequest().getURI());
        String path = exchange.getRequest().getPath().toString();
        logger.info("path -> {}", path);
        List<String> list = exchange.getRequest().getHeaders().get("Token");
        if (list == null || list.size() != 1) {
            log.warn("没有携带token，拦截请求");
            return Mono.empty();
        }
        String token = list.get(0);
        User user = userContainer.get(token);
        if (user == null) {
            log.warn("token无效，拦截请求");
            return Mono.empty();
        }
        String method = exchange.getRequest().getMethod().name();
        logger.info("method -> {}", method);

        String button = properties.getProperty(path + method);
        if (button == null) {
            log.warn("请求不合法，拦截请求");
            return Mono.empty();
        }
        if (!userContainer.containsButton(user.getRoleId(), Integer.parseInt(button))) {
            log.warn("没有权限，拦截请求");
            return Mono.empty();
        }
        return chain.filter(exchange);
    }
}
