package exception_handling.demo.ecommerce_application;

import java.util.Scanner;

public class InputHelper {
  public static final Scanner scanner = new Scanner(System.in);

  public static int readInt(String prompt) {
    String line;

    while (true) {
      try {
        System.out.print(prompt);
        line = scanner.nextLine().trim();

        if (!line.matches("-?\\d+")) {
          throw new IllegalArgumentException("The number must be Integer. Try Again!");
        }

        if (Integer.parseInt(line) < 0) {
          throw new IllegalArgumentException("The number must be greater than >0. Try Again!");
        }

        break;

      } catch (IllegalArgumentException i) {
        System.out.println(i.getMessage());
      }
    }
    return Integer.parseInt(line);
  }

  public static float readFloat(String prompt) {
    String line;

    while (true) {
      try {
        System.out.print(prompt);
        line = scanner.nextLine().trim();

        if (!line.matches("-?\\d+")) {
          throw new IllegalArgumentException("The number must be Float. Try Again!");
        }

        if (Integer.parseInt(line) < 0) {
          throw new IllegalArgumentException("The number must be greater than >0. Try Again!");
        }

        break;

      } catch (IllegalArgumentException i) {
        System.out.println(i.getMessage());
      }
    }
    return Float.parseFloat(line);
  }

  public static double readDouble(String prompt) {
    String line;

    while (true) {
      try {
        System.out.print(prompt);
        line = scanner.nextLine().trim();

        if (!line.matches("-?\\d+")) {
          throw new IllegalArgumentException("The number must be Float. Try Again!");
        }

        if (Integer.parseInt(line) < 0) {
          throw new IllegalArgumentException("The number must be greater than >0. Try Again!");
        }

        break;

      } catch (IllegalArgumentException i) {
        System.out.println(i.getMessage());
      }
    }
    return Double.parseDouble(line);
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
}
