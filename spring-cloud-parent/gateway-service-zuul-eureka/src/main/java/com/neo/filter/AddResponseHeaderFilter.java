package com.neo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * 后置过滤器，在响应头中添加一些内容
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/23 14:06
 */
@Component
public class AddResponseHeaderFilter extends ZuulFilter{

    @Override
    public boolean shouldFilter() {
        return true;

    }

    @Override
    public Object run() {

        //获取请求上下文
        RequestContext requestContext = RequestContext.getCurrentContext();

        //获取HttpServletResponse
        HttpServletResponse response = requestContext.getResponse();

        //添加头信息
        response.addHeader("X-Foo", "add header");

        return null;

    }

    @Override
    public String filterType() {
        //后置过滤器
        return FilterConstants.POST_TYPE;

    }

    @Override
    public int filterOrder() {
        //在org.springframework.cloud.netflix.zuul.filters.post.SendResponseFilter#filterOrder()这个过滤一起之前执行即可
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER-1;

    }
}
