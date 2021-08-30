package ru.yakup.survey.services;

import ru.yakup.survey.entitшes.Survey;

import java.sql.Date;
import java.util.List;

public interface SurveyService {
    List<Survey> findAll();

    List<Survey> findSurveyByTitle(String title);

    List<Survey> findSurveyByBeginDate(Date beginDate);

    List<Survey> findSurveyByEndDate(Date endDate);

    List<Survey> findSurveyByActivity(Boolean activity);

    List<Survey> findSurveyByOrderByTitle();

    List<Survey> findSurveyByOrderByBeginDate();

    Survey  save(Survey survey);

    void delete(Integer integer);


}
