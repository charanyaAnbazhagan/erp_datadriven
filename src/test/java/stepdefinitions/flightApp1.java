package stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class flightApp1 {
	public static WebDriver driver;
	@Given("I open the browser with URL {string}")
	public void i_open_the_browser_with_url(String URL) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
	}
	@Then("I should see login page")
	public void i_should_see_login_page() {
		if( driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed())
		{
			System.out.println("login page is displayed");
		}
	}
	@When("I should click signup link")
	public void i_should_click_signup_link() {
		driver.findElement(By.xpath("//div[3]/div[1]/a")).click();
	}

	@Then("I enter name")
	public void i_enter_name() {
		driver.findElement(By.name("name")).sendKeys("saranya");;
	}
	@Then("I enter email Id")
	public void i_enter_email_id() {
		driver.findElement(By.name("email")).sendKeys("saranyaanbazhagan05@gmail.com");
	}
	@Then("I select contact number")
	public void i_select_contact_number() {
		driver.findElement(By.name("contact")).sendKeys("9965146319");;
	}
	@Then("I select gender")
	public void i_select_gender() {
		WebElement element=	driver.findElement(By.name("gender"));
		Select ss=new Select(element);
		ss.selectByValue("F");
	}
	@Then("Ienter password")
	public void ienter_password() {
		driver.findElement(By.id("address")).sendKeys("saran123");
	}
	@Then("I select date of birth")
	public void i_select_date_of_birth() {
		driver.findElement(By.xpath("//input[@name='dob']")).click();
		WebElement month =driver.findElement(By.className("ui-datepicker-month"));
		Select mn = new Select(month);
		mn.selectByValue("4");
		WebElement yr=    driver.findElement(By.className("ui-datepicker-year"));
		Select year= new Select(yr);
		year.selectByValue("1994");
		WebElement dt= driver.findElement(By.className("ui-datepicker-calendar"));
		List<WebElement> rows=dt.findElements(By.tagName("tr"));
		for(int i=1;i<rows.size();i++)
		{
			List<WebElement> col=rows.get(i).findElements(By.tagName("td"));
			for(WebElement date:col)
			{
				if(date.getText().equals("15"))
				{
					date.click();
				}

			}
		}
	}
	@Then("I click privacy box")
	public void i_click_privacy_box() {
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	}
	@When("I click register link")
	public void i_click_register_link() {
		driver.findElement(By.xpath("//input[@name='submit']")).click();

	}
	@Then("I enter EmailId as {string}")
	public void i_enter_email_id_as(String emailid) {
		driver.findElement(By.name("email")).sendKeys(emailid);
	}
	@Then("i enter password as {string}")
	public void i_enter_password_as(String pwd) {
		driver.findElement(By.name("password")).sendKeys(pwd);
	}
	@When("I click login")
	public void i_click_login() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Then("I should see booking page")
	public void i_should_see_booking_page() throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(" Welcome ")));
		// click on the compose button as soon as the "compose" button is visible
		//driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
		if( driver.findElement(By.xpath("//div/div[3]/ul")).isDisplayed())
		{
			System.out.println("booking page");
		}
	}
	@When("i click logout")
	public void i_click_logout() {
		driver.findElement(By.xpath("//div[3]/ul/li[2]/div")).click();
		driver.findElement(By.xpath("//div/ul/li[5]/a/i")).click();
	}
	@Then("close the browser")
	public void close_the_browser() {
		driver.close();

	}
	@When("I need to select date of Flight")
	public void i_need_to_select_date_of_flight() {
		driver.findElement(By.id("search-date")).click();
		String fly="15-june-2029";
		String[]temp=fly.split("-");
		String dt =temp[0];
		String month =temp[1];
		String year =temp[2];
		//String flight="King Fisher Airlines";

		String calyear =driver.findElement(By.className("ui-datepicker-year")).getText();
		while(!calyear.equals(year))
		{
			driver.findElement(By.linkText("Next")).click();
			calyear = driver.findElement(By.className("ui-datepicker-year")).getText();

		}

		String calmonth =driver.findElement(By.className("ui-datepicker-month")).getText();
		while(!calmonth.equalsIgnoreCase(month))
		{
			driver.findElement(By.linkText("Next")).click();
			calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();

		}
		WebElement date=driver.findElement(By.className("ui-datepicker-calendar"));
		List<WebElement> row=driver.findElements(By.tagName("tr"));
		for(int i=1;i<row.size();i++)
		{
			List<WebElement> col=row.get(i).findElements(By.tagName("td"));
			for(WebElement list:col)
			{
				if(list.getText().equals(dt))
				{
					list.click();
					break;
				}}}


	}
	@When("I need to select place of FlyFrom")
	public void i_need_to_select_place_of_fly_from() {
		WebElement fly=  driver.findElement(By.xpath("//div[2]/select"));
		Select fly1 = new Select(fly);
		fly1.selectByValue("2");
	}
	@When("i need to select place of FlyTo")
	public void i_need_to_select_place_of_fly_to() {
		WebElement flyto=  driver.findElement(By.xpath("//div[3]/select"));
		Select fly2 = new Select(flyto);
		fly2.selectByValue("4");
	}
	@When("I click Search Flight")
	public void i_click_search_flight() {
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Search Flights")));

		driver.findElement(By.xpath("//div/div[4]/button")).click();

	}
	@Then("I should see Flight Available")
	public void i_should_see_flight_available() {

	}
	@Then("I need to select the ticket")
	public void i_need_to_select_the_ticket() throws Exception {
		String flight= "King Fisher Airlines";

		//Thread.sleep(5000);
		//WebElement fly123 = driver.findElement(By.className("flights_table"));
		//driver.findElement(By.xpath("//button[@class='selected_flight']")).click();
		//List<WebElement> tlist = fly123.findElements(By.tagName("tr"));
		//System.out.println(tlist.size());
		//for(int i=1;i<tlist.size();i++)
		//{
		//List<WebElement> col =tlist.get(i).findElements(By.tagName("td"));
		//for(int j=1;j<col.size();j++)
		//{
		//String flyName = col.get(0).getText();
		//System.out.println(flyName);
		//if(flyName.equalsIgnoreCase(flight))
		//{
		//col.get(8).click();
		//break;
		//}
		//}



		//}
		WebElement fly2 = driver.findElement(By.className("flights_table"));
		List<WebElement> tlist =fly2.findElements(By.tagName("tr"));
		for(int i =1;i<tlist.size();i++)
		{

			List<WebElement> col =tlist.get(i).findElements(By.tagName("td"));
			WebElement order =col.get(0);

			String list =order.getText();
			System.out.println(list);
			if(list.equals(flight)) {
				col.get(8).click();

				break;

				//Thread.sleep(2000);


			}
			driver.findElement(By.xpath("//button[@class='close']")).click();



		}



	}
	@Then("I need to give name of traveller")
	public void i_need_to_give_name_of_traveller()
	{

		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("charan");
	}
	@When("I click insert order")
	public void i_click_insert_order() throws InterruptedException {
		driver.findElement(By.xpath("//div/div[4]/div/button")).click();

		//driver.findElement(By.linkText("Insert Order")).click();
	}
	@Then("i need to see ticket booked msg")
	public void i_need_to_see_ticket_booked_msg() {
		if(driver.findElement(By.linkText("View Ticket")).isDisplayed())
		{
			System.out.println("Ticket booked succesfully");
		}}
	@Then("I click booking page")
	public void i_click_booking_page() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='profile-usermenu']/ul/li[2]")).click();
	}
	@Then("I should see ticket")
	public void i_should_see_ticket() {
		if(driver.findElement(By.xpath("//div/div[1]/h2")).isDisplayed())
		{
			System.out.println("Tickets displayed");
		}
	}
	@Then("I delete ticket")
	public void i_delete_ticket() throws Throwable {
		String order ="10911";
		driver.findElement(By.className("flights_table"));
		List<WebElement> rows =driver.findElements(By.tagName("tr"));
		for(int i=1;i<rows.size();i++)
		{
			List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
			String lists=cols.get(0).getText();
		
			if(lists.equals(order))
			{
				System.out.println(lists);
				List<WebElement> atags = cols.get(9).findElements(By.tagName("a"));
				for(WebElement a : atags)
				{
				 	String atext = a.getText();
				 	if(atext.equalsIgnoreCase("Delete"))
				 	{
				 		a.click();
						driver.switchTo().alert().accept();
						System.out.println("Ticket is deleted");

				 	}
				}
			}

		}

	}
}





