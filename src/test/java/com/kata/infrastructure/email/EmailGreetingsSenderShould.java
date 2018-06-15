package com.kata.infrastructure.email;

import com.kata.domain.model.greetings.GreetingsSender;
import com.kata.domain.model.employee.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmailGreetingsSenderShould {

    @Mock
    private EmailSender emailSender;

    private GreetingsSender emailGreetingsSender;

    @Before
    public void setUp() {
        emailGreetingsSender = new EmailGreetingsSender(emailSender);
    }

    @Test
    public void send_greeting_email_to_employee() {
        // Given
        String email = "john.doe@foobar.com";
        String firstName = "John";
        String lastName ="Doe";
        Employee employee = new Employee(firstName, lastName, LocalDate.now(), email);

        // When
        emailGreetingsSender.sendGreetingsTo(employee);

        // Then
        verify(emailSender).send(new Email(email, "Happy birthday!", "Happy birthday, dear " + firstName + " " + lastName + "!"));
    }

}
