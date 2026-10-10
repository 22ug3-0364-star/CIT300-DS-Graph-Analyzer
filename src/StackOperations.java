import java.util.Scanner;

/**
 * Array-based Stack (LIFO - Last In, First Out).
 * Operations: push, pop, peek, display.
 * Includes input validation and empty/full stack handling.
 */
public class StackOperations {

    // The array that stores the stack elements
    private int[] stack;

    // Index of the top element (-1 means the stack is empty)
    private int top;

    // Creates a stack with the given capacity
    public StackOperations(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    // Returns true if the stack has no elements
    public boolean isEmpty() {
        return top == -1;
    }

    // Returns true if the stack cannot take more elements
    public boolean isFull() {
        return top == stack.length - 1;
    }

    // Push: add an element on top - O(1)
    public void push(int value) {

        // Full stack check (stack overflow)
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value + ".");
            return;
        }

        top++;
        stack[top] = value;

        System.out.println(value + " pushed successfully.");
    }

    // Pop: remove the top element - O(1)
    public void pop() {

        // Empty stack check (stack underflow)
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to pop.");
            return;
        }

        int value = stack[top];
        top--;

        System.out.println(value + " popped successfully.");
    }

    // Peek: show the top element without removing it - O(1)
    public void peek() {

        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return;
        }

        System.out.println("Top element: " + stack[top]);
    }

    // Display the stack from top to bottom - O(n)
    public void display() {

        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack elements (top to bottom):");

        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
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

    // Stack submenu
    public void menu(Scanner scanner) {

        int choice;

        do {

            System.out.println("\n========== STACK OPERATIONS ==========");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {

                case 1:
                    int pushValue = readInt(scanner, "Enter value to push: ");
                    push(pushValue);
                    break;

                case 2:
                    pop();
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