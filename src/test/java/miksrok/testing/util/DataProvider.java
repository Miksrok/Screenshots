package miksrok.testing.util;

/**
 * Created by Залізний Мозок on 04.06.2017.
 */
public class DataProvider {

    @org.testng.annotations.DataProvider(name = "getData")
    public static Object[][] getData() {
        return new Object[][]{
                {"de"},
                {"en"},
                {"ru"}
        };

    }
}
