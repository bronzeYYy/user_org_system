package cn.chen.user_org_system.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class MyGlobalFilter implements GlobalFilter {
    private static final Logger logger = LoggerFactory.getLogger(MyGlobalFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("uri -> {}", exchange.getRequest().getURI());
        return chain.filter(exchange);
    }
}
