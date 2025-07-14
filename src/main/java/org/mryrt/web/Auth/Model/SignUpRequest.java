package org.mryrt.web.Auth.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.mryrt.web.Auth.Annotation.Username;

@Data
public class SignUpRequest {

    @Username
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 5, message = "Password must be longer than 5 characters")
    private String password;

}
