package com.spring.mvc.board.controller;

import com.spring.mvc.board.domain.Board;
import com.spring.mvc.board.dto.ModBoard;
import com.spring.mvc.board.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/board")
public class BoardController {

    /**
     * 게시물 목록요청: /board/list: GET
     * 게시물 상세조회요청: /board/content: GET
     * 게시글 쓰기 화면요청: /board/write: GET
     * 게시글 등록요청: /board/write: POST
     * 게시글 삭제요청: /board/delete: GET
     * 게시글 수정화면요청: /board/modify: GET
     * 게시글 수정요청: /board/modify: POST
     */
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        log.info("/board/list GET!! ");
        List<Board> boardList = boardService.getList();
        model.addAttribute("articles", boardList);
        return "board/list";
    }

    //글쓰기 화면요청
    @GetMapping("/write")
    public String write() {
        log.info("/board/write GET!");
        return "board/write";
    }

    //글쓰기 등록요청
    @PostMapping("/write")
    public String write(Board board) {
        log.info("/board/write POST! - " + board);
        boardService.write(board);
        return "redirect:/board/list";
    }

    //상세조회 요청
    // /board/content?boardNo=3
    @GetMapping("/content")
    public String content(Long boardNo, Model model) {
        log.info("/board/content GET! - " + boardNo);
        Board board = boardService.get(boardNo);
        log.info("board - " + board);
        model.addAttribute("b", board);
        return "board/content";
    }
    
    // 수정양식 화면 요청
    @GetMapping("/modify")
    public String modify(Long boardNo, Model model) {
        log.info("/board/modify GET!! - " + boardNo);
        Board board = boardService.get(boardNo);
        model.addAttribute("board", board);
        return "board/modify";
    }

    // 수정 요청 처리
    @PostMapping("/modify")
    public String modify(ModBoard board) {
        log.info("/board/modify POST! - " + board);
        boardService.update(board);
        return "redirect:/board/content?boardNo=" + board.getBoardNo();
    }

    @GetMapping("/delete")
    public String delete(Long boardNo) {
        log.info("/board/delete GET! - " + boardNo);
        boardService.remove(boardNo);
        return "redirect:/board/list";

    }

}