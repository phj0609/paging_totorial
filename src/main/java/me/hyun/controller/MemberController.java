package me.hyun.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.protobuf.Service;

import me.hyun.model.Member;
import me.hyun.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("/success")
	public String success() {
		return "member/success";
	}
	
	@GetMapping("/list")
	public String memberList(Model model) {
		model.addAttribute("list", service.getList());
		return "member/list";
	}
	
	@GetMapping("/get")
	public String get(Long id, Model model) {
		model.addAttribute("member", service.get(id));
		return "member/get";
	}
	
	@GetMapping("/register")
	public String registerForm(Member member) {
		return "member/register";
	} 
	
	@GetMapping("/modify")
	public String modifyForm(Member member) {
		System.out.println(member);
		return "member/modify";
	}

	@PostMapping("/modify")
	public String modify(Member member) {
		service.modify(member);
		return "redirect:list";
	}
		
	@PostMapping("/register")
	public String register(@Valid Member member, Errors errors) {
//		new MemberValidator().validate(member, errors);
		if (errors.hasErrors()) {
			return "member/register";
		}
		return "redirect:success";
	}
	
	@PostMapping("/remove")
	public String remove(Long id, RedirectAttributes rttr) {
		service.remove(id);
		rttr.addFlashAttribute("message", id);
		return "redirect:list";
	}
	
}
