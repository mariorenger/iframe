package com.infrastructure.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class PreRequestFilter extends ZuulFilter {
    @Value("${auth.check-url}")
    private String checkAuthUrl;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String keyLogin = request.getParameter("key");
        String username = request.getParameter("user");

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(checkAuthUrl + "?key_login=" + keyLogin + "&username=" + username, String.class);

        if(request.getRequestURI().contains(".css")){
            return null;
        }

        assert result != null;
        if(!result.equals("true")){
            throw new ValidationException();
        }

        return null;
    }
}
