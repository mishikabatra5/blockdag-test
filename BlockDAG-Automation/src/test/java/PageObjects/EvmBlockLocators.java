package PageObjects;

import Helper.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EvmBlockLocators extends BaseClass {

    public WebElement BlocksOnSideBar(){
        WebElement BlocksOnSideBar=BaseClass.getDriver()
                .findElement(By.xpath("//ul/li/a/span[contains(text(), 'Blocks')]"));
        return   BlocksOnSideBar;
    }

    public WebElement FirstBlockOnBlockList() {
        WebElement FirstBlockOnBlockList = BaseClass.getDriver()
                .findElement(By.xpath("//div/span[@class='cursor-pointer'][1]"));
        return FirstBlockOnBlockList;
    }

    public WebElement BackButtonOnDetailPage() {
        WebElement BackButtonOnDetailPage = BaseClass.getDriver()
                .findElement(By.xpath("//button[@class='style_button__rI39t']"));
        return BackButtonOnDetailPage;
    }
}