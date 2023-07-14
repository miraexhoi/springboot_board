package com.study.board.controller;

import ch.qos.logback.core.model.Model;
import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;
    @GetMapping("/board/write") //localhost:8080/board/write
    public String boardWriteForm(){

        return "boardwrite";
    }

    @PostMapping("board/writePro")
    public String boardWritePro(Board board) {
        boardService.write(board);
        return "";
    }
    @GetMapping("/board/list")
    public String boardList(Model model){
        model.addAtturibute("list", boardService.boardlist())
        return "boardlist";
    }
}
