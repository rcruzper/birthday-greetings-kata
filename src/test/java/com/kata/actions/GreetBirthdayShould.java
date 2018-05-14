package com.kata.actions;

import com.kata.domain.model.greetings.GreetingsSender;
import com.kata.domain.model.employee.Employee;
import com.kata.domain.model.employee.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.*;
import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class GreetBirthdayShould {

    private GreetBirthday greetBirthday;
    private final static ZoneId DEFAULT_ZONE = ZoneId.systemDefault();
    private final static Clock FIXED_CLOCK = Clock.fixed(LocalDateTime.of(1980, 1, 1, 10, 0).atZone(DEFAULT_ZONE).toInstant(), DEFAULT_ZONE);

    @Mock
    private GreetingsSender greetingsSender;
    @Mock
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {
        greetBirthday = new GreetBirthday(greetingsSender, employeeRepository, FIXED_CLOCK);
    }

    @Test
    public void send_greetings() {
        // Given
        Employee employee = new Employee("John", "Doe", LocalDate.of(1980, 1, 1), "john.doe@foobar.com");
        List<Employee> employees = Collections.singletonList(employee);
        given(employeeRepository.findEmployeesBornOn(MonthDay.now(FIXED_CLOCK))).willReturn(employees);

        // When
        greetBirthday.greet();

        // Then
        Mockito.verify(greetingsSender).sendGreetingsTo(employee);
        Mockito.verifyNoMoreInteractions(greetingsSender);
    }
}
