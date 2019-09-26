package sxy.dx.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;

/**
 * @auther 丁溪贵
 * @date 2019/9/26
 */
@Component // 将过滤器加入容器
public class LoginFilter extends ZuulFilter {

    // 拦截的类型
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    // 该拦截器在拦截器的执行顺序（数值越大，优先级越高）
    @Override
    public int filterOrder() {
        // 在处理头连接器(PreDecorationFilter)的后面执行，
        // 避免消息头数据没有被处理
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }

    // 是否执行拦截器
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 只有有dingxigui=true 这个参数就算登录成功
    @Override
    public Object run() {
        // 如何获取Request对象呢？ 可以观看源码，看看他们的过滤器是怎么写就可以知道了
        // Zuul对象Request封装的上下文对象，生命周期从一次请求的进入到结束就完成了
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String dingxigui = request.getParameter("dingxigui");
        if(StringUtils.isBlank(dingxigui)){
            // 说明用户没有登录，需要拦截，并返回403（拒绝的状态码）
            ctx.setSendZuulResponse(false); // true代表放行，false代表拦截不进行放行
            // 返回拒绝的状态码
            ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());

        }
// 校验通过，可以考虑把用户信息放入上下文，继续向后执行
// （这个返回值会被放入）RequestContext还是类似于ServletContext不得而知了
        return null;
    }
}
