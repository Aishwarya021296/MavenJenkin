package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage 
{
	@FindBy(xpath="//div[@class='app_logo']") private WebElement logotext;
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") private WebElement openMenu;
	
	public SwagLabHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLogoText()
	{
		String actText = logotext.getText();
		String expText="Swag Labs";
		
		if(actText.equals(expText))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}
	
	public String getLogoText()
	{
		String LogoText=logotext.getText();
		return LogoText;
	}
	
	public void OpenMenu()
	{
		openMenu.click();
	}
	
}
