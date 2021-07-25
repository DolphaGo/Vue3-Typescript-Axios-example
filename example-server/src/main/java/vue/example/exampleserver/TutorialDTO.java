package vue.example.exampleserver;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class TutorialDTO {
    private Long id;

    private String title;

    private String description;

    private Boolean published;

    public static TutorialDTO create(Tutorial tutorial) {
        return builder()
                .id(tutorial.getId())
                .title((tutorial.getTitle()))
                .description(tutorial.getDescription())
                .published(tutorial.getPublished())
                .build();
    }
}
