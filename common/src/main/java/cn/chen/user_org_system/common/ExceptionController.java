package cn.chen.user_org_system.common;

import cn.chen.user_org_system.common.response.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler
    @ResponseBody
    public BaseResponse handler(Exception e) {
        return new BaseResponse().error(e);
    }
}
