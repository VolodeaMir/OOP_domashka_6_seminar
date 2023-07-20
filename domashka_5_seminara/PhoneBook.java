// package task2;

// Методы для импорта и экспорта данных
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class PhoneBook {
    private List<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        // Реализация добавления контакта
    }

    // Реализация удаления контакта
    public boolean removeContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                contacts.remove(contact);
                return true;
            }
        }
        return false;
    }

    // Реализация поиска контактов
    public List<Contact> searchContacts(String keyword) {
        List<Contact> searchResults = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().contains(keyword)) {
                searchResults.add(contact);
            }
        }
        return searchResults;
    }

    // Реализация экспорта в CSV файл
    public void exportToCSV(String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Contact contact : contacts) {
                writer.println(contact.getName() + "," + contact.getPhoneNumber());
            }
        }
    }

    // Реализация импорта из CSV файла
    public void importFromCSV(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    String phoneNumber = parts[1];
                    Contact contact = new Contact(name, phoneNumber);
                    contacts.add(contact);
                }
            }
        }
    }
}
