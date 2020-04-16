package cn.chen.user_org_system.common.response;

public class DataResponse<T> extends BaseResponse {
    private T data;
    public DataResponse(T data) {
        setData(data);
    }
    public DataResponse() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DataResponse<T> data(T data) {
        setData(data);
        return this;
    }

}
