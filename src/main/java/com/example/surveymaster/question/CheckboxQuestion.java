package com.example.surveymaster.question;

import com.example.surveymaster.survey.Survey;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class CheckboxQuestion extends Question {

    private List<String> options;

    public CheckboxQuestion(List<String> options) {
        this.options = options;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "CheckboxQuestion{" +
                "options=" + options +
                '}';
    }
}
