// Ini adalah program kuis pengurangan
import java.util.Scanner;
public class A_SubstractionQuiz {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    long startTime = System.currentTimeMillis();
    int benar = 0;
    String eval = "";
    String check, numWrong = "";
    final int count = 5;
    
    System.out.println("This is a substraction quiz, make sure you answer correctly.");
    System.out.println("The quiz will consist of **" + count + " short-answer questions**. Do your best!");

    int i = 0;
    while(i < count) {
      int a = (int)(Math.random() * 100);
      int b = (int)(Math.random() * 100);
      
      // Algoritma agar bilangan terbesar selalu yang dikurangi
      if(b > a) {
        int temp = a; //Variabel ini digunakan sebagai inisiasi bilangan terbesar di antara a dan b
        a = b;
        b = temp;
      }
      int c = a - b;
      System.out.print((i+1) + ") " + a + " - " + b + " = ");
      int jawaban = input.nextInt();
      
      if(jawaban == c) {
        benar++;
      }
      i++;

      check = (jawaban == c) ? "[ CORRECT ]" : "[INCORRECT] <--";
      eval += String.format("\n%-20s%s", i + ") " + a + " - " + b + " = " + jawaban, check);
      // Algoritma untuk mendaftar semua jawaban yang salah
      if(check == "[INCORRECT] <--") {
        numWrong += String.format("%-2d", i);
      }
    }
    input.close();

    System.out.printf("[%S%d][%S%d][%S%.2f]\n","correct: ", benar, "wrong: ", (count - benar), "score: ", (100.0 * benar/count));

    long endTime = System.currentTimeMillis();
    int timeSpent = (int)(endTime - startTime)/1000;
    System.out.printf("%s\n%s %d %s %d %s\n%s\n","------------------------------------------------", "You completed the quiz in", timeSpent/60, "minutes", (timeSpent % 60), "seconds!", "------------------------------------------------");
    
    System.out.printf("%S:","evaluation");
    System.out.println(eval);
    System.out.printf("%s %s", "Where you got it wrong:", numWrong);
  }
}