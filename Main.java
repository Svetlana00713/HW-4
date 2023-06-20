import java.util.*;

public class Main {
    static Scanner scaner = new Scanner(System.in);
    public static ArrayList<String> surname = new ArrayList<>();
    public static ArrayList<String> name = new ArrayList<>();
    public static ArrayList<String> patronymic = new ArrayList<>();
    public static ArrayList<Integer> age = new ArrayList<>();
    public static ArrayList<String> gender = new ArrayList<>();
    public static ArrayList<Integer> key = new ArrayList<>();

    public static void main(String[] args) {
        input_data();
        print_data(key);

        System.out.println("Выберите действие: q - выход, a - сортировка по возрасту, g - сортировка по возрасту и полу.");
        String data = scaner.nextLine();
        if (data.equals("q")) { 
            System.exit(0); 
        } else if (data.equals("a")) { 
            System.out.println("Сортировка по возрасту:");
            System.out.println("__________________");
            print_data(sortdata_age());
        } else if (data.equals("g")) { 
            System.out.println("Сортировка по возрасту и полу:");
            System.out.println("__________________");
            print_data(sortdata_age_and_gender());
        } else { 
            System.out.println("Неверный ввод. Повторите попытку.");
        }
    }

    static void input_data() {
        System.out.println("Введите фамилию, имя, отчество, возраст и пол: ");
        int count = 0;
        while (true) {
            String data = scaner.nextLine();
            if (data.equals("q")) return;
            surname.add(data.split(" ")[0]);
            name.add(data.split(" ")[1]);
            patronymic.add(data.split(" ")[2]);
            age.add(Integer.parseInt(data.split(" ")[3]));
            gender.add(data.split(" ")[4]);
            key.add(count);
            count += 1;
        }
    }

    static void print_data(ArrayList<Integer>key ) {
        for (Integer i : key) {
            System.out.println(surname.get(i) + " " + name.get(i).toUpperCase().charAt(0)
                    + "." + patronymic.get(i).toUpperCase().charAt(0) + "." + age.get(i) + " " + gender.get(i));
        }
    }

    static ArrayList<Integer> sortdata_age() {
        ArrayList<Integer> a_key = new ArrayList<>();
        ArrayList<Integer> tmp_a = new ArrayList<>();
        tmp_a.addAll(age);
        for (int i = 0; i < age.size(); i++) {
            a_key.add(age.indexOf(Collections.min(tmp_a)));
            tmp_a.remove(tmp_a
                    .indexOf(Collections
                            .min(tmp_a)));
        }
        return a_key;
    }

    static ArrayList<Integer> sortdata_age_and_gender() {
        ArrayList<Integer> a_key = new ArrayList<>();
        a_key.addAll(sortdata_age());
        int tmp;
        int k = 0;
        ArrayList<Integer>ag_key = new ArrayList<>();
        ag_key.addAll(a_key);
        for (int i = 0; i < key.size(); i++) {
            if (gender.get(a_key.get(i)).toLowerCase().equals("f")) {
                tmp = ag_key.get(k);
                ag_key.remove(k);
                ag_key.add(tmp);
            } else k += 1;
        }
        return ag_key;
    }
}