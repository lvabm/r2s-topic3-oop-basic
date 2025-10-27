package polymorphism_and_abstraction;

import java.util.Scanner;

public class Electronics extends Product {
  private String brand;

  public Electronics() {}

  public Electronics(int id, String name, float price, String brand) {
    super(id, name, price);
    this.brand = brand;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  @Override
  public void input(Scanner scanner) {
    System.out.println("--- ELECTRONICS ---");
    super.input(scanner);
    setBrand(super.readString("Enter brand: "));
  }

  @Override
  public String toString() {
    return String.format("Electronics: %s, Brand: %s", super.toString(), brand);
  }
}
