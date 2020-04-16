package cn.chen.user_org_system.common.response;


public class PageResponse<T> extends DataResponse<T> {
    private int count;

    public PageResponse(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
