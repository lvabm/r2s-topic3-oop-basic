package encapsulation_and_inheritance;

import java.util.Scanner;

public class Statue extends Item {
  private int weight;
  private String color;

  public Statue() {}

  public Statue(String id, int value, String creator, int weight, String color) {
    super(id, value, creator);
    this.weight = weight;
    this.color = color;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return String.format("Statue: %s | Weight: %s, Color: %s", super.toString(), weight, color);
  }

  @Override
  public void input() {
    Scanner scanner = new Scanner(System.in);
    super.input();
    System.out.print("Enter Weight: ");
    setWeight(Integer.parseInt(scanner.nextLine()));
    System.out.print("Enter Color: ");
    setColor(scanner.nextLine().trim());
    System.out.println("----------------------------------------");
  }
}
