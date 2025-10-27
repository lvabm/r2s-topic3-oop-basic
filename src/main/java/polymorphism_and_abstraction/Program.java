package polymorphism_and_abstraction;

import java.util.Scanner;

public class Program {
  private final Product[] listProducts;
  private byte numOfProduct;
  private static final byte MAX = 100;
  private final Scanner scanner;

  public Program() {
    numOfProduct = 0;
    listProducts = new Product[MAX];
    scanner = new Scanner(System.in);
  }

  public static void main(String[] args) {
    new Program().runMenu();
  }

  public void addProduct(Product prototype) {
    boolean isAdding = true;
    while (isAdding) {
      if (numOfProduct < 0 || numOfProduct >= MAX) {
        System.out.println("Add new product fail");
      }

      prototype.input(scanner);
      listProducts[numOfProduct++] = prototype;
      System.out.println("Add new product successfully");

      isAdding = backToMainMenu();
    }
  }

  public void displayProducts() {
    if (numOfProduct == 0) {
      System.out.println("There are no products");
    }

    for (int i = 0; i < numOfProduct; i++) {
      System.out.println(listProducts[i].toString());
    }

    System.out.println("Here is the full product");
  }

  public Product findProduct(int id) {
    if (numOfProduct == 0) {
      System.out.println("There are no products");
      return null;
    }

    for (int i = 0; i < numOfProduct; i++) {
      if (listProducts[i].getId() == id) {
        System.out.println(listProducts[i].toString());
        System.out.println("Found id: " + id);
        return listProducts[i];
      }
    }

    System.out.println("Not found id: " + id);
    return null;
  }

  public void runMenu() {
    boolean isRunning = true;
    while (isRunning) {
      System.out.println("************************************************************");
      System.out.println("1. Add a new Product");
      System.out.println("2. Display all Product");
      System.out.println("3. Find the product by id ");
      System.out.println("0. Quit");
      System.out.println("************************************************************");

      System.out.print("Select function: ");
      String choice = scanner.nextLine().trim();

      switch (choice) {
        case "1" -> {
          boolean isChoosing = true;
          while (isChoosing) {
            System.out.println("   1. Add a new Electronics");
            System.out.println("   2. Add a new Clothing");
            System.out.println("   Previous (Press Y/N): ");

            switch (scanner.nextLine().trim()) {
              case "1" -> addProduct(new Electronics());
              case "2" -> addProduct(new Clothing());
              case "y", "Y" -> isChoosing = false;
              default -> isChoosing = backToMainMenu();
            }
          }
        }
        case "2" -> displayProducts();
        case "3" -> {
          System.out.print("Enter id to find Product: ");
          findProduct(Integer.parseInt(scanner.nextLine()));
        }
        case "0" -> {
          System.out.println("Exiting...");
          isRunning = false;
        }
      }
    }
  }

  public boolean backToMainMenu() {
    System.out.print("Previous (Press Y/N): ");
    return !scanner.nextLine().equalsIgnoreCase("Y");
  }
}
