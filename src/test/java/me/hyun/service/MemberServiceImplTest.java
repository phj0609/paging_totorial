package me.hyun.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.hyun.AppTest;
import me.hyun.model.Member;

public class MemberServiceImplTest extends AppTest{

	@Autowired
	MemberService service;
	
	@Test
	public void getListTest() {
		List<Member> list = service.getList();
		assertEquals(5, list.size());
	}

}
