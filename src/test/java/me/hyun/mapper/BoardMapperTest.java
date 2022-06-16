package me.hyun.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.hyun.AppTest;
import me.hyun.model.Board;

public class BoardMapperTest extends AppTest{

	@Autowired
	private BoardMapper boardMapper;
	
//	@Test
//	public void getListTest() {
//		List<Board> list = boardMapper.getList();
//		assertEquals(8, list.size());
//	}
//	
	@Test
	@Ignore
	public void insertTest() {
		Board board = new Board();
		board.setTitle("제목 테스트임");
		board.setContent("내용 테스트임");
		board.setWriter("작성자");
		boardMapper.insert(board);
	}
	
	@Test
	@Ignore
	public void updateTest() {
		Board board = boardMapper.get(1L);
		board.setTitle("제목수정함");
		board.setContent("내용수정함");
		boardMapper.update(board);
		assertEquals("제목수정함", board.getTitle());
		assertEquals("내용수정함", board.getContent());
		assertEquals("집으로", board.getWriter());
	}
	
	@Test
	public void dataInsert() {
		for (int i = 1; i <= 412; i++) {
			Board board = new Board();
			board.setTitle("spring 연습" + i);
			board.setContent("jsp 연습" + i);
			board.setWriter("글쓴이");
			boardMapper.insert(board);
		}
	}
	
}
