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
import mlm.admin.module.project.model.AdminLogin;
import mlm.admin.module.project.model.AdminRegister;
import mlm.admin.module.project.model.User;
import mlm.admin.module.project.service.AdminService;
import mlm.admin.module.project.service.MailService;


@Controller
public class AdminController 
{
	
	@Autowired
	private AdminService adminService;
	
	
	@Autowired
	private PinGeneratorDAO pin;
	
	
	@Autowired
	private MailService mailService;
	
	
	// SHOW ADMIN LOGIN FORM
	@RequestMapping("/login-admin")
	public String showAdminLoginForm(Model model)
	{
		AdminLogin adminLogin = new AdminLogin();
		
		model.addAttribute("adminLogin", adminLogin);
		
		return "login-admin";
	}
	
	
	// LOGIN ADMIN
	@RequestMapping("/loginAdmin")
	public String loginAdmin(@ModelAttribute("adminlogin") AdminLogin adminlogin, Model model , HttpServletRequest req, HttpSession session)
	{	
		
		int count = 0, count1 = 0;
		
		String username = null;
		String password = null;
	
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		
		
		List<AdminRegister> loginadmin = adminService.adminLogin(adminlogin);
		
		for(AdminRegister data: loginadmin)
		{
			username = data.getUsername();
			password = data.getPassword();
		}

		if( user.equals(username) && pass.equals(password))
		{
			System.out.println("\n LOGIN SUCCESS");

			System.out.println("\n" +adminlogin);
			
			
			// FOR SHOWING COUNT OF TOTAL USERS & TOTAL PIN REQUEST IN ADMIN DASHBOARD
			List<User> allUsers = adminService.getAllUsers();
			
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
			
			System.out.println("\n TOTAL USERS COUNT IN ADMIN DASHBOARD : "+totalUsersCount);
			
			req.setAttribute("usersCount", totalUsersCount);
			
			count = 0;
			
			
			// FOR SHOWING COUNT OF TOTAL PINS GENERATED IN ADMIN DASHBOARD
			List<User> allUsersPinRequest = adminService.getAllPinRequest();
			
			for (User usersPin : allUsersPinRequest) 
			{
				usersPin.getId();
				usersPin.getEmail();
				usersPin.getPin();
				
				count1++;
			}
			
			String totalPinsCount = String.valueOf(count1);
			
			System.out.println("\n TOTAL PINS GENERATED COUNT : "+totalPinsCount);
			
			req.setAttribute("pinsCount", totalPinsCount);
			
			count1 = 0;
			
			session.setAttribute("username", username);
			
			
			// SHOW ADMIN COMMISSION IN ADMIN PALETTE
			int totalAmount = adminService.showAdminCommission();
			
			System.out.println("\n TOTAL USER'S AMOUNT : "+totalAmount);
			
			req.setAttribute("totalAmount", totalAmount);
			
			int b = 5;
			
			int c = totalAmount*b/100 ;
			
			String finalAmount = String.valueOf(c);
			
			System.out.println("\n COMMISSION IS : " +finalAmount);
			
			req.setAttribute("finalAmount", finalAmount);
			
			return "admin-dashboard";
		}
		else
		{
			System.out.println("\n LOGIN FAILED");
			
			String message = "Invalid Username Or Password";
			
			model.addAttribute("message",message);
			
			return "login-admin";
		}

	}
	
	
	// ADMIN LOGOUT
	@RequestMapping("/adminLogout")
	public String adminLogout(HttpSession session)
	{
		session.removeAttribute("username");
		
		return "login-admin";
	}
	
	
	// SHOW ADMIN REGISTRATION FORM
	@RequestMapping("/showAdminRegister")
	public String showAdminRegistrationForm(Model model)
	{
		AdminRegister adminregister = new AdminRegister();
		
		model.addAttribute("adminregister", adminregister);
		
		return "register-admin";
	}
	
	
	// INSERT ADMIN DATA INTO TABLE && REGISTER ADMIN
	@RequestMapping("/registerAdmin")
	public String registerAdmin(@ModelAttribute("adminregister") AdminRegister adminregister, Model model, HttpServletRequest req)
	{
		
		String password = req.getParameter("password");
		String confirmpassword = req.getParameter("confirmpassword");
		
		if( password.equals(confirmpassword) )
		{
			int register = adminService.adminRegister(adminregister);
			
			System.out.println("\n DATA INSERTED SUCCESSFULLY");
			
			System.out.println("\n " +adminregister);
			
			return "login-admin";
		} 
		else
		{
			String message = "Registration Failed";
			
			model.addAttribute("message", message);
			
			return "register-admin";
		}
		
	}
	
	
	// GET ALL USERS ON ADMIN DASHBOARD
	@RequestMapping("/showAllUsers")
	public String getAllUsers(Model model, HttpServletRequest req)
	{
		List<User> allUsers = adminService.getAllUsers();
		
		model.addAttribute("allUsers", allUsers);
		
		System.out.println(" \n All Records : \n " +allUsers);
		
		
		// GETTING SESSION VALUE OF ADMIN
		HttpSession httpSession = req.getSession();
		Object attribute = httpSession.getAttribute("username");
		String topUserid = String.valueOf(attribute);
		System.out.println("\n ADMIN USERNAME IS : "+topUserid);
		
		return "admin-allusers";
	}
	
	
	// GET ALL PIN REQUESTS ON ADMIN DASHBOARD
	@RequestMapping("/viewPinRequestAdmin")
	public String viewPinRequestAdmin(Model model)
	{
		List<User> allUsers = adminService.getAllUsers();
		
		model.addAttribute("allUsers", allUsers);
		
		System.out.println(" \n All Records : \n " +allUsers);
		
		return "admin-pin-request";
	}
	
	
	// GENERATE PIN FOR PARTICULAR USER
	@RequestMapping("generatePin/{id}")
	public String populateFormForAdminPin(@PathVariable int id, Model model, HttpSession httpSession, HttpServletRequest req)
	{
		String s = null, s1=null;
		
		List<User> singleUser = adminService.getSingleUser(id);
		
		for (User user : singleUser) 
		{
			s1 = user.getTopuserid();
			s = user.getEmail();
		}
		
		model.addAttribute("singleUser",singleUser);
		
		httpSession.setAttribute("email", s);
		
		req.setAttribute("topUserId", s1);
		
		System.out.println(" \n POPULATED USER ID : "+id);
		
		char[] pinPin = pin.generatePin(6);
		
		String ste = String.valueOf(pinPin);
		
		System.out.println("\n GENERATED PIN : "+ste);
		
		req.setAttribute("pinPin", ste);
		
		return "admingenerate-pin";
	}
	
	
	// SAVE PIN IN DB WITH PARTICULAR USER'S EMAILID
	@RequestMapping("/savePin")
	public String savePin(@ModelAttribute("singleUser") User user, Model model, HttpSession httpSession, HttpServletRequest req)
	{
	
		model.addAttribute("singleUser", user);
		
		//String email = (String) httpSession.getAttribute("email");
		
		//String pinOtp = req.getParameter("pin");
		
		//req.setAttribute("email", email);
		
		String p = req.getParameter("topuserid");
		String p1 = req.getParameter("email");
		String p2 = req.getParameter("pin");
		
		System.out.println("\n TOPUSERID : " +p + " || " + " EMAIL : "+p1 + " || " + " PIN : "+p2);
		
		int savePin = adminService.savePin(user);
		
		String content = "\n Below is a Pin as a password for user to login with system \n\n";
		content+= "\n\n Email ID : "+user.getEmail();
		content+= "\n\n Pin : "+user.getPin();
		
		String subject = "Generated pin for the user";
		
		mailService.sendPin(user.getTopuserid(), user.getEmail(), subject, content);
		
		System.out.println("\n RECORD INSERTED SUCCESSFULLY : "+savePin);
		
		return "redirect:/viewPinRequestAdmin";
		
	}
	
	
	// SHOW ALL USERS WITH AMOUNT FOR COMMISSION GENERATED
	@RequestMapping("/showUsersRevenue")
	public String showAllUsersRevenue(Model model)
	{
		
		List<User> allUsers = adminService.getAllUsers();
		
		model.addAttribute("allUsers", allUsers);
		
		System.out.println(" \n All Records : \n " +allUsers);
		
		return "admin-revenue";
	}
	
	
	// CHECK ADMIN USERNAME IS ALREADY EXIST IN DB
	@RequestMapping("/checkUsername")
	@ResponseBody
	public String checkUsernameExist(@RequestParam String username)
	{
		
		if( adminService.isUsernameExist(username) )
		{
			return "**Username is already exist please enter different";
		}
		else
		{
			return "**Correct Username";
		}
		
	}

}
