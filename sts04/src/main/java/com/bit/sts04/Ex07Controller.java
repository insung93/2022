package com.bit.sts04;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex07Controller {

	@RequestMapping("/ex07")
	public String ex07(Model model, HttpSession session, String id, String pw) {
		model.addAttribute("msg", "ex07 page");
		System.out.println(session.getId());
		System.out.println(id);
		System.out.println(pw);
		return "ex01";
	}
}