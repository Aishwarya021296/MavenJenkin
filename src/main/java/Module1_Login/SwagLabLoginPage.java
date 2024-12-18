package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage
{
	@FindBy(xpath="//input[@id='user-name']") private WebElement UN;
	@FindBy(xpath="//input[@id='password']") private WebElement PWD;
	@FindBy(xpath="//input[@id='login-button']") private WebElement login_btn;
	
	public SwagLabLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String uname)
	{
		UN.sendKeys(uname);
	}
	
	public void enterPassword(String pwd)
	{
		PWD.sendKeys(pwd);
	}
	
	public void click()
	{
		login_btn.click();
	}

}
