// Program quiz penjumlahan. User memasukkan jawaban hingga jawabannya benar
import java.util.Scanner;
public class A5_AdditionQuiz {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    

    System.out.printf("[%s]\n","Jawab \"-1\" untuk keluar");
    System.out.print("Banyak soal: ");
    int count = input.nextInt(); // Ini count untuk menentukan banyak soal awal
    int countA = count; // Ini count yang digunakan ketika user meminta keluar
    int salah = 0;
    // Toggle untuk menghentikan loop ketika user ingin keluar
    boolean isActive = true;
    // Loop
    int i = 0;
    while(i < countA && isActive) {
      int a = (int)(100 * Math.random());
      int b = (int)(100 * Math.random());
      int c = a + b;

      System.out.printf("%d. %d + %d = ", (i + 1), a, b);
      int jawaban = input.nextInt();
      // Jika user memberikan jawaban yang salah
      if(jawaban != c && jawaban != -1) {
        salah++;
        System.out.printf("\t[%S]\n","salah");
      }
      // Jika user menghentikan kuis
      if(jawaban == -1) {
        isActive = false;
        countA = i;
        System.out.println("Quiz dihentikan di nomor " + (i + 1));
      }
      i++;
      if(i == count && isActive == true) {
        System.out.println("Quiz selesai");
      }
    }
    int benar = countA - salah;
    int kosong = count - countA;
    // Banyak benar, salah, kosong
    System.out.printf("[%S%c %d][%S%c %d][%S%c %d]\n","benar", ':', benar, "salah", ':', salah, "Kosong", ':', kosong);
    // Nilai
    double nilai = 100 * (double)benar/count;
    System.out.printf("%s %.2f", "Nilai Anda adalah", nilai);
    
    input.close();
  }
}
