package com.example.surveymaster.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SurveyController {
    @Autowired
    private SurveyService ss;

    @PostMapping
    public ResponseEntity<Survey> createSurvey(@RequestBody Map<String, Object> object){
        return ResponseEntity.ok(ss.createSurvey(object));
    }
    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys() {
        List<Survey> surveys = ss.getAllSurveys();
        return ResponseEntity.ok(surveys);
    }
    @GetMapping("/enabled")
    public ResponseEntity<List<Survey>> getAllEnabledSurveys() {
        List<Survey> surveys = ss.getAllEnabledSurveys();
        return ResponseEntity.ok(surveys);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable String id){
        Survey survey = ss.getSurveyById(id);
        return ResponseEntity.ok(survey);
    }
    @PutMapping("/enable/{id}")
    public ResponseEntity<Survey> enableSurvey(@PathVariable String id){
        Survey survey = ss.enableSurvey(id);
        return ResponseEntity.ok(survey);
    }
    @PutMapping("/disable/{id}")
    public ResponseEntity<Survey> disableSurvey(@PathVariable String id){
        Survey survey = ss.disableSurvey(id);
        return ResponseEntity.ok(survey);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSurvey(@PathVariable String id){
        return ResponseEntity.ok(ss.deleteSurvey(id));
    }

}
