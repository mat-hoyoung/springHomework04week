package com.sparta.springproject4week.controller;

import com.sparta.springproject4week.dto.BoardDeleteRequestDto;
import com.sparta.springproject4week.dto.BoardRequestDto;
import com.sparta.springproject4week.dto.BoardUpdateRequestDto;
import com.sparta.springproject4week.model.*;
import com.sparta.springproject4week.repository.Boardrepository;
import com.sparta.springproject4week.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController

public class BoardRestController {

    private final BoardService boardService;
    private final Boardrepository boardRepository;


    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return board;
    }

    @GetMapping("/api/boards")
    public List<Board> getBoards() {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @PutMapping("/api/boards/{id}")
    public Long updataBoard(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        if (requestDto.getPassword().equals(board.getPassword())) {
            boardService.update(id, requestDto);
        }

        return id;
    }

    @DeleteMapping("/api/boards/{id}")
    public Long deleteBoard(@PathVariable Long id, @RequestBody BoardDeleteRequestDto requestDto) {      //pathvariable은 경로에있는 id 값을 불러주기위해 사용하는것 , 없으면 id에서 오류뜸
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        if (requestDto.getPassword().equals(board.getPassword())) {
            boardRepository.deleteById(id);

        }
        return id;
    }


}