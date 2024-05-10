package com.joaovitor.quiz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class quizController {

    private final String EXTERNAL_API_URL = "https://opentdb.com/api.php?amount=1&category=27&difficulty=easy&type=multiple";

    @GetMapping("/quiz")
    public ResponseEntity<Map<String, Object>> getQuiz() {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> response = restTemplate.getForObject(EXTERNAL_API_URL, Map.class);

        List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");
        Map<String, Object> questionData = results.get(0);
        String question = (String) questionData.get("question");
        String correctAnswer = (String) questionData.get("correct_answer");
        List<String> incorrectAnswers = (List<String>) questionData.get("incorrect_answers");

        List<String> allAnswers = new ArrayList<>(incorrectAnswers);
        allAnswers.add(correctAnswer);

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("question", question);
        responseData.put("answers", allAnswers);
        responseData.put("correct", correctAnswer);
        return ResponseEntity.ok(responseData);
    }

    @PostMapping("/answer")
    public ResponseEntity<Map<String, Object>> checkAnswer(@RequestBody Map<String, String> userAnswer) {
        String correctAnswer = userAnswer.get("correct");
        String userResponse = userAnswer.get("response");
        boolean isCorrect = correctAnswer.equals(userResponse);

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("is_correct", isCorrect);
        return ResponseEntity.ok(responseData);
    }

}