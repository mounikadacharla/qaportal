package com.alacriti.qaportal.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/*import com.alacriti.qaportal.log.impl.AppLogger;*/
/*import com.alacriti.qaportal.util.LogUtil;*/



@Provider
public class ResponseFilter implements ContainerResponseFilter {
	

	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		// TODO Auto-generated method stub
		responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().putSingle("Access-Control-Allow-Credentials", "true");
		responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
		responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
		
		}
}
//add("Access-Control-Allow-Or