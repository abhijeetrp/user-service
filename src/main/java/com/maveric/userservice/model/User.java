package com.maveric.userservice.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maveric.userservice.constants.Gender;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
//    @NotEmpty(message = "required")
//    @Size(min=2, max=30)
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String email;
    private String address;
    private String dateOfBirth;
    private Gender gender;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
