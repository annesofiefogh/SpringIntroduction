package com.example.helloworldspring.services;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.text.DateFormat;
import java.time.LocalDate;

public class DayOfWeek {

    private LocalDate thisDate = LocalDate.now();

    //Alternative method
    public String isThisDayFriday(){
        if (thisDate.getDayOfWeek().toString().equals("FRIDAY")){
            return "FRIDAY";
        } else {
            return thisDate.getDayOfWeek().toString();
        }
    }

    //Method with Zellers Congruence
    public int calculateIsItFriday(){
        int q = thisDate.getDayOfMonth();
        int m = thisDate.getMonthValue();
        int j = (thisDate.getYear() / 100);
        int k = (thisDate.getYear() % 100);

        if (m == 1){
            m = 13;
            j--;
        }
        if (m == 2){
            m = 14;
            j--;
        }

        //First calculation
        double h = (q + Math.floor((13 * (m + 1))/5) + k + Math.floor(k/4) + Math.floor(j/4) - (2 * j)) % 7;

        //Second calculation
        int d = (int) ((h + 5) % 7) + 1;

        return d;
    }

    public String getDayOfWeek(){
        return thisDate.getDayOfWeek().toString();
    }
}

