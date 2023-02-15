package util;
import static util.InputUtil.*;
public class MenuUtil {
    public static int entryApp() {
        System.out.println("\n-----| Employee Management Service |-----\n" +
                "\n[0] Exit System" +
                "\n[1] Register" +
                "\n[2] ShowEmployee" +
                "\n[3] Update" +
                "\n[4] Delete" +
                "\n[5] Find by Name" +
                "\n[6] Total Employee");

        return InputTypeInt("\nEnter the option: ");
    }
}
