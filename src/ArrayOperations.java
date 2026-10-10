import java.util.Scanner;

/**
 * Fixed-size array operations: insert, delete, search, display.
 * Includes input validation, empty-array and full-array handling.
 */
public class ArrayOperations {

    // The array that stores the values
    private int[] array;

    // Number of elements currently stored (not the total capacity)
    private int size;

    // Creates an array with the given capacity
    public ArrayOperations(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    // Returns true if there are no elements
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns true if no more elements can be added
    public boolean isFull() {
        return size == array.length;
    }

    // Insert an element at the end - O(1)
    public void insert(int value) {

        // Full array check
        if (isFull()) {
            System.out.println("Array is full. Cannot insert " + value + ".");
            return;
        }

        array[size] = value;
        size++;

        System.out.println(value + " inserted successfully.");
    }

    // Delete an element by value - O(n) because elements must be shifted
    public void delete(int value) {

        // Empty array check
        if (isEmpty()) {
            System.out.println("Array is empty. Nothing to delete.");
            return;
        }

        int index = search(value);

        if (index == -1) {
            System.out.println(value + " not found. Nothing deleted.");
            return;
        }

        // Shift all elements after the deleted one to the left
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;

        System.out.println(value + " deleted successfully.");
    }

    // Linear search: returns the index of the value, or -1 if not found - O(n)
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1;
    }

    // Display all elements - O(n)
    public void display() {

        if (isEmpty()) {
            System.out.println("Array is empty.");
            return;
        }

        System.out.print("Array: ");

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("(" + size + "/" + array.length + " used)");
    }

    // Keeps asking until the user types a whole number.
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

    // Array submenu
    public void menu(Scanner scanner) {

        int choice;

        do {
            System.out.println("\n========== ARRAY OPERATIONS ==========");
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
                    if (isEmpty()) {
                        System.out.println("Array is empty. Nothing to search.");
                        break;
                    }

                    int searchValue = readInt(scanner, "Enter value to search: ");
                    int result = search(searchValue);

                    if (result != -1) {
                        System.out.println(searchValue + " found at index " + result);
                    } else {
                        System.out.println(searchValue + " not found.");
                    }
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