package com.formaciondcli.zuul.zuulserver.filters;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
public class PostTiempoTrancurridoFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PostTiempoTrancurridoFilter.class);

	@Override
	public Object run() throws ZuulException {
        
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("Entrando a post");
		Long tiempoInicio= (Long)request.getAttribute("tiempoInicio");
		Long tiempofinal=System.currentTimeMillis();
		Long tiempoTrancurrido=  tiempoInicio - tiempofinal;
		
		log.info(String.format("tiempo trancurrido en segundos %s seg", tiempoTrancurrido.doubleValue()/1000,00));
		log.info(String.format("tiempo trancurrido en milisegundos %s milseg", tiempoTrancurrido.doubleValue()));
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
		return "post";
	}
    

}