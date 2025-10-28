package exception_handling.demo;

import java.io.File;

public class demo3 {
  public static void main(String[] args) {
    new demo3().testFile();
  }

  private void testFile() {
    File file = new File("levanan.txt");
  }
}
