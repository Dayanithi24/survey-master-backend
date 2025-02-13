package com.example.surveymaster.question;

import com.example.surveymaster.survey.Survey;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
public abstract class Question {

    @Id
    private int questionNum;
    private String question;
    private String inputType;
    private String supportMessage;
    private String errorMessage;
    private boolean required;

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getSupportMessage() {
        return supportMessage;
    }

    public void setSupportMessage(String supportMessage) {
        this.supportMessage = supportMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionNum=" + questionNum +
                ", question='" + question + '\'' +
                ", inputType='" + inputType + '\'' +
                ", supportMessage='" + supportMessage + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", required=" + required +
                '}';
    }
}