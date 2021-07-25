package vue.example.exampleserver;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TutorialUpdateDTO {
    private Long id;
    private String title;
    private String description;
    private Boolean published;
}
