package polymorphism_and_abstraction;

import java.util.Scanner;

public abstract class Product {
  protected int id;
  protected String name;
  protected float price;

  public Product() {}

  public Product(int id, String name, float price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public void input(Scanner scanner) {
    setId(readInt(scanner, "Enter id: "));
    setName(readString("Enter name: "));
    setPrice(readFloat(scanner, "Enter price: "));
  }

  @Override
  public String toString() {
    return String.format("ID: %d, Name: %s, Price: %.1f", id, name, price);
  }

  protected int readInt(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String line = scanner.nextLine().trim();
      if (line.matches("-?\\d+")) { // chỉ số nguyên
        try {
          return Integer.parseInt(line);
        } catch (NumberFormatException e) {
          System.out.println("Wrong input. Try Again!");
        }
      } else {
        System.out.println("Wrong input. Try Again!");
      }
    }
  }

  protected float readFloat(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String line = scanner.nextLine().trim();
      if (line.matches("-?\\d+(\\.\\d+)?")) {
        try {
          return Float.parseFloat(line);
        } catch (NumberFormatException e) {
          System.out.println("Wrong input. Try Again!");
        }
      } else {
        System.out.println("Wrong input. Try Again!");
      }
    }
  }

  protected String readString(String message) {
    Scanner scanner = new Scanner(System.in);
    String input;

    while (true) {
      System.out.print(message);
      input = scanner.nextLine().trim();

      if (!input.isEmpty()) {
        return input;
      }
      System.out.println("Wrong input. Try Again!");
    }
  }
}
