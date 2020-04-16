package cn.chen.user_org_system.org_system.dao;

import cn.chen.user_org_system.common.entity.Org;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrgDao {
    int count();
    Org findById(Integer id);
    int insert(Org org);
    int delete(Integer id);
    int update(Org org);
    List<Org> findOrg(int start, int length);

}
