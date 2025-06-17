import java.util.*;
class Contact {
    String name;
    long phoneNumber;
    String email;
    Contact(String name, long phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}
public class PhoneBook {
    public static List<Contact> pb = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    static void addContact() {
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        long phoneNumber;
        while (true) {
            try {
                phoneNumber = sc.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Enter digits only: ");
                sc.next();
            }
        }
        sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        Contact contact = new Contact(name, phoneNumber, email);
        pb.add(contact);
        System.out.println("Contact added successfully!");
    }
    static void printContacts() {
        if (pb.isEmpty()) {
            System.out.println("PhoneBook is empty.");
        } else {
            pb.sort(Comparator.comparing(b -> b.name.toLowerCase()));
            System.out.println("Contacts:");
            for (Contact b : pb) {
                System.out.println(b);
            }
        }
    }
    static void deleteContact() {
        sc.nextLine();
        System.out.print("Enter name to delete: ");
        String name = sc.nextLine();
        boolean removed = pb.removeIf(contact -> contact.name.equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }
    static void searchContact() {
        sc.nextLine();
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();
        boolean found = false;
        for (Contact b : pb) {
            if (b.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + b);
                found = true;
            }
        }
        if (!found)
            System.out.println("Contact not found.");
    }
    public static void main(String[] args) {
        int ch;
        do {
            System.out.println("\nPhoneContact Menu:");
            System.out.println("1. Add Contact\n2. Delete Contact\n3. Print Contacts\n4. Search Contact\n0. Exit\n");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:addContact();
						break;
                case 2:deleteContact();
						break;
                case 3:printContacts();
						break;
                case 4:searchContact();
						break;
                case 0:System.out.println("Exiting PhoneBook.");
						break;
                default:System.out.println("Invalid Choice. Try again.");
            }
        } while (ch != 0);
    }
}