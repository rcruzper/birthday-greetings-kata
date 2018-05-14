package com.kata.actions;

import com.kata.domain.model.greetings.GreetingsSender;
import com.kata.domain.model.employee.Employee;
import com.kata.domain.model.employee.EmployeeRepository;

import java.time.Clock;
import java.time.MonthDay;
import java.util.List;

public class GreetBirthday {

    private final GreetingsSender greetingsSender;
    private final EmployeeRepository employeeRepository;
    private final Clock clock;

    public GreetBirthday(GreetingsSender greetingsSender, EmployeeRepository employeeRepository, Clock clock) {
        this.greetingsSender = greetingsSender;
        this.employeeRepository = employeeRepository;
        this.clock = clock;
    }

    public void greet() {
        List<Employee> employees = employeeRepository.findEmployeesBornOn(MonthDay.now(clock));
        employees.forEach(greetingsSender::sendGreetingsTo);
    }
}
