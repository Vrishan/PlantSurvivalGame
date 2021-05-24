// Vrishan Inukollu
// 5/22/21
// Levels5.java



// This class sets the speeds and time for each component for each level.
// The healthbars decrease speed and by how much it decreases by is based
// on what level is selected. The enemy speed and how frequent it appears
// is based on the difficulty selected.
public class Levels5
{
	
	private int waterSpeed;
	private double waterTime;
	private int sunSpeed;
	private double sunTime;
	private int foodSpeed;
	private double foodTime;
	private int enemySpeed;
	private double enemyTime;
	
	public void set(String l)
	{
		String t = l;
		if(t.equals("Easy"))
			resetEasy();
		if(t.equals("Medium"))
			resetMedium();
		if(t.equals("Hard"))
			resetHard();
	}
	public void resetEasy()
	{
		waterSpeed = 4;
		waterTime = 8.0;
		sunSpeed = 9;
		sunTime = 10.0;
		foodSpeed = 6;
		foodTime = 12.0;
		enemySpeed = 8;
		enemyTime = 13.0;
		
	}
	public void resetMedium()
	{
		waterSpeed = 14;
		waterTime = 10.0;
		sunSpeed = 12;
		sunTime = 8.0;
		foodSpeed = 10;
		foodTime = 13.0;
		enemySpeed = 10;
		enemyTime = 9.0;
	}
	public void resetHard()
	{
		waterSpeed = 23;
		waterTime = 7.0;
		sunSpeed = 21;
		sunTime = 12.0;
		foodSpeed = 14;
		foodTime = 17.0;
		enemySpeed = 13;
		enemyTime = 7.0;
	}
	public int getWaterSpeed()
	{
		return waterSpeed;
	}
	public double getWaterTime()
	{
		return waterTime;
	}
	public int getSunSpeed()
	{
		return sunSpeed;
	}
	public double getSunTime()
	{
		return sunTime;
	}
	public int getFoodSpeed()
	{
		return foodSpeed;
	}
	public double getFoodTime()
	{
		return foodTime;
	}
	public int getEnemySpeed()
	{
		return enemySpeed;
	}
	public double getEnemyTime()
	{
		return enemyTime;
	}

}
