package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Board;
import com.example.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTests{

	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testInsert() {
		Board board = new Board();
		board.setTitle("제목");
		board.setContent("내용...");
		board.setWriter("하이");
		
		boardRepo.save(board);
	}
	
	@Test
	public void testRead() {
		boardRepo.findById(1L).ifPresent((board)->{
		System.out.println(board);
		});
	}
	
	@Test
	public void testUpdate() {
		System.out.println("Read First.....");
		Board board = boardRepo.findById(1L).get();
		
		System.out.println("Update Title.....");
		board.setTitle("수정된 제목");
		
		System.out.println("Call Save( ).....");
		boardRepo.save(board);
	}
	
	@Test
	public void testDelete() {
		System.out.println("DELETE Entity ");
		
		boardRepo.deleteById(1L);
	}
}