package end_project.new_meetup.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class UserRegisterDTO {

    @NotBlank(message = "WPISZ NAZWĘ UŻTKOWNIKA")
    @Size(max = 50)
    private String name;

    @NotBlank
    @Pattern(regexp = ".+@.+")
    @Email(message = "WPISZ POPRAWNY ADRES E-MAIL")
    private String email;

    @NotBlank(message = "WPISZ POPRAWNE HASŁO")
    @Size(min = 1, max = 30)
    private String password;

}
