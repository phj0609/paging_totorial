package me.hyun.service;

import java.util.List;

import me.hyun.model.Board;
import me.hyun.model.Criteria;

public interface BoardService {
	List<Board> getList(Criteria criteria);
	Board get(Long bno);
	void register(Board board);
	void modify(Board board);
	void remove(Long bno);
	int totalCount(Criteria criteria);
}
