package com.jee.cdi.plainQualifiersImpl.service;

import com.jee.cdi.model.Book;
import com.jee.cdi.qualifiers.Generator;
import com.jee.cdi.qualifiers.NumberOfDigits;

import javax.inject.Inject;


public class BookService {

    @Inject @Generator(digits = NumberOfDigits.THIRTEEN, isprinted = false)
    private NumGenerator generator;

    public Book createBook (String title) {
        System.out.println("Creating book " + title);
        return new Book(title, generator.genNumber());
    }
}
