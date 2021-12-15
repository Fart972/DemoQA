package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHelper extends HelperBase{
    public AlertHelper(WebDriver wd) {
        super(wd);
    }
    public void selectItemAlert() {
        click(By.xpath("//div/h5[.='Alerts, Frame & Windows']"));

    }

    public void selectAlerts() {
        click(By.xpath("//span[text()='Alerts']"));
    }

    public void clickAlertButton1() {
        click(By.xpath("//button[@id='alertButton']"));
    }

    public void acceptAlert() {
        wd.switchTo().alert().accept();
    }

    public void clickAlertButton3() {
        click(By.id("confirmButton"));

    }

    public void clickOnCancelButton(String text) {
        if (text != null && text.equals("Cancel")) {
            wd.switchTo().alert().dismiss();
        } else if (text!=null && text.equals("Ok")){
            wd.switchTo().alert().accept();
        }

    }

    public String getConfirmResult() {
        return wd.findElement(By.id("confirmResult")).getText();
    }

    public void clickAlertButton4() {

        click(By.xpath("//*[@class='col']//button[last()]"));
    }

    public void sendTextToAlert(String text) {
        if(text!=null)
            wd.switchTo().alert().sendKeys(text);
        System.out.println(wd.switchTo().alert().getText());
        wd.switchTo().alert().accept();
    }



    public String getConfirmResultLast() {
        return wd.findElement(By.xpath("//span[@id='promptResult']")).getText();
    }

    public void clickAlertButton2() {

        click(By.id("timerAlertButton"));
        WebDriverWait wait = new WebDriverWait(wd,10);
        Alert myAlert= wait.until(ExpectedConditions.alertIsPresent());
        myAlert.accept();

    }

}
