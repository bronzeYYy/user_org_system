package cn.chen.user_org_system.org_system.service;

import cn.chen.user_org_system.common.entity.Org;
import cn.chen.user_org_system.common.response.BaseResponse;
import cn.chen.user_org_system.common.response.DataResponse;
import cn.chen.user_org_system.org_system.dao.OrgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgService {
    @Autowired
    private OrgDao orgDao;
    public BaseResponse findOrg(Integer id, Integer page) {
        if (id != null) {
            return new DataResponse<>().data(orgDao.findById(id));
        }
        if (page == null || page <= 0) {
            page = 1;
        }
        int length = 10;
        int start = (page - 1) * length;
        return new DataResponse<>().data(orgDao.findOrg(start, length));
    }
    public BaseResponse updateOrg(Org org) {
        orgDao.update(org);
        return BaseResponse.SUCCESS;
    }
    public BaseResponse deleteOrg(Integer id) {
        orgDao.delete(id);
        return BaseResponse.SUCCESS;
    }
    public BaseResponse insertOrg(Org org) {
        orgDao.insert(org);
        return BaseResponse.SUCCESS;
    }
}
