import java.io.*;
import java.util.*;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class User {
    String username;
    String password;
    double balance;

    public User(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
}

class Order {
    List<Product> products;
    double totalCost;

    public Order() {
        this.products = new ArrayList<>();
        this.totalCost = 0;
    }
}

public class onlinebillingsystem{
    private static List<Product> products = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static List<Order> orderHistory = new ArrayList<>();
    private static User currentUser;

    public static void main(String[] args) {
        initializeData(); // Load initial data

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    private static void initializeData() {
        // Add some sample products
        products.add(new Product("Laptop", 800.0));
        products.add(new Product("Headphones", 50.0));
        products.add(new Product("Mouse", 20.0));
        products.add(new Product("Smartphones", 10000.0));
        products.add(new Product("Smartwatches", 500.0));
        products.add(new Product("Cameras", 5000.0));
        products.add(new Product("Speakers", 1000.0));
        products.add(new Product("Fitness Trackers", 200.0));
        products.add(new Product("Playstation", 6000.0));
        products.add(new Product("SmartHomeDevices", 8000.0));
        products.add(new Product("SmartTV's", 20000.0));
        products.add(new Product("Printers", 700.0));
        products.add(new Product("VR Headsets", 900.0));
        products.add(new Product("Networking Devices", 2000.0));
        products.add(new Product("Security Cameras", 4000.0));

        // Add a sample user
        users.add(new User("saloni", "saloni@24", 60000.0));
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        currentUser = authenticateUser(username, password);

        if (currentUser != null) {
            showProductList(scanner);
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }

    private static User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }

    private static void showProductList(Scanner scanner) {
        boolean continueShopping = true;
        Order currentOrder = new Order();

        while (continueShopping) {
            System.out.println("\nAvailable Products:");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i).name + " - $" + products.get(i).price);
            }

            System.out.println("0. Checkout");
            System.out.print("Enter product number to add to cart (or 0 to checkout): ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= products.size()) {
                Product selectedProduct = products.get(choice - 1);
                currentOrder.products.add(selectedProduct);
                currentOrder.totalCost += selectedProduct.price;
                System.out.println(selectedProduct.name + " added to cart.");
            } else if (choice == 0) {
                checkout(currentOrder);
                continueShopping = false;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void checkout(Order order) {
        if (currentUser.balance >= order.totalCost) {
            currentUser.balance -= order.totalCost;
            orderHistory.add(order);

            System.out.println("\nCheckout successful!");
            System.out.println("Total cost: $" + order.totalCost);
            System.out.println("Remaining balance: $" + currentUser.balance);
        } else {
            System.out.println("\nInsufficient balance. Checkout failed.");
        }
    }
}
