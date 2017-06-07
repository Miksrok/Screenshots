package miksrok.testing.pages;

import miksrok.testing.util.CustomReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;
    int h;
    int w;





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
    public void enterDate(){
        List<WebElement> e = driver.findElements(By.xpath("//div[@class='js-calendar-show js-calendar-text calendar_field']"));
        e.get(0).click();
        WebElement w = driver.findElement(By.xpath("//a[@data-handler='next']"));
        w.click();
        WebElement q = driver.findElement(By.xpath("//tbody/tr[2]/td[5]"));
        q.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[3]/td[6]")));
        WebElement q2 = driver.findElement(By.xpath("//tbody/tr[3]/td[6]"));
        q2.click();
    }

    public void resizeWindow(){
        w = driver.manage().window().getSize().getWidth();
        h = driver.manage().window().getSize().getHeight();
        driver.manage().window().setSize(new Dimension( w, h*15));
    }

    public boolean compareImg(String f, String s){
        boolean test = true;
        try {
            BufferedImage img1 = ImageIO.read(new File("target\\surefire-reports\\screens\\"+f+".png"));
            BufferedImage img2 = ImageIO.read(new File("target\\surefire-reports\\screens\\"+s+".png"));
            int x = img1.getWidth();
            int y = img1.getHeight();

            for (int xx = 0; xx<x; xx++){
                for (int yy=0; yy<y; yy++){
                    if(img1.getRGB(xx,yy) != img2.getRGB(xx,yy)){
                        img1.setRGB(xx,yy,-13810036);
                        test = false;
                    }
                }
            }
            ImageIO.write(img1,
                    "png",
                    new File("target\\surefire-reports\\screens\\"+f+s+".png"));
        } catch (IOException e1) {
            e1.printStackTrace();

        }

        return test;
    }

    public void report(String testNumber, String firstScreen, String secondScreen ){
        CustomReporter.log("<p>Test number "+testNumber+"</p>");
        CustomReporter.log("<br><img src='screens/"+firstScreen+".png' width='388' height='216' />");
        CustomReporter.log("<img src='screens/"+secondScreen+".png' width='388' height='216' />");
        CustomReporter.log("<p>Differents</p>");
        CustomReporter.log("<br><img src='screens/"+firstScreen+secondScreen+".png' width='388' height='216' />");
        CustomReporter.log("<br>");
    }

    public void makeScreenShot(String name) {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("target\\surefire-reports\\screens\\"+name+".png"));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
