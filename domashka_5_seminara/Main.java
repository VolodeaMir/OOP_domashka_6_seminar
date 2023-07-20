// package task2;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        boolean exit = false;

        while (!exit) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Удалить контакт");
            System.out.println("3. Найти контакт");
            System.out.println("4. Экспортировать в файл");
            System.out.println("5. Импортировать из файла");
            System.out.println("6. Выйти из программы");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact(scanner, phoneBook);
                    break;
                case 2:
                    removeContact(scanner, phoneBook);
                    break;
                case 3:
                    searchContact(scanner, phoneBook);
                    break;
                case 4:
                    exportToFile(scanner, phoneBook);
                    break;
                case 5:
                    importFromFile(scanner, phoneBook);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Некорректный выбор.");
            }
        }
    }

    private static void addContact(Scanner scanner, PhoneBook phoneBook) {
        System.out.println("Введите имя контакта:");
        String name = scanner.nextLine();
        System.out.println("Введите номер телефона:");
        String phoneNumber = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber);
        phoneBook.addContact(contact);
        System.out.println("Контакт добавлен.");
    }

    private static void removeContact(Scanner scanner, PhoneBook phoneBook) {
        System.out.println("Введите имя контакта, который хотите удалить:");
        String name = scanner.nextLine();

        if (phoneBook.removeContact(name)) {
            System.out.println("Контакт удален.");
        } else {
            System.out.println("Контакт с таким именем не найден.");
        }
    }

    private static void searchContact(Scanner scanner, PhoneBook phoneBook) {
        System.out.println("Введите имя контакта для поиска:");
        String name = scanner.nextLine();

        List<Contact> searchResults = phoneBook.searchContacts(name);

        if (!searchResults.isEmpty()) {
            System.out.println("Результаты поиска:");
            for (Contact contact : searchResults) {
                System.out.println(contact);
            }
        } else {
            System.out.println("Контакт с таким именем не найден.");
        }
    }

    private static void exportToFile(Scanner scanner, PhoneBook phoneBook) {
        System.out.println("Введите имя файла для экспорта:");
        String fileName = scanner.nextLine();

        try {
            phoneBook.exportToCSV(fileName);
            System.out.println("Данные экспортированы в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при экспорте данных: " + e.getMessage());
        }
    }

    private static void importFromFile(Scanner scanner, PhoneBook phoneBook) {
        System.out.println("Введите имя файла для импорта:");
        String fileName = scanner.nextLine();

        try {
            phoneBook.importFromCSV(fileName);
            System.out.println("Данные импортированы из файла " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при импорте данных: " + e.getMessage());
        }
    }
}
