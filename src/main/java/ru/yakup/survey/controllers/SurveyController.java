package ru.yakup.survey.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yakup.survey.entitшes.Survey;
import ru.yakup.survey.services.SurveyService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/surveys")
@Tag(name="Опрос", description="Инф об опросе")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @GetMapping("")
    @Operation(
            summary = "Все опросы",
            description = "Позволяет получить все опросы"
    )
    public List<Survey> showAllSurvey () {
        List<Survey> surveys = surveyService.findAll();
        return surveys;
    }

    @GetMapping("/title/{title}")
    @Operation(
            summary = "Поиск по названию",
            description = "Позволяет найти опрос(ы) по названию"
    )
    public List<Survey> showSurveyByTitle (@PathVariable @Parameter(description = "Название опроса") String title) {
        List<Survey> surveys = surveyService.findSurveyByTitle(title);
        return surveys;
    }

    @GetMapping("/begin-date/{date}")
    @Operation(
            summary = "Поиск по дате начала",
            description = "Позволяет найти опрос(ы) по дате начала опроса"
    )
    public List<Survey> showSurveyByBeginDate (@PathVariable @Parameter(description = "Дата начала опроса") Date date) {
        List<Survey> surveys = surveyService.findSurveyByBeginDate(date);
        return surveys;
    }

    @GetMapping("/end-date/{date}")
    @Operation(
            summary = "Поиск по дате окончания",
            description = "Позволяет найти опрос(ы) по дате окончания опроса"
    )
    public List<Survey> showSurveyByEndDate (@PathVariable @Parameter(description = "Дата окончания опроса") Date date) {
        List<Survey> surveys = surveyService.findSurveyByEndDate(date);
        return surveys;
    }

    @GetMapping("/activity/{activity}")
    @Operation(
            summary = "Поиск по активности",
            description = "Позволяет найти опрос(ы) по активности"
    )
    public List<Survey> showSurveyByTitle (@PathVariable @Parameter(description = "Активность") Boolean activity) {
        List<Survey> surveys = surveyService.findSurveyByActivity(activity);
        return surveys;
    }

    @GetMapping("/title-order")
    @Operation(
            summary = "Сортировать по названию",
            description = "Позволяет вывести все опросы отсортированные по названию опроса"
    )
    public List<Survey> showSurveyByTitleByOrder () {
        List<Survey> surveys = surveyService.findSurveyByOrderByTitle();
        return surveys;
    }

    @GetMapping("/begin-date-order")
    @Operation(
            summary = "Сортировать по дате начала",
            description = "Позволяет вывести все опросы отсортированные по дате начала опроса"
    )
    public List<Survey> showSurveyByBeginDateByOrder () {
        List<Survey> surveys = surveyService.findSurveyByOrderByBeginDate();
        return surveys;
    }

    @PostMapping("")
    @Operation(
            summary = "Создание опрос",
            description = "Позволяет создать опрос. Нужно передать опрос (json) в теле."
    )
    public Survey addNewSurvey(@RequestBody Survey survey) {
        surveyService.save(survey);
        return survey;
    }

    @PutMapping("")
    @Operation(
            summary = "Редактировать опрос",
            description = "Позволяет редактировать опрос. Нужно передать опрос (json) в теле."
    )
    public Survey updateSurvey (@RequestBody Survey survey) {
        surveyService.save(survey);
        return survey;
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удалить опрос",
            description = "Позволяет удалить опрос. Нужно передать id опроса."
    )
    public String deleteSurvey (@PathVariable @Parameter(description = "id удаляемого опроса") Integer id) {
        surveyService.delete(id);
        return  "Опрос с id = " + id + " удален";
    }
}
