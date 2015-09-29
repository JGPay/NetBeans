package controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.CreditCardDAO;
import model.User;

@Controller
public class FunctionsController {
	
	public boolean paymentAuthorization(){
		return false;
	}
	
	@RequestMapping("acceptPaymentMobileCard")
	public ModelAndView acceptPaymentMobileCard(HttpSession session){
		ModelAndView mv = new ModelAndView("acceptPaymentMobileCard");
		User usuario = (User)session.getAttribute("usuarioLogado");
		if(usuario != null){
				List<String> lista = new CreditCardDAO().returnPendingActivationCreditCards(usuario);
				mv.addObject("listaCreditCard", lista);
			return mv;
		}
		mv.setViewName("formulario-login");
		return mv;
	}
}