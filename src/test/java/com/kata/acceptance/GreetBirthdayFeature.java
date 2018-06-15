package com.kata.acceptance;

import com.kata.actions.GreetBirthday;
import com.kata.domain.model.employee.Employee;
import com.kata.infrastructure.email.Email;
import com.kata.infrastructure.email.EmailGreetingsSender;
import com.kata.infrastructure.email.EmailSender;
import com.kata.infrastructure.persistance.FileEmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GreetBirthdayFeature {

    private GreetBirthday greetBirthday;

    private final static ZoneId DEFAULT_ZONE = ZoneId.systemDefault();
    private final static Clock FIXED_CLOCK = Clock.fixed(LocalDateTime.of(1980, 1, 1, 10, 0).atZone(DEFAULT_ZONE).toInstant(), DEFAULT_ZONE);

    @Mock
    private EmailSender emailSender;

    @Before
    public void setUp() {
        greetBirthday = new GreetBirthday(new EmailGreetingsSender(emailSender), new FileEmployeeRepository(), FIXED_CLOCK);
    }

    @Test
    public void greet_all_employees_whose_birthday_is_today() {
        // When
        greetBirthday.greet();

        // Then
        verify(emailSender).send(new Email("john.doe@foobar.com", "Happy birthday!", "Happy birthday, dear John Doe!"));
        Mockito.verifyNoMoreInteractions(emailSender);
    }

}
