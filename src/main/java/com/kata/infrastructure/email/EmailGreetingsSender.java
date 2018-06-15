package com.kata.infrastructure.email;

import com.kata.domain.model.greetings.GreetingsSender;
import com.kata.domain.model.employee.Employee;

public class EmailGreetingsSender implements GreetingsSender {

    private EmailSender emailSender;

    public EmailGreetingsSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void sendGreetingsTo(Employee employee) {
        emailSender.send(new Email(
                        employee.getEmail(),
                        "Happy birthday!",
                        String.format("Happy birthday, dear %s %s!", employee.getFirstName(), employee.getLastName())
                )
        );
    }

}
