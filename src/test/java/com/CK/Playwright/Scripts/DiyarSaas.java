package com.CK.Playwright.Scripts;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.CK.Playwright.Pages.DSHomePage;
import com.CK.Playwright.Pages.DSLoginPage;
import com.CK.Playwright.Pages.DSPage;
import com.Diyar.Playwright.Reporting.Reporting;
import com.Diyar.Playwright.Util.Util;

import io.qameta.allure.Description;
import io.qameta.allure.Step;


public class DiyarSaas extends DiyarSaas_Lib{
	
	@Step
	@Description("Invalid tenant error")
	@Test
	public void TS051_Login_with_invalid_tenant() {
		
		String Tenant = getdata("Tenant"); // "asdfgh";
		String Given_tenant_doesnt_exist = "Given tenant doesn\'t exist:";
		
		page.navigate(sURL);
		
		DSPage.LoginBtn.click("Login Btn");
		Assert.assertEquals("Login Btn","Login Btn");
		
		Util.sleepforseconds(5);
		DSLoginPage.Tenant_Switch_Btn.click("switch button in tenant");
		Util.sleepforseconds(3);
		DSLoginPage.Switch_Tenant_Name.fill(Tenant, "tenant name");
		DSLoginPage.Switch_Tenant_Save.click("Save button in Switch tenant");
		Util.sleepforseconds(5);
		
		lib.screenshotToAllure("line num 36", "image here");
		
		DSLoginPage.Switch_Tenant_DoesnotExist.verifyElementPresent("Tenant does not exist error");
		
		System.out.println(" Tenant error : " + DSLoginPage.Switch_Tenant_DoesnotExist.textContent());

		Util.verifyText(Given_tenant_doesnt_exist +" "+ Tenant, DSLoginPage.Switch_Tenant_DoesnotExist.textContent());
		
		DSLoginPage.Switch_Tenant_Ok.click("Ok button in switch tenant");
		
		
	}
	@Test
	@Step
	@Description("Login with valid tenant")
	public void TS052_Login_with_valid_tenant() {
		
		String User =  getdata("Username");  //"admin";
		String Pass =  getdata("Password"); // "P9$!nf5*jB9wiK";
		String Tenant = getdata("Tenant"); // "knpc";
		
		page.navigate(sURL);
		
		
		if(!DSHomePage.Avatar.isElementPresent()) {
		login(Tenant, User, Pass);
		}
		
		DSHomePage.Avatar.click("Admin");
		DSHomePage.Logout.click("Logout");
		Util.sleepforseconds(5);
		
	}

	@Step
	@Test
	public void TS053_Login_with_empty_credentials() {
	
		String Tenant = getdata("Tenant"); // "knpc";
		
		page.navigate(sURL);
		
		if(!DSHomePage.Avatar.isElementPresent()) {
			login(Tenant, "", "");
			}else {
				Reporting.info("System already logged in");
				DSHomePage.Avatar.click("Admin");
				DSHomePage.Logout.click("Logout");
				Util.sleepforseconds(10);
				login(Tenant, "",""); 
			}
		
		
		DSLoginPage.Username_RequiredError.verifyElementPresent("Username RequiredError");
		DSLoginPage.Password_RequiredError.verifyElementPresent("Password RequiredError");
		
		System.out.println("username error : " + DSLoginPage.Username_RequiredError.textContent());
		System.out.println("pwd error : " + DSLoginPage.Password_RequiredError.textContent());
		
		Util.sleepforseconds(5);
	}
	
	@Step
	@Test
	public void TS054_Login_with_valid_username_and_empty_password(){
		
		String Tenant = getdata("Tenant"); // "knpc";
		String User =  getdata("Username");  //"admin";
		
		page.navigate(sURL);
		
		
		if(!DSHomePage.Avatar.isElementPresent()) {
			login(Tenant, User, "");
			}else {
				Reporting.info("System already logged in");
				DSHomePage.Avatar.click("Admin");
				DSHomePage.Logout.click("Logout");
				Util.sleepforseconds(10);
				login(Tenant, User,""); 
			}
		
		DSLoginPage.Password_RequiredError.verifyElementPresent("Password RequiredError");
		
	}

	@Step
	@Test
	public void TS055_Login_with_valid_password_and_empty_username(){
		
		String Tenant = getdata("Tenant"); // "knpc";
		String Pass =  getdata("Password");  //"admin";
		
		page.navigate(sURL);
		
		if(!DSHomePage.Avatar.isElementPresent()) {
			login(Tenant, "", Pass);
			}else {
				Reporting.info("System already logged in");
				DSHomePage.Avatar.click("Admin");
				DSHomePage.Logout.click("Logout");
				Util.sleepforseconds(10);
				login(Tenant,"", Pass); 
			}
		
		
		DSLoginPage.Username_RequiredError.verifyElementPresent("Username RequiredError");
	}

	@Step
	@Test
	public void TS056_Login_with_valid_username_and_invalid_password(){
		
		String Invalid_Username_Or_Password_Error = "Invalid username or password!";
		
		String Tenant = getdata("Tenant"); // "knpc";
		String User =  getdata("Username");  //"admin";
		String Pass = getdata("Password");
		
		page.navigate(sURL);
		
		
		if(!DSHomePage.Avatar.isElementPresent()) {
			login(Tenant, User, Pass);
			}else {
				Reporting.info("System already logged in");
				DSHomePage.Avatar.click("Admin");
				DSHomePage.Logout.click("Logout");
				Util.sleepforseconds(10);
				login(Tenant, User, Pass); 
			}
		
		DSLoginPage.Invalid_Username_Or_Password_Error.verifyElementPresent(Invalid_Username_Or_Password_Error);
		
	}

	@Step
	@Test
	public void TSC057_Login_with_valid_password_and_invalid_username() {
		
		
String Invalid_Username_Or_Password_Error = "Invalid username or password!";
		
		String Tenant = getdata("Tenant"); // "knpc";
		String User =  getdata("Username");  //"admin";
		String Pass = getdata("Password");
		
		page.navigate(sURL);
		
		
		if(!DSHomePage.Avatar.isElementPresent()) {
			login(Tenant, User, Pass);
			}else {
				Reporting.info("System already logged in");
				DSHomePage.Avatar.click("Admin");
				DSHomePage.Logout.click("Logout");
				Util.sleepforseconds(10);
				login(Tenant, User, Pass); 
			}
		
		DSLoginPage.Invalid_Username_Or_Password_Error.verifyElementPresent(Invalid_Username_Or_Password_Error);
		
	}
	
	@Step
	@Test
public void	TS059_Login_To_check_if_the_back_button_in_the_login_form_is_working_fine() {
	
	
	String Tenant = getdata("Tenant"); // "knpc";
	page.navigate(sURL);
	
	
	if(!DSHomePage.Avatar.isElementPresent()) {
		DSPage.LoginBtn.click("Login Btn");
		Util.sleepforseconds(5);
		}else {
			Reporting.info("System already logged in");
			DSHomePage.Avatar.click("Admin");
			DSHomePage.Logout.click("Logout");
			Util.sleepforseconds(10);
			
			DSPage.LoginBtn.click("Login Btn");
			Util.sleepforseconds(5);
		
			
		}
	
	DSLoginPage.Tenant_Switch_Btn.click("switch button in tenant");
	DSLoginPage.Switch_Tenant_Name.fill(Tenant, "tenant name");
	Util.sleepforseconds(5);
	
	page.goBack();
	Util.sleepforseconds(3);
	
	DSPage.LoginBtn.verifyElementPresent("Login Button in Login page");
	
}

	@Step
	@Test
	public void TS060_Login_with_Valid_username_and_password() {
		
		String User =  getdata("Username");  //"admin";
		String Pass =  getdata("Password"); // "P9$!nf5*jB9wiK";
		String Tenant = getdata("Tenant"); // "knpc";
		
		page.navigate(sURL);
		
		
		if(!DSHomePage.Avatar.isElementPresent()) {
		login(Tenant, User, Pass);
		}
		
		DSHomePage.Avatar.click("Admin");
		DSHomePage.Logout.click("Logout");
		Util.sleepforseconds(5);
		
	}
	

	@Step
	@Test
	public void TS062_Login_Click_Forgot_password() {
		
		String User =  getdata("Username");  //"admin";
		String Tenant = getdata("Tenant"); // "knpc";

		
		page.navigate(sURL);
		Util.sleepforseconds(5);
		
		if(DSHomePage.Avatar.isElementPresent()) {
			DSHomePage.Logout.click("Logout");
			Util.sleepforseconds(5);
		}
		
		DSPage.LoginBtn.click("Login Btn");
		
		Util.sleepforseconds(5);
		DSLoginPage.Tenant_Switch_Btn.click("switch button in tenant");
		DSLoginPage.Switch_Tenant_Name.fill(Tenant, "tenant name");
		DSLoginPage.Switch_Tenant_Save.click("Save button in Switch tenant");
		Util.sleepforseconds(5);
		
		DSLoginPage.Username.fill(User, "Username");
		DSLoginPage.ForgotPassword_Link.click("Forgot Password");
		
		DSLoginPage.ForgotPassword_Label.verifyElementPresent("Forgot Password page");
		
//		DSLoginPage.Email_in_ForgotPassword.fill(Pass, Tenant);
		
		
	}

	
}
