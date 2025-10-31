package helper;

import java.util.Scanner;

public class InputHelper {
  public static final Scanner scanner = new Scanner(System.in);

  public static int readInt(String prompt) {
    String line;

    while (true) {
      try {
        System.out.print(prompt);
        line = scanner.nextLine().trim();

        if (!line.matches("^\\d+$")) {
          throw new IllegalArgumentException("Input must be a positive Integer. Try Again!");
        }

        int value = Integer.parseInt(line);
        if (value <= 0) {
          throw new IllegalArgumentException("The number must be greater than 0. Try Again!");
        }

        return value;

      } catch (IllegalArgumentException i) {
        System.out.println(i.getMessage());
      }
    }
  }

  public static float readFloat(String prompt) {
    String line;
    float value;

    while (true) {
      try {
        System.out.print(prompt);
        line = scanner.nextLine().trim();

        if (line.isEmpty()) {
          throw new IllegalArgumentException("Input can't be null or empty.");
        }

        // Java tự động chuyển đổi số nguyên thành số thực (ví dụ: "1" -> 1.0f)
        value = Float.parseFloat(line);

        if (value <= 0) {
          throw new IllegalArgumentException("The number must be greater than 0. Try Again!");
        }

        return value;

      } catch (NumberFormatException e) {
        System.out.println("Input must be a positive number (integer or decimal). Try Again!");
      } catch (IllegalArgumentException i) {
        System.out.println(i.getMessage());
      }
    }
  }

  public static String readString(String prompt) {
    String line;

    while (true) {
      try {
        System.out.print(prompt);
        line = scanner.nextLine().trim();

        if (line.isEmpty()) {
          throw new IllegalArgumentException("Input can't be null or empty");
        }

        break;

      } catch (IllegalArgumentException i) {
        System.out.println(i.getMessage());
      }
    }

    return line;
  }

  public static boolean readBoolean(String prompt) {
    String line;
    while (true) {
      System.out.print(prompt + " [1] Active / [0] In-active: ");
      line = scanner.nextLine().trim();

      if (line.equals("1")) {
        return true;
      } else if (line.equals("0")) {
        return false;
      } else {
        System.out.println("Please select [1] Active / [0] In-active");
      }
    }
  }
}
