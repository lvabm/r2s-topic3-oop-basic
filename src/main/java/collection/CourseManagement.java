package collection;

import helper.InputHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseManagement {
  private final ArrayList<Course> courses;

  public CourseManagement() {
    courses = new ArrayList<>();
  }

  public static void main(String[] args) {
    new CourseManagement().runMenu();
  }

  public void addCourse() {
    new Course().input(courses);
  }

  public void searchCourses() {
    if (courses.isEmpty()) {
      System.out.println("No courses available to search.");
      return;
    }

    String attribute;
    while (true) {
      System.out.println("\nAvailable attributes for search: code, name, status, duration, flag");
      attribute = InputHelper.readString("Enter attribute name to search by: ").toLowerCase();
      if (attribute.matches("code|name|status|duration|flag")) {
        break;
      }
      System.out.println("Invalid attribute name. Try again.");
    }

    String searchValue = InputHelper.readString("Enter search data for " + attribute + ": ");

    String finalAttribute = attribute;
    List<Course> result =
        courses.stream()
            .filter(
                c -> {
                  switch (finalAttribute) {
                    case "code":
                      return c.getCode().equalsIgnoreCase(searchValue);
                    case "name":
                      return c.getName().toLowerCase().contains(searchValue.toLowerCase());
                    case "status":
                      boolean statusValue =
                          searchValue.equalsIgnoreCase("active") || searchValue.equals("1");
                      return c.isStatus() == statusValue;
                    case "duration":
                      try {
                        int durationValue = Integer.parseInt(searchValue);
                        return c.getDuration() == durationValue;
                      } catch (NumberFormatException e) {
                        return false;
                      }
                    case "flag":
                      return c.getFlag().equalsIgnoreCase(searchValue);
                    default:
                      return false;
                  }
                })
            .collect(Collectors.toList());

    if (result.isEmpty()) {
      System.out.println("No courses found matching the search criteria.");
    } else {
      System.out.println("\n--- Search Results ---");
      result.forEach(System.out::println);
      System.out.println("----------------------\n");
    }
  }

  public void displayCoursesByFlag() {
    if (courses.isEmpty()) {
      System.out.println("No courses available to display.");
      return;
    }

    String flagInput;
    while (true) {
      System.out.println("\nAvailable Flags: OPTIONAL, PREREQUISITE, N/A");
      flagInput = InputHelper.readString("Enter flag to display courses: ").toUpperCase();
      if (Validator.validateFlag(flagInput)) {
        break;
      }
      System.out.println("Invalid flag value. Please choose OPTIONAL, PREREQUISITE, or N/A.");
    }

    String finalFlagInput = flagInput;
    List<Course> result =
        courses.stream()
            .filter(c -> c.getFlag().equalsIgnoreCase(finalFlagInput))
            .collect(Collectors.toList());

    if (result.isEmpty()) {
      System.out.println("No courses found with flag '" + flagInput + "'.");
    } else {
      System.out.println("\n--- Courses with Flag: " + flagInput + " ---");
      result.forEach(System.out::println);
      System.out.println("----------------------------------------\n");
    }
  }

  public void runMenu() {
    boolean isRunning = true;
    while (isRunning) {
      System.out.println("\n************************************************************");
      System.out.println("1. Create a new course");
      System.out.println("2. Search courses by attribute");
      System.out.println("3. Display all courses base on flag");
      System.out.println("4. Quit");
      System.out.println("************************************************************");

      String choice = InputHelper.readString("Select function (1-4): ");

      switch (choice) {
        case "1" -> addCourse();
        case "2" -> searchCourses();
        case "3" -> displayCoursesByFlag();
        case "4" -> {
          System.out.println("Exiting application...");
          isRunning = false;
        }
        default -> System.out.println("Invalid selection. Please choose 1, 2, 3, or 4.");
      }
    }
  }
}
