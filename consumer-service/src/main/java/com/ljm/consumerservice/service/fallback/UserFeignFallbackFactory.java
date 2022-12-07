package com.ljm.consumerservice.service.fallback;

import com.ljm.consumerservice.service.UserFeignService;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserFeignFallbackFactory implements FallbackFactory<UserFeignService> {
    @Override
    public UserFeignService create(Throwable cause) {
        //打印异常信息
//        UserFallbackFactory.logger.info("fallback; exception was: {}", cause.toString());
//        UserFallbackFactory.logger.info("fallback; reason was: {}", cause.getMessage());

        //捕获从服务端传来的异常（服务端连接正常的情况下）
        FeignException ex = (FeignException) cause;
        System.out.println("feign exception:" + ex.contentUTF8());
        return new UserFeignService() {
            @Override
            public String getUserByNameInFeign(String name) {
                //自定义错误返回
                return "nothing";
            }

            @Override
            public String getErrorInFeign() {
                return "There is error";
            }
        };
    }
}
