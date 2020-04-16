package cn.chen.user_org_system.gateway.dao;

import cn.chen.user_org_system.common.entity.Button;
import cn.chen.user_org_system.common.model.MenuModel;
import cn.chen.user_org_system.common.model.RoleButtonModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleDao {
    List<RoleButtonModel> findAll();
    Set<Integer> findButtonIdsByRoleId(Integer roleId);
    Set<MenuModel> findMenuByButtonIds(@Param("buttonIds") Set<Integer> buttonIds);
    List<Button> findButtonByIds(@Param("buttonIds") Set<Integer> buttonIds);
    List<MenuModel> findAllMenus();
    List<Integer> findButtonByMenu(Integer menuId);
}
