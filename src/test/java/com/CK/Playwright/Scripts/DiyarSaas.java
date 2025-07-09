package com.CK.Playwright.Scripts;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.CK.Playwright.Pages.DSLoginPage;
import com.CK.Playwright.Pages.DSPage;
import com.Diyar.Playwright.BaseTest.BaseTest;
import com.Diyar.Playwright.Util.Util;

import io.qameta.allure.Description;
import io.qameta.allure.Step;


public class DiyarSaas extends BaseTest{
	
	@Step
	@Description("Invalid tenant error")
	@Test
	public void TC051_Login_with_invalid_tenant() {
		
		String Tenant = getdata("Tenant"); // "asdfgh";
		String Given_tenant_doesnt_exist = "Given tenant doesn\'t exist:";
		
		page.navigate(sURL);
		
		DSPage.LoginBtn.click("Login Btn");
		Assert.assertEquals("Login Btn","Login Btn");
		
		Util.sleepforseconds(5);
		DSLoginPage.Tenant_Switch_Btn.click("switch button in tenant");
		DSLoginPage.Switch_Tenant_Name.fill(Tenant, "tenant name");
		DSLoginPage.Switch_Tenant_Save.click("Save button in Switch tenant");
		Util.sleepforseconds(5);
		
		
		DSLoginPage.Switch_Tenant_DoesnotExist.verifyElementPresent("Tenant does not exist error");
		
		System.out.println(" Tenant error : " + DSLoginPage.Switch_Tenant_DoesnotExist.textContent());

		Util.verifyText(Given_tenant_doesnt_exist +" "+ Tenant, DSLoginPage.Switch_Tenant_DoesnotExist.textContent());
		
		DSLoginPage.Switch_Tenant_Ok.click("Ok button in switch tenant");
		
		
	}
	@Test
	@Step
	@Description("Login with valid tenant")
	public void TC052_Login_with_valid_tenant() {
		
		String User =  getdata("Username");  //"admin";
		String Pass =  getdata("Password"); // "P9$!nf5*jB9wiK";
		String Tenant = getdata("Tenant"); // "knpc";
		
		page.navigate(sURL);
		
		DSPage.LoginBtn.click("Login Btn");
		Assert.assertEquals("Login Btn","Login Btn");
		
		Util.sleepforseconds(5);
		DSLoginPage.Tenant_Switch_Btn.click("switch button in tenant");
		DSLoginPage.Switch_Tenant_Name.fill(Tenant, "tenant name");
		DSLoginPage.Switch_Tenant_Save.click("Save button in Switch tenant");
		Util.sleepforseconds(5);
		
		DSLoginPage.Username.fill(User, "Username");
		DSLoginPage.Password.fill(Pass, "Password");
		DSLoginPage.Login_Btn.click("Login Button");
		
		Util.sleepforseconds(5);
		
	}

	
}
