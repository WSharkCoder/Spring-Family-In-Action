package cn.wsharkcoder.service.api;

import cn.wsharkcoder.common.api.request.HelloRequest;
import cn.wsharkcoder.common.api.response.ApiResult;
import cn.wsharkcoder.core.main.HelloBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author WSharkCoder
 * @Date 2022/08/15
 */
@RestController
@RequestMapping(path = "/api")
public class HelloController {
    private HelloBiz helloBiz;

    @Autowired
    public void setHelloBiz(HelloBiz helloBiz) {
        this.helloBiz = helloBiz;
    }

    @RequestMapping(path = "/hello", method = {RequestMethod.GET, RequestMethod.POST})
    public ApiResult hello(HelloRequest request) {
        return helloBiz.execute(request);
    }
}
