package cn.chen.user_org_system.gateway.login;

import cn.chen.user_org_system.common.entity.User;
import cn.chen.user_org_system.common.model.RoleButtonModel;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RedisUserContainer implements UserContainer {
    private RedisTemplate<String, User> userRedisTemplate;
    private RedisTemplate<Integer, Integer> roleButtonsRedisTemplate;
    RedisUserContainer(RedisTemplate<String, User> userRedisTemplate, RedisTemplate<Integer, Integer> roleButtonsRedisTemplate) {
        this.userRedisTemplate = userRedisTemplate;
        this.roleButtonsRedisTemplate = roleButtonsRedisTemplate;
    }
    @Override
    public void addUser(String token, User user) {
        userRedisTemplate.opsForValue().set(token, user);
    }

    @Override
    public void deleteUser(String token) {
        userRedisTemplate.delete(token);
    }

    @Override
    public User get(String token) {
        return userRedisTemplate.opsForValue().get(token);
    }

    @Override
    public void addRoleButtons(List<RoleButtonModel> roleButtons) {
        roleButtonsRedisTemplate.delete(roleButtons.stream().map(RoleButtonModel::getRoleId).collect(Collectors.toList()));
        roleButtons.forEach(rb -> roleButtonsRedisTemplate.opsForSet().add(rb.getRoleId(), rb.getButtonIds().toArray(new Integer[0])));
    }

    @Override
    public boolean containsButton(Integer roleId, Integer buttonId) {
        Set<Integer> members = roleButtonsRedisTemplate.opsForSet().members(roleId);
        return members != null && members.contains(buttonId);
    }

    @Override
    public Set<Integer> getButtonIds(Integer roleId) {
        return roleButtonsRedisTemplate.opsForSet().members(roleId);
    }
}
