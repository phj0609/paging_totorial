package me.hyun.config;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.hyun.AppTest;
import me.hyun.mapper.MemberMapper;
import me.hyun.model.Member;

public class MemberMapperTest extends AppTest{

	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void getListTest() {
		List<Member> list = memberMapper.getList();
		assertEquals(4, list.size());
	}
	
	@Test
	public void insertTest() {
		Member member = new Member();
		member.setUserName("이름 테스트");
		member.setPassword("13456478");
		member.setEmail("comjafa@comjafa");
		memberMapper.insert(member);
	}
	
}
