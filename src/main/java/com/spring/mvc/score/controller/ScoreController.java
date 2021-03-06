package com.spring.mvc.score.controller;

import com.spring.mvc.score.domain.Score;
import com.spring.mvc.score.repository.ScoreRepository;
import com.spring.mvc.score.service.ScoreService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Log4j2
public class ScoreController {
    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/score/score-list")
    public String scoreList() {
        return "score/score-list";
    }

    @PostMapping("/score/register")
    public String scoreRegister(Score score) {
        log.info("/score/register POST! - " + score);
        scoreService.register(score);
        return "redirect:/score/list";
    }

    // 전체 성적정보 조회 요청
    @GetMapping("/score/list")
    public String list(Model model) {
        log.info("/score/list GET! ");
        List<Score> scores = scoreService.getList();
        model.addAttribute("scores", scores);
        return "score/score-list";
    }
    
    // 성적정보 삭제 요청처리
    @GetMapping("/score/delete")
    public String delete(int stuNum) {
        log.info("/score/delete GET! - " + stuNum);
        scoreService.remove(stuNum);
        return "redirect:/score/list";
    }

    // 상세 정보 요청처리
    @GetMapping("/score/detail")
    public String detail(int stuNum, Model model) {
        log.info("/score/detail GET! - " + stuNum);
        Score score = scoreService.getScore(stuNum);
        model.addAttribute("s", score);
        return "score/detail";
    }
}
