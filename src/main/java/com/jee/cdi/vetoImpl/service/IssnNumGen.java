package com.jee.cdi.vetoImpl.service;

import com.jee.cdi.qualifiers.GeneratorV2;

import javax.enterprise.inject.Vetoed;
import java.util.Random;

@Vetoed
@GeneratorV2
public class IssnNumGen implements NumGenerator {
    public String genNumber () {
        System.out.println("V2 gen");
        return "13-" + Math.abs(new Random().nextInt());
    }
}

