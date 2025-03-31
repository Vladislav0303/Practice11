import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        System.out.println("~Оберіть пункт~");
        System.out.println("~1.Створити файл, та записати щось");
        System.out.println("~2.Прочитати вміст файлу~");
        System.out.println("~3.Вийти~");
        System.out.println("Оберіть функцію(1-3): ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc = new Scanner(System.in);
        System.out.println("Введіть назву файла: ");
        String file = sc.nextLine();
        while (true) {
        try {
            if(a == 1) {
                writer(file);
            } else if(a == 2) {
                reader(file);
            } else if(a == 3) {
                break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Введіть цифру будь ласка");
        }
    }
    }
    public static void writer(String file) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            Scanner sc = new Scanner(System.in);
            System.out.println("Введіть що хочете записати в файл: ");
            String text = sc.nextLine();

            fw.write(text);
            fw.close();
            System.out.println("Записано");
            menu();
        } catch (FileNotFoundException e)  {
            System.out.println("Помилка, файл не найдено");
    } catch (IOException e) {
            System.out.println("Помилка");
        }
}
    public static void reader(String file) {
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            String s = "";

            while (fr.ready()) {
            s += (char) fr.read();
            }

            System.out.println(s);
            menu();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено");
        } catch (IOException e) {
            System.out.println("Помилка");
        } finally {
            try {
                if(fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("Помилка");
            }
        }
    }
}