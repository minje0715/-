package com.its.memberboardproject.controller;

import com.its.memberboardproject.common.PagingConst;
import com.its.memberboardproject.dto.BoardDTO;
import com.its.memberboardproject.dto.CommentDTO;
import com.its.memberboardproject.service.BoardService;
import com.its.memberboardproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private final CommentService commentService;

    @GetMapping("/save-form")
    public String saveForm() {
        return "boardPages/save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) throws IOException {
        boardService.save(boardDTO);
        return "redirect:/board";
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "boardPages/list";
    }

    @GetMapping("/findById/{bid}")
    public String findById(@PathVariable Long bid, Model model) {
        BoardDTO boardDTO = boardService.findById(bid);
        model.addAttribute("board", boardDTO);
        List<CommentDTO> commentDTOList = commentService.findByBoardId(bid);
        model.addAttribute("commentList", commentDTOList);
        return "boardPages/detail";
    }

    @GetMapping("/update-form/{bid}")
    public String updateForm(@PathVariable Long bid, Model model) {
        BoardDTO boardDTO = boardService.findById(bid);
        model.addAttribute("board", boardDTO);
        return "boardPages/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO) {
        boardService.update(boardDTO);
        return "redirect:/board/findById/" + boardDTO.getBid();
    }

    @GetMapping("/deleteById/{bid}")
    public String deleteById(@PathVariable Long bid) {
        boardService.deleteById(bid);
        return "redirect:/board/findAll";
    }

    @GetMapping
    public String paging(@PageableDefault(page = 1) Pageable pageable, Model model) {
        Page<BoardDTO> boardList = boardService.paging(pageable);
        model.addAttribute("boardList", boardList);
        int startPage = (((int) (Math.ceil((double) pageable.getPageNumber() / PagingConst.BLOCK_LIMIT))) - 1) * PagingConst.BLOCK_LIMIT + 1;
        int endPage = ((startPage + PagingConst.BLOCK_LIMIT - 1) < boardList.getTotalPages()) ? startPage + PagingConst.BLOCK_LIMIT - 1 : boardList.getTotalPages();
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "boardPages/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("q")String q, @RequestParam("p")String p,
                         @PageableDefault(page = 1) Pageable pageable ,Model model) {
        Page<BoardDTO> boardList = boardService.search(pageable,q ,p);

        int startPage = (((int) (Math.ceil((double) pageable.getPageNumber() / PagingConst.BLOCK_LIMIT))) - 1) * PagingConst.BLOCK_LIMIT + 1;
        int endPage = ((startPage + PagingConst.BLOCK_LIMIT - 1) < boardList.getTotalPages()) ? startPage + PagingConst.BLOCK_LIMIT - 1 : boardList.getTotalPages();
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("q",q);
        model.addAttribute("p",p);
        model.addAttribute("searchList",boardList);
        return "boardPages/list";
    }
}
