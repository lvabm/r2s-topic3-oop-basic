package encapsulation_and_inheritance;

public class ItemList {
  private Item[] listItem;
  private int numberOfItem = 0;
  private final int MAX = 100;

  public ItemList() {
    listItem = new Item[MAX];

    listItem[0] = new Vase("Id_1", 100, "LeVanAn", 10, "Wood");
    listItem[1] = new Statue("Id_2", 1000, "LeVanAn", 100, "Green");
    listItem[2] = new Painting("Id_3", 10000, "LeVanAn", 5, 20, true, true);
    numberOfItem = 3;
  }

  public boolean addItem(Item item) {
    if (numberOfItem > MAX) {
      return false;
    }
    item.input();
    listItem[numberOfItem++] = item;
    return true;
  }

  public void displayAll() {
    if (numberOfItem < 0) {
      throw new IllegalArgumentException("There are no items");
    }
    for (int i = 0; i < numberOfItem; i++) {
      System.out.println(listItem[i].toString());
    }
  }

  public Item findItem(String creator) {
    if (numberOfItem < 0) {
      throw new IllegalArgumentException("There are no item of " + creator);
    }
    for (int i = 0; i < numberOfItem; i++) {
      if (listItem[i].getCreator().equalsIgnoreCase(creator)) {
        System.out.println(listItem[i].toString());
      }
    }
    return null;
  }

  public void displayItemsByType(String type) {
    if (numberOfItem < 0) {
      throw new IllegalArgumentException("There are no items");
    }
    for (int i = 0; i < numberOfItem; i++) {
      if (listItem[i] instanceof Vase vase && type.equalsIgnoreCase("VASE")) {
        System.out.println(vase.toString());
      }
      if (listItem[i] instanceof Statue statue && type.equalsIgnoreCase("STATUE")) {
        System.out.println(statue.toString());
      }
      if (listItem[i] instanceof Painting painting && type.equalsIgnoreCase("PAINTING")) {
        System.out.println(painting.toString());
      }
    }
  }
}
