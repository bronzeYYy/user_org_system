package cn.chen.user_org_system.role_system.dao;

import cn.chen.user_org_system.common.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainDao {
    /**
     * 根据按钮id列表查询菜单
     * @param buttons 按钮id列表
     * @return 菜单列表
     */
    List<Menu> getMenus(@Param("buttons") List<Integer> buttons);

    /**
     * 根据角色查询按钮id
     * @param roleId 角色id
     * @return 按钮id
     */
    List<Integer> getButtons(Integer roleId);
}
