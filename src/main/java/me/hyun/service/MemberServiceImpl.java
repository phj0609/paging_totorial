package me.hyun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.hyun.mapper.MemberMapper;
import me.hyun.model.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public List<Member> getList() {
		return memberMapper.getList();
	}

	@Override
	public void insert(Member member) {
		memberMapper.insert(member); 
		
	}

	@Override
	public void delete(Long id) {
		memberMapper.delete(id);
	}

	@Override
	public void update(Member member) {
		memberMapper.update(member);
	}

	@Override
	public Member get(Long id) {
		return memberMapper.get(id);
	}

	@Override
	public void modify(Member member) {
		
		
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}


}