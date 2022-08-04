package org.design.bonpellz.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class EarlyAccessRequest {

    @NotNull
    @NotBlank(message = "Name is required")
    private String name;

    private String email;
    private String phoneNumber;
    private String hearAboutUs;
}
