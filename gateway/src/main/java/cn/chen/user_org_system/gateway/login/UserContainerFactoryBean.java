package cn.chen.user_org_system.gateway.login;

import cn.chen.user_org_system.common.entity.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user.container")
public class UserContainerFactoryBean implements FactoryBean<UserContainer> {
    private boolean useRedis;
    @Autowired
    @Qualifier("userRedisTemplate")
    private RedisTemplate<String, User> userRedisTemplate;
    @Autowired
    @Qualifier("roleButtonsRedisTemplate")
    private RedisTemplate<Integer, Integer> roleButtonsRedisTemplate;
    @Override
    public UserContainer getObject() throws Exception {
        UserContainer userContainer;
        if (useRedis) {
            userContainer = new RedisUserContainer(userRedisTemplate, roleButtonsRedisTemplate);
        }  else {
            userContainer = new MapUserContainer();
        }
        System.out.println("使用redis存放用户token -> " + useRedis);
        return userContainer;
    }

    @Override
    public Class<?> getObjectType() {
        return UserContainer.class;
    }

    public boolean isUseRedis() {
        return useRedis;
    }

    public void setUseRedis(boolean useRedis) {
        this.useRedis = useRedis;
    }
}
