package com.example.surveymaster.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SurveyDao {
    @Autowired
    private MongoTemplate mt;

    public List<Survey> getAllSurveys() {
        return  mt.findAll(Survey.class);
    }

    public Survey createSurvey(Survey survey) {
        return mt.save(survey);
    }

    public Survey getSurveyById(String id) {
        return mt.findById(id, Survey.class);
    }

    public Survey saveSurvey(Survey survey){
        return mt.save(survey);
    }

    public String deleteSurvey(Survey survey) {
        mt.remove(survey);
        return  "Deleted Successfully!!";
    }

    public void incrementResponseCount(String id) {
        Survey survey = getSurveyById(id);
        survey.setResponseCount(survey.getResponseCount() + 1);
        mt.save(survey);
    }

    public void decrementResponseCount(String id) {
        Survey survey = getSurveyById(id);
        survey.setResponseCount(survey.getResponseCount() - 1);
        mt.save(survey);
    }
}
