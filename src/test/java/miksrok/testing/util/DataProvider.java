package miksrok.testing.util;

/**
 * Created by Залізний Мозок on 04.06.2017.
 */
public class DataProvider {

    @org.testng.annotations.DataProvider(name = "getData")
    public static Object[][] getData() {
        return new Object[][]{
                {"http://www.parishotelsweb.com/ru/"},
                {"http://www.parishotelsweb.com/search/?sort=Rating&amp;order=DESC&amp;part=1&amp;Name="},
                {"http://bridgestreet-st-germain-hotel.parishotelsweb.com/ru/"}
        };

    }
    @org.testng.annotations.DataProvider(name = "getTestNumber")
    public static Object[][] getTestNumber() {
        return new Object[][]{
                {"1"},
                {"2"},
                {"3"}
        };

    }
}
