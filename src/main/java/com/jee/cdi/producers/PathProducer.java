package com.jee.cdi.producers;

import com.jee.cdi.qualifiers.Root;
import com.jee.cdi.qualifiers.Temp;

import javax.enterprise.inject.Produces;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathProducer {

    @Produces
    @Root
    Path dir = Paths.get("/home/dev/Documents/cisco");

    @Produces
    @Temp
    Path tmp = Paths.get("/tmp");

}
