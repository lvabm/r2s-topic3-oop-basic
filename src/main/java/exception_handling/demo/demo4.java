package exception_handling.demo;

import java.util.Scanner;

public class demo4 {
  public static void main(String[] args) {
    boolean isValid = false;

    while (!isValid) {
      try {
        new demo4().testThrowExeption();

        isValid = true;
      } catch (Exception e) {
        System.out.println("Catched Exeption: " + e);
      }
    }
  }

  private void testThrowExeption() throws Exception {
    Scanner scanner = new Scanner(System.in);
    int number;

    System.out.print("Enter your number: ");
    number = Integer.parseInt(scanner.nextLine().trim());

    if (number < 0 || number > 100) {
      throw new Exception("The number is between 0 to 100. Try Again!");
    }

    System.out.println("Your number is: " + number);
  }
}
