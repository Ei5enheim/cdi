package com.jee.cdi.plainQualifiersImpl.service;


import com.jee.cdi.qualifiers.Generator;
import com.jee.cdi.qualifiers.NumberOfDigits;

import java.util.Random;

@Generator(digits = NumberOfDigits.NINE, isprinted = false)
public class IsbnNumGen  implements NumGenerator {


    public String genNumber () {

        return "9-" + Math.abs(new Random().nextInt());
    }
}
