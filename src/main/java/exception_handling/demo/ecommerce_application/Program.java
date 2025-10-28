package exception_handling.demo.ecommerce_application;

import java.util.Scanner;

public class Program {
  private static final String ADD_NEW_PRODUCT = "1";
  private static final String FIND_PRODUCT_BY_ID = "2";
  private static final String UPDATE_PRODUCT_QUANTITY = "3";
  private static final String EXIT_PROGRAM = "0";
  private final Scanner scanner;
  private final ProductManagement pm;

  public Program() {
    scanner = InputHelper.scanner;
    pm = new ProductManagement();
  }

  public static void main(String[] args) {
    new Program().runMenu();
  }

  public void runMenu() {
    boolean isRunning = true;

    while (isRunning) {
      System.out.println("************************************************************");
      System.out.println("1. Add a new Product");
      System.out.println("2. Find the product by id");
      System.out.println("3. Update Product Quantity ");
      System.out.println("0. Exit");
      System.out.println("************************************************************");

      System.out.print("Select function: ");
      String choice = scanner.nextLine().trim();

      try {
        switch (choice) {
          case ADD_NEW_PRODUCT -> {
            pm.addProduct().displayCurrentProductDetail();
          }

          case FIND_PRODUCT_BY_ID -> {
            pm.displayProductByID(InputHelper.readInt("Enter ID to find: "))
                .displayCurrentProductDetail();
          }

          case UPDATE_PRODUCT_QUANTITY -> {
            pm.updateProductQuantity(
                    InputHelper.readInt("Enter ID to find: "),
                    InputHelper.readInt("Enter new quanity to update: "))
                .displayCurrentProductDetail();
          }

          case EXIT_PROGRAM -> {
            System.out.println("Exiting...");
            isRunning = false;
          }
        }
      } catch (ProductNotFoundException | RuntimeException e) {
        System.err.println("Operation Failed: " + e.getMessage());
      } catch (Exception e) {
        System.err.println("An unexpected error occurred: " + e.getMessage());
      }
    }
  }
}
