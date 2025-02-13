package com.example.surveymaster.question;

import lombok.*;

@Data
public class NumberQuestion extends Question {

    private int minimumValue;
    private int maximumValue;
    public NumberQuestion(int minimumValue, int maximumValue) {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }

    public int getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(int minimumValue) {
        this.minimumValue = minimumValue;
    }

    public int getMaximumValue() {
        return maximumValue;
    }

    public void setMaximumValue(int maximumValue) {
        this.maximumValue = maximumValue;
    }

    @Override
    public String toString() {
        return "NumberQuestion{" +
                "minimumValue=" + minimumValue +
                ", maximumValue=" + maximumValue +
                '}';
    }
}
