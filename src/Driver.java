public class Driver 
{

	public static void main(String[] args)
	{ 
		CardParser cp = new CardParser("https://api.hearthstonejson.com/v1/25770/enUS/cards.json");
		//cp.showMinions();
		cp.sortLowestCostToHighestCost();
		cp.showMinions();
		System.out.println("hello world!");
	}
}
