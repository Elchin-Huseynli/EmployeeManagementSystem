package util;

import java.util.Scanner;

public class InputUtil {
    public static String InputTypeString(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextLine();
    }

    public static long InputTypeLong(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextLong();
    }

    public static int InputTypeInt(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextInt();
    }

}
