package ru.yakup.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yakup.survey.entitшes.Survey;

import java.sql.Date;
import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {

    List<Survey> findSurveyByTitle(String title);

    List<Survey> findSurveyByBeginDate(Date beginDate);

    List<Survey> findSurveyByEndDate(Date endDate);

    List<Survey> findSurveyByActivity(Boolean activity);

    List<Survey> findSurveyByOrderByTitle();

    List<Survey> findSurveyByOrderByBeginDate();

}
