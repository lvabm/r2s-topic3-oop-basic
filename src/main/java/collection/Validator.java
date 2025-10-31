package collection;

import java.util.ArrayList;

public class Validator {
  public static boolean validateCode(String code) {
    return code.matches("^RA\\d{3}$");
  }

  public static boolean isDuplicatedCode(String code, ArrayList<Course> courses) {
    return courses.stream().anyMatch(c -> c.getCode().equalsIgnoreCase(code));
  }

  public static boolean validateFlag(String flag) {
    String upperFlag = flag.toUpperCase();
    return upperFlag.equals("OPTIONAL")
        || upperFlag.equals("PREREQUISITE")
        || upperFlag.equals("N/A");
  }

  public static boolean validateDuration(short duration) {
    return duration > 0;
  }
}
