package com.example;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.domain.Board;
import com.example.persistence.BoardRepository;

@SpringBootTest
class Boot03ApplicationTests {

	@Autowired
	private BoardRepository repo;
	
	@Test
	public void testInsert200() {
		for (int i=1;i<=200;i++) {
			
			Board board = new Board();
			board.setTitle("제목..."+i);
			board.setContent("내용..."+i+" 채우기");
			board.setWriter("user0"+(i%10));
			repo.save(board);
		}
	}

	@Test
	public void testByTitle() {
		repo.findBoardByTitle("제목...177").forEach(board -> System.out.println(board));
	}
	
	@Test
	public void testByWriter() {
		Collection<Board> results = repo.findByWriter("user00");
		results.forEach(board -> System.out.println(board));
	}
	
	@Test
	public void testByWriterContaining() {
		Collection<Board> results = repo.findByWriterContaining("05");
		results.forEach(board -> System.out.println(board));
	}

	@Test
	public void testByTitleOrContent() {
		Collection<Board> results = repo.findByTitleContainingOrContentContaining("15", "...77");
		results.forEach(board -> System.out.println(board));
	}
	
	@Test
	public void testByTitleAndBno() {
		Collection<Board> results = repo.findByTitleContainingAndBnoGreaterThan("5", 50L);
		results.forEach(board -> System.out.println(board));
	}
	
	@Test
	public void testBnoOrderByPaging() {
		Pageable paging = PageRequest.of(0, 10);
		Collection<Board> results = repo.findByBnoGreaterThanOrderByBnoDesc(0L, paging);
		results.forEach(board -> System.out.println(board));
	}
	
	@Test
	public void testBnoPagingSort() {
		Pageable paging = PageRequest.of(0, 10, Sort.Direction.ASC, "bno");
		Collection<Board> results = repo.findByBnoGreaterThan(0L, paging);
		results.forEach(board -> System.out.println(board));
	}
}
