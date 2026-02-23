package com.learn.withravi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "User Data Transfer Object (DTO) represents the data structure for transferring user information between different layers of the application. It includes fields for user ID, first name, last name, and email address, along with validation constraints to ensure data integrity."
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private Long id;

    //User first name should not be empty

    @NotEmpty(message = "First name should not be empty")
    @Schema(
            description = "First name of the user",
            example = "John"
    )
    private  String firstName;

    //User last name should not be empty
    @NotEmpty(message = "Last name should not be empty")
    @Schema(
            description = "Last name of the user",
            example = "Doe"
    )
    private String lastName;

    //User Email should not be empty
    //Email address should be valid
    @NotEmpty(message ="Email should not be empty")
    @Email(message = "Email address should be valid")
    @Schema(
            description = "Email address of the user",
            example = "test@gmail.com"
    )
    private String email;
}
