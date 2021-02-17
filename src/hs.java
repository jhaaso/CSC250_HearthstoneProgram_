public class hs
{
	private int cost;
	private int attack;
	private int defense;
	private String name;
	
	public hs(String name, int cost, int attack, int defense)
	{
		this.cost = cost;
		this.attack = attack;
		this.defense = defense;
		this.name = name;
	}
	
	
	public void setName(String name)
	{
		if(name.length() >= 5)
		{
			this.name = name;
		}
	}
	
	void display()
	{
		
		System.out.format("Name: %s \nCost: %d \nAttack: %d Defense: %d\n", this.name, this.cost, this.attack,this.defense);
	}
}