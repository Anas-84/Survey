package ru.yakup.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yakup.survey.entitшes.Survey;
import ru.yakup.survey.repositories.SurveyRepository;

import java.sql.Date;
import java.util.List;

@Service
public class SurveyServiceImp implements SurveyService{
    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public List<Survey> findAll() {
        List<Survey> survey= surveyRepository.findAll();
        return survey;
    }

    @Override
    public List<Survey> findSurveyByTitle(String title) {
        List<Survey> survey= surveyRepository.findSurveyByTitle(title);
        return survey;
    }

    @Override
    public List<Survey> findSurveyByBeginDate(Date beginDate) {
        List<Survey> survey= surveyRepository.findSurveyByBeginDate(beginDate);
        return survey;
    }

    @Override
    public List<Survey> findSurveyByEndDate(Date endDate) {
        List<Survey> survey= surveyRepository.findSurveyByEndDate(endDate);
        return survey;
    }

    @Override
    public List<Survey> findSurveyByActivity(Boolean activity) {
        List<Survey> survey= surveyRepository.findSurveyByActivity(activity);
        return survey;
    }

    @Override
    public List<Survey> findSurveyByOrderByTitle() {
        List<Survey> survey= surveyRepository.findSurveyByOrderByTitle();
        return survey;
    }

    @Override
    public List<Survey> findSurveyByOrderByBeginDate() {
        List<Survey> survey= surveyRepository.findSurveyByOrderByBeginDate();
        return survey;
    }

    @Override
    public Survey save(Survey survey) {
        surveyRepository.saveAndFlush(survey);
        return survey;
    }

    @Override
    public void delete(Integer id) {
        surveyRepository.deleteById(id);
    }
}
