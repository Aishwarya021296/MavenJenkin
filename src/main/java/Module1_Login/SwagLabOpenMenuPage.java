package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabOpenMenuPage 
{
	@FindBy(xpath="//a[@id='logout_sidebar_link']") private WebElement logout;
	
	public SwagLabOpenMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogout()
	{
		logout.click();
	}
}
