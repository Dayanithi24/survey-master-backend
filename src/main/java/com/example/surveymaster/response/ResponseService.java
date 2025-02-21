package com.example.surveymaster.response;

import com.example.surveymaster.survey.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ResponseService {
    @Autowired
    private ResponseDao dao;
    @Autowired
    private SurveyService ss;

    public Response saveResponse(Response response) {
        response.setRespondedAt(LocalDateTime.now());
        Response res = dao.saveResponse(response);
        if(res != null) ss.incrementResponseCount(res.getSurveyId());
        return res;
    }

    public Response getResponseById(String id) {
        return dao.getResponseById(id);
    }

    public List<Response> getAllResponses() {
        return dao.getAllResponses();
    }

    public Page<Response> getResponseBySurvey(String surveyId, int page, int size, String from, String to) {
        if (!from.equals("") && !to.equals("")) {
            LocalDate fromDate = LocalDate.parse(from, DateTimeFormatter.ISO_DATE);
            LocalDate toDate = LocalDate.parse(to, DateTimeFormatter.ISO_DATE);

            LocalDateTime fromDateTime = fromDate.atStartOfDay(); // 2025-02-13T00:00:00
            LocalDateTime toDateTime = toDate.atTime(23, 59, 59);  // 2025-02-15T23:59:59

            return dao.getResponseBySurvey(surveyId, page, size, fromDateTime, toDateTime);
        }
        return dao.getResponseBySurvey(surveyId, page, size);
    }

    public String deleteResponseById(String id) {
        return dao.deleteResponseById(id);
    }

    public String deleteAllResponsesOfSurvey(String surveyId) {
        return dao.deleteAllResponsesOfSurvey(surveyId);
    }

}
