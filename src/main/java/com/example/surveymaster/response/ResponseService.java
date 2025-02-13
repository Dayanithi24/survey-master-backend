package com.example.surveymaster.response;

import com.example.surveymaster.survey.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public List<Response> getResponseBySurvey(String surveyId, int page, int size){
        return dao.getResponseBySurvey(surveyId, page, size);
    }

    public List<Response> getAllResponses() {
        return dao.getAllResponses();
    }
}
