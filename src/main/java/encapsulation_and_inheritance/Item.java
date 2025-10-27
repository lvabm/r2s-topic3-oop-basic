package encapsulation_and_inheritance;

import java.util.Scanner;

public class Item {
  String id;
  int value;
  String creator;

  public Item() {}

  public Item(String id, int value, String creator) {
    this.id = id;
    this.value = value;
    this.creator = creator;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  @Override
  public String toString() {
    return String.format("ID: %s, Value: %d, Creator: %s", id, value, creator);
  }

  public void input() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("----------------------------------------");
    System.out.print("Enter Id: ");
    setId(scanner.nextLine());
    System.out.print("Nhập Value: ");
    setValue(Integer.parseInt(scanner.nextLine()));
    System.out.print("Enter Creator: ");
    setCreator(scanner.nextLine().trim());
  }
}
