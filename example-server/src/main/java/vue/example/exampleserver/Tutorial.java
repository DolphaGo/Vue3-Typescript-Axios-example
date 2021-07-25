package vue.example.exampleserver;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Boolean published = true;

    @Builder
    public Tutorial(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void update(final String title, final String description, final Boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }
}
