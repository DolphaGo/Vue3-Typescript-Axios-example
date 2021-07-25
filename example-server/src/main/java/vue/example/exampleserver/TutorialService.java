package vue.example.exampleserver;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TutorialService {

    private final TutorialRepository tutorialRepository;

    public List<Tutorial> findAll() {
        return tutorialRepository.findAll();
    }

    public Tutorial findById(Long id) {
        return tutorialRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Long create(TutorialReqDTO tutorialReqDTO) {
        Tutorial tutorial = tutorialReqDTO.toEntity();
        return tutorialRepository.save(tutorial).getId();
    }

    @Transactional
    public Long update(TutorialUpdateDTO tutorialUpdateDTO) {
        final Long id = tutorialUpdateDTO.getId();
        Tutorial tutorial = tutorialRepository.findById(id).orElseThrow();

        tutorial.update(tutorialUpdateDTO.getTitle(), tutorialUpdateDTO.getDescription(), tutorialUpdateDTO.getPublished());
        return id;
    }

    @Transactional
    public Long delete(final Long id) {
        tutorialRepository.deleteById(id);
        return id;
    }

    @Transactional
    public void deleteAll() {
        tutorialRepository.deleteAll();
    }

    public Tutorial findByTitle(final String title) {
        return tutorialRepository.findByTitle(title);
    }
}
