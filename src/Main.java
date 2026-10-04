import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayOperations arrayOperations =
                new ArrayOperations(10);

        StackOperations stackOperations =
                new StackOperations(10);

        QueueOperations queueOperations =
                new QueueOperations(10);

        LinkedListOperations linkedListOperations =
                new LinkedListOperations();

        SearchingOperations searchingOperations =
                new SearchingOperations(20);

        Graph graph =
                new Graph();

        int choice;

        do {

            System.out.println("\n==============================================");
            System.out.println("     DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("==============================================");

            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    arrayOperations.menu(scanner);
                    break;

                case 2:
                    stackOperations.menu(scanner);
                    break;

                case 3:
                    queueOperations.menu(scanner);
                    break;

                case 4:
                    linkedListOperations.menu(scanner);
                    break;

                case 5:
                    searchingOperations.menu(scanner);
                    break;

                case 6:
                    graph.menu(scanner);
                    break;

                case 7:
                    PerformanceComparison.compareSearching();
                    break;

                case 8:

                    System.out.println(
                        "\n=============================================="
                    );

                    System.out.println(
                        "             ALL RESULTS SUMMARY"
                    );

                    System.out.println(
                        "=============================================="
                    );

                    System.out.println("\n1. ARRAY");
                    System.out.println(
                        "   Insert, Delete, Search and Display operations implemented."
                    );

                    System.out.println("\n2. STACK");
                    System.out.println(
                        "   Push, Pop, Peek and Display operations implemented."
                    );

                    System.out.println("\n3. QUEUE");
                    System.out.println(
                        "   Enqueue, Dequeue, Peek and Display operations implemented."
                    );

                    System.out.println("\n4. LINKED LIST");
                    System.out.println(
                        "   Insert, Delete, Search and Display operations implemented."
                    );

                    System.out.println("\n5. SEARCHING");
                    System.out.println(
                        "   Linear Search and Binary Search implemented."
                    );

                    System.out.println(
                        "   Linear Search Complexity: O(n)"
                    );

                    System.out.println(
                        "   Binary Search Complexity: O(log n)"
                    );

                    System.out.println("\n6. GRAPH");
                    System.out.println(
                        "   Add Vertex, Add Edge, Display, BFS and DFS implemented."
                    );

                    System.out.println("\n7. PERFORMANCE");
                    System.out.println(
                        "   Step counting and execution time measurement implemented."
                    );

                    System.out.println(
                        "   Searching performance comparison available in Option 7."
                    );

                    System.out.println(
                        "\n=============================================="
                    );

                    System.out.println(
                        "          END OF RESULTS SUMMARY"
                    );

                    System.out.println(
                        "=============================================="
                    );

                    break;

                case 9:

                    System.out.println(
                        "\nExiting the system..."
                    );

                    break;

                default:

                    System.out.println(
                        "\nInvalid choice. Please try again."
                    );
            }

        } while (choice != 9);

        scanner.close();
    }
}