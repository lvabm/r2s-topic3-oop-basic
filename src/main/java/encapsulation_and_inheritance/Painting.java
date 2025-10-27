package encapsulation_and_inheritance;

import java.util.Scanner;

public class Painting extends Item {
  private int height;
  private int width;
  private boolean isWaterColor;
  private boolean isFramed;

  public Painting() {}

  public Painting(
      String id,
      int value,
      String creator,
      int height,
      int width,
      boolean isWaterColor,
      boolean isFramed) {
    super(id, value, creator);
    this.height = height;
    this.width = width;
    this.isWaterColor = isWaterColor;
    this.isFramed = isFramed;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public boolean isWaterColor() {
    return isWaterColor;
  }

  public void setWaterColor(boolean waterColor) {
    isWaterColor = waterColor;
  }

  public boolean isFramed() {
    return isFramed;
  }

  public void setFramed(boolean framed) {
    isFramed = framed;
  }

  @Override
  public String toString() {
    return String.format(
        "Painting: %s | Height: %s, Width: %s, Water Color: %b, Framed: %b",
        super.toString(), height, width, isWaterColor, isFramed);
  }

  @Override
  public void input() {
    Scanner scanner = new Scanner(System.in);
    super.input();
    System.out.print("Enter Height: ");
    setHeight(Integer.parseInt(scanner.nextLine()));
    System.out.print("Enter Width: ");
    setWidth(Integer.parseInt(scanner.nextLine()));
    System.out.print("Is It Water Color: ");
    setWaterColor(Boolean.parseBoolean(scanner.nextLine()));
    System.out.print("Is It Framed: ");
    setFramed(Boolean.parseBoolean(scanner.nextLine().trim()));
    System.out.println("----------------------------------------");
  }
}
