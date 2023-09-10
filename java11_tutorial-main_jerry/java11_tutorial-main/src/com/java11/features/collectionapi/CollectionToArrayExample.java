package com.java11.features.collectionapi;

import java.util.Arrays;
import java.util.List;

public class CollectionToArrayExample {
    public static void main(String[] args) {
        List<String> names = List.of("John","Nancy","Daniel");
        // before java11
        String[] nameArray = names.toArray(new String[names.size()]);
        System.out.println("Names String[] :"+ Arrays.toString(nameArray));

        Object[] nameObjArray = names.toArray();
        System.out.println("Names Object[] :"+ Arrays.toString(nameObjArray));

        // in java11
        String[] nameArray1 = names.toArray(String[]::new);
        System.out.println("Names String[] Java11:"+ Arrays.toString(nameArray1));
    }

}
