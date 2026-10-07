import java.util.Scanner;

/**
 * Singly Linked List operations: insert, delete, search, display.
 * Includes input validation and empty-list handling.
 */
public class LinkedListOperations {

    // Node class: one box in the list (holds data + link to next node)
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // First node of the list (null means the list is empty)
    private Node head;

    public LinkedListOperations() {
        head = null;
    }

    // Checks whether the list has no nodes
    public boolean isEmpty() {
        return head == null;
    }

    // Insert an element at the end of the list - O(n)
    public void insert(int value) {

        // Duplicate check: do not allow the same value twice
        if (contains(value)) {
            System.out.println(value + " already exists in the list. Duplicates are not allowed.");
            return;
        }

        Node newNode = new Node(value);

        // If the list is empty, the new node becomes the head
        if (head == null) {
            head = newNode;
            System.out.println(value + " inserted successfully.");
            return;
        }

        // Walk to the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Link the last node to the new node
        current.next = newNode;
        System.out.println(value + " inserted successfully.");
    }

    // Delete an element - O(n)
    public void delete(int value) {

        // Handle empty list
        if (isEmpty()) {
            System.out.println("Linked List is empty. Nothing to delete.");
            return;
        }

        // Case 1: the first node holds the value
        if (head.data == value) {
            head = head.next;
            System.out.println(value + " deleted successfully.");
            return;
        }

        // Case 2: find the node BEFORE the one we want to delete
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        // Reached the end without finding the value
        if (current.next == null) {
            System.out.println(value + " not found. Nothing deleted.");
            return;
        }

        // Skip over the node to remove it
        current.next = current.next.next;
        System.out.println(value + " deleted successfully.");
    }

    // Search an element - O(n)
    public void search(int value) {

        // Handle empty list
        if (isEmpty()) {
            System.out.println("Linked List is empty. Nothing to search.");
            return;
        }

        Node current = head;
        int position = 0;   // position starts from 0 (like an array index)
        int steps = 0;      // number of nodes checked

        while (current != null) {
            steps++;

            if (current.data == value) {
                System.out.println(value + " found at position " + position
                        + " (steps taken: " + steps + ")");
                return;
            }

            current = current.next;
            position++;
        }

        System.out.println(value + " not found (steps taken: " + steps + ")");
    }

    // Helper: returns true if the value is already in the list
    private boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Display the linked list - O(n)
    public void display() {

        if (isEmpty()) {
            System.out.println("Linked List is empty.");
            return;
        }

        Node current = head;
        System.out.print("Linked List: ");

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }

    // Helper: keeps asking until the user types a valid whole number.
    // This stops the program from crashing when letters are typed.
    private int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                scanner.nextLine(); // clear the rest of the line
                return number;
            }

            // Not a number: throw away the bad input and ask again
            scanner.next();
            System.out.println("Invalid input. Please enter a whole number.");
        }
    }

    // Linked List submenu
    public void menu(Scanner scanner) {

        int choice;

        do {
            System.out.println("\n========== LINKED LIST OPERATIONS ==========");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {

                case 1:
                    int insertValue = readInt(scanner, "Enter value to insert: ");
                    insert(insertValue);
                    break;

                case 2:
                    int deleteValue = readInt(scanner, "Enter value to delete: ");
                    delete(deleteValue);
                    break;

                case 3:
                    int searchValue = readInt(scanner, "Enter value to search: ");
                    search(searchValue);
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1-5.");
            }

        } while (choice != 5);
    }
}