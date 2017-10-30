package com.autumnframework.cms.model.bo;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 16:05 2017/9/5.
 */
public class DataPageResponseMsg extends BaseResponseMsg {
    private int count;


    public DataPageResponseMsg(int code, String msg, Object data, int count) {
        super(code, msg, data);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
