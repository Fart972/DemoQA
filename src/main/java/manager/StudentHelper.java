package manager;

import models.Hobby;
import models.Student;
import models.StudentEnum;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class StudentHelper extends HelperBase{
    public StudentHelper(WebDriver wd) {
        super(wd);
    }

    public void selectItemForms() {
        if(isElementPresent(By.id("close-fixedban"))) {
            click(By.id("close-fixedban"));
        }
        click(By.xpath("//div[@class='category-cards']/div[2]"));
        pause(500);
    }

    public void selectPracticeForm() {
        click(By.xpath("//span[.='Practice Form']"));
    }
    public void uploadPicture() {
        wd.findElement(By.id("uploadPicture")).sendKeys("/Users/tayahatum/Qa30/Qa30_DemoQa/boy.jpeg");
    }
    public void submit() {
        click(By.id("submit"));
    }

    public void closeSuccessDialog() {
        click(By.id("closeLargeModal"));
    }
    public String getTitleFromDialog() {
        return wd.findElement(By.id("example-modal-sizes-title-lg")).getText();
    }

    public void fillForm(Student model) {

        type(By.id("firstName"),model.getFirstName());
        type(By.id("lastName"),model.getLastName());
        type(By.id("userEmail"),model.getEmail());
        selectGender(model.getGender());
        type(By.id("userNumber"),model.getPhone());
        //typeBDay(model.getBirthday());
        typeBDaySelect(model.getBirthday());

        addSubject(model.getSubject());
        selectHobby(model.getHobbies());
        type(By.id("currentAddress"), model.getAddress());
        //typeState(model.getState());
        //typeCity(model.getCity());
    }

    public void fillForm(StudentEnum model) {

        type(By.id("firstName"),model.getFirstName());
        type(By.id("lastName"),model.getLastName());
        type(By.id("userEmail"),model.getEmail());
        selectGender(model.getGender());
        type(By.id("userNumber"),model.getPhone());
        //typeBDay(model.getBirthday());
        typeBDaySelect(model.getBirthday());

        addSubject(model.getSubject());
        selectHobbyEnum(model.getHobbies());
        type(By.id("currentAddress"), model.getAddress());
        typeState(model.getState());
        typeCity(model.getCity());
    }

    private void typeCity(String city) {
       WebElement cityEl=wd.findElement(By.id("react-select-4-input"));
//        cityEl.sendKeys(city);
//        cityEl.sendKeys(Keys.ENTER);
        new Actions(wd).sendKeys(cityEl,city).sendKeys(Keys.ENTER).perform();

    }

    private void typeState(String state) {

        Dimension dimension = wd.manage().window().getSize();
        System.out.println (dimension.getHeight()+dimension.getWidth());

        //scroll
        scroll(0,400);

        WebElement element = wd.findElement(By.cssSelector("#react-select-3-input"));
        element.sendKeys(state);
        element.sendKeys(Keys.ENTER);
    }


    private void selectHobbyEnum (List<Hobby>  hobbies){
        for (Hobby h:hobbies){
            switch (h){
                case SPORTS:
                    click(By.xpath("//label[@for='hobbies-checkbox-1']"));
                    break;
                case READING:
                    click(By.xpath("//label[@for='hobbies-checkbox-2']"));
                    break;
                case MUSIC:
                    click(By.xpath("//label[@for='hobbies-checkbox-3']"));
                    break;
            }
        }

    }

    private void selectHobby(String hobbies) {
        String [] all = hobbies.split(",");

        for (String s:all) {
            switch (s){
                case "Sports":
                    click(By.xpath("//label[@for='hobbies-checkbox-1']"));
                    break;
                case "Reading":
                    click(By.xpath("//label[@for='hobbies-checkbox-2']"));
                    break;
                case "Music":
                    click(By.xpath("//label[@for='hobbies-checkbox-3']"));
                    break;
            }
        }

    }



    private void addSubject(String subject) {
        String[] all = new String[0];
        if(subject!=null && !subject.isEmpty()) {
            all=  subject.split(",");
        }

        click(By.id("subjectsInput"));

        for (String sub:all) {
            wd.findElement(By.id("subjectsInput")).sendKeys(sub);
            //wd.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);//or
            click(By.id("react-select-2-option-0")); //or

            pause(4000);
        }
    }

    private void typeBDaySelect(String birthday) {
        String [] data= birthday.split(" ");


        click(By.id("dateOfBirthInput"));

        new Select(wd.findElement(By.cssSelector(".react-datepicker__month-select"))).selectByVisibleText(data[1]);
        new Select(wd.findElement(By.cssSelector(".react-datepicker__year-select"))).selectByValue(data[2]);

        // click data
        //click(By.xpath("//div[text()='25']"));
       String locator = "//div[text()='" + data[0]+"']";
        String locator2 = String.format("//div[text()='%s']",data[0]);
        List <WebElement> list = wd.findElements(By.xpath(locator2));

        if(list.size()>1 && Integer.parseInt(data[0])>15){
            list.get(1).click();
        }else {
            list.get(0).click();
        }
        pause(2000);
    }


    private void typeBDay(String birthday) {
        WebElement dBirth = wd.findElement(By.id("dateOfBirthInput"));
        dBirth.click();
        String os = System.getProperty("os.name");
        System.out.println(os);

        if(os.startsWith("Mac")){
            //command +a
            dBirth.sendKeys(Keys.chord(Keys.COMMAND ,"a"));

        }else{
            //control+a
            dBirth.sendKeys(Keys.chord(Keys.CONTROL,"a"));

        }
        dBirth.sendKeys(birthday);
        dBirth.sendKeys(Keys.ENTER);


    }

    private void selectGender(String gender) {
        if(gender.equals("Male")) {
            click(By.xpath("//label[@for='gender-radio-1']"));
        }else if (gender.equals("Female")){
            click(By.xpath("//label[@for='gender-radio-2']"));
        }else {
            click(By.xpath("//label[@for='gender-radio-3']"));
        }
    }
}
