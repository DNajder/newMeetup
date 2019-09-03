package end_project.new_meetup.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class CommentaryDTO {

    @NotBlank(message = "Komentarz nie może być pusty")
    @Size(max = 500)
    private String description;
}
