package org.design.bonpellz.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
public class EarlyAccessRequest {

    @NotNull
    @NotBlank(message = "Name is required")
    private String name;

    @NotNull
    @Column(name = "email", unique = true)
    @Email
    private String email;

    @NotNull
    @Column(name = "phone_number")
    @NotBlank(message = "Phone Number is required")
    @Pattern(regexp = "(^$|[0-9]{11})", message = "Phone Number should contain 11 digits")
    private String phoneNumber;

    @NotNull
    @NotBlank(message = "Field must Not be empty")
    private String hearAboutUs;
}
