import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class Seminar4 {
    static Scanner scanner = new Scanner(System.in);  // System in  - для считывания из файла (не из консоли?)
    // вынесли сюда покольку применяем И в main И в input_data

    // 3. добавлена возможность выхода или вывода списка отсортированного по возрасту. (осн. реализ. sortData_age)
    public static void main(String[] args) {
        ArrayList<String> lst = new ArrayList<>();
        input_data(lst);
        print_data(lst);
        System.out.println("Введите: q - выход, s - сортировка по возрасту");   // реализуем интерф. для польз.
        String data = scanner.nextLine();
//        scanner.useDelimiter(" ");  // делит вх.данные на части по разделителю
        if (data.equals("q")) {      // выход из программы
            System.exit(0);
        }
        sortData_age(lst);
        print_data(lst);
    }

    // 1. ввод и хранение данных пользователей
    static void input_data(ArrayList<String> arr) {
        System.out.println("Введите: Фамилию Имя Отчество возраст пол");
        while (true) {            // ввели цикл для возможности выхода из режима ввода
            String data = scanner.nextLine();
            if (data.equals("q")) return; //остановка метода ввода данных (не добавл.в массив)// поскольку string -> equals (а не ==)
            arr.add(data);       // после ввода q перейдем из режима ввода данн. в main, где реализуем основн. интерфейс
        }
    }

    // 2. Вывод в формате Фамилия И.О. возраст пол
    static void print_data(ArrayList<String> arr){
        for (String i: arr){
            String[] str = i.split(" ");
            System.out.println(str[0]+ " " + str[1].toUpperCase().charAt(0)
                    + "." + str[2].toUpperCase().charAt(0) + ". " + str[3] + " " + str[4]);
        }
    }

    // 3. добавлена возможность выхода или вывода списка отсортированного по возрасту. В main доп. принимаем
    // от пользователя действие Scanner-м
    static  void sortData_age(ArrayList<String> arr){
        arr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1.split(" ")[3]) - Integer.parseInt(o2.split(" ")[3]);
            }
        });
    }

    // 4. требуется добавить сортировку по возрасту с использованием индексов

//    scanner.close();

    // 5. добавить сортировку по возрасту с использованием индексов
}
