package rss;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class UsdanRssReadrTest {

	@Test
	public void SetUrltest() {
		System.out.println("testing setURL....will respond if failure occurs");
		UsdanRssReadr readr = new UsdanRssReadr();
		readr.setUrl("http://legacy.cafebonappetit.com/rss/menu/332");
		URL u = null;
		try {
			u = new URL("http://legacy.cafebonappetit.com/rss/menu/332");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("do the setters and getters for url work?....",u,readr.getUrl());
		
	}
	@Test
	public void getMenuTest(){
		System.out.println("testing getMenu....will respond if failure occurs");
		UsdanRssReadr readr = new UsdanRssReadr();
		String Menu = readr.getMenu();
		boolean isMenu = false; 
		if(Menu.substring(1,4).equals("Mon"))
			isMenu = true;
		assertEquals("is the Menu properly retrieved...",true,isMenu);
		
 
	}
	

}
