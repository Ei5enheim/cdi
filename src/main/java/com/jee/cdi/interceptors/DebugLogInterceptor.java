package com.jee.cdi.interceptors;

import com.jee.cdi.qualifiers.Loggable;
import com.jee.cdi.qualifiers.LoggingType;
import org.apache.log4j.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;


@Interceptor
@Loggable(LoggingType.DEBUG)
public class DebugLogInterceptor {

    Logger log = Logger.getLogger("DEBUG Interceptor");

    @AroundInvoke
    private Object log (InvocationContext ctxt) {

        try {
            log.debug("Invoked - Method - " + ctxt.getClass() + "." + ctxt.getMethod());
            return ctxt.proceed();
        } catch (Exception ex) {

        } finally {
            log.debug("Return - Method - " + ctxt.getClass() + "." + ctxt.getMethod());
        }
        return null;
    }
}
