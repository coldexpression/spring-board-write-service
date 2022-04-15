package com.carrot.writeservice.board.controller;

import com.carrot.writeservice.board.model.SaveBoardParam;
import com.carrot.writeservice.board.model.SearchBoardModel;
import com.carrot.writeservice.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home/infos")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/add")
    public String addForm() {
        return "home/addForm";
    }

    @GetMapping
    public String searchBoardInfos(Model model) {
        model.addAttribute("infos", boardService.searchBoardInfos());
        return "home/infos";
    }

    @GetMapping("/{id}")
    public String searBoardInfo(Model model, @PathVariable Long id) {
        model.addAttribute("info", boardService.searchBoardInfo(id));
        return "home/info";
    }

    @PostMapping("/add")
    public String saveBoardInfo(@RequestParam String title, @RequestParam String path) {
        boardService.saveBoardInfo(title, path);
        return "home/infos";
    }
}
