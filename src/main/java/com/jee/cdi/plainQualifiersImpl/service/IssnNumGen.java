package com.jee.cdi.plainQualifiersImpl.service;

import com.jee.cdi.qualifiers.Generator;
import com.jee.cdi.qualifiers.NumberOfDigits;

import java.util.Random;

@Generator(digits = NumberOfDigits.THIRTEEN, isprinted = false)
public class IssnNumGen implements NumGenerator {
    public String genNumber () {

        return "13-" + Math.abs(new Random().nextInt());
    }
}

