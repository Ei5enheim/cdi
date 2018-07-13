package com.jee.cdi.defaultQualifiersImpl.service;

import com.jee.cdi.qualifiers.GeneratorV2;

import java.util.Random;

@GeneratorV2
public class IssnNumGen implements NumGenerator {
    public String genNumber () {

        return "13-" + Math.abs(new Random().nextInt());
    }
}

