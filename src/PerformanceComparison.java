public class PerformanceComparison {

    // Linear Search Performance
    public static void linearSearchPerformance(int[] data, int target) {

        int steps = 0;

        long startTime = System.nanoTime();

        int foundIndex = -1;

        for (int i = 0; i < data.length; i++) {

            steps++;

            if (data[i] == target) {

                foundIndex = i;

                break;
            }
        }

        long endTime = System.nanoTime();

        System.out.println("\n----- Linear Search Performance -----");

        System.out.println("Target: " + target);

        if (foundIndex != -1) {

            System.out.println(
                    "Result: Found at index " + foundIndex
            );

        } else {

            System.out.println("Result: Not Found");
        }

        System.out.println("Steps: " + steps);

        System.out.println(
                "Execution Time: "
                        + (endTime - startTime)
                        + " ns"
        );

        System.out.println("Time Complexity: O(n)");
    }


    // Binary Search Performance
    public static void binarySearchPerformance(
            int[] data,
            int target) {

        int steps = 0;

        long startTime = System.nanoTime();

        int left = 0;

        int right = data.length - 1;

        int foundIndex = -1;

        while (left <= right) {

            steps++;

            int middle = (left + right) / 2;

            if (data[middle] == target) {

                foundIndex = middle;

                break;

            } else if (target < data[middle]) {

                right = middle - 1;

            } else {

                left = middle + 1;
            }
        }

        long endTime = System.nanoTime();

        System.out.println("\n----- Binary Search Performance -----");

        System.out.println("Target: " + target);

        if (foundIndex != -1) {

            System.out.println(
                    "Result: Found at index " + foundIndex
            );

        } else {

            System.out.println("Result: Not Found");
        }

        System.out.println("Steps: " + steps);

        System.out.println(
                "Execution Time: "
                        + (endTime - startTime)
                        + " ns"
        );

        System.out.println("Time Complexity: O(log n)");
    }


    // Main Performance Comparison
    public static void compareSearching() {

        int[] data = {

                10, 20, 30, 40, 50,

                60, 70, 80, 90, 100,

                110, 120, 130, 140, 150,

                160, 170, 180, 190, 200
        };

        int target = 190;

        System.out.println(
                "\n=========================================="
        );

        System.out.println(
                "        SEARCH PERFORMANCE COMPARISON"
        );

        System.out.println(
                "=========================================="
        );

        linearSearchPerformance(data, target);

        binarySearchPerformance(data, target);

        System.out.println(
                "\nPerformance comparison completed."
        );
    }
}