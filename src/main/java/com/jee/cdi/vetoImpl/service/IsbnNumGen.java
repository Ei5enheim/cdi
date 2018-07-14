package com.jee.cdi.vetoImpl.service;


import com.jee.cdi.qualifiers.GeneratorV2;
import com.jee.cdi.qualifiers.NumberOfDigits;

import javax.enterprise.inject.Vetoed;
import java.util.Random;


@GeneratorV2
public class IsbnNumGen  implements NumGenerator {


    public String genNumber () {
        System.out.println("V2 gen");
        return "9-" + Math.abs(new Random().nextInt());
    }
}
