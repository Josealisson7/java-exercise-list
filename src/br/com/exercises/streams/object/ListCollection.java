package br.com.exercises.streams.object;

import br.com.exercises.streams.object.entity.Employee;
import br.com.exercises.streams.object.entity.Manager;
import br.com.exercises.streams.object.entity.Secretary;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ListCollection {

    public static void main(String[] args) {
        List<Employee> employeeList = addEmployeesToList();
        sortEmployeeByName(employeeList);
        sortTheEmployeeFromLowestToHighestBySalary(employeeList);
        sortTheEmployeeFromHighestToLowestBySalary(employeeList);
        takeTheEmployeeWithTheHighestSalary(employeeList);
        takeTheEmployeeWithTheLowestSalary(employeeList);
        addingUpTheSalaryOfAllEmployees(employeeList);
    }

    public static List<Employee> addEmployeesToList() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Secretary("Marcela", BigDecimal.valueOf(3100.00)));
        employeeList.add(new Secretary("Angela", BigDecimal.valueOf(3500.00)));
        employeeList.add(new Secretary("Marcos", BigDecimal.valueOf(3100.00)));
        employeeList.add(new Secretary("Pedro", BigDecimal.valueOf(3000.00)));
        employeeList.add(new Secretary("Carlos", BigDecimal.valueOf(3400.00)));
        employeeList.add(new Manager("Antonio", BigDecimal.valueOf(6000.00)));
        employeeList.add(new Manager("Lorena", BigDecimal.valueOf(6200.00)));
        return employeeList;
    }

    public static void sortEmployeeByName(List<Employee> employeeList) {
        System.out.println(System.lineSeparator() + "Sort employee by name");
        employeeList.stream().sorted().forEach(employee -> {
            System.out.print(" " + employee.getName());
        });
    }

    public static void sortTheEmployeeFromLowestToHighestBySalary(List<Employee> employeeList) {
        System.out.println(System.lineSeparator() + "Sort the employee from lowest to highest by salary");
        employeeList.stream().sorted(Comparator.comparing(Employee::getWage)).forEach(employee -> {
            System.out.print(" | " + employee.getName() + " : " + employee.getWage());
        });
    }

    public static void sortTheEmployeeFromHighestToLowestBySalary(List<Employee> employeeList) {
        System.out.println(System.lineSeparator() + "Sort the employee from highest to lowest by salary");
        employeeList.stream().sorted((employee1, employee2) -> {
            return employee2.getWage().compareTo(employee1.getWage());
        }).forEach(employee -> {
            System.out.print(" | " + employee.getName() + " : " + employee.getWage());
        });
    }

    public static void takeTheEmployeeWithTheLowestSalary(List<Employee> employeeList) {
        System.out.println("Take the employee with the lowest salary");
        Optional<Employee> employee = employeeList.stream().min(Comparator.comparing(Employee::getWage));
        employee.ifPresent(lowestNumber -> System.out.println(" " + lowestNumber.getName() + " : " + lowestNumber.getWage()));
    }

    public static void takeTheEmployeeWithTheHighestSalary(List<Employee> employeeList) {
        System.out.println(System.lineSeparator() + "Take the employee with the highest salary");
        Optional<Employee> employee = employeeList.stream().max(Comparator.comparing(Employee::getWage));
        employee.ifPresent(highestSalary -> System.out.println(" " + highestSalary.getName() + " : " + highestSalary.getWage()));
    }

    public static void addingUpTheSalaryOfAllEmployees(List<Employee> employeeList) {
        List<Integer> listNumbers = List.of(10, 20, 15, 30, 40, 35, 50);
        System.out.println("Adding up the salary of all employees");
        BigDecimal teste = employeeList.stream().map(Employee::getWage).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(teste);
    }
}
