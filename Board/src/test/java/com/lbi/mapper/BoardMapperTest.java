package com.lbi.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lbi.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(BoardMapperTest.class);
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testEnroll() {
		BoardVO vo = new BoardVO();
		vo.setTitle("mapper Test");
		vo.setContent("mapper Test");
		vo.setWriter("mapper Test");
		mapper.enroll(vo);
	}
}
