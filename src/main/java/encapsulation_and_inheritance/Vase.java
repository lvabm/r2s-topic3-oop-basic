package encapsulation_and_inheritance;

import java.util.Scanner;

public class Vase extends Item {
  private int height;
  private String material;

  public Vase() {}

  public Vase(String id, int value, String creator, int height, String material) {
    super(id, value, creator);
    this.height = height;
    this.material = material;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  @Override
  public String toString() {
    return String.format("Vase: %s | Height: %s, Material: %s", super.toString(), height, material);
  }

  @Override
  public void input() {
    Scanner scanner = new Scanner(System.in);
    super.input();
    System.out.print("Enter Height: ");
    setHeight(Integer.parseInt(scanner.nextLine()));
    System.out.print("Enter Material: ");
    setMaterial(scanner.nextLine().trim());
    System.out.println("----------------------------------------");
  }
}
