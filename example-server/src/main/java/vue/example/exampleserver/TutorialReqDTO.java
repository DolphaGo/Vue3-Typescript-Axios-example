package vue.example.exampleserver;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TutorialReqDTO {
    private String title;
    private String description;

    public Tutorial toEntity() {
        return Tutorial.builder()
                       .title(title)
                       .description(description)
                       .build();
    }
}

