/*Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
NoteBook notebook1 = new NoteBook
NoteBook notebook2 = new NoteBook
NoteBook notebook3 = new NoteBook
NoteBook notebook4 = new NoteBook
NoteBook notebook5 = new NoteBook

Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет

Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.

Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

Класс сделать в отдельном файле */

//Строковые параметры (для поиска) написаны на английском, тюкю существует проблема с кириллицей в VS Code

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class HomeWork6 {
    public static void main(String[] args) {
        Notebook nb1 = new Notebook("Asus", "VivoBook 15 OLED K513EA", 16, "SSD", 512, "Windows 11", "gray");
        Notebook nb2 = new Notebook("Acer", "Extensa 15 EX215-22-R8E3", 4, "SSD",256, "Windows 10", "black");
        Notebook nb3 = new Notebook("HP", "Victus 16-e", 32, "HDD", 2000, "Windows 11", "blue");
        Notebook nb4 = new Notebook("MSI", "Modern 15 B11-002RU", 8, "HDD", 256, "Windows 11", "black");
        Notebook nb5 = new Notebook("Asus", "VivoBook Pro 14 K3400PA-KP109", 16, "SSD",512, "Windows 10", "silver");
        Notebook nb6 = new Notebook("MSI", "GF63 Thin 11UD", 64, "SSD", 512, "No OS", "black");
        Notebook nb7 = new Notebook("Huawei", "MateBook D 15", 8, "SSD", 256, "DOS", "gray");
        Notebook nb8 = new Notebook("Asus", "TUF Gaming F15 FX506HCB", 8, "SSD", 512, "Windows 10", "black");
        Notebook nb9 = new Notebook("Lenovo", "Legion 5 15", 16, "HDD", 2000, "No OS", "black");
        Notebook nb10 = new Notebook("Apple", "MacBook Air 13 2022", 8, "HDD", 256, "macOS", "silver");

        HashSet<Notebook> notebooks = new HashSet<Notebook>(
                Arrays.asList(nb1, nb2, nb3, nb4, nb5, nb6, nb7, nb8, nb9, nb10));

        Scanner sc = new Scanner(System.in, "cp866");

        System.out.println();
        System.out.println("Здравствуйте!'\n" +
                "В этом каталоге вы можете подобрать себе подходящий ноутбук\n");
        boolean filter = true;
        while (filter) {
            System.out.println("Выбрать по ОЗУ, введите - 1\n" +
                    "Выбрать по объему жесткого диска, введите - 2\n" +
                    "Выбрать по оперативной системе, введите - 3\n" +
                    "Выбрать по типу жесткого диска, введите - 4\n" +
                    "Выбрать по цвету, введите - 5\n" +
                    "Посмотреть все модели, введите - 6\n" +
                    "Для выхода из каталога, введите - 0");
       
            String operation = sc.nextLine();
            switch (operation) {
                case "1":
                    filterRAM(notebooks, sc);
                    break;
                case "2":
                    FilterHardDisk(notebooks, sc);
                    break;
                case "3":
                    filterOS(notebooks, sc);
                    break;
                case "4":
                    filterType(notebooks, sc);
                    break;
                case "5":
                    filterColor(notebooks, sc);
                    break;
                case "6":
                    ShowAllNB(notebooks);
                    break;
                case "0":
                    System.out.println("До свидания! Ждем вашего посещения много раз!");
                    filter = false;
                    break;
                default:
                    System.out.println("Введен неправильный номер операции");
                    System.out.println();
                    break;
            }
        }

    }
    // Функция фильтра 
    public static void filterRAM(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<Integer> ram = new TreeSet<>();
        for (Notebook note : notebooks) {
            ram.add(note.getRam());
        }
        System.out.println();
        System.out.println("В нашем каталоге представлены ноутбуки с оперативной памятью "
                + ram.toString().replaceAll("^\\[|\\]$", "") + " Гб\n" +
                "Введите интересующее значение: ");

        String oper = scanner.nextLine();
        int filter = Integer.parseInt(oper);
        if (ram.contains(filter)) {
            System.out.println();
            System.out.println("Отобрала подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getRam() == filter) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Неправильное значение. Попробуйте снова");
            filterRAM(notebooks, scanner);
        }

    }
       // Функция фильтра 
       public static void filterType(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<String> typehardDisk = new TreeSet<>();
        for (Notebook note : notebooks) {
            typehardDisk.add(note.getTypeHardDisk());
        }
        System.out.println();
        System.out.println("В нашем каталоге представлены такие типы жестких дисков: "
                + typehardDisk.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующий тип жесткого диска: ");

        String oper = scanner.nextLine().toUpperCase();
        if (typehardDisk.contains(oper)) {
            System.out.println();
            System.out.println("Отобрала подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getTypeHardDisk().equals(oper)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет такого типа жесткого диска. Попробуйте снова");
            filterType(notebooks, scanner);

        }
    }
    // Функция фильтра 
    public static void FilterHardDisk(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<Integer> hardDisk = new TreeSet<>();
        for (Notebook note : notebooks) {
            hardDisk.add(note.getHardDisk());
        }
        System.out.println();
        System.out.println("В нашем каталоге представлены ноутбуки с объемом жесткого диска "
                + hardDisk.toString().replaceAll("^\\[|\\]$", "") + " Гб\n" +
                "Введите интересующее значение: ");

        String oper = scanner.nextLine();
        int filter = Integer.parseInt(oper);
        if (hardDisk.contains(filter)) {
            System.out.println();
            System.out.println("Отобрала подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getHardDisk() == filter) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Неправильное значение. Попробуйте снова");
            FilterHardDisk(notebooks, scanner);
        }
    }
    // Функция фильтра
    public static void filterOS(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<String> operSystems = new TreeSet<>();
        for (Notebook note : notebooks) {
            operSystems.add(note.getOperSystem());
        }
        System.out.println();
        System.out.println("В нашем каталоге представлены операционные системы: "
                + operSystems.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующую ОС: ");

        String oper = scanner.nextLine().toUpperCase();
        if (operSystems.contains(oper)) {
            System.out.println();
            System.out.println("Отобрала подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getOperSystem().equals(oper)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет такой ОС. Попробуйте снова");
            filterOS(notebooks, scanner);

        }
    }
    // Функция фильтра
    public static void filterColor(HashSet<Notebook> notebooks, Scanner scanner){
        TreeSet<String> colors = new TreeSet<>();
        for (Notebook note: notebooks){
            colors.add(note.getColor());
        }
        System.out.println();
        System.out.println("В нашем каталоге представлены ноутбуки следующих цветов: "
                + colors.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующий цвет: ");
      
        String oper = scanner.nextLine().toLowerCase();
        if (colors.contains(oper)) {
            System.out.println();
            System.out.println("Отобрала подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getColor().equals(oper)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет такого цвета. Попробуйте снова");
            filterColor(notebooks, scanner);
        }
    }
    // Функция вывода полного каталога
    public static void ShowAllNB(HashSet<Notebook> notebooks){
        System.out.println();
        System.out.println("Полный каталог ноутбуков: ");
        System.out.println();
        for (Notebook note : notebooks) {
                note.showInfo();
        }
    }
}
