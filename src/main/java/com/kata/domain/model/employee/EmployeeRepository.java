package com.kata.domain.model.employee;

import java.time.MonthDay;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> findEmployeesBornOn(MonthDay monthDay);
}
