package com.stc.proxy.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class MainFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final DiscoveryClient discoveryClient;

    public MainFilter(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        List<ServiceInstance> instances = discoveryClient.getInstances(context.get("serviceId").toString());
        try {
            if (instances != null && instances.size() > 0) {
                context.setRouteHost(instances.get(0).getUri().toURL());
            } else {
                throw new IllegalStateException("Target service instance not found!");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Couldn't get service URL!", e);
        }
        return null;
    }
}