package com.decepticons.assetManagement.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.entity.LoginHistory;
import com.decepticons.assetManagement.entity.UserAuth;
import com.decepticons.assetManagement.services.protocols.IEmployeeService;
import com.decepticons.assetManagement.services.protocols.ILoginHistoryService;
import com.decepticons.assetManagement.services.protocols.IUserAuthService;
import com.decepticons.assetManagement.util.SessionObject;

@Controller
@RequestMapping("/userAuth")
@Scope("session")
@SessionAttributes("user")
public class UserAuthController {

	@Autowired
	private IUserAuthService uAuthService;

	@Autowired
	private IEmployeeService empService;

	@Autowired
	private ILoginHistoryService loginHistoryService;

	private List<UserAuth> userCredentials;

	@PostConstruct
	public void loadData() {
		userCredentials = new ArrayList<UserAuth>(uAuthService.findAll());
	}

	String userID_Name = "";

	@GetMapping("/login")
	public String requestLogin(Model model, @ModelAttribute("user") SessionObject session_emp) {

		String nextPage = "userAuth/login";
		System.out.println("from request login - Start");
		// System.out.println("****** session : " + session_emp + " session_emp != null
		// " + (session_emp != null));
		if (session_emp != null && session_emp.getUser() != null) {
			System.out.println("from request login - End 1");
			return "userAuth/Home";
		}

		System.out.println("from request login - End 2" + nextPage);
		return nextPage;
	}

	@PostMapping("/login")
	public String authenticateUser(@ModelAttribute("user") SessionObject session_emp, @RequestParam("userName") String userName, @RequestParam("password") String password, Model model) {
		System.out.println(" authenticateUser - start");
		String nextPage = "userAuth/Login";// redirect:/Login.html?loginError=true";
		String loginMessage = "The userID or password is incorrect!";

		System.out.println("****** userName " + userName + " password " + password + " session " + session_emp);

		// System.out.println(uAuthService.findAll());
		UserAuth user = uAuthService.findByUserName(userName);
		long currentDate = Calendar.getInstance().getTime().getTime();
		Date dt = new Date(currentDate);

		if (user != null) {
			System.out.println("user " + user + " password match " + (user.getPassword().equals(password)));

			if (user.getPassword().equals(password)) {
				loginMessage = "Success!";
				userID_Name = userName;
				// login historyInfo - start

				List<LoginHistory> loginHistoryCol = loginHistoryService.findByUsernameOrderByIdDesc(user.getUserName());

				System.out.println(" loginHistoryCol " + loginHistoryCol);
				LoginHistory loginHistory = (loginHistoryCol.size() > 0 ? loginHistoryCol.get(0) : null);

				if (loginHistory != null) {
					dt = loginHistory.getLastlogin();

				}

				System.out.println("login History " + loginHistory);

				loginHistory = new LoginHistory();
				loginHistory.setUsername(user.getUserName());
				loginHistory.setLastlogin(dt);

				loginHistoryService.save(loginHistory);

				// loginHistory - end

				System.out.println("dt  : " + dt);

				setUserAuthSession(session_emp, user, dt);

				nextPage = "userAuth/Home";
			} else {
				loginMessage = "The password is incorrect ";
			}
		}

		model.addAttribute("employee", user);
		model.addAttribute("lastLogin", dt);
		model.addAttribute("loginErrorMsg", loginMessage);
		System.out.println(" user " + user + " nextPage " + nextPage);

		System.out.println(" authenticateUser - End");
		return nextPage;
	}

	// set session user
	@ModelAttribute("user")
	public SessionObject setUserAuthSession(SessionObject session_emp, UserAuth user, Date lastloginTime) {

		System.out.println("****** setUserAuthSession :: Start ***********");
		System.out.println("input date  : " + lastloginTime);
		Employee emp = empService.findByUserName(user.getUserName());
		if (emp == null)
			return null;

		System.out.println("emp  :: " + emp + "input date  : " + lastloginTime + " session_emp : " + session_emp);

		SessionObject obj = new SessionObject();
		if (session_emp != null)
			obj = session_emp;

		obj.setUser(emp);
		obj.setLastLogin(lastloginTime);

		System.out.println(user + " => setting session " + obj);

		System.out.println("########## setUserAuthSession :: END ########## ");
		return obj;
	}

	@GetMapping("/Profile")
	public String Profile(@SessionAttribute("user") SessionObject user, Model model) {
		System.out.println(" MOdel -- user :" + user);
		model.addAttribute("employee", user.getUser());
		return "/Profile";
	}

	/*
	 * <frame src="http://localhost:8080/userAuth/Header" name="head"> <frameset
	 * cols="10%,90%"> <frame src="http://localhost:8080/userAuth/SideMenu"
	 * name="SIDE"> <frame src="http://localhost:8080/userAuth/Body" name="MAIN">
	 * </frameset> <frame src="http://localhost:8080/userAuth/Bottom" name="bottom">
	 */

	// start homepage - html
//	@GetMapping("Header")
//	public String getHeader(Model model)
//	{
//		return "/main/Header";
//	}
//	

	@GetMapping("/Home")
	public String sendToHome(@SessionAttribute("user") SessionObject user, Model model) {
		System.out.println(" ********* HOME MOdel -- user :" + user);

		model.addAttribute("employee", user.getUser());

		return "/main/Home";
	}

	@GetMapping("SideMenu")
	public String getSideMenu(@SessionAttribute("user") SessionObject user, Model model) {
		System.out.println(" ********* Side Menu MOdel -- user :" + user);

		model.addAttribute("employee", user.getUser());

		return "/main/SideMenu";
	}
//	
//	@GetMapping("Body")
//	public String getMainBody(Model model)
//	{
//		return "redirect:http://localhost:8080/employees/list";
//	}
//	
//	@GetMapping("Bottom")
//	public String getFooter(Model model)
//	{
//		return "/main/Bottom";
//	}

	// stop homepage - html

	@GetMapping("/list")
	public String listUserAuths(Model model) {
		loadData();
		model.addAttribute("userCredentials", userCredentials);
		return "list-UserAuth";

	}

	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model) {
		UserAuth userAuth = new UserAuth();
//		userAuth.setUserName(userName);
//		userAuth.setPassword(userName);

		model.addAttribute("empRecord", userAuth);

		return "userAuth/UserAuthForm";
	}

	@PostMapping("/save")
	public String saveUserAuthData(@ModelAttribute("empRecord") UserAuth userAuth) {

		System.out.println("saving.. " + userAuth);

		uAuthService.save(userAuth);

		System.out.println("Saved " + userAuth);
		return "redirect:/userAuth/list";
	}

	@GetMapping("/showForForUpdate")
	public String showFormForUpdate(@RequestParam("Id") String Id, Model model) {
		UserAuth userAuth = uAuthService.findById(Id);

		System.out.println("Saved " + userAuth);

		model.addAttribute("empRecord", userAuth);

		return "userAuth/UserAuthForm";
	}

	@GetMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("Id") String Id, Model model) {
		UserAuth userAuth = uAuthService.findById(Id);

		uAuthService.deleteById(Id);

		System.out.println("Deleted " + userAuth);
		return "redirect:/userAuth/list";
	}

//	@GetMapping("/Home")
//	public String Home()
//	{
//		return "Home";
//	}

	@GetMapping("/pricing-table")
	public String pricingTable() {
		return "pricing-table";
	}

	@GetMapping("/updatePassword")
	public String requestUpdatePassword(Model model) {

		System.out.println(" userID_Name :" + userID_Name);
		UserAuth userAuth = uAuthService.findByUserName(userID_Name);
		model.addAttribute("currentUser", userAuth);
		System.out.println("Calling from requestUpdatePassword");
		return "userAuth/UpdatePassword";
	}

	@PostMapping("/updatePassword")
	public String processUpdatePassword(@RequestParam Map<String, String> reqParam, Model model) {

		String nextPage = "/userAuth/updatePassword";

		String currentPassword = reqParam.get("current_password");
		String new_password_1 = reqParam.get("new_password_1");
		String new_password_2 = reqParam.get("new_password_2");

		UserAuth userAuth = uAuthService.findByUserName(userID_Name);

		model.addAttribute("currentUser", userAuth);
		String passwordUpdateStatus = "Incorrect current Password";

		// System.out.println(uAuthService.findAll());
		if (validateUserCredentials(userAuth, currentPassword)) {
			if (new_password_1.trim().equals(new_password_2.trim())) {
				userAuth.setPassword(new_password_1);
				uAuthService.save(userAuth);
				passwordUpdateStatus = "Successfully updated password!";
				nextPage = "/userAuth/Home";
			} else {
				passwordUpdateStatus = "New Passwords do not match";
			}
		}

		model.addAttribute("pageMsg", passwordUpdateStatus);
		System.out.println(" user " + userAuth + " nextPage " + nextPage + " model " + model);

		return nextPage;
	}

	private boolean validateUserCredentials(UserAuth userAuth, String password) {

		if (userAuth != null && userAuth.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
}
