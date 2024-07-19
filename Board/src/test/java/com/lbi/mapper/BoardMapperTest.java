package com.lbi.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lbi.model.BoardVO;
import com.lbi.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(BoardMapperTest.class);
	@Autowired
	private BoardMapper mapper;

	@Test
	public void testGetListPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(2);
		List<BoardVO> list = mapper.getListPaging(cri);
		list.forEach(board -> log.info("" + board));

		
	}

	/*
	 * @Test public void testDelete() { int result = mapper.delete(21);
	 * log.info("result : "+ result); }
	 */

	/*
	 * @Test public void testGetPage() {
	 * 
	 * int bno = 8; log.info("" + mapper.getPage(bno)); }
	 */

	/*
	 * @Test public void testEnroll() { BoardVO vo = new BoardVO();
	 * vo.setTitle("mapper Test"); vo.setContent("mapper Test");
	 * vo.setWriter("mapper Test"); mapper.enroll(vo); }
	 */
}
