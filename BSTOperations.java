import java.util.Scanner;

public class BSTOperations {

    // Node class
    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BSTOperations() {
        root = null;
    }

    // Insert a value
    public void insert(int value) {
        root = insertRecursive(root, value);
        System.out.println(value + " inserted successfully.");
    }

    private Node insertRecursive(Node node, int value) {

        if (node == null) {
            return new Node(value);
        }

        if (value < node.data) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.data) {
            node.right = insertRecursive(node.right, value);
        } else {
            System.out.println(value + " already exists in the tree.");
        }

        return node;
    }

    // Search a value
    public void search(int value) {

        if (searchRecursive(root, value)) {
            System.out.println(value + " found in the BST.");
        } else {
            System.out.println(value + " not found.");
        }
    }

    private boolean searchRecursive(Node node, int value) {

        if (node == null) {
            return false;
        }

        if (node.data == value) {
            return true;
        }

        if (value < node.data) {
            return searchRecursive(node.left, value);
        }

        return searchRecursive(node.right, value);
    }

    // Delete a value
    public void delete(int value) {

        if (!searchRecursive(root, value)) {
            System.out.println(value + " not found.");
            return;
        }

        root = deleteRecursive(root, value);

        System.out.println(value + " deleted successfully.");
    }

    private Node deleteRecursive(Node node, int value) {

        if (node == null) {
            return null;
        }

        if (value < node.data) {
            node.left = deleteRecursive(node.left, value);

        } else if (value > node.data) {
            node.right = deleteRecursive(node.right, value);

        } else {

            // No child
            if (node.left == null && node.right == null) {
                return null;
            }

            // Only right child
            if (node.left == null) {
                return node.right;
            }

            // Only left child
            if (node.right == null) {
                return node.left;
            }

            // Two children
            Node smallestNode = findMin(node.right);

            node.data = smallestNode.data;

            node.right = deleteRecursive(node.right, smallestNode.data);
        }

        return node;
    }

    // Find minimum value
    private Node findMin(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    // Display BST using Inorder Traversal
    public void display() {

        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }

        System.out.print("BST (Inorder): ");

        inorder(root);

        System.out.println();
    }

    private void inorder(Node node) {

        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // BST menu
    public void menu(Scanner scanner) {

        int choice;

        do {
            System.out.println("\n========== BST OPERATIONS ==========");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
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
                    System.out.print("Enter value to search: ");
                    int searchValue = scanner.nextInt();
                    search(searchValue);
                    break;

                case 3:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = scanner.nextInt();
                    delete(deleteValue);
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
