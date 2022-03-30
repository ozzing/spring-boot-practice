package com.example.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	
	public List<Board> findBoardByTitle(String title);
	
	public Collection<Board> findByWriter(String writer);
	
	public Collection<Board> findByWriterContaining(String writer);
	
	public Collection<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	public Collection<Board> findByTitleContainingAndBnoGreaterThan(String keyword, Long num);
	
	public List<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno, Pageable paging);
	
	public Page<Board> findByBnoGreaterThan(Long bno, Pageable paging);
	
}