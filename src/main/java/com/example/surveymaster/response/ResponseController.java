package com.example.surveymaster.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/response")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ResponseController {
    @Autowired
    private ResponseService rs;

    @PostMapping
    public ResponseEntity<Response> saveResponse(@RequestBody Response response) {
        System.out.println(response);
        return ResponseEntity.ok(rs.saveResponse(response));
    }

    @GetMapping()
    public ResponseEntity<List<Response>> getAllResponses(){
        return ResponseEntity.ok(rs.getAllResponses());
    }

    @GetMapping("{id}")
    public ResponseEntity<Response> getResponseById(@PathVariable String id){
        return ResponseEntity.ok(rs.getResponseById(id));
    }

    @GetMapping("survey/{surveyId}")
    public ResponseEntity<List<Response>> getResponseBySurvey(@PathVariable String surveyId, @RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok(rs.getResponseBySurvey(surveyId, page, size));
    }

}
