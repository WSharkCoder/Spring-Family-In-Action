package cn.wsharkcoder.core.main;

import cn.wsharkcoder.common.ResultStatus;
import cn.wsharkcoder.common.api.request.HelloRequest;
import cn.wsharkcoder.common.api.response.ApiResult;
import cn.wsharkcoder.core.AbstractBiz;
import cn.wsharkcoder.data.InfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author WSharkCoder
 * @Date 2022/08/15
 */
@Service
public class HelloBiz extends AbstractBiz<HelloRequest, ApiResult<String>> {
    private InfoDao infoDao;

    @Autowired
    public void setInfoDao(InfoDao infoDao) {
        this.infoDao = infoDao;
    }

    @Override
    public ApiResult execute(HelloRequest request) {
        ApiResult result = new ApiResult();
        if (checkRequest(request)) {
            result.setResultStatus(ResultStatus.SUCCESS);
            result.setData("Hello");
            infoDao.saveInfo("Hello");
        } else {
            result.setResultStatus(ResultStatus.FAIL);
        }
        return result;
    }

    @Override
    protected boolean checkRequest(HelloRequest request) {
        return true;
    }
}
