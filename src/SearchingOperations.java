import java.util.Arrays;
import java.util.Scanner;

/**
 * Demonstrates Linear Search and Binary Search.
 * Both searches count the steps taken and measure execution time,
 * so the two approaches can be compared.
 */
public class SearchingOperations {

    // Stored data and the number of values currently stored
    private int[] data;
    private int size;

    // Steps taken by the most recent searches (used by Performance Comparison)
    private int lastLinearSteps;
    private int lastBinarySteps;

    // Creates a data store with the given capacity
    public SearchingOperations(int capacity) {
        data = new int[capacity];
        size = 0;
        lastLinearSteps = 0;
        lastBinarySteps = 0;
    }

    // Add a value to the data store
    public void addValue(int value) {

        // Full storage check
        if (size == data.length) {
            System.out.println("Data storage is full. Cannot add " + value + ".");
            return;
        }

        data[size] = value;
        size++;

        System.out.println(value + " added successfully.");
    }

    // Display all stored values
    public void displayData() {

        if (size == 0) {
            System.out.println("No data available.");
            return;
        }

        System.out.print("Data: ");

        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println("(" + size + "/" + data.length + " used)");
    }

    // Linear search: checks every element one by one.
    // Worst case O(n) - works on unsorted data.
    public void linearSearch(int target) {

        if (size == 0) {
            System.out.println("No data available.");
            return;
        }

        lastLinearSteps = 0;

        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {

            // One comparison = one step
            lastLinearSteps++;

            if (data[i] == target) {

                long endTime = System.nanoTime();

                System.out.println("Linear Search: " + target + " found at position " + i);
                System.out.println("Steps: " + lastLinearSteps);
                System.out.println("Execution Time: " + (endTime - startTime) + " ns");

                return;
            }
        }

        long endTime = System.nanoTime();

        System.out.println("Linear Search: " + target + " not found.");
        System.out.println("Steps: " + lastLinearSteps);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
    }

    // Binary search: repeatedly halves the search range.
    // Worst case O(log n) - needs SORTED data, so a sorted copy is made first.
    public void binarySearch(int target) {

        if (size == 0) {
            System.out.println("No data available.");
            return;
        }

        // Binary search only works on sorted data
        int[] sortedData = Arrays.copyOf(data, size);
        Arrays.sort(sortedData);

        lastBinarySteps = 0;

        int left = 0;
        int right = sortedData.length - 1;

        long startTime = System.nanoTime();

        while (left <= right) {

            // One comparison with the middle element = one step
            lastBinarySteps++;

            int middle = (left + right) / 2;

            if (sortedData[middle] == target) {

                long endTime = System.nanoTime();

                System.out.println("Binary Search: " + target + " found.");
                System.out.println("Sorted Data: " + Arrays.toString(sortedData));
                System.out.println("Steps: " + lastBinarySteps);
                System.out.println("Execution Time: " + (endTime - startTime) + " ns");

                return;
            }

            // Discard the half that cannot contain the target
            if (target < sortedData[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        long endTime = System.nanoTime();

        System.out.println("Binary Search: " + target + " not found.");
        System.out.println("Sorted Data: " + Arrays.toString(sortedData));
        System.out.println("Steps: " + lastBinarySteps);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
    }

    // Steps of the last linear search (used by Performance Comparison)
    public int getLastLinearSteps() {
        return lastLinearSteps;
    }

    // Steps of the last binary search (used by Performance Comparison)
    public int getLastBinarySteps() {
        return lastBinarySteps;
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

    // Searching submenu
    public void menu(Scanner scanner) {

        int choice;

        do {

            System.out.println("\n========== SEARCHING OPERATIONS ==========");
            System.out.println("1. Add Data");
            System.out.println("2. Display Data");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Return to Main Menu");

            choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {

                case 1:
                    int value = readInt(scanner, "Enter value to add: ");
                    addValue(value);
                    break;

                case 2:
                    displayData();
                    break;

                case 3:
                    if (size == 0) {
                        System.out.println("No data available. Add data first.");
                        break;
                    }
                    int linearTarget = readInt(scanner, "Enter value to search: ");
                    linearSearch(linearTarget);
                    break;

                case 4:
                    if (size == 0) {
                        System.out.println("No data available. Add data first.");
                        break;
                    }
                    int binaryTarget = readInt(scanner, "Enter value to search: ");
                    binarySearch(binaryTarget);
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