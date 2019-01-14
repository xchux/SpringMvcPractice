package com.tutorial.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tutorial.Dao.MemberRepository;
import com.tutorial.Model.MemberAccountJPA;

@Controller
public class MemberController {
	// 透過 @RequestMapping 指定從/會被對應到此hello()方法
	/*@Autowired
	MemberAccount memberAccount;

	@Autowired
	MemberService memberService;*/

	/*@GetMapping	
	 * public String hello(){ memberAccount = new MemberAccount();
	 * memberAccount.setPassword("12345678");
	 * memberAccount.setEmail("test@gmail.com");
	 * memberAccount.setCellphone("0912345789"); memberAccount.setAddress("台北市");
	 * memberService.addMember(memberAccount); return "新增會員成功"; }
	 */
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	DataSource dataSource;
	
	@GetMapping("/login")
    public String login(@ModelAttribute MemberAccountJPA memberAccountJPA){

        return "login";
    }
	
	@PostMapping("/doLogin")
    public String doLogin(@ModelAttribute MemberAccountJPA memberAccountJPA){
		System.out.println(memberRepository.findCheckMemberAccount(memberAccountJPA.getEmail(), memberAccountJPA.getPassword()));

        return "welcome";
    }
}