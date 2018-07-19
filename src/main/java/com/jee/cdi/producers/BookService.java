package com.jee.cdi.producers;

import com.jee.cdi.model.Book;
import com.jee.cdi.qualifiers.CurrentTime;
import com.jee.cdi.qualifiers.Dummy;
import com.jee.cdi.qualifiers.Generator;
import com.jee.cdi.qualifiers.NumberOfDigits;
import org.apache.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.rmi.server.ExportException;

@ApplicationScoped
public class BookService {

    @Inject
    Logger log;

    @Inject
    int number;
    @Inject
    String name;
    @Inject
    float decimal;

    @Inject @CurrentTime
    long currentTime;

    @Inject
    long random;

    @Inject
    Path f;

    public Book createBook (String title) throws Exception {
        if (f != null) {
            Files.write(f, "Rajesh was here".getBytes());
        }
        log.info("Creating book " + title + " " + number + " " + name + " " + decimal + " " + random + " " + currentTime);
        System.out.println("Creating book " + title + " " + number + " " + name + " " + decimal + " " + random + " " + currentTime );
        return new Book(title, name);
    }
}
