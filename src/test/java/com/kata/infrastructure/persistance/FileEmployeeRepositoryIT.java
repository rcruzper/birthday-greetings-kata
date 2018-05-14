package com.kata.infrastructure.persistance;

import com.kata.domain.model.employee.Employee;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileEmployeeRepositoryIT {

    private final static ZoneId DEFAULT_ZONE = ZoneId.systemDefault();
    private final static Clock FIXED_CLOCK = Clock.fixed(LocalDateTime.of(1980, 1, 1, 10, 0).atZone(DEFAULT_ZONE).toInstant(), DEFAULT_ZONE);

    @Test
    public void should_return_employees_born_on_a_given_date() {
        // When
        FileEmployeeRepository fileEmployeeRepository = new FileEmployeeRepository();
        List<Employee> employees = fileEmployeeRepository.findEmployeesBornOn(MonthDay.now(FIXED_CLOCK));

        // Then
        assertThat(employees)
                .hasSize(1);
    }

}
