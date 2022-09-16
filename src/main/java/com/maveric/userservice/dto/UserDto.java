package com.maveric.userservice.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maveric.userservice.constants.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Id
    private Long id;
    @NotEmpty(message = "First Name is mandatory")
    @Size(min = 2 , message="First Name atleast 2 charaters")
    private String firstName;

    @Size(min = 1 , message="Last Name atleast 1 charaters")
    @NotEmpty(message = "Last Name is mandatory")
    private String lastName;

    @Size(min = 1 , message="Middle Name atleast 1 charaters")
    @NotEmpty(message = "Middle Name is mandatory")
    private String middleName;

    @NotEmpty(message = "Phone Number is mandatory")
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;

    @Email(message = "Email Should be valid")
    @NotEmpty(message = "Email is mandatory")
    @Column(unique=true)
    private String email;

    @NotEmpty(message = "Address is mandatory")
    private String address;

    @NotEmpty(message = "Date of Birth is mandatory")
    private String dateOfBirth;

    @NotNull(message = "Gender is mandatory 'MALE' or 'FEMALE'")
    private Gender gender;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty(message = "Password is mandatory")
    private String password;
}