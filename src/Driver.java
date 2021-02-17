import java.net.URL;
import java.util.Scanner;


public class Driver
{

	public static void main(String[] args) 
	{
		hs c1 = new hs("Charmander", 1, 2, 3);
		hs c2 = new hs("Squirtle", 1, 3, 2);
		hs c3 = new hs("Bulbasaur", 1, 4, 1);
		hs c4 = new hs("Pikachu", 5, 10, 8);
		
		System.out.println("hello World");
		

		c1.display();
		c2.display();
		c3.display();
		c4.display();
		
		c1.setName("woot");
		c1.display();
		
		
		//https://pokemondb.net/pokedex/all
		//something
		
		String cardJson = Driver.getJSON("https://pokemondb.net/pokedex/all");
		System.out.println(cardJson);

		
	}
	static String getJSON(String urlString)
	{	    
		String line = "";
		try
		{
			URL url = new URL(urlString);
		    Scanner input = new Scanner(url.openStream());
		   
		    while (input.hasNext())
		    {
		    	line += input.nextLine();
		    }

		   
		    input.close();
		    
		
		}
	    catch(Exception e)
		{
	    	e.printStackTrace();
	    	line = "Can't Connect";
		}
		return line;
	}
}