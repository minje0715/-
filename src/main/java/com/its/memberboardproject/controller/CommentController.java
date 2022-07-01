package com.its.memberboardproject.controller;

import com.its.memberboardproject.dto.CommentDTO;
import com.its.memberboardproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/save")
    public @ResponseBody List<CommentDTO> save(@ModelAttribute CommentDTO commentDTO) {
       commentService.save(commentDTO);
      List<CommentDTO> commentDTOList = commentService.findByBoardId(commentDTO.getBoardId());
      return commentDTOList;
    }
}

