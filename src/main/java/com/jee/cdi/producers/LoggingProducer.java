package com.jee.cdi.producers;

import com.jee.cdi.qualifiers.Dummy;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

public class LoggingProducer {

    /*
    static {
        // Set up a simple configuration that logs on the console.
        BasicConfigurator.configure();
    }*/


    Logger log = Logger.getLogger("Bar");

    @PostConstruct
    public void callMe() {
        log.info("created object " + this);
    }

    @Produces
    private Logger produceLogger (InjectionPoint point) {
        //System.out.println("producing the logger object" + point.getMember().getDeclaringClass().getName() );
        log.info("producing the logger object" + point.getMember().getDeclaringClass().getName() );
        return Logger.getLogger(point.getMember().getDeclaringClass().getName());
    }

    @Produces @Alternative
    private Logger alternativeLogger (InjectionPoint point) {
        log.info("producing alternative logger object" + point.getMember().getDeclaringClass().getName() );
        return Logger.getLogger("Alternative");
    }

    private void c (@Disposes Logger logger) {
        Main.i += 99;

        //System.out.println("disposing the logger object " + logger.getName());
        log.info("disposing the logger object " +  logger.getName());

    }

    @PreDestroy
    public void callback() {
        //System.out.println("I got a call back");
        log.info("I got a call back - destroy " + this);
    }
}
