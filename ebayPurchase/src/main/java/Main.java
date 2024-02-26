
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Main {
    //To access driver in other classes
    public static WebDriver driver;


    @BeforeTest
    @Parameters({"url"})
        public void begin(@Optional("https://www.ebay.com/") String url){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        //1. Launch a Chrome Browser
         driver = new ChromeDriver();
        //To open the webpage(Below web page will be loaded)
        //2. Navigate to URL https://www.ebay.com/
        driver.navigate().to(url);

        //To Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    @Parameters({"url"})
            public void test1(String url){
        //Getting the actual page URL, and storing that into String variable actualUrl
        String actualUrl = driver.getCurrentUrl();

        //3. Get the page URL and verify the correct page that is opened
        if(actualUrl.equals(url)){
            System.out.println("Verification is Successful, The correct url is opened");
        }else{
            System.out.println("Verification failed, An incorrect url is opened ");

            System.out.println("The actual url is "+actualUrl);
            System.out.println("Expected url is "+url);
        }
    }

    @Test(priority = 2)
    public void test2(){
        //4. Select “Cell Phones & Accessories” from main drop-down box (All categories drop down)
        Select select1 = new Select(driver.findElement(By.xpath("//*[@id=\"gh-cat\"]")));
        select1.selectByVisibleText("Cell Phones & Accessories");
    }

    @Test(priority = 3)
    public void test3(){
        //5. Type “Mobile phone” on search bar
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("Mobile phone");
    }

    @Test(priority = 4)
    public void test4(){
        //6. Click on Search button icon [ Right hand side]
        driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
    }

    @Test(priority = 5)
    public void test5(){
        //7. Select brand as “Apple” from side panel[checkbox]
        driver.findElement(By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[1]/div/a/div/span/input")).click();
    }

    @Test(priority = 6)
    public void test6(){
        //8. Select the first search item.
        driver.findElement(By.xpath("//*[@id=\"item4df268cc70\"]/div/div[2]/a/div/span")).click();
    }

    @Test(priority = 7)
    public void test7(){
        //9. Navigate to a new window.
        driver.navigate().to("https://www.ebay.com/itm/334779436144?epid=5041723784&hash=item4df268cc70:g:uoMAAOSwUu9kNvv7&amdata=enc%3AAQAIAAAA4Od61LqZ%2B%2B%2F%2FDVviXaBLM1o9hZDjygoAXHPq11go8d2gbyRNfGF%2B64oMGOdvvmHda9xjvPzBvbfwpnLaie6Z%2B5MtkFWffG49%2Fe8%2BDYd2fgQcaLfg0HMh9wu5w93yydSk1DVfCevVFaORMEY6dBLY93lU9TcGIrlAwlBTiC%2BtvfSfCFmCTBHPvDHkWKPdb4Eqxt3vwFMrFjGqpIOox5ojZLyiL%2F6qWT3k60%2FCVVU9rBvb63ltx3lW0xX1nG8sNLaCwWx%2FWywOLEJT3hde8ljOzQBekeFbiEAqlug5InqpQGPI%7Ctkp%3ABFBM_o796ZJi");
    }

    @Test(priority = 8)
    public void test8(){
        //We have to give below command, when switching a new tab window in our internet browser
        for (String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }




}

