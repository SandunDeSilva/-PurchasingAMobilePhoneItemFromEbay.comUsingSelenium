import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

//Extends because we want to access the driver instance in this class too
public class chromeNewTab extends Main{

    @Test(priority = 9)
    public void test9(){
        //10. Select Storage, Color etc. from drop-downs if available.
        //Hint: use try catch when check the element availability

        //Select color to blue
        try {

            Select select2 = new Select(driver.findElement(By.xpath("//*[@id=\"x-msku__select-box-1000\"]")));
            select2.selectByValue("1");

        }catch(Exception e){
            System.out.println(e);
        }

        //Select storage to 64GB
        try{

            Select select3 = new Select(driver.findElement(By.xpath("//*[@id=\"x-msku__select-box-1001\"]")));
            select3.selectByValue("6");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Test(priority = 10)
    public void test10(){
        //11. Get item Name and print in console
        // we have to use the .getText() command to get the name of the item and store it to a String variable
        //We have to put cssSelector to execute below program, not working when used the xpath
        String itemName = driver.findElement(By.cssSelector("#LeftSummaryPanel > div.vi-swc-lsp > div:nth-child(1) > div > h1 > span")).getText();
        System.out.println("Item name is "+itemName);
    }

    @Test(priority = 11)
    public void test11(){
        //12. Get item Price and print in console
        // we have to use the .getText() command to get the name of the item and store it to a String variable
        String itemPrice = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[1]/div/div[2]/div[1]/span[1]/span")).getText();
        System.out.println("The Item Price is "+itemPrice);
    }

    @Test(priority = 12)
    public void test12(){
        //13. Get condition and print in console
        // we have to use the .getText() command to get the name of the item and store it to a String variable
        String itemCondition = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[1]/div[1]/div/div[2]/div[1]/div/span/span[1]/span")).getText();
        System.out.println("Item Condition is "+itemCondition);
    }

    @Test(priority = 13)
    public void test13(){
        //14. Get quantity and print in console
        // // we have to use the .getText() command to get the name of the item and store it to a String variable
        String itemQuantity = driver.findElement(By.id("qtyTextBox")).getAttribute("value");
        System.out.println("Item Quantity is "+itemQuantity);
    }

    @Test(priority = 14)
    public void test14(){
        //15.  Select “Add to cart”
       driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[2]/ul/li[2]/div/a")).click();
    }



}
