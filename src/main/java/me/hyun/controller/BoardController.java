package me.hyun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.hyun.model.Board;
import me.hyun.model.Criteria;
import me.hyun.model.PageMaker;
import me.hyun.service.BoardService;
import me.hyun.validation.BoardValidator;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	BoardService service; 
	
	@GetMapping("list")
	public String boardList(Model model, Criteria criteria) {
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(service.totalCount()); 
		System.out.println("시작페이지 : " + pageMaker.getStartPage());
		System.out.println("끝 페이지 : " + pageMaker.getEndPage());
		model.addAttribute("list", service.getList(criteria));
		model.addAttribute("pageMaker", pageMaker);
		return "board/list";
	}

	@GetMapping("/get")
	public String get(Long bno, Model model) {
		model.addAttribute("board", service.get(bno));
		return "board/get";
	}
	
	@GetMapping("/modify")
	public String modifyForm(Long bno, Model model) {
		model.addAttribute("board", service.get(bno));
		return "board/modify";
	}

	@PostMapping("/modify")
	public String modify(Board board, RedirectAttributes rttr) {
		service.modify(board);
		rttr.addFlashAttribute("message", board.getBno());
		return "redirect:list";
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		service.remove(bno);
		rttr.addFlashAttribute("message", bno);
		return "redirect:list";
	}
	
	@GetMapping("/register")
	public String registerForm(Board board) {
		return "board/register";
	}
	
	@PostMapping("/register")	
	public String register(Board board, Errors errors) {
		new BoardValidator().validate(board, errors);
		if (errors.hasErrors()) {
			return "board/register";
		}
		System.out.println("제목 : " + board.getTitle());
		System.out.println("내용 : " + board.getContent());
		System.out.println("작성자 : " + board.getWriter());
		return "redirect:list";
	}
	
	
}
