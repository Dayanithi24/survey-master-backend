package com.example.surveymaster.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class ResponseDao {
    @Autowired
    private MongoTemplate mt;

    public Response saveResponse(Response response) {
        return mt.save(response);
    }

    public Response getResponseById(String id) {
        return mt.findById(id, Response.class);
    }

    public List<Response> getAllResponseOfSurvey(String surveyId){
        Query query = new Query(Criteria.where("surveyId").is(surveyId));
        return  mt.find(query, Response.class);
    }

    public Page<Response> getResponseBySurvey(String id, int page, int size){
        Query query = new Query(Criteria.where("surveyId").is(id));
        long totalCount = mt.count(query, Response.class);

        Pageable pageable = PageRequest.of(page, size);
        query.with(pageable);

        List<Response> responses = mt.find(query, Response.class);

        return new PageImpl<>(responses, pageable, totalCount);
    }

    public Page<Response> getResponseBySurvey(String id, int page, int size, LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        Criteria criteria = Criteria.where("surveyId").is(id)
                .and("respondedAt").gte(fromDateTime).lte(toDateTime);

        Query query = new Query(criteria);
        long totalCount = mt.count(query, Response.class);

        Pageable pageable = PageRequest.of(page, size);
        query.with(pageable);

        List<Response> responses = mt.find(query, Response.class);

        return new PageImpl<>(responses, pageable, totalCount);
    }

    public List<Response> getAllResponses() {
        return mt.findAll(Response.class);
    }

    public String deleteResponseById(String id) {
        Response response = getResponseById(id);
        if(response == null)
            return null;
        mt.remove(response);
        return "Deleted Successfully!!";
    }

    public String deleteAllResponsesOfSurvey(String surveyId) {
        List<Response> responses = getAllResponseOfSurvey(surveyId);
        System.out.println(responses);
        for (Response response: responses){
            mt.remove(response);
        }
        return "Deleted Successfully!!";
    }

}
