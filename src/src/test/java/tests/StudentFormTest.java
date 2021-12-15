package tests;

import models.Hobby;
import models.Student;
import models.StudentEnum;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentFormTest extends TestBase{

    @BeforeMethod
    public void preconditions(){
        app.studentHelper().selectItemForms();
        app.studentHelper().selectPracticeForm();
        app.studentHelper().hideFooter();

    }

    @Test
    public void studentFormTest(){
        Student model = Student.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@mail.com")
                .gender("Male")
                .phone("1234567890")
                .birthday("30 June 2016")
                .subject("Maths,Chemistry")
                .hobbies("Sports,Music")
                .address("Tel Aviv")
                .state("NCR")
                .city("Gurgaon")
                .build();
        app.studentHelper().fillForm(model);

        app.studentHelper().uploadPicture();

        app.studentHelper().pause(500);
        app.studentHelper().submit();
        app.studentHelper().pause(1000);
        Assert.assertEquals(app.studentHelper().getTitleFromDialog(),"Thanks for submitting the form");
        app.studentHelper().closeSuccessDialog();

    }

    @Test
    public void studentFormTestEnum(){
        List<Hobby> hobbies = new ArrayList<>();
        hobbies.add(Hobby.MUSIC);
        hobbies.add(Hobby.READING);

        StudentEnum student = StudentEnum.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@mail.com")
                .gender("Male")
                .phone("1234567890")
                .birthday("30 June 2016")
                .subject("Maths,Chemistry")
                .hobbies(hobbies)
                .address("Tel Aviv")
                .state("NCR")
                .city("Gurgaon")
                .build();


        app.studentHelper().fillForm(student);

        app.studentHelper().uploadPicture();

        app.studentHelper().pause(3000);
        app.studentHelper().submit();
        app.studentHelper().pause(1000);
        Assert.assertEquals(app.studentHelper().getTitleFromDialog(),"Thanks for submitting the form");
        app.studentHelper().closeSuccessDialog();

    }

}
