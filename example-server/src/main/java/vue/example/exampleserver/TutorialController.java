package vue.example.exampleserver;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TutorialController {

    private final TutorialService tutorialService;

    @GetMapping("/tutorials")
    public List<TutorialDTO> getAll(@RequestParam(value = "title", required = false) String title) {
        if (StringUtils.hasText(title)) {
            return List.of(TutorialDTO.create(tutorialService.findByTitle(title)));
        }

        return tutorialService.findAll()
                              .stream()
                              .map(TutorialDTO::create)
                              .collect(toList());
    }

    @GetMapping("/tutorials/{id}")
    public TutorialDTO get(@PathVariable Long id) {
        return TutorialDTO.create(tutorialService.findById(id));
    }

    @PostMapping("/tutorials")
    public Long create(@RequestBody @NotNull TutorialReqDTO tutorialCreateDTO) {
        log.info("create 요청...................... {}", tutorialCreateDTO);
        return tutorialService.create(tutorialCreateDTO);
    }

    @PutMapping("/tutorials/{id}")
    public Long update(@PathVariable Long id, @RequestBody TutorialUpdateDTO tutorialUpdateDTO) {
        log.info("업데이트..........................{}", tutorialUpdateDTO);
        return tutorialService.update(tutorialUpdateDTO);
    }

    @DeleteMapping("/tutorials/{id}")
    public Long delete(@PathVariable Long id) {
        log.info("특정 튜토리얼 삭제");
        return tutorialService.delete(id);
    }

    @DeleteMapping("/tutorials")
    public void deleteAll() {
        log.info("전체 삭제");
        tutorialService.deleteAll();
    }
}
