package com.example.classicmodelsonlineshop;

import com.example.classicmodelsonlineshop.entities.Employee;
import com.example.classicmodelsonlineshop.entities.Office;
import com.example.classicmodelsonlineshop.repositories.EmployeeRepository;
import com.example.classicmodelsonlineshop.repositories.OfficeRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class TestJpa {
    private static final Scanner scanner = new Scanner(System.in);
    private static final OfficeRepository officeRepository = new OfficeRepository();
    private static final EmployeeRepository employeeRepository = new EmployeeRepository();

    public static void main(String[] args) {
//        testOffice();
        testEmployee();
    }

    //-----------------EMPLOYEE-----------------

    private static void testEmployee() {
        System.out.println("1. Find all employees");
        System.out.println("2. Find employee by id");
        System.out.println("3. Add new employee");
        System.out.println("4. Delete employee by id");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
//                listAllEmployees();
                break;
            case 2:
//                findEmployeeById();
                break;
            case 3:
//                addNewEmployee();
                break;
            case 4:
//                deleteEmployeeById();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private static void listAllEmployees() {
        employeeRepository.findAll().forEach(TestJpa::printEmployee);
    }

    private static void printEmployee(Employee e){
        System.out.println("Employee number: " + e.getEmployeeNumber());
        System.out.println("Last name: " + e.getLastName());
        System.out.println("First name: " + e.getFirstName());
        System.out.println("Extension: " + e.getExtension());
        System.out.println("Email: " + e.getEmail());
        System.out.println("Office code: " + e.getOfficeCode());
        System.out.println("Reports to: " + e.getReportsTo());
        System.out.println("Job title: " + e.getJobTitle());
        System.out.println("====================================");
    }

    //-----------------OFFICE-----------------

    private static void testOffice() {
        int choice = 0;
        do {
            choice = menu();
            switch (choice) {
                case 1:
                    addNewOffice();
                    break;
                case 2:
                    updateOffice();
                    break;
                case 3:
                    deleteOffice();
                    break;
                case 4:
                    searchOffice();
                    break;
                case 5:
                    listAllOffices();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        while (choice != 3);
    }

    private static int menu() {
        System.out.println("1. Add new office");
        System.out.println("2. Editted office");
        System.out.println("3. Delete office");
        System.out.println("4. Search office");
        System.out.println("5. List all offices");
        System.out.print("Your choice: ");
        return scanner.nextInt();
    }

    private static void searchOffice() {
        System.out.print("Enter city or country to find: ");
        String cityOrCountry = scanner.next();
        List<Office> offices = officeRepository.findByCityOrCountry(cityOrCountry);
        if (!offices.isEmpty()) {
            System.out.printf("Office search by %s*\n", cityOrCountry);
            System.out.println("------------------------");
            offices.forEach(TestJpa::printOffice);
        } else {
            System.out.printf("Office search by %s not found!\n", cityOrCountry);
        }
    }

    private static void listAllOffices() {
        officeRepository.findAll().forEach(TestJpa::printOffice);
    }

    private static void addNewOffice() {
        int x = (int) (Math.random() * 99 + 7);
        Office newOffice = new Office();

        newOffice.setOfficeCode(String.valueOf(x));

        System.out.print("Enter address line 1: ");
        newOffice.setAddressLine1(scanner.next());

        System.out.print("Enter address line 2: ");
        newOffice.setAddressLine2(scanner.next());

        System.out.print("Enter city: ");
        newOffice.setCity(scanner.next());

        System.out.print("Enter state: ");
        newOffice.setState(scanner.next());

        System.out.print("Enter country: ");
        newOffice.setCountry(scanner.next());

        System.out.print("Enter postal code: ");
        newOffice.setPostalCode(scanner.next());

        System.out.print("Enter territory: ");
        newOffice.setTerritory(scanner.next());

        System.out.println("Enter phone: ");
        newOffice.setPhone(scanner.next());

        if (officeRepository.addOffice(newOffice)) {
            System.out.println("===================================");
            System.out.println("Add new office successfully!");
            System.out.println("===================================");
            printOffice(newOffice);

        } else {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Add new office failed!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    private static void updateOffice() {
        System.out.println("Enter office code to update: ");
        String officeCode = scanner.next();
        Office office = officeRepository.find(officeCode);

        if (office != null) {
            System.out.println(":::Update office:::");
            printOffice(office);
            officeRepository.getTransaction().begin();

            System.out.println("Enter new city: ");
            office.setCity(scanner.next());

            System.out.println("Enter new country: ");
            office.setCountry(scanner.next());

            officeRepository.getTransaction().commit();
            System.out.printf("Update office %s successfully!\n", officeCode);
        }
    }

    private static void deleteOffice() {
        System.out.println("Enter office code to delete(by code): ");
        String officeCode = scanner.next();

        System.out.println(officeCode + (officeRepository.delete(officeCode) ? " deleted successfully!" : " not found!"));

        System.out.println("------------------------");

        System.out.println("Enter office code to delete(by object): ");
        officeCode = scanner.next();
        Office office = officeRepository.find(officeCode);

        if (officeRepository.delete(office)) {
            System.out.printf("Delete office %s successfully!\n", officeCode);
        } else {
            System.out.printf("Office %s not found!\n", officeCode);
        }
    }

    private static void printOffice(Office o) {
        System.out.println("Office Code: " + o.getOfficeCode());
        System.out.println("City: " + o.getCity());
        System.out.println("Country: " + o.getCountry());
        System.out.println("----------------");
    }
}
