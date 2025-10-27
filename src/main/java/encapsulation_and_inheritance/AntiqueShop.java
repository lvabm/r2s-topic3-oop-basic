package encapsulation_and_inheritance;

import java.util.Scanner;

public class AntiqueShop {
  public static void main(String[] args) {
    new AntiqueShop().runMenu();
  }

  private void runMenu() {
    Scanner scanner = new Scanner(System.in);
    ItemList itemList = new ItemList();
    boolean isRunning = true;
    while (isRunning) {

      System.out.println("************************************************************");
      System.out.println("1. Add a new Item");
      System.out.println("2. Display all items");
      System.out.println("3. Display the list of type ");
      System.out.println("4. Find the items by the creator ");
      System.out.println("0. Quit");
      System.out.println("************************************************************");

      System.out.print("Select function: ");
      String choice = scanner.nextLine().trim();

      switch (choice) {
        case "1" -> addItemByType(itemList, scanner);
        case "2" -> displayAllItem(itemList);
        case "3" -> displayItemByType(itemList, scanner);
        case "4" -> displayItemByCreator(itemList, scanner);
        case "0" -> isRunning = false;
        default -> System.out.println("Enter Again! \n");
      }
    }
  }

  private void addItemByType(ItemList itemList, Scanner scanner) {
    boolean isChoosingType = true;

    while (isChoosingType) {
      System.out.println("1. Add a new Vase");
      System.out.println("2. Add a new Statue");
      System.out.println("3. Add a new Painting");
      System.out.println("R. Retrun to main menu");

      System.out.print("Select type to add: ");
      String choiceType = scanner.nextLine().trim();

      Item item;
      switch (choiceType) {
        case "1" -> {
          item = new Vase();
          itemList.addItem(item);
        }
        case "2" -> {
          item = new Statue();
          itemList.addItem(item);
        }
        case "3" -> {
          item = new Painting();
          itemList.addItem(item);
        }
        case "r" -> isChoosingType = false;
        default -> System.out.println("Enter Again! \n");
      }
    }
  }

  private void displayAllItem(ItemList itemList) {
    itemList.displayAll();
  }

  private void displayItemByType(ItemList itemList, Scanner scanner) {
    boolean isChoosingType = true;

    while (isChoosingType) {
      System.out.println("1. Display all Vase");
      System.out.println("2. Display all Statue");
      System.out.println("3. Display all Painting");
      System.out.println("r. Retrun to main menu");

      System.out.print("Select type to display: ");
      String choiceType = scanner.nextLine().trim();
      switch (choiceType) {
        case "1" -> itemList.displayItemsByType("VASE");
        case "2" -> itemList.displayItemsByType("STATUE");
        case "3" -> itemList.displayItemsByType("PAINTING");
        case "r" -> isChoosingType = false;
        default -> System.out.println("Enter Again!");
      }
    }
  }

  private void displayItemByCreator(ItemList itemList, Scanner scanner) {
    while (true) {
      System.out.println("r. Retrun to main menu");
      System.out.print("Enter creator name to find: ");
      String creator = scanner.nextLine().trim();
      if (creator.equalsIgnoreCase("r")) {
        break;
      }
      itemList.findItem(creator);
    }
  }
}
