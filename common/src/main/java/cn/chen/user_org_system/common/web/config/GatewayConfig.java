package cn.chen.user_org_system.common.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 统一的网关配置
 */
@Slf4j
@Component
@ConfigurationProperties(prefix = "gateway")
public class GatewayConfig {
    /**
     * 网关所在uri
     */
    private Set<String> gatewaySets;
    private boolean enable;
    public GatewayConfig() {
        log.info("GatewayConfig.GatewayConfig");
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Set<String> getGatewaySets() {
        return gatewaySets;
    }

    public void setGatewaySets(Set<String> gatewaySets) {
        this.gatewaySets = gatewaySets;
    }

    public void addGatewayUri(String host) {
        if (gatewaySets == null) {
            gatewaySets = new HashSet<>(4);
        }
        gatewaySets.add(host);
    }
}
