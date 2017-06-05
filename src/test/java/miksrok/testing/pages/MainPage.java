package miksrok.testing.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Залізний Мозок on 01.06.2017.
 */
public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;
    int h;
    int w;
    BufferedImage image;




    public MainPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void openMainPage(String name) {
        driver.get(name);
    }


    /*public void scrollDown(int height){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,"+height+")", "");
    }*/
    public void createImage(){


        w = driver.manage().window().getSize().getWidth();
        h = driver.manage().window().getSize().getHeight();
        driver.manage().window().setSize(new Dimension(w, h*15));

    }




//=============================================================================
    public void makeScreenShot(String name) {


        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            // now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(src, new File("D://reports/"+ name + System.currentTimeMillis() + ".png"));

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
