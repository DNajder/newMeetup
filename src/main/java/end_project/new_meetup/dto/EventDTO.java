package end_project.new_meetup.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class EventDTO {

    @NotBlank(message = "Musisz podać tytuł wydażenia")
    private String title;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate evenStart;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate evenEnd;

    @NotBlank(message = "Podaj wyczerpujący opis")
    @Size(min = 20)
    private String description;
}
