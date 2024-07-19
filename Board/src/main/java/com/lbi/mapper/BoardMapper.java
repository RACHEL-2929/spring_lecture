package com.lbi.mapper;

import java.util.List;

import com.lbi.model.BoardVO;
import com.lbi.model.Criteria;

public interface BoardMapper {
	public void enroll(BoardVO board);

	public List<BoardVO> getList();

	public BoardVO getPage(int bno);

	public int modify(BoardVO board);

	public int delete(int bno);

	public List<BoardVO> getListPaging(Criteria cri);

	public int getTotal(Criteria cri);
	
	
}
