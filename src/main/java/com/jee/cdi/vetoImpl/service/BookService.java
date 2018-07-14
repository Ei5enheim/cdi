package com.jee.cdi.vetoImpl.service;

import com.jee.cdi.model.Book;
import com.jee.cdi.qualifiers.GeneratorV2;
import com.jee.cdi.qualifiers.NumberOfDigits;

import javax.inject.Inject;


public class BookService {

    @Inject @GeneratorV2
    private NumGenerator generator;

    public Book createBook (String title) {
        System.out.println("Creating book " + title);
        return new Book(title, generator.genNumber());
    }
}
