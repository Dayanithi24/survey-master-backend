package com.example.surveymaster.question;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class MultipleChoiceQuestion extends Question {

    private List<String> options;

    public MultipleChoiceQuestion(List<String> options) {
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
        return "MultipleChoiceQuestion{" +
                "options=" + options +
                '}';
    }
}
