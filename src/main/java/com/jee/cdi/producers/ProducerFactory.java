package com.jee.cdi.producers;

import com.jee.cdi.qualifiers.CurrentTime;

import javax.enterprise.inject.Produces;
import java.util.Date;
import java.util.Random;

public class ProducerFactory {

    @Produces
    int number = 99;

    @Produces
    String name = " by rajesh";

    @Produces
    float decimal = 9.99f;

    @Produces
    long random =   Math.abs(new Random().nextLong());

    @Produces @CurrentTime
    long time = new Date().getTime();
}
