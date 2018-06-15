package com.kata.domain.model.employee;

import java.time.LocalDate;
import java.time.MonthDay;

public class Employee {

    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final String email;

    public Employee(String firstName, String lastName, LocalDate dateOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public Boolean wasBornOn(MonthDay monthDay) {
        return dateOfBirth.getMonth().equals(monthDay.getMonth()) && dateOfBirth.getDayOfMonth() == monthDay.getDayOfMonth();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }
}
