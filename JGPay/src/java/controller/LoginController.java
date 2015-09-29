package controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.UserDAO;
import model.User;
@Controller
public class LoginController {
	
	@RequestMapping("loginForm")
	public String loginForm(){
		return "formulario-login";
	}
	
	
	@RequestMapping("login")
	public String login(User usuario,HttpSession session){
		User userBD = new UserDAO().returnUser(usuario);

		if(userBD != null){
			session.setAttribute("user",userBD.getIdUser());
			session.setAttribute("userLogged",userBD);
			
			return "menu";
		}return "redirect:loginForm";
	}

}