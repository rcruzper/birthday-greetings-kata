package com.kata;


import com.kata.actions.GreetBirthday;
import com.kata.infrastructure.email.EmailGreetingsSender;
import com.kata.infrastructure.email.EmailSender;
import com.kata.infrastructure.persistance.FileEmployeeRepository;

import java.time.Clock;

public class BirthdayGreetingsApp {

    public static void main(String[] args) {
        GreetBirthday greetBirthday = new GreetBirthday(
                new EmailGreetingsSender(new EmailSender()),
                new FileEmployeeRepository(),
                Clock.systemUTC());
        
        greetBirthday.greet();
    }

}
