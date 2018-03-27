import java.io.IOException;


public class Code {
    public static void main(String[] args) throws IOException {
        // String[] testData = { "0975156900", "(097)5156900", "(097)515-69-00", "(097)51-56-900", "+380975156900",
        //         "+38 097 515 69 00" };

        test1_isPhone();
        test2_isPhone();
    }

    public static boolean isPhone(String text) {
        String regex = "(?:\\+38)? ?(?:0\\d{2}|\\(0\\d{2}\\)) ?\\d{2}(?:\\d{3}|\\d[- ]\\d{2}[- ]|[ -]\\d{2}[ -]\\d)\\d{2}";
        return text.matches(regex);
    }

    public static void test1_isPhone() {
        String testData = "0975156900";

        boolean result = isPhone(testData);

        if (result == true) {
            System.out.println("Test1 passed");
        } else {
            System.out.println("Test1 failed");
        }
    }

    public static void test2_isPhone() {
        String testData = "asdaddasds";

        boolean result = isPhone(testData);

        if (result == false) {
            System.out.println("Test2 passed");
        } else {
            System.out.println("Test2 failed");
        }
    }
}
