import java.util.Arrays;
import java.util.Scanner;

public class SearchingOperations {

    private int[] data;
    private int size;

    private int lastLinearSteps;
    private int lastBinarySteps;

    public SearchingOperations(int capacity) {
        data = new int[capacity];
        size = 0;
        lastLinearSteps = 0;
        lastBinarySteps = 0;
    }

    public void addValue(int value) {

        if (size == data.length) {
            System.out.println("Data storage is full.");
            return;
        }

        data[size] = value;
        size++;

        System.out.println(value + " added successfully.");
    }

    public void displayData() {

        if (size == 0) {
            System.out.println("No data available.");
            return;
        }

        System.out.print("Data: ");

        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println();
    }

    public void linearSearch(int target) {

        if (size == 0) {
            System.out.println("No data available.");
            return;
        }

        lastLinearSteps = 0;

        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {

            lastLinearSteps++;

            if (data[i] == target) {

                long endTime = System.nanoTime();

                System.out.println(
                    "Linear Search: " + target +
                    " found at position " + i
                );

                System.out.println(
                    "Steps: " + lastLinearSteps
                );

                System.out.println(
                    "Execution Time: " +
                    (endTime - startTime) +
                    " ns"
                );

                return;
            }
        }

        long endTime = System.nanoTime();

        System.out.println(
            "Linear Search: " + target + " not found."
        );

        System.out.println(
            "Steps: " + lastLinearSteps
        );

        System.out.println(
            "Execution Time: " +
            (endTime - startTime) +
            " ns"
        );
    }

    public void binarySearch(int target) {

        if (size == 0) {
            System.out.println("No data available.");
            return;
        }

        int[] sortedData = Arrays.copyOf(data, size);

        Arrays.sort(sortedData);

        lastBinarySteps = 0;

        int left = 0;
        int right = sortedData.length - 1;

        long startTime = System.nanoTime();

        while (left <= right) {

            lastBinarySteps++;

            int middle = (left + right) / 2;

            if (sortedData[middle] == target) {

                long endTime = System.nanoTime();

                System.out.println(
                    "Binary Search: " + target +
                    " found."
                );

                System.out.println(
                    "Sorted Data: " +
                    Arrays.toString(sortedData)
                );

                System.out.println(
                    "Steps: " + lastBinarySteps
                );

                System.out.println(
                    "Execution Time: " +
                    (endTime - startTime) +
                    " ns"
                );

                return;
            }

            if (target < sortedData[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        long endTime = System.nanoTime();

        System.out.println(
            "Binary Search: " + target + " not found."
        );

        System.out.println(
            "Sorted Data: " +
            Arrays.toString(sortedData)
        );

        System.out.println(
            "Steps: " + lastBinarySteps
        );

        System.out.println(
            "Execution Time: " +
            (endTime - startTime) +
            " ns"
        );
    }

    public int getLastLinearSteps() {
        return lastLinearSteps;
    }

    public int getLastBinarySteps() {
        return lastBinarySteps;
    }

    public void menu(Scanner scanner) {

        int choice;

        do {

            System.out.println(
                "\n========== SEARCHING OPERATIONS =========="
            );

            System.out.println("1. Add Data");
            System.out.println("2. Display Data");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Return to Main Menu");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print(
                        "Enter value to add: "
                    );

                    int value = scanner.nextInt();

                    addValue(value);

                    break;

                case 2:

                    displayData();

                    break;

                case 3:

                    System.out.print(
                        "Enter value to search: "
                    );

                    int linearTarget = scanner.nextInt();

                    linearSearch(linearTarget);

                    break;

                case 4:

                    System.out.print(
                        "Enter value to search: "
                    );

                    int binaryTarget = scanner.nextInt();

                    binarySearch(binaryTarget);

                    break;

                case 5:

                    System.out.println(
                        "Returning to Main Menu..."
                    );

                    break;

                default:

                    System.out.println(
                        "Invalid choice."
                    );
            }

        } while (choice != 5);
    }
}