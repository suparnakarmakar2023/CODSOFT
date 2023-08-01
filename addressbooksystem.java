package codesoft;

import javax.swing.*;
import java.util.ArrayList;

class Contact {
    String name;
    String address;
    String emailaddress;
    String phonenumber;

    Contact(String n, String a, String ea, String pn) {
        name = n;
        address = a;
        emailaddress = ea;
        phonenumber = pn;
    }

    void display() {
        JOptionPane.showMessageDialog(null, "name: " + name + " Address: " + address + " emailaddress: " + emailaddress + " phonenumber: " + phonenumber);
    }
}

class AddressBook {
    ArrayList<Contact> contacts;

    AddressBook() {
        contacts = new ArrayList<>();
    }

    void addContact() {
        String name = JOptionPane.showInputDialog("Enter Name: ");
        String address = JOptionPane.showInputDialog("Enter Address: ");
        String emailaddress = JOptionPane.showInputDialog("Enter Email Address: ");
        String phonenumber = JOptionPane.showInputDialog("Enter Your PhoneNumber: ");
        Contact c = new Contact(name, address, emailaddress, phonenumber);
        contacts.add(c);
    }

    void searchContact(String n) {
        for (Contact c : contacts) {
            if (n.equals(c.name)) {
                c.display();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Contact not found.");
    }

    void deleteContact(String n) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);
            if (n.equals(c.name)) {
                contacts.remove(i);
                JOptionPane.showMessageDialog(null, "Contact deleted.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Contact not found.");
    }
}

public class addressbooksystem {
    public static void main(String[] args) {
        AddressBook ab = new AddressBook();
        String input;
        int ch;
        while (true) {
            input = JOptionPane.showInputDialog("Enter 1 to add\nEnter 2 to Search\nEnter 3 to Delete\nEnter 4 to exit");
            ch = Integer.parseInt(input);
            switch (ch) {
                case 1:
                    ab.addContact();
                    break;
                case 2:
                    String s = JOptionPane.showInputDialog("Enter name to search:");
                    ab.searchContact(s);
                    break;
                case 3:
                    s = JOptionPane.showInputDialog("Enter the name to delete: ");
                    ab.deleteContact(s);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input, please try again.");
            }
        }
    }
}
