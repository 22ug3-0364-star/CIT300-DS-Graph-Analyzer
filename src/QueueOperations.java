import java.util.Scanner;

/**
 * Circular array-based Queue (FIFO - First In, First Out).
 * Operations: enqueue, dequeue, peek, display.
 * Includes input validation and empty/full queue handling.
 */
public class QueueOperations {

    // The array that stores the queue elements
    private int[] queue;

    // Index of the front element
    private int front;

    // Index of the last (rear) element
    private int rear;

    // Number of elements currently in the queue
    private int size;

    // Creates a queue with the given capacity
    public QueueOperations(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Returns true if the queue has no elements
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns true if the queue cannot take more elements
    public boolean isFull() {
        return size == queue.length;
    }

    // Enqueue: add an element at the rear - O(1)
    public void enqueue(int value) {

        // Full queue check
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value + ".");
            return;
        }

        // Circular array: wrap around to index 0 after the last index
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;

        System.out.println(value + " enqueued successfully.");
    }

    // Dequeue: remove the element at the front - O(1)
    public void dequeue() {

        // Empty queue check
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to dequeue.");
            return;
        }

        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;

        System.out.println(value + " dequeued successfully.");
    }

    // Peek: show the front element without removing it - O(1)
    public void peek() {

        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek.");
            return;
        }

        System.out.println("Front element: " + queue[front]);
    }

    // Display the queue from front to rear - O(n)
    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue (front to rear): ");

        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.print(queue[index] + " ");
        }

        System.out.println();
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

    // Queue submenu
    public void menu(Scanner scanner) {

        int choice;

        do {

            System.out.println("\n========== QUEUE OPERATIONS ==========");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {

                case 1:
                    int enqueueValue = readInt(scanner, "Enter value to enqueue: ");
                    enqueue(enqueueValue);
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    peek();
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

        } while (choice!= 5);
    }
}