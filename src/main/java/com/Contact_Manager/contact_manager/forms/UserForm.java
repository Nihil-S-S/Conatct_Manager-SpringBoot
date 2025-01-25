package com.Contact_Manager.contact_manager.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    @NotBlank(message = "Username is Required")
    @Size(min=3,message = "Min 3 characters is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email address")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min=6,message = "Min 6 character required")
    private String password;

    @NotBlank(message = "About is required")
    private String about;

    @NotBlank(message = "PhoneNumber is required")
    @Size(min=8,max = 12,message = "Invalid phone number")
    private String phoneNumber;

}
