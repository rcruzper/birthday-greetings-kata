package com.kata.infrastructure.persistance;

import com.kata.domain.model.employee.Employee;
import com.kata.domain.model.employee.EmployeeRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileEmployeeRepository implements EmployeeRepository {

    private Function<String, Employee> mapToEmployee = line -> {
        List<String> lineSplitted = Stream.of(line.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        return new Employee(lineSplitted.get(1), lineSplitted.get(0), LocalDate.parse(lineSplitted.get(2), DateTimeFormatter.ofPattern("yyyy/MM/dd")), lineSplitted.get(3));
    };

    @Override
    public List<Employee> findEmployeesBornOn(MonthDay monthDay) {

        try (Stream<String> lines = Files.lines(Paths.get(getClass().getClassLoader().getResource("employees.csv").getPath()))) {
            return lines
                    .skip(1)
                    .map(mapToEmployee)
                    .filter(employee -> employee.wasBornOn(monthDay))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UnsupportedOperationException();
        }
    }

}
