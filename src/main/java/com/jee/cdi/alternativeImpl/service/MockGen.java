package com.jee.cdi.alternativeImpl.service;


import com.jee.cdi.qualifiers.GeneratorV2;
import com.jee.cdi.qualifiers.NumberOfDigits;

import javax.enterprise.inject.Alternative;
import java.util.Random;

@Alternative
@GeneratorV2(NumberOfDigits.NINE)
@GeneratorV2(NumberOfDigits.THIRTEEN)
public class MockGen  implements NumGenerator {


    public String genNumber () {

        return "22-" + Math.abs(new Random().nextInt());
    }
}
