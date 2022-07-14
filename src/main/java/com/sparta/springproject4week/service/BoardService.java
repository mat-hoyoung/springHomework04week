package com.sparta.springproject4week.service;

import com.sparta.springproject4week.model.Board;
import com.sparta.springproject4week.model.BoardUpdateRequestDto;
import com.sparta.springproject4week.model.Boardrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final Boardrepository boardRepository;

    @Transactional
    public Long update(Long id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return id;
    }
}
