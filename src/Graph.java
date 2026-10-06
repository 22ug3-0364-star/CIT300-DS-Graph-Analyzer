import java.util.*;

public class Graph {

    private Map<String, List<String>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add a campus location
    public void addLocation(String location) {

        if (adjacencyList.containsKey(location)) {
            System.out.println(location + " already exists.");
            return;
        }

        adjacencyList.put(location, new ArrayList<>());

        System.out.println(location + " added successfully.");
    }

    // Remove a campus location
    public void removeLocation(String location) {

        if (!adjacencyList.containsKey(location)) {
            System.out.println(location + " not found.");
            return;
        }

        adjacencyList.remove(location);

        for (List<String> connections : adjacencyList.values()) {
            connections.remove(location);
        }

        System.out.println(location + " removed successfully.");
    }

    // Add a connection between two locations
    public void addConnection(String location1, String location2) {

        if (!adjacencyList.containsKey(location1)) {
            System.out.println(location1 + " does not exist.");
            return;
        }

        if (!adjacencyList.containsKey(location2)) {
            System.out.println(location2 + " does not exist.");
            return;
        }

        if (location1.equals(location2)) {
            System.out.println("A location cannot connect to itself.");
            return;
        }

        if (adjacencyList.get(location1).contains(location2)) {
            System.out.println("Connection already exists.");
            return;
        }

        adjacencyList.get(location1).add(location2);
        adjacencyList.get(location2).add(location1);

        System.out.println("Connection added successfully.");
    }

    // Remove a connection
    public void removeConnection(String location1, String location2) {

        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)) {

            System.out.println("One or both locations do not exist.");
            return;
        }

        boolean removed1 =
                adjacencyList.get(location1).remove(location2);

        boolean removed2 =
                adjacencyList.get(location2).remove(location1);

        if (removed1 || removed2) {
            System.out.println("Connection removed successfully.");
        } else {
            System.out.println("Connection not found.");
        }
    }

    // Display all graph connections
    public void displayConnections() {

        if (adjacencyList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        System.out.println("\n========== CAMPUS CONNECTIONS ==========");

        for (String location : adjacencyList.keySet()) {

            System.out.print(location + " -> ");

            List<String> connections =
                    adjacencyList.get(location);

            if (connections.isEmpty()) {

                System.out.println("No connections.");

            } else {

                for (String connection : connections) {
                    System.out.print(connection + " ");
                }

                System.out.println();
            }
        }
    }

    // Breadth First Search
    public void bfs(String startLocation) {

        if (!adjacencyList.containsKey(startLocation)) {
            System.out.println(startLocation + " not found.");
            return;
        }

        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();

        visited.add(startLocation);
        queue.add(startLocation);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.print(current + " ");

            for (String neighbour :
                    adjacencyList.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println();
    }

    // Depth First Search
    public void dfs(String startLocation) {

        if (!adjacencyList.containsKey(startLocation)) {
            System.out.println(startLocation + " not found.");
            return;
        }

        Set<String> visited = new HashSet<>();

        System.out.print("DFS Traversal: ");

        dfsRecursive(startLocation, visited);

        System.out.println();
    }

    // Recursive method for DFS
    private void dfsRecursive(
            String current,
            Set<String> visited) {

        visited.add(current);

        System.out.print(current + " ");

        for (String neighbour :
                adjacencyList.get(current)) {

            if (!visited.contains(neighbour)) {

                dfsRecursive(neighbour, visited);
            }
        }
    }

    // Graph menu
    public void menu(Scanner scanner) {

        int choice;

        do {

            System.out.println("\n========== GRAPH OPERATIONS ==========");

            System.out.println("10. Add Campus Location");
            System.out.println("11. Remove Campus Location");
            System.out.println("12. Add Connection / Road");
            System.out.println("13. Remove Connection / Road");
            System.out.println("14. Display Connections");
            System.out.println("15. BFS Traversal");
            System.out.println("16. DFS Traversal");
            System.out.println("17. Return to Main Menu");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 10:

                    System.out.print("Enter campus location: ");

                    String location =
                            scanner.nextLine();

                    addLocation(location);

                    break;

                case 11:

                    System.out.print("Enter location to remove: ");

                    String removeLocation =
                            scanner.nextLine();

                    removeLocation(removeLocation);

                    break;

                case 12:

                    System.out.print("Enter first location: ");

                    String location1 =
                            scanner.nextLine();

                    System.out.print("Enter second location: ");

                    String location2 =
                            scanner.nextLine();

                    addConnection(
                            location1,
                            location2);

                    break;

                case 13:

                    System.out.print("Enter first location: ");

                    String location3 =
                            scanner.nextLine();

                    System.out.print("Enter second location: ");

                    String location4 =
                            scanner.nextLine();

                    removeConnection(
                            location3,
                            location4);

                    break;

                case 14:

                    displayConnections();

                    break;

                case 15:

                    System.out.print("Enter starting location: ");

                    String startLocation =
                            scanner.nextLine();

                    bfs(startLocation);

                    break;

                case 16:

                    System.out.print("Enter starting location: ");

                    String dfsStartLocation =
                            scanner.nextLine();

                    dfs(dfsStartLocation);

                    break;

                case 17:

                    System.out.println(
                            "Returning to Main Menu...");

                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 17);
    }
}