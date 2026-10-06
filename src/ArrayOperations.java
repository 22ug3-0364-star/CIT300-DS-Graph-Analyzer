import java.util.Scanner;

public class ArrayOperations {

    private int[] array;
    private int size;

    public ArrayOperations(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    // Insert an element
    public void insert(int value) {
        if (size == array.length) {
            System.out.println("Array is full.");
            return;
        }

        array[size] = value;
        size++;

        System.out.println(value + " inserted successfully.");
    }

    // Delete an element
    public void delete(int value) {
        int index = search(value);

        if (index == -1) {
            System.out.println(value + " not found.");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;

        System.out.println(value + " deleted successfully.");
    }

    // Search an element
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1;
    }

    // Display array
    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }

        System.out.print("Array: ");

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    // Array menu
    public void menu(Scanner scanner) {

        int choice;

        do {
            System.out.println("\n========== ARRAY OPERATIONS ==========");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value to insert: ");
                    int insertValue = scanner.nextInt();
                    insert(insertValue);
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = scanner.nextInt();
                    delete(deleteValue);
                    break;

                case 3:
                    System.out.print("Enter value to search: ");
                    int searchValue = scanner.nextInt();

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
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }
}