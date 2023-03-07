package com.skypro;

import java.text.DecimalFormat;
import java.util.*;


public class EmployeeBook {

    public final int maxSizeEmployeeBook = 5;

    private final Map<String, Employee> employees = new HashMap<>();


   //ОСНОВНЫЕ МЕТОДЫ

    //Добавить нового сотрудника
    public void addEmployee(String fullName, int department, float salary) {
        if (employees.size() == maxSizeEmployeeBook) {
            System.out.println("Нельзя добавить сотрудника, закончилось место ");
            return;
        }
        if (!employees.containsKey(fullName)) {
            Employee employee = new Employee(fullName, department, salary);
            employees.put(fullName, employee);
            System.out.println("Сотрудник ФИО = " + fullName + " добавлен");
        } else {
            System.out.println(" такой сотрудник уже есть");
        }
    }

    //Найти сотрудника по ФИО и удалить его
    public void removeEmployeeByName(String fullName) {
        if (employees.containsKey(fullName)) {
            employees.remove(fullName);
            System.out.println("Сотрудник " + fullName + " удален");
        } else {
            System.out.println("Сотрудник с таким ФИО не найден");
        }
    }


    //Найти сотрудника по ФИО изменить его зарплату и отдел
    public void changeDataEmployee(String fullName, int newDepartment, float newSalary) {
        if (employees.containsKey(fullName)) {
            employees.get(fullName).setDepartment(newDepartment);
            employees.get(fullName).setSalary(newSalary);
            System.out.println("Сотрудни ФИО = " + fullName + " переведен в отдел " + employees.get(fullName).getDepartment() +
                    " его новая зарплата составляет " + employees.get(fullName).getSalary());
        } else {
            System.out.println("сотрудник " + fullName + " не найден");
        }
    }

    //Получить список всех сотрудников со всеми данными
    public void printAllEmployees() {
        for (String key : employees.keySet()) {
            Employee employee = employees.get(key);
            System.out.println(key + " : " + employee);
        }
    }

    //Найти сотрудника
    public void findEmployee(String fullName) {
        if (employees.containsKey(fullName)) {
            System.out.println("найден сотрудник " + fullName + " : " + employees.get(fullName));
        } else {
            System.out.println("сотрудник " + fullName + " не найден");
        }
    }

    // Остальные методы --------------------------------------------------------------------------------------


    //Сумма затрат на все зарплаты в месяц
    public void countTotalSalaryPerMonth() {
        List<Employee> employeesList = new ArrayList<>(employees.values());
        float sum = 0;
        for (Employee employee : employeesList) {
            if (employee != null) {
                sum = sum + employee.getSalary();
            }
        }
        System.out.println("Общие затраты компании на все зарплаты в месяц составляют " + sum);
    }

    //Найти сотрудника с минимальной зарплатой в компании
    public void findMinSalaryEmployee() {
        List<Employee> employeesList = new ArrayList<>(employees.values());
        String name = "";
        float min = 100000000;
        for (Employee employee : employeesList) {
            if (employee != null && employee.getSalary() < min) {
                min = employee.getSalary();
                name = employee.getFullName();
            }
        }
        System.out.println("Минимальная зарплата в компании - у сотрудника " + name + " и составляет " + min);
    }

    //Найти сотрудника с максимальной зарплатой в компании
    public void findMaxSalaryEmployee() {
        List<Employee> employeesList = new ArrayList<>(employees.values());
        String name = "";
        float max = Integer.MIN_VALUE;
        for (Employee employee : employeesList) {
            if (employee != null && employee.getSalary() > max) {
                max = employee.getSalary();
                name = employee.getFullName();
            }
        }
        System.out.println("Максимальная зарплата в компании - у сотрудника " + name + " и составляет " + max);
    }

    //Подсчитать среднюю зарплату в компании в месяц
    public void countMiddleSalaryPerMonth() {
        List<Employee> employeesList = new ArrayList<>(employees.values());
        int count = 0;
        float sun = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (Employee employee : employeesList) {
            if (employee != null) {
                sun = sun + employee.getSalary();
                count++;
            }
        }
        System.out.println("Средняя зарплата в компании в месяц составляет " + decimalFormat.format(sun / count));
    }

    //Найти сотрудника с минимальной зарплатой в отделе
    public void findMinSalaryEmployeeDepartment(int numberDepartment) {
        List<Employee> employeesList = new ArrayList<>(employees.values());
        String name = "";
        float min = Integer.MAX_VALUE;
        for (Employee employee : employeesList) {
            if (employee != null && employee.getDepartment() == numberDepartment) {
                if (employee.getSalary() < min) {
                    min = employee.getSalary();
                    name = employee.getFullName();
                }
            }
        }
        System.out.println("Минимальная зарплата  в отделе " + numberDepartment + " - у сотрудника " + name + " и составляет " + min);
    }

    //Найти сотрудника с максимальной зарплатой в отделе
    public void findMaxSalaryEmployeeDepartment(int numberDepartment) {
        List<Employee> employeesList = new ArrayList<>(employees.values());
        String name = "";
        float max = 0;
        for (Employee employee : employeesList) {
            if (employee != null && employee.getDepartment() == numberDepartment) {
                if (employee.getSalary() > max) {
                    max = employee.getSalary();
                    name = employee.getFullName();
                }
            }
        }
        System.out.println("Максимальная зарплата  в отделе " + numberDepartment + " - у сотрудника " + name + " и составляет " + max);
    }

    //Сумма всех зарплат в отделе за месяц
    public void countTotalSalaryPerMonthDepartment(int numberDepartment) {
        List<Employee> employeesList = new ArrayList<>(employees.values());
        float sum = 0;
        for (Employee employee : employeesList) {
            if (employee != null && employee.getDepartment() == numberDepartment) {
                sum = sum + employee.getSalary();
            }
        }
        System.out.println("В отделе " + numberDepartment + " затраты на все зарплаты в месяц составляют " + sum);
    }

    //Средняя зарплата в отделе в месяц
    public void countMiddleSalaryPerMonthDepartment(int numberDepartment) {
        List<Employee> employeesList = new ArrayList<>(employees.values());
        int count = 0;
        float sum = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (Employee employee : employeesList) {
            if (employee != null && employee.getDepartment() == numberDepartment) {
                sum = sum + employee.getSalary();
                count++;
            }
        }
        System.out.println("В отделе " + numberDepartment + " средняя зарплата в месяц составляет " + decimalFormat.format(sum / count));
    }

    //Проиндексировать зарплату всех сотрудников отдела на заданный процент
    public void IndexSalaryDepartment(int numberDepartment, float index) {
        List<Employee> employeesList = new ArrayList<>(employees.values());
        for (Employee employee : employeesList) {
            if (employee != null && employee.getDepartment() == numberDepartment) {
                float premiumFactor = (index + 100) / 100;
                employee.setSalary(employee.getSalary() * premiumFactor);
            }
        }
        System.out.println("Зарплата сотрудников в отделе " + numberDepartment + " проиндексирована на " + index + " процентов");
    }

    // Получить список всех сотрудников отдела (все данные кроме отдела)
    public void printListEmployeesDepartment(int numberDepartment) {
        List<Employee> employeesList = new ArrayList<>(employees.values());
        System.out.println("Список сотрудников отдела " + numberDepartment);
        for (Employee employee : employeesList) {
            if (employee != null && employee.getDepartment() == numberDepartment) {
                System.out.println("id = " + employee.getId() + ", ФИО сотрудника: " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary());
            }
        }
    }

    //Получить список сотрудников с зарплатой меньше заданного числа
    public void printListEmployeesSalaryLessNumber(int salaryLevel) {
        List<Employee> employeesList = new ArrayList<>(employees.values());
        System.out.println("Список сотрудников отдела c зарплатой меньше " + salaryLevel);
        for (Employee employee : employeesList) {
            if (employee != null && employee.getSalary() < salaryLevel) {
                System.out.println("id = " + employee.getId() + ", ФИО сотрудника: " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary());
            }
        }
    }

    //Получить список сотрудников с зарплатой больше заданного числа
    public void printListEmployeesSalaryMoreNumber(int salaryLevel) {
        List<Employee> employeesList = new ArrayList<>(employees.values());
        System.out.println("Список сотрудников c зарплатой больше " + salaryLevel);
        for (Employee employee : employeesList) {
            if (employee != null && employee.getSalary() >= salaryLevel) {
                System.out.println("id = " + employee.getId() + ", ФИО сотрудника: " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary());
            }
        }
    }

    // Очень сложные методы ----------------------------------------------------------------------------


}










