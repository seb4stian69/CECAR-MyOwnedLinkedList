package org.sebastiansantis.utils;

import java.util.List;

public class ArrayAVG {

    private ArrayAVG(){/*Utility Class*/}

    public static Double avg(List<Double> lista) {

        Double suma = 0D;

        for (Double aDouble : lista) {
            suma += aDouble;
        }

        return (double) suma / lista.size();

    }

}
