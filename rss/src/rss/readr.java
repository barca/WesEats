package rss;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class readr {

	private String date;
	private String desc;
	private URL url;
	
	public URL getURL(String d){
		try {
			this.url = new URL(d);
			return url;
		} catch (MalformedURLException e) {
			System.out.println("failed to accept url");
			return url;
		}
	}
	public String Read(URL d)throws Exception 
	{
		int count = 0;
		String S = "";
		cleanr cd = new cleanr();
		URL inp = d;
		BufferedReader in = new BufferedReader(
		new InputStreamReader(inp.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
	    {
			
			if(cd.clean2(cd.clean(inputLine)).length()>5)
					{
			if(cd.clean2(cd.clean(inputLine)).substring(0,6).equals("<title"))
					{
					count++;
					}
			if(count > 1)
			S = S + "\n" + cd.clean2(cd.clean(inputLine));
			
			}
	    }
		in.close();
		return S;
	}
	public String parse(String s)
	{
		
		if(s.length() > 6)
		{
			if(s.substring(0,6).equals("<title"))
			{
				return s;
			}
		}return s;
	}
	
		    public static void main(String[] args){
		    	readr R = new readr();
		    	cleanr cd = new cleanr();
		    	try {
					
					System.out.println(cd.clean3(R.Read(R.getURL("http://legacy.cafebonappetit.com/rss/menu/332"))));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    } 
	
}
