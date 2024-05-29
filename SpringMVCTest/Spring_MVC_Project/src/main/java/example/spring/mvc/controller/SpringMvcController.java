package example.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import example.spring.mvc.model.User;
import example.spring.mvc.model.UserValidator;

@Controller//Marks this class as a Controller
@SessionAttributes({"validUserName"})
public class SpringMvcController {
	@RequestMapping("/showIndex")
	public String getIndexPage() {
		return "index";//Returning view name
	}
	
	@RequestMapping("/showLogin")//GET
	public String getLoginPage() {
		return "login";//Returning view name
	}
	
	@RequestMapping("/showLoginAgain")//GET
	public String getLoginPageAgain() {
		return "loginAgain";//Returning view name
	}
	
	@RequestMapping(value = "/doValidate", method = RequestMethod.POST)//POST
	public String doValidateUser(
			@RequestParam("user_name") String uid, 
			@RequestParam("user_password") String pwd
			) {
		String resultPage = "failure";
		User incomingUser = new User(uid, pwd);
		boolean found = UserValidator.isValid(incomingUser);
		if(found) {
			resultPage = "success";
		}
		return resultPage;
	}
	@RequestMapping(value = "/doValidateAgain", method = RequestMethod.POST)//POST
	public String doValidateUserAgain(
			@RequestParam("user_name") String uid, 
			@RequestParam("user_password") String pwd,
			Model dataModel
			) {
		String resultPage = "failureAgain";
		User incomingUser = new User(uid, pwd);
		boolean found = UserValidator.isValid(incomingUser);
		if(found) {
			//Adding username to dataModel
			dataModel.addAttribute("validUserName", uid);
			resultPage = "successAgain";
		}
		return resultPage;
	}
}
