package cn.chen.user_org_system.common.response;

/**
 * 响应的实体类，全部返回这个
 * 需要其它返回信息 则返回其子类
 */
public class BaseResponse {
    private int code = 0;
    private boolean success = true;
    private String msg = "ok";
    public static final BaseResponse PLEASE_LOGIN_RESPONSE = new BaseResponse().pleaseLogin(); // 需要登陆
    public static final BaseResponse INSUFFICIENT_AUTHORITY = new BaseResponse().InsufficientAuthority(); // 权限不足
    public static final BaseResponse SUCCESS = new BaseResponse();
    public BaseResponse() {

    }

    public int getCode() {
        return code;
    }

    private void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    private void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BaseResponse InsufficientAuthority() {
        setCode(-2);
        setMsg("权限不足");
        setSuccess(true);
        return this;
    }
    public BaseResponse pleaseLogin() {
        setCode(-1);
        setMsg("请先登陆");
        setSuccess(true);
        return this;
    }
    public BaseResponse error(Exception e) {
        setCode(-3);
        setMsg(e.getMessage());
        setSuccess(false);
        return this;
    }
    public void setFail(String msg) {
        setCode(-4);
        setMsg(msg);
        setSuccess(true);
    }
    public static BaseResponse fail(String msg) {
        BaseResponse response = new BaseResponse();
        response.setCode(-4);
        response.setMsg(msg);
        response.setSuccess(true);
        return response;
    }

}
