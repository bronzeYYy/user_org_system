package cn.chen.user_org_system.role_system.service;

import cn.chen.user_org_system.common.entity.Role;
import cn.chen.user_org_system.common.response.BaseResponse;
import cn.chen.user_org_system.common.response.DataResponse;
import cn.chen.user_org_system.role_system.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    public BaseResponse find(Integer id, Integer page) {
        if (id != null) {
            return new DataResponse<>(roleDao.findById(id));
        }
        if (page == null || page == 0) {
            page = 1;
        }
        int length = 10;
        int start = (page - 1) * length;
        return new DataResponse<>(roleDao.find(start, length));
    }
    public BaseResponse update(Role role) {
        roleDao.update(role);
        return BaseResponse.SUCCESS;
    }
    public BaseResponse insert(Role role) {
        roleDao.insert(role);
        return BaseResponse.SUCCESS;
    }
    public BaseResponse delete(Integer id) {
        roleDao.delete(id);
        return BaseResponse.SUCCESS;
    }
}
