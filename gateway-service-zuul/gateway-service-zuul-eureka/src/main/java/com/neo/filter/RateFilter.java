package com.neo.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;

/**
 * 多维度限流
 * https://segmentfault.com/a/1190000012252677
 * 前置过滤器
 * 限流,前置过滤器
 * 限流的过滤器的优先级应该是最高，数字最小
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/23 14:25
 * 使用前置过滤器，在请求被转发之前调用，限流的过滤器应该是所有过滤器中优先级最大的
 */
public class RateFilter extends ZuulFilter {
    /**
     * 令牌桶算法
     * https://blog.csdn.net/tianyaleixiaowu/article/details/74942405
     *
     * https://baike.baidu.com/item/%E4%BB%A4%E7%89%8C%E6%A1%B6%E7%AE%97%E6%B3%95/6597000?fr=aladdin
     *
     * 系统按照恒定的速率往指定大小的桶里添加令牌，每来一个请求就消耗一个令牌，如果桶内没有令牌表示此事的请求流量已经超过设置的大小了，应该做出相应的响应或者直接抛出异常
     * 程每秒钟往桶里放置100个令牌
     */
    private static final RateLimiter RATE_LIMITER=RateLimiter.create(100);



    @Override
    public boolean shouldFilter() {

        return true;

    }

    @Override
    public Object run() {
        /**
         * 	tryAcquire()：如果获取不到一个令牌,表示流量超时了，没有等待时间
         *  tryAcquire(int permits, long timeout, TimeUnit unit)：获取permits个令牌，如果在指定的时间timeout内，还是没有获取到指定的permits个令牌，那么就返回false
         */
        if (!RATE_LIMITER.tryAcquire()) {
            RequestContext requestContext = RequestContext.getCurrentContext();
            //不路由
            requestContext.setSendZuulResponse(false);
            //403拒绝访问
            requestContext.setResponseStatusCode(HttpStatus.FORBIDDEN.value());

        }



        //也可以直接抛出异常

//		if (!RATE_LIMITER.tryAcquire()) {

//			throw new RuntimeException();  //抛出异常

//		}

        return null;

    }

    @Override
    public String filterType() {

        //前置
        return FilterConstants.PRE_TYPE;

    }

    @Override
    public int filterOrder() {

        //org.springframework.cloud.netflix.zuul.filters.pre.ServletDetectionFilter#filterOrder()这个过滤器的优先级是最高的，只需要-1即可
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER-1;

    }
}
