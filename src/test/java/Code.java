import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class Code {
//    public static void main(String[] args) throws IOException {
//        // String[] testData = { "0975156900", "(097)5156900", "(097)515-69-00", "(097)51-56-900", "+380975156900",
//        //         "+38 097 515 69 00" };
//
//        test1_isPhone();
//        test2_isPhone();
//    }

    public static boolean isPhone(String text) {
        String regex = "(?:\\+38)? ?(?:0\\d{2}|\\(0\\d{2}\\)) ?\\d{2}(?:\\d{3}|\\d[- ]\\d{2}[- ]|[ -]\\d{2}[ -]\\d)\\d{2}";
        return text.matches(regex);
    }


    // Positive test-cases
    @Test
    public static void test1_isPhone() {
        String testData = "0975156900";
        boolean result = isPhone(testData);
        Assert.assertTrue(result, "Test 1");
    }


    @Test
    public static void test2_isPhone() {
        String testData = "+380975156900";
        boolean result = isPhone(testData);
        Assert.assertTrue(result);
    }

    @Test
    public static void test3_isPhone() {
        String testData = "(097)5156900";
        boolean result = isPhone(testData);
        Assert.assertTrue(result);
    }

    @Test
    public static void test4_isPhone() {
        String testData = "(097)515-69-00";
        boolean result = isPhone(testData);
        Assert.assertTrue(result);
    }

    @Test
    public static void test5_isPhone() {
        String testData = "(097)51-56-900";
        boolean result = isPhone(testData);
        Assert.assertTrue(result);
    }

    @Test
    public static void test6_isPhone() {
        String testData = "+38 097 515 69 00";
        boolean result = isPhone(testData);
        Assert.assertTrue(result);
    }


    // Negative test-cases
    @Test
    public static void test7_isPhone() {
        String testData = "097515690";
        boolean result = isPhone(testData);
        Assert.assertFalse(result);
    }

    @Test
    public static void test8_isPhone() {
        String testData = "asdaddasds";
        boolean result = isPhone(testData);
        Assert.assertFalse(result);
    }

    @Test
    public static void test9_isPhone() {
        String testData = "09751569000";
        boolean result = isPhone(testData);
        Assert.assertFalse(result);
    }


    @Test
    public static void test10_isPhone() {
        String testData = "80975156900";
        boolean result = isPhone(testData);
        Assert.assertFalse(result);
    }

    @Test
    public static void test11_isPhone() {
        String testData = "380975156900";
        boolean result = isPhone(testData);
        Assert.assertFalse(result);
    }

    @Test
    public static void test12_isPhone() {
        String testData = "8975156900";
        boolean result = isPhone(testData);
        Assert.assertFalse(result);
    }

}