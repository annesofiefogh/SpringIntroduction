package com.example.helloworldspring.controllers;

import com.example.helloworldspring.services.DayOfWeek;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    //Exercise 1.1
    @GetMapping
    public String hello(){
        return "Hello you, soon it's Spring!";
    }

    //Exercise 1.2
    @GetMapping("/echo")
    public String endPoint(@RequestParam String input){
        return "Your input is: " + input;
    }

    //Exercise 1.3
    @GetMapping("/is-it-friday")
    public String isItFriday(){
        DayOfWeek day = new DayOfWeek();

        //Alternative method
        //return "The day is " + day.isThisDayFriday();

        //Zellers Congruence method - day 5 is friday
        if (day.calculateIsItFriday() == 5){
            return "It's friday!";
        } else {
            return "No it's " + day.getDayOfWeek();
        }
    }
}
