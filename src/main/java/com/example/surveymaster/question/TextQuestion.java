package com.example.surveymaster.question;

import lombok.*;

@Data
public class TextQuestion extends Question {

    private int minimumLength;
    private int maximumLength;

    public TextQuestion(int minimumLength, int maximumLength) {
        this.minimumLength = minimumLength;
        this.maximumLength = maximumLength;
    }

    public int getMinimumLength() {
        return minimumLength;
    }

    public void setMinimumLength(int minimumLength) {
        this.minimumLength = minimumLength;
    }

    public int getMaximumLength() {
        return maximumLength;
    }

    public void setMaximumLength(int maximumLength) {
        this.maximumLength = maximumLength;
    }

    @Override
    public String toString() {
        return "TextQuestion{" +
                "minimumLength=" + minimumLength +
                ", maximumLength=" + maximumLength +
                '}';
    }
}
