package collection;

import helper.InputHelper;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringJoiner;

public class Course {
  private String code = "RA000";
  private String name;
  private boolean status;
  private short duration;
  private String flag;

  public Course() {}

  public Course(String code, String name, boolean status, short duration, String flag) {
    setCode(code);
    setName(name);
    setStatus(status);
    setDuration(duration);
    setFlag(flag);
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public short getDuration() {
    return duration;
  }

  public void setDuration(short duration) {
    this.duration = duration;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  @Override
  public String toString() {
    return new StringJoiner(" | ", "{", "}")
        .add("Code: " + code)
        .add("Name: " + name)
        .add("Status: " + (status ? "Active" : "In-active"))
        .add("Duration: " + duration + " hours")
        .add("Flag: " + flag)
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Course course = (Course) o;
    return Objects.equals(code, course.code);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(code);
  }

  public void input(ArrayList<Course> courses) {
    String code;
    String name;
    boolean status;
    short duration;
    String flag;

    while (true) {
      code = InputHelper.readString("Enter Course Code (RAxxx): ");
      if (!Validator.validateCode(code)) {
        System.out.println("Invalid code format. Must be 'RA' followed by 3 digits.");
        continue;
      }
      if (Validator.isDuplicatedCode(code, courses)) {
        System.out.println("Code is duplicated. Please enter a unique code.");
        continue;
      }
      break;
    }

    name = InputHelper.readString("Enter Course Name: ");

    status = InputHelper.readBoolean("Enter Course Status: ");

    duration = (short) InputHelper.readInt("Enter Course Duration (hours, >0): ");

    while (true) {
      System.out.println("Available Flags: OPTIONAL, PREREQUISITE, N/A");
      flag = InputHelper.readString("Enter Course Flag: ").toUpperCase();
      if (!Validator.validateFlag(flag)) {
        System.out.println("Invalid flag value. Please choose OPTIONAL, PREREQUISITE, or N/A.");
      } else {
        break;
      }
    }

    courses.add(new Course(code, name, status, duration, flag));
    System.out.println("Course added successfully.");
  }
}
