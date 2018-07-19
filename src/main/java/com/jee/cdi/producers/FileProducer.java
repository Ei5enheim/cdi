package com.jee.cdi.producers;

import com.jee.cdi.qualifiers.Root;
import com.jee.cdi.qualifiers.Temp;
import org.apache.log4j.Logger;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProducer {

    @Inject
    Logger logger;

    @Inject
    long rand;

    @Inject @Temp
    Path dir;

    @Produces
    public Path produceFile() throws IOException {

        if (Files.notExists(dir)) {
            Files.createDirectory(dir);
        }
        Path f = dir.resolve(rand + ".txt");
        if (Files.notExists(f)) {
            Files.createFile(f);
        }
        return f;
    }
}
