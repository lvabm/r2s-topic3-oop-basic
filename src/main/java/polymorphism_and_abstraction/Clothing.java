package polymorphism_and_abstraction;

import java.util.Scanner;

public class Clothing extends Product {
  private String size;

  public Clothing() {}

  public Clothing(int id, String name, float price, String size) {
    super(id, name, price);
    this.size = size;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  @Override
  public void input(Scanner scanner) {
    System.out.println("--- CLOTHING ---");
    super.input(scanner);
    setSize(super.readString("Enter size: "));
  }

  @Override
  public String toString() {
    return String.format("Clothing: %s, Size: %s", super.toString(), size);
  }
}
