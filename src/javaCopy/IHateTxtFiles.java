package javaCopy;

import java.io.File;
class IHateTxtFiles {
 public static void main(String args[]) {
  File folder = new File("C://Src//");
  for (File file : folder.listFiles()) {
   if (file.getName().endsWith("_Test.cls")) {
    file.delete();
   }
  }
 }
}