package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Student {

    String firstName;
    String lastName;
    String email;
    String gender;
    String phone;
    String birthday;
    String subject;
    String hobbies;
    String address;
    String state;
    String city;
}
