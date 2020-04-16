package cn.chen.user_org_system.common.web.filter;

import cn.chen.user_org_system.common.utils.IpUtils;
import cn.chen.user_org_system.common.web.config.GatewayConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

/**
 * 拦截不是从网关发送的请求
 */
@Slf4j
@Component
@WebFilter(filterName = "gatewayFilter", urlPatterns = "/*")
public class GatewayFilter implements Filter {
    @Autowired
    private GatewayConfig gatewayConfig;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("拦截请求 {}", ((HttpServletRequest) servletRequest).getRequestURI());
        log.info("网关拦截 {}", gatewayConfig.isEnable());
        if (gatewayConfig.isEnable()) {
            // 获取客户端ip 验证是否来自网关
            String requestIp = IpUtils.getIpAddr((HttpServletRequest) servletRequest);
            if (gatewayConfig.getGatewaySets() != null && gatewayConfig.getGatewaySets().contains(requestIp)) {
                log.info("通过验证 {}", requestIp);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            log.info("拦截 {}", requestIp);
            HttpServletResponse response = ((HttpServletResponse) servletResponse);
            response.setStatus(403);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 添加网关uri
        if (!gatewayConfig.isEnable()) {
            return;
        }
        gatewayConfig.addGatewayUri("127.0.0.1");
        gatewayConfig.addGatewayUri("0:0:0:0:0:0:0:1");
        URI uri;
        for (ServiceInstance serviceInstance : discoveryClient.getInstances("gateway")) {
            uri = serviceInstance.getUri();
            log.info("添加网关 {}", uri);
            gatewayConfig.addGatewayUri(uri.getHost());
        }
    }
}
