package cn.wsharkcoder.core;


import cn.wsharkcoder.common.api.response.ApiResult;

/**
 * @Author WSharkCoder
 * @Date 2022/08/15
 */
public abstract class AbstractBiz<T, R> {
    protected abstract R execute(T request);

    protected boolean checkRequest(T request) {
        return true;
    }
}
