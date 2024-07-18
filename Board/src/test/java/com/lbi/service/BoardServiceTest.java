package com.lbi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lbi.mapper.BoardMapper;
import com.lbi.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTest {

	private static final Logger log = LoggerFactory.getLogger(BoardServiceTest.class);

	@Autowired
	private BoardService service;

	@Autowired
	private BoardMapper mapper;

	/*
	 * @Test public void testEnroll() {
	 * 
	 * BoardVO vo = new BoardVO();
	 * 
	 * vo.setTitle("service Test"); vo.setContent("service Test");
	 * vo.setWriter("service Test"); service.enroll(vo); }
	 */

	/*
	 * @Test public void testGetList() { service.getList().forEach(board ->
	 * log.info(""+board)); }
	 */

	@Test
	public void testGetPage() {

		int bno = 8;
		log.info("" + mapper.getPage(bno));
	}

	/*
	 * @Test public void testModify() {
	 * 
	 * BoardVO board = new BoardVO(); board.setBno(8); board.setTitle("수정 제목");
	 * board.setContent("수정 내용");
	 * 
	 * int result = mapper.modify(board); log.info("result : " + result); }
	 */

}
