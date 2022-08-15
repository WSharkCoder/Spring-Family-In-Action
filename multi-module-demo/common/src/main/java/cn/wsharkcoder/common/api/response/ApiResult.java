package cn.wsharkcoder.common.api.response;

import cn.wsharkcoder.common.ResultStatus;
import lombok.Data;

/**
 * @Author WSharkCoder
 * @Date 2022/08/15
 */
@Data
public class ApiResult<T> {
    public ResultStatus resultStatus;
    private T data;
}
