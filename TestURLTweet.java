
//*************************************************************************
//Create an app that will be executed in terminal or from the command line.
//The app should accept a hashtag as an argument and should only print out
//unique urls found in the 100 most recent tweets that matched the hashtag
//*************************************************************************
import java.io.*;
import java.util.*;
import java.net.*;

public class TestURLTweet
{

  public static void main(String[] args) throws Exception {
    String Name_of_StringFile =" ";
    String String_of_tweet;
  	
	Set<String> Unique_url = new  HashSet<String>();//Use Sets for unique urls.

   
  	

			if(args.length==1)
			{
				Name_of_StringFile = args[0];
				Name_of_StringFile=Name_of_StringFile.replace("#", "");
		        URL tweet = new URL("http://search.twitter.com/search.json?q="+Name_of_StringFile+"&rpp=100&include_entities=true&result_type=recent");
		        BufferedReader in = new BufferedReader(new InputStreamReader(tweet.openStream()));

		        String next_tweet;
		        String input_lines;
		        

		        while ((input_lines = in.readLine()) != null)
		        {
		        	//Scanner s = new Scanner(input_lines).useDelimiter(",");
		        	//System.out.println("The Value of s"+s);
		        	System.out.println(input_lines);
		        	Scanner s = new Scanner(input_lines).useDelimiter(",");
		        	String match ="expanded_url";
		            while(s.hasNext())
		            {
		            	next_tweet=s.next();
		            	if(next_tweet.length()>=13)
		            	{		            	 
		             	if(next_tweet.substring(1,13).equals(match.substring(0,12)))
		            	 {
		             		String_of_tweet = next_tweet.substring(16,next_tweet.length()-1);

		             		String_of_tweet=String_of_tweet.replaceAll("/","");
		             		Unique_url.add(String_of_tweet);
		            	 }
		            	}

		            }
		         }
		                   System.out.println("The Unique URLs are");
		                   System.out.println(Unique_url);   
		                   in.close();
		                   String Data;
			}
			else
			{
				 System.out.println("Please enter the Hashtag in the Command Argument");
			}
  }
}