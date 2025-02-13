package com.example.surveymaster.survey;

import com.example.surveymaster.question.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SurveyService {
    @Autowired
    private SurveyDao dao;
    public Survey toSurvey(Map<String, Object> requestData){
        System.out.println("Raw Object: " + requestData);

        String title = (String) requestData.get("title");
        String description = (String) requestData.get("description");

        List<Map<String, Object>> questionMaps = (List<Map<String, Object>>) requestData.get("questions");
        List<Question> questions = new ArrayList<>();

        for (Map<String, Object> questionMap : questionMaps) {
            String questionText = (String) questionMap.get("question");
            int questionNum = (int) questionMap.get("question_num");
            String inputType = (String) questionMap.get("inputType");
            String supportMessage = (String) questionMap.get("support_message");
            String errorMessage = (String) questionMap.get("error_message");
            boolean required = (boolean) questionMap.get("required");

            Question question;
            switch (inputType) {
                case "multiple choice":
                    List<String> options = (List<String>) questionMap.get("options");
                    question = new MultipleChoiceQuestion(options);
                    break;
                case "checkbox":
                    List<String> checkOptions = (List<String>) questionMap.get("options");
                    question = new CheckboxQuestion(checkOptions);
                    break;
                case "text":
                    int minLength = Integer.parseInt((String) questionMap.getOrDefault("minimum_value", "0"));
                    int maxLength = Integer.parseInt((String) questionMap.getOrDefault("maximum_value", "1000"));
                    question = new TextQuestion(minLength, maxLength);
                    break;
                case "number":
                    int minValue = Integer.parseInt((String) questionMap.getOrDefault("minimum_value", "0"));
                    int maxValue = Integer.parseInt((String) questionMap.getOrDefault("maximum_value", "1000"));
                    question = new NumberQuestion(minValue, maxValue);
                    break;
                case "file":
                    List<String> fileFormats = (List<String>) questionMap.get("file_formats");
                    int noOfFiles = Integer.parseInt((String) questionMap.getOrDefault("maximum_number_of_files", "1"));
                    String fileSize = (String) questionMap.get("maximum_file_size");
                    question = new FileUploadQuestion(fileFormats, noOfFiles, fileSize);
                    break;
                default:
                    question = new DateTimeQuestion();
                    break;
            }
            question.setQuestionNum(questionNum);
            question.setQuestion(questionText);
            question.setInputType(inputType);
            question.setSupportMessage(supportMessage);
            question.setErrorMessage(errorMessage);
            question.setRequired(required);
            questions.add(question);
        }

        Survey survey = new Survey(null, title, description, "Admin", LocalDateTime.now(), false, questions);

        System.out.println("Converted Survey: " + survey);
        return survey;

    }

    public List<Survey> getAllSurveys() {
        return dao.getAllSurveys();
    }

    public Survey createSurvey(Map<String, Object> object) {
        Survey survey = toSurvey(object);
        return dao.createSurvey(survey);
    }

    public Survey getSurveyById(String id) {
        return dao.getSurveyById(id);
    }

    public List<Survey> getAllEnabledSurveys() {
        List<Survey> surveys = dao.getAllSurveys();
        surveys = surveys.stream()
                .filter(Survey::isActive)
                .collect(Collectors.toList());
        return surveys;
    }


    public Survey enableSurvey(String id) {
        Survey survey = dao.getSurveyById(id);
        survey.setActive(true);
        return dao.saveSurvey(survey);
    }

    public Survey disableSurvey(String id) {
        Survey survey = dao.getSurveyById(id);
        survey.setActive(false);
        return dao.saveSurvey(survey);
    }

    public String deleteSurvey(String id) {
        Survey survey = dao.getSurveyById(id);
        if(survey == null){
            return "Survey not found!!";
        }
        return dao.deleteSurvey(survey);
    }   

    public void incrementResponseCount(String id){
        dao.incrementResponseCount(id);
    }

    public void decrementResponseCount(String id){
        dao.decrementResponseCount(id);
    }
}
