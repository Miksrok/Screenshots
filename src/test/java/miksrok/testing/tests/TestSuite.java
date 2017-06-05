package miksrok.testing.tests;

import miksrok.testing.BaseScript;
import org.testng.annotations.Test;

/**
 * Created by Залізний Мозок on 01.06.2017.
 */
 public class TestSuite extends BaseScript {



      @Test
      public void test(){
         mainPage.createImage();
         mainPage.makeScreenShot("myScreen");
      }

}
