package rss;

import static org.junit.Assert.*;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

public class RssCleanrTest {

	
	// assert test for AsciiToText
	  @Test 
	public void ATTTest() {
		  System.out.println("testing AsciiToText....will respond if failure occurs");
		RssCleanr tester = new RssCleanr();
		assertEquals(
				"&lt; h &gt; &amp; &lt; m &gt; should be read as < h >  < m >",
				"< h >  < m >",
				tester.asciiToText("&lt; h &gt; &amp; &lt; m &gt;"));
	}

	
	
	
	// assert test for tag removing method
	  @Test
	public void removeTagsTest() {
		  System.out.println("testing removeTags...will respond if failure occurs");
		RssCleanr tester = new RssCleanr();
		assertEquals("extracting elemenet between tags, <a>notag</a>", "notag",
				tester.removeTags("<a>notag</a>"));
	}
	
		  
		

}
