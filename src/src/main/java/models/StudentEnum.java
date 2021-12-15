package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class StudentEnum {

    String firstName;
    String lastName;
    String email;
    String gender;
    String phone;
    String birthday;
    String subject;
    //String hobbies;
    //Hobby hobby;
    List<Hobby> hobbies;
    String address;
    String state;
    String city;
}
