package cn.chen.user_org_system.user_system.service;

import cn.chen.user_org_system.common.entity.User;
import cn.chen.user_org_system.common.response.BaseResponse;
import cn.chen.user_org_system.common.response.DataResponse;
import cn.chen.user_org_system.common.response.PageResponse;
import cn.chen.user_org_system.user_system.dao.UserDao;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public BaseResponse findUser(Integer id, Integer page) {
        if (id != null) {
            new DataResponse<>().data(userDao.findUserById(id));
        }
        if (page == null || page == 0) {
            page = 1;
        }
        int length = 10;
        int start = (page - 1) * length;
        return new PageResponse<>(userDao.count()).data(userDao.findUser(start, length));
    }
    public BaseResponse deleteUser(Integer id) {
        userDao.deleteUser(id);
        return BaseResponse.SUCCESS;
    }
    public BaseResponse updateUser(User user) {
        // todo 确认需要更新列
        User oldUser = userDao.findUserById(user.getId());
        user.setPassword(oldUser.getPassword());
        user.setPasswordUpdateTime(oldUser.getPasswordUpdateTime());

        userDao.updateUser(user);
        return BaseResponse.SUCCESS;
    }
    public BaseResponse insertUser(User user) {
        BaseResponse baseResponse = new BaseResponse();
        check(user, baseResponse);
        if (baseResponse.getCode() != 0) {
            return baseResponse;
        }
        user.setPassword("123456");
        // todo 参数验证
        userDao.insertUser(user);
        return BaseResponse.SUCCESS;
    }

    private void check(User user, BaseResponse response) {
        // 校验用户、角色是否在同一机构
        if (StringUtils.isNullOrEmpty(user.getUsername())
                || StringUtils.isNullOrEmpty(user.getNickname())
                || StringUtils.isNullOrEmpty(user.getPhone())) {
            response.setFail("信息不完整");
            return;
        }
    }
}
