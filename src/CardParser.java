import java.util.ArrayList;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class CardParser 
{
	private String urlString;
	private ArrayList<HearthstoneCard> theMinions;
	
	public CardParser(String urlString)
	{
		//initial fields
		this.urlString = urlString;
		theMinions = new ArrayList<HearthstoneCard>();
		
		URLReader hearthstoneURLReader = new URLReader(this.urlString);
		Object obj = JSONValue.parse(hearthstoneURLReader.getTheURLContents());
		
	    if(obj instanceof JSONArray)
	    {
	    	//I am only in here if obj IS a JSONArray
	    	JSONArray array = (JSONArray)obj;
	    	
		    for(int i = 0; i < array.size(); i++)
		    {
		    	JSONObject cardData = (JSONObject)array.get(i);
		    	if(cardData.containsKey("cost") && cardData.containsKey("name"))
		    	{
		    		if(cardData.containsKey("type") && cardData.get("type").equals("MINION"))
		    		{
		    			//I am only here is this is a minion card!!!
		    			System.out.println(cardData.keySet().toString());
		    			String name = (String)cardData.get("name");
		    			int cost = Integer.parseInt(cardData.get("cost").toString());
		    			int attack = Integer.parseInt(cardData.get("attack").toString());
		    			int health = Integer.parseInt(cardData.get("health").toString());
		    			HearthstoneCard temp = new HearthstoneCard(name, cost, attack, health);
		    			theMinions.add(temp);
		    		}
		    	}
		    	
		    }
	    }
	}
	
	public void showMinions()
	{
		for(int i = 0; i < this.theMinions.size(); i++)
		{
			this.theMinions.get(i).display();
		}
	}
	
	public void sortLowestCostToHighestCost()
	{
		ArrayList<HearthstoneCard> theSortedList = new ArrayList <HearthstoneCard>();
		HearthstoneCard nextSmallest;
		while(this.theMinions.size() > 0)
		{
			nextSmallest = this.findSmallest();
			theSortedList.add(nextSmallest);
		}
		this.theMinions = theSortedList;
	}
	
	private HearthstoneCard findSmallest()
		{
			HearthstoneCard currWinner = this.theMinions.get(0);
			int indexOfWinner = 0;
			for(int i = 1; i < this.theMinions.size(); i++)
			{ 
				if (this.theMinions.get(i).getCost() > currWinner.getCost())
				{
					currWinner = this.theMinions.get(i);
					indexOfWinner = i;
				}
	
			}
			this.theMinions.remove(indexOfWinner);
			return currWinner;
			
		}
	
	//public static main void (String[] args)
	{
	//	int[] ar = {1, 3, 5, 7, 9};
	//	System.out.println(Arrays.toString(ar));
	//	selectionSort(ar);
	//	System.out.println(Arrays.toString(ar));
	}
	//public static selectionSort(int[] ar)
	{
		//int currStart = 0;
		//int swapPos, temp;
		//while(currStart < ar.length)
		//	swapPos = currStart;
		//	for(int i = currStart + 1;i < ar.length; i++)
		//	{
		//		if(ar[i] < ar[swapPos])
		//		{
		//			swapPos = i;
		//		}
		//	}
		//	temp = ar[currStart];
		//	ar[currStart] = ar[swapPos];
		//	ar[swapPos] = temp;
		//	currStart++;
	}




}
		
	


