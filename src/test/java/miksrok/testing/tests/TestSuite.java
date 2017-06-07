package miksrok.testing.tests;

import miksrok.testing.BaseScript;
import miksrok.testing.util.DataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

 public class TestSuite extends BaseScript {

    int i =1;
    int j =1;

    @Test(dataProvider = "getData", dataProviderClass = DataProvider.class, priority = 1)
    public void onlyScreensTest(String url){
        mainPage.openMainPage(url);
        mainPage.resizeWindow();
        mainPage.makeScreenShot("uno"+i);
        i++;
    }

      @Test(dataProvider = "getData", dataProviderClass = DataProvider.class, priority = 2)
      public void screensAndDateTest(String url){

         mainPage.openMainPage(url);
         mainPage.enterDate();
         mainPage.makeScreenShot("uno2"+j);
         j++;

      }

      @Test(dataProvider = "getTestNumber", dataProviderClass = DataProvider.class, priority = 3)
        public void compareTest(String number){

             Assert.assertFalse(mainPage.compareImg("uno"+number, "uno2"+number));
             mainPage.report(number, "uno"+number, "uno2"+number);

      }

}
