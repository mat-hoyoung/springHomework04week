package com.sparta.springproject4week.repository;

import com.sparta.springproject4week.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Boardrepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByModifiedAtDesc();
}
