package testNG_dem;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import base.com.Base_new;
import pom.demo.BookAHotel;
import pom.demo.Booked_Itinerary;
import pom.demo.BookingConfirmation;
import pom.demo.Login_POM;
import pom.demo.Search_Hotel;
import pom.demo.Select_Hotel;


public class adactin_testng extends Base_new {
	public static WebDriver driver;
	
	@BeforeSuite
	 private void browser() {
      driver = BrowserLaunch();
	}
	
	 @BeforeClass
	 private void login() throws InterruptedException {
		 Url("https://adactinhotelapp.com/");
		 Login_POM lp = new  Login_POM(driver);
		 SendKeys(lp.getUser(),"aswinkumar799");
		 SendKeys(lp.getPass(),"dcc123");
		 Thread.sleep(2000);
		 click1(lp.getLogin());
		 
	}
	 @Test(priority = -1)
	 private void search_Hotel() throws InterruptedException {
		 Search_Hotel s= new Search_Hotel(driver);
		 Selectby_Index(s.getLocation(),1);
		 Selectby_Index(s.getHotels(),1);
		 Selectby_Index(s.getRoomtype(),1);
		 Selectby_Index(s.getNumberofRooms(),1);
		 s.getCheckinDate().clear();
		 SendKeys(s.getCheckinDate(),"21/02/2023");
		 s.getCheckoutDate().clear();
		 SendKeys(s.getCheckoutDate(),"30/02/2023");
		 Selectby_Index(s.getAdultperroom(),1);
		 Selectby_Index(s.getChildperroom(),1);
		 Thread.sleep(2000);
		 click1(s.getSearch());
	}
	 @Test()
	 private void selecthotel() throws InterruptedException  {
		 Select_Hotel sh=new Select_Hotel(driver);
		 Thread.sleep(2000);
		 click1(sh.getSelect());
		 Thread.sleep(2000);
		 click1(sh.getContinue());
		 
	}
	   @Test(priority = 1)
	    private void bookhotel() {
		 BookAHotel ba = new BookAHotel(driver);
		 SendKeys(ba.getName(), "aswin");
		 SendKeys(ba.getLname(), "kumar");
		 SendKeys(ba.getBillingAddress(), "southchennai");
		 SendKeys(ba.getCreditCardNo(), "1234 5678 8765 4321");
		 Selectby_Index(ba.getCreditType(), 1);
		 Selectby_Index(ba.getExpDate(), 2);
         Selectby_Index(ba.getExpYear(), 3);	
         SendKeys(ba.getCVVNo(), "643");
         click1(ba.getBookNow());
      
	}
	   @Test(priority = 2)
	   private void bookingconfirm() throws Throwable {
		   BookingConfirmation bc= new  BookingConfirmation(driver);
		   Thread.sleep(10000);
		   click1(bc.getMyItinerary());
	}
	   @AfterClass
	   private void bookIte() {
		   Booked_Itinerary bi= new Booked_Itinerary(driver);
		   click1(bi.getOrderid());
		   click1(bi.getCancelSelected());
		   Alert1();
		   click1(bi.getLogout());
		 
		   
	}
	   @AfterSuite
	   private void close() {
		   Quit();
	}
	 
	 
	 
}

