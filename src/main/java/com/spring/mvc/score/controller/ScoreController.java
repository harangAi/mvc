package com.spring.mvc.score.controller;

import com.spring.mvc.score.domain.Score;
import com.spring.mvc.score.repository.ScoreRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
public class ScoreController {
    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @GetMapping("/score/score-list")
    public String scoreList() {
        return "score/score-list";
    }

    @PostMapping("/score/register")
    public String scoreRegister(Score score) {
        log.info("/score/register POST! - " + score);
        scoreRepository.save(score);
        return "redirect:/score/list";
    }

    // 전체 성적정보 조회 요청
    @GetMapping("/score/list")
    public String list(Model model) {
        log.info("/score/list GET! ");
        List<Score> scores = scoreRepository.findAll();
        model.addAttribute("scores", scores);
        return "score/score-list";
    }
}
