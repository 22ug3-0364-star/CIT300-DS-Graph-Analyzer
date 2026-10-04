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

        HashTableOperations hashTableOperations =
                new HashTableOperations(10);

        BSTOperations bstOperations =
                new BSTOperations();

        Graph graph =
                new Graph();

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println(" UNIVERSITY STUDENT RECORD &");
            System.out.println(" CAMPUS ROUTE MANAGEMENT SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Hash Table Operations");
            System.out.println("6. BST Operations");
            System.out.println("7. Graph Operations");
            System.out.println("8. Exit");

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
                    hashTableOperations.menu(scanner);
                    break;

                case 6:
                    bstOperations.menu(scanner);
                    break;

                case 7:
                    graph.menu(scanner);
                    break;

                case 8:
                    System.out.println(
                        "Exiting the system..."
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please try again."
                    );
            }

        } while (choice != 8);

        scanner.close();
    }
}