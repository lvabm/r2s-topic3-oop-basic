package exception_handling.demo;

public class demo2 {
  public static void main(String[] args) {
    new demo2().testArray();
  }

  private void testArray() {
    int listNumber[] = {1, 2, 3, 4, 5};

    try {

      for (int i = 0; i <= listNumber.length; i++) {
        System.out.println("Num: " + listNumber[i]);
      }
    } catch (Exception e) {
      System.out.println("Wrong: " + e);
    }

    System.out.println("Done");
  }
}
