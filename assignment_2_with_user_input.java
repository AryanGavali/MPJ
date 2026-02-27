import java.util.Scanner;

class Employee {
    double salary;   // base salary

    void getSalary(double s) {
        salary = s;
    }

    void DisplaySalary() {
        System.out.println("Salary: " + salary);
    }
}

class FullTimeEmployee extends Employee {

    void CalculateSalary() {
        salary = salary + (salary * 0.50);   // 50% hike
    }
}

class InternEmployee extends Employee {

    void CalculateSalary() {
        salary = salary + (salary * 0.25);   // 25% hike
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FullTimeEmployee f = new FullTimeEmployee();
        InternEmployee i = new InternEmployee();

        System.out.print("Enter base salary for Full Time Employee: ");
        double fullSalary = sc.nextDouble();
        f.getSalary(fullSalary);

        System.out.print("Enter base salary for Intern Employee: ");
        double internSalary = sc.nextDouble();
        i.getSalary(internSalary);

        System.out.println("\nFull Time Employee:");
        System.out.println("Before hike:");
        f.DisplaySalary();

        f.CalculateSalary();

        System.out.println("After 50% hike:");
        f.DisplaySalary();

        System.out.println("\nIntern Employee:");
        System.out.println("Before hike:");
        i.DisplaySalary();

        i.CalculateSalary();

        System.out.println("After 25% hike:");
        i.DisplaySalary();

        sc.close();
    }
}
