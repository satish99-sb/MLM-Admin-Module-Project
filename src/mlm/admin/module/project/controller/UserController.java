package mlm.admin.module.project.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mlm.admin.module.project.dao.PinGeneratorDAO;
import mlm.admin.module.project.model.User;
import mlm.admin.module.project.service.MailService;
import mlm.admin.module.project.service.UserService;


@Controller
public class UserController 
{
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private MailService mailService;
	
	
	@Autowired
	private PinGeneratorDAO pin;
	
	
	// SHOW USER LOGIN FORM
	@RequestMapping("/")
	public String showUserLoginForm(Model model)
	{
		User user = new User();
		
		model.addAttribute("user", user);
		
		return "login-user";
	}
	
	
	// LOGIN USER
	@RequestMapping("/user-login")
	public String loginUser(@ModelAttribute("user") User user, Model model, HttpServletRequest req, HttpSession httpSession)
	{
		int count = 0;
		
		String email = null;
		String pin = null;
		
		String userEmail = req.getParameter("email");
		String userPin = req.getParameter("pin");
		
		List<User> userLogin = userService.userLogin(user);
		
		for (User userlogin : userLogin) 
		{
			email = userlogin.getEmail();
			pin = userlogin.getPin();
		}
		
		if( userEmail.equals(email) && userPin.equals(pin) )
		{
			System.out.println("\n LOGIN SUCCESSFUL \n");
			
			System.out.println(user);
			
			httpSession.setAttribute("email", email);
			
			
			// FOR SHOWING COUNT OF TOTAL USERS IN USER DASHBOARD
			List<User> allUsers = userService.getAllUsersBytopUserId(email);
			
			for (User u : allUsers) 
			{			
				u.getId();
				u.getTopuserid();
				u.getEmail();
				u.getGender();
				u.getMobileno();
				u.getAccountno();
				u.getAddress();
				u.getUserside();
				u.getAmount();
				
				count++;
		
			}
			
			String totalUsersCount = String.valueOf(count);
			
			System.out.println("\n TOTAL USERS IN USER DASHBOARD : "+totalUsersCount);
			
			req.setAttribute("usersCount", totalUsersCount);
			
			req.setAttribute("usersPinCount", totalUsersCount);
			
			count = 0;
			
			
			// SHOW PIN REQUEST FOR PARTICULAR USER ON USER DASHBOARD
			
			
			// SHOW USER COMMISSION IN USER PALETTE
			httpSession = req.getSession();
			Object attribute = httpSession.getAttribute("email");
			String emailId = String .valueOf(attribute);
			System.out.println("\n USER USERNAME IS : "+emailId);
			
			int totalAmount = userService.showUserCommission(emailId);
			
			System.out.println("\n TOTAL INCOME OF " +emailId+ " IS : " +totalAmount);
			
			req.setAttribute("totalAmount", totalAmount);
			
			int rate = 5;
			
			int totalCommission = totalAmount * rate/100;
			
			String finalCommission = String.valueOf(totalCommission);
			
			System.out.println("\n USER'S COMMISSION IS :"+finalCommission);
			
			req.setAttribute("finalCommission", finalCommission);
			
			return "user-dashboard";
		}
		else
		{
			System.out.println("\n LOGIN FAILED");
			
			String message = "Invalid Username Or Password";
			
			model.addAttribute("message",message);
			
			return "login-user";
		}
	}
	
	
	// LOGOUT USER
	@RequestMapping("/userLogout")
	public String logoutUser(HttpSession httpSession)
	{
		httpSession.removeAttribute("email");
		
		return "login-user";
	}
	
	
	// SHOW USER REGISTRATION FORM
	@RequestMapping("/showUserRegistrationForm")
	public String showUserRegistrationForm(Model model)
	{
		User user = new User();
		
		model.addAttribute("user", user);
		
		return "register-user";
	}
	
	
	// REGISER NEW USER
	@RequestMapping("/registerUser")
	public String registerNewUser(@ModelAttribute("user") User user, Model model, HttpServletRequest req)
	{
		
		String content="\n Below are the details of new user. Please provide new pin to activate his account";
		content += "\n User's Email is : " +user.getEmail();
		content += "\n User's Top User ID is : " +user.getTopuserid();
		content += "\n User's Account No is : " +user.getAccountno();
		content += "\n User's Mobile No is : " +user.getMobileno();
		content += "\n User's Address is : " +user.getAddress();
		content += "\n User's Side below Top User is : " +user.getUserside();
		content += "\n User's Amount is : " +user.getAmount();
		
		String subject = "Pin Request to activate account";
		
		int userRegister = userService.userRegister(user);

		mailService.send(user.getEmail(), user.getTopuserid(), subject, content);
		
		System.out.println("\n E-MAIL SENT SUCCESSFULLY ");
		
		System.out.println("\n USER DATA INSERTED SUCCESSFULLY ");
		
		System.out.println("\n" +user);
		
		return "login-user";
		
	}
	
	
	// SHOW ALL USERS LIST IN TOTAL USERS PALETTE IN USER DASHBOARD
	@RequestMapping("/showAllUsersInUser")
	public String getAllUsers(User user, Model model, HttpServletRequest req)
	{
		
		HttpSession session = req.getSession();
		
		Object attribute = session.getAttribute("email");
		
		String emailId = String.valueOf(attribute);
		
		System.out.println("\n SESSION VALUE IN USERS ALL LIST IS : "+emailId);
		
		List<User> allUsersByTopUserID = userService.getAllUsersBytopUserId(emailId);
		
		model.addAttribute("allUsersByTopUserID", allUsersByTopUserID);
		
		System.out.println("\n ALL USERS LIST WITH EMAIL-ID : "+allUsersByTopUserID);
		
		return "users-allusers";
	}
	
	
	// VIEW ALL PIN FOR USER
	@RequestMapping("/viewAllPinOfUser")
	public String viewAllPinByEmailID(User user, Model model, HttpServletRequest req)
	{
		
		HttpSession session = req.getSession();
		
		Object attribute = session.getAttribute("email");
		
		String emailId = String.valueOf(attribute);
		
		System.out.println("\n SESSION VALUE IN VIEW PIN IS : "+emailId);
		
		List<User> allUsersByTopUserID = userService.getAllUsersBytopUserId(emailId);
		
		model.addAttribute("allPinsByEmailId", allUsersByTopUserID);
		
		System.out.println("\n VIEW ALL PIN : "+allUsersByTopUserID);
		
		return "user-viewpin";
	}
	
	
	// GENERATE PIN FOR PARTICULAR USER
	@RequestMapping("generatePinForUser/{id}")
	public String populateFormForAdminPin(@PathVariable int id, Model model, HttpSession httpSession, HttpServletRequest req)
	{
		String s1 = null, s2=null;
			
		List<User> singleUser = userService.getSingleUser(id);
			
		for (User userNew : singleUser) 
		{
			s1 = userNew.getTopuserid();
			s2 = userNew.getEmail();
		}
			
		model.addAttribute("singleUser",singleUser);
		
		httpSession.setAttribute("topUserId", s1);
			
		req.setAttribute("downuserid", s2);
			
		System.out.println(" \n POPULATED USER ID : "+id);
			
		char[] pinPin = pin.generatePin(6);
			
		String userPin = String.valueOf(pinPin);
			
		System.out.println("\n GENERATED PIN : "+userPin);
			
		req.setAttribute("pinPin", userPin);
			
		return "usergenerate-pin";
	}
	
	
	@RequestMapping("/savePinForUser")
	public String savePinForUser(@ModelAttribute("singleUser") User user, Model model, HttpSession httpSession, HttpServletRequest req)
	{
		String topUserId = req.getParameter("email");
		String emailId = req.getParameter("downuserid");
		String userPin = req.getParameter("pin");
		
		System.out.println("\n TOPUSERID : "+ topUserId + " || " + " EMAILID : "+ emailId + " || " + " USER-PIN : "+userPin);
		
		int savePin = userService.savePin(user);
		
		String content = "\n Below is a Pin as a password for user to login with system \n\n";
		content+= "\n\n Email ID : "+user.getEmail();
		content+= "\n\n Pin : "+user.getPin();
		
		String subject = "Generated pin for the user";
		
		mailService.sendPin(user.getTopuserid(), user.getEmail(), subject, content);
		
		System.out.println("\n RECORD INSERTED SUCCESSFULLY : "+savePin);
		
		return "redirect:/showAllUsersInUser";
	}
	
	
	// CHECK ADMIN USERNAME IS ALREADY EXIST IN DB
	@RequestMapping("/checkEmailid")
	@ResponseBody
	public String isEmailExist(@RequestParam String emailId)
	{
		if( userService.isEmailExist(emailId) )
		{
			return "**Username is already exist please enter different";
		}
		else
		{
			return "**Correct Username";
		}
	}
	
}
