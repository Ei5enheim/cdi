package com.jee.cdi.interceptors;

import com.jee.cdi.qualifiers.Loggable;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;


@Interceptor
@Loggable
public class LogInterceptor {

    Logger log = Logger.getLogger(" Info Interceptor");

    @AroundInvoke
    private Object log (InvocationContext ctxt) {

        try {
            log.info("Invoked - Method - " + ctxt.getClass() + "." + ctxt.getMethod());
            return ctxt.proceed();
        } catch (Exception ex) {

        } finally {
            log.info("Return - Method - " + ctxt.getClass() + "." + ctxt.getMethod());
        }
        return null;
    }
}
