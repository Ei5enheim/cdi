package com.jee.cdi.alternativeImpl.service;


import com.jee.cdi.alternativeImpl.service.NumGenerator;
import com.jee.cdi.qualifiers.GeneratorV2;
import com.jee.cdi.qualifiers.NumberOfDigits;

import java.util.Random;

@GeneratorV2(NumberOfDigits.NINE)
public class IsbnNumGen implements NumGenerator {


    public String genNumber () {
        return "9-" + Math.abs(new Random().nextInt());
    }
}
