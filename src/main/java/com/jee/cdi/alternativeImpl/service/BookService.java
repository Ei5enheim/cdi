package com.jee.cdi.alternativeImpl.service;

import com.jee.cdi.model.Book;
import com.jee.cdi.qualifiers.GeneratorV2;
import com.jee.cdi.qualifiers.NumberOfDigits;

import javax.inject.Inject;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//@com.jee.cdi.qualifiers.Dummy
public class BookService {

    @Inject @GeneratorV2(NumberOfDigits.NINE)
    private NumGenerator generator;

    @Inject @GeneratorV2
    private NumGenerator gen2;

    public Book createBook (String title) {
        System.out.println("Creating book " + title);
        return new Book(title, generator.genNumber());
    }

    public Book createBookV2 (String title) {
        System.out.println("Creating book V2 " + title);
        return new Book(title, gen2.genNumber());
    }
}
