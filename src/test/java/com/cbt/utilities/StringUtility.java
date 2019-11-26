package com.cbt.utilities;

import java.sql.SQLOutput;

public class StringUtility {
    //Create a publicstatic method verifyEquals which takes two string arguments,expected and actual

//   public static void main(String[] args) {
//        verifyEquals("", "");
//    }

    public static void verifyEquals(String expected, String actual) {

        //The method prints `PASS`if both strings are equals to each other.
        // Else it prints `FAIL`and it also prints the values of both arguments
        if (expected.equalsIgnoreCase(actual)) {
                  System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: "+actual);
        }
    }
}

