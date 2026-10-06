import java.util.Scanner;

public class HashTableOperations {

    private int[] hashTable;
    private boolean[] occupied;
    private int capacity;

    public HashTableOperations(int capacity) {
        this.capacity = capacity;
        hashTable = new int[capacity];
        occupied = new boolean[capacity];
    }

    private int hashFunction(int key) {
        return Math.abs(key) % capacity;
    }

    public void insert(int key) {
        int index = hashFunction(key);

        for (int i = 0; i < capacity; i++) {
            int newIndex = (index + i) % capacity;

            if (!occupied[newIndex]) {
                hashTable[newIndex] = key;
                occupied[newIndex] = true;

                System.out.println(
                    key + " inserted at index " + newIndex
                );

                return;
            }
        }

        System.out.println("Hash Table is full.");
    }

    public void search(int key) {
        int index = hashFunction(key);

        for (int i = 0; i < capacity; i++) {
            int newIndex = (index + i) % capacity;

            if (!occupied[newIndex]) {
                System.out.println(key + " not found.");
                return;
            }

            if (hashTable[newIndex] == key) {
                System.out.println(
                    key + " found at index " + newIndex
                );

                return;
            }
        }

        System.out.println(key + " not found.");
    }

    public void delete(int key) {
        int index = hashFunction(key);

        for (int i = 0; i < capacity; i++) {
            int newIndex = (index + i) % capacity;

            if (!occupied[newIndex]) {
                System.out.println(key + " not found.");
                return;
            }

            if (hashTable[newIndex] == key) {
                occupied[newIndex] = false;

                System.out.println(
                    key + " deleted successfully."
                );

                return;
            }
        }

        System.out.println(key + " not found.");
    }

    public void display() {
        System.out.println("\n========== HASH TABLE ==========");

        for (int i = 0; i < capacity; i++) {

            if (occupied[i]) {
                System.out.println(
                    "Index " + i + " : " + hashTable[i]
                );
            } else {
                System.out.println(
                    "Index " + i + " : Empty"
                );
            }
        }
    }

    public void menu(Scanner scanner) {

        int choice;

        do {

            System.out.println("\n========== HASH TABLE OPERATIONS ==========");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter key to insert: ");
                    int insertKey = scanner.nextInt();
                    insert(insertKey);
                    break;

                case 2:
                    System.out.print("Enter key to search: ");
                    int searchKey = scanner.nextInt();
                    search(searchKey);
                    break;

                case 3:
                    System.out.print("Enter key to delete: ");
                    int deleteKey = scanner.nextInt();
                    delete(deleteKey);
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println(
                        "Returning to Main Menu..."
                    );
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }
}