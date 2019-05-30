package com.neo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 过滤器
 * Filter 的生命周期有 4 个，分别是 “PRE”、“ROUTING”、“POST” 和“ERROR”
 * 生命周期解释如下：
 * PRE：这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、鉴权、限流、参数校验、请求转发，在集群中选择请求的微服务、记录调试信息等。
 * ROUTING：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用 Apache HttpClient 或 Netfilx Ribbon 请求微服务。
 * POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的 HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
 * ERROR：在其他阶段发生错误时执行该过滤器。 除了默认的过滤器类型，Zuul 还允许我们创建自定义的过滤器类型。例如，
 * 我们可以定制一种 STATIC 类型的过滤器，直接在 Zuul 中生成响应，而不将请求转发到后端的微服务。
 */
/**
 * 前置过滤器的使用
 * 自定义过滤器，用于实现鉴权，前置过滤器
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/23 13:43
 */
@Component
public class TokenFilter  extends ZuulFilter {

    /**
     * 判断过滤器是否被执行，返回true表示被会被执
     * 在这里我们可以限制过滤器的执行范围，可以根据指定的条件判断这个请求是否被过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 指定过滤器的类型
     * 指定过滤器的类型，前置，后置.................
     *  1、其中FilterConstants这个常量类中定义了过滤器常用的变量
     *  2、public static final String ERROR_TYPE = "error";
     *  3、public static final String POST_TYPE = "post";
     *  4、public static final String PRE_TYPE = "pre";
     *  5、public static final String ROUTE_TYPE = "route";
     */
    @Override
    public String filterType() {
        //前置过滤器 pre
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //一般前置过滤器放在org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter这个过滤器之前即可，只需要将其对应的顺序-1
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }


    /**
     *  过滤器的具体实现逻辑
     * @return
     */
    @Override
    public Object run() {
        //获取请求上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        //获取HttpServletRequest
        HttpServletRequest request = requestContext.getRequest();
        //获取传递过来的请求参数
        String token = request.getParameter("token");
        //如果token是空的，返回权限不足，一般返回的状态码是401
        if (StringUtils.isEmpty(token)) {
            //设置false，此时的zuul不对此路由
            requestContext.setSendZuulResponse(false);
            //设置401
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            //设置响应的消息
            requestContext.setResponseBody("no power");
/***			requestContext.setResponseBody("no power"); ***/
        }
        return null;
    }
}
