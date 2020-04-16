package cn.chen.user_org_system.role_system.dao;

import cn.chen.user_org_system.common.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    int count();
    Role findById(Integer id);
    List<Role> find(int start, int length);
    int delete(Integer id);
    int update(Role role);
    int insert(Role role);
}
