package com.example.surveymaster.response;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Document(collection =  "responses")
@Data
public class Response {
    @Id
    private String id;
    private String surveyId;
    private String respondedBy;
    private LocalDateTime respondedAt;
    private Map<String, Object> responses;

    public Response() {
    }

    public Response(String id, String surveyId, String respondedBy, LocalDateTime respondedAt, Map<String, Object> responses) {
        this.id = id;
        this.surveyId = surveyId;
        this.respondedBy = respondedBy;
        this.respondedAt = respondedAt;
        this.responses = responses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getRespondedBy() {
        return respondedBy;
    }

    public void setRespondedBy(String respondedBy) {
        this.respondedBy = respondedBy;
    }

    public LocalDateTime getRespondedAt() {
        return respondedAt;
    }

    public void setRespondedAt(LocalDateTime respondedAt) {
        this.respondedAt = respondedAt;
    }

    public Map<String, Object> getResponses() {
        return responses;
    }

    public void setResponses(Map<String, Object> responses) {
        this.responses = responses;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id='" + id + '\'' +
                ", surveyId='" + surveyId + '\'' +
                ", respondedBy='" + respondedBy + '\'' +
                ", respondedAt=" + respondedAt +
                ", responses=" + responses +
                '}';
    }
}
