package org.sahil.lamda_expression;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LamdaExpressionApplication {


    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", "IT", 50000),
                new Employee(2, "Jane Smith", "Finance", 60000),
                new Employee(3, "Bob Brown", "IT", 75000),
                new Employee(4, "Lucy Gray", "HR", 45000),
                new Employee(5, "Tom White", "Finance", 80000)
        );

        // Operations using Lambda Expressions
        filterByDepartment(employees, "IT");
        sortEmployeesBySalary(employees);
        mapEmployeeNames(employees);
        findHighEarner(employees, 100000);
        calculateAverageSalary(employees, "Finance");
    }

    // Filter employees by department
    public static void filterByDepartment(List<Employee> employees, String department) {
        System.out.println("\nEmployees in " + department + " department:");
        employees.stream()
                .filter(e -> e.getDepartment().equals(department))
                .forEach(e -> System.out.println(e.getName()));
    }

    // Sort employees by salary
    public static void sortEmployeesBySalary(List<Employee> employees) {
        System.out.println("\nEmployees sorted by salary (ascending):");
        employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .forEach(e -> System.out.println(e.getName() + ", " + e.getSalary()));
    }

    // Map employee names
    public static void mapEmployeeNames(List<Employee> employees) {
        System.out.println("\nList of employee names:");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    // Find if any employee earns more than a specific amount
    public static void findHighEarner(List<Employee> employees, double threshold) {
        boolean hasHighEarner = employees.stream()
                .anyMatch(e -> e.getSalary() > threshold);

        System.out.println("\nIs there any employee with a salary greater than $" + threshold + "?");
        System.out.println(hasHighEarner);
    }

    // Calculate average salary of employees in a specific department
    public static void calculateAverageSalary(List<Employee> employees, String department) {
        double averageSalary = employees.stream()
                .filter(e -> e.getDepartment().equals(department))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        System.out.println("\nAverage salary in " + department + " department:");
        System.out.println(averageSalary);
    }
}


