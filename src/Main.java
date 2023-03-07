import com.skypro.EmployeeBook;

public class Main {
    public static void main(String[] args) {

        // создаем книгу учета
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Имя1 Фамилия1", 1, 10000);
        employeeBook.addEmployee("Имя2 Фамилия2", 2, 20000);
        employeeBook.addEmployee("Имя3 Фамилия3", 3, 30000);
        employeeBook.addEmployee("Имя4 Фамилия4", 4, 40000);
        employeeBook.addEmployee("Имя5 Фамилия5", 5, 50000);

        employeeBook.findEmployee("Имя5 Фамилия5"); //найти сотрудника

        employeeBook.removeEmployeeByName("Имя5 Фамилия5"); //удалить сотрудника




        employeeBook.countTotalSalaryPerMonth(); //Сумма затрат на все зарплаты в месяц
        employeeBook.findMinSalaryEmployee(); //Найти сотрудника с минимальной зарплатой в компании
        employeeBook.findMaxSalaryEmployee(); //Найти сотрудника с максимальной зарплатой в компании
        employeeBook.countMiddleSalaryPerMonth(); //Подсчитать среднюю зарплату в компании в месяц
        System.out.println();

        employeeBook.findMinSalaryEmployeeDepartment(1); //Найти сотрудника с минимальной зарплатой в отделе
        employeeBook.findMaxSalaryEmployeeDepartment(3); //Найти сотрудника с максимальной зарплатой в отделе
        employeeBook.countTotalSalaryPerMonthDepartment(3); //Сумма всех зарплат в отделе за месяц
        employeeBook.countMiddleSalaryPerMonthDepartment(1); //Средняя зарплата в отделе в месяц
        employeeBook.IndexSalaryDepartment(2, 10); //Проиндексировать зарплату всех сотрудников отдела на заданный процент
        employeeBook.printListEmployeesDepartment(2); // Получить список всех сотрудников отдела (все данные кроме отдела)
        employeeBook.printListEmployeesSalaryLessNumber(12000);  //Получить список сотрудников с зарплатой меньше заданного числа
        employeeBook.printListEmployeesSalaryMoreNumber(12000);  //Получить список сотрудников с зарплатой больше заданного числа
        System.out.println();

        employeeBook.changeDataEmployee("Имя4 Фамилия4", 10, 100000);
        System.out.println();


        employeeBook.printAllEmployees();

    }
}