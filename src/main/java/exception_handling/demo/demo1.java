package exception_handling.demo;

import java.util.Scanner;

public class demo1 {
  public static void main(String[] args) {
    new demo1().testNumber();
  }

  private void testNumber() {
    Scanner scanner = new Scanner(System.in);
    int number;

    try {
      System.out.print("Enter your number: ");
      number = scanner.nextInt();
    } catch (Exception e) { // InputMismatchException (Dùng Exeption để biết ngoại lệ chính xác)
      System.out.println("Invalid Number: " + e);
      number = 0;
    }

    System.out.println("Your number is: " + number);
  }
}
