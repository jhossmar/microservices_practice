package com.formaciondcli.zuul.zuulserver.filters;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
public class PreTiempoTrancurridoFilter extends ZuulFilter{

    private static Logger log = LoggerFactory.getLogger(PreTiempoTrancurridoFilter.class);

	@Override
	public Object run() throws ZuulException {
        
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request enrutado a %s", request.getMethod(), request.getRequestURL().toString()));
        Long tiempoInicio= System.currentTimeMillis();
        request.setAttribute("tiempoInicio", tiempoInicio);

		return true;
	}

	@Override
	public boolean shouldFilter() {
		//aqui podemos valitar el request
		return true;
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}
    

}