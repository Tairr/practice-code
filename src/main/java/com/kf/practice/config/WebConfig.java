package com.kf.practice.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptorAdapter;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/31
 */
public class WebConfig extends WebMvcConfigurerAdapter{


    /**
     * 超时配置
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(5000);
        configurer.registerDeferredResultInterceptors(
                new DeferredResultProcessingInterceptorAdapter() {
                    @Override
                    public <T> boolean handleTimeout(NativeWebRequest req, DeferredResult<T> result) {
                        return result.setErrorResult(new AsyncTimeoutException());
                    }
                });
        super.configureAsyncSupport(configurer);
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public static class AsyncTimeoutException extends Exception {
    }
}
