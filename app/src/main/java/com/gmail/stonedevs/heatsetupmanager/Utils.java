package com.gmail.stonedevs.heatsetupmanager;

public class Utils {
    public static int convertTempStringToInt(String temp) {
        if (temp.equals("")) {
            return 0;
        } else {
            return Integer.parseInt(temp);
        }
    }
}
