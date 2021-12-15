package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest extends TestBase{


    @BeforeMethod
    public void preconditions() {
        app.alert().selectItemAlert();
        app.alert().selectAlerts();
    }

    @Test
    public void alertTest(){

        app.alert().clickAlertButton1();
        app.alert().pause(2000);
        app.alert().acceptAlert();


    }
    @Test
    public void alertTestWait(){

        app.alert().clickAlertButton2();




    }
    @Test
    public void cancelAlertTest(){

        app.alert().clickAlertButton3();
        app.alert().pause(2000);
        app.alert().clickOnCancelButton("Cancel");
        Assert.assertTrue(app.alert().getConfirmResult().contains("Cancel"));

    }

    @Test
    public void oKlAlertTest(){

        app.alert().clickAlertButton3();
        app.alert().pause(2000);
        app.alert().clickOnCancelButton("Ok");
        app.alert().pause(2000);
        Assert.assertTrue(app.alert().getConfirmResult().contains("Ok"));

    }

    @Test
    public void AlertSendTextTest(){
        app.alert().clickAlertButton4();
        app.alert().sendTextToAlert("Hello");
        app.alert().pause(2000);
        Assert.assertTrue(app.alert().getConfirmResultLast().contains("Hello"));

    }
}
