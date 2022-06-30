package com.its.memberboardproject.controller;

import com.its.memberboardproject.dto.BoardDTO;
import com.its.memberboardproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/save-form")
    public String saveForm() {
        return "boardPages/save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) throws IOException {
        boardService.save(boardDTO);
        return "redirect:/board/findAll";
    }

    @GetMapping("/findAll")
    public String findAll(Model model) throws IOException{
       List<BoardDTO> boardDTOList = boardService.findAll();
       model.addAttribute("boardList", boardDTOList);
       return "boardPages/list";
    }
    @GetMapping("/findById/{bid}")
    public String findById(@PathVariable Long bid, Model model) {
       BoardDTO boardDTO = boardService.findById(bid);
        System.out.println("==================================================");
        System.out.println(boardDTO.getBoardHits());
        System.out.println("dto"+boardDTO);
        System.out.println("==================================================");

        model.addAttribute("board", boardDTO);
        return "boardPages/detail";
    }


}
