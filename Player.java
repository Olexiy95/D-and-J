import java.util.Scanner;

public class Player
{
    private String name;
    private int health;
    private Inventory potions;
    private Inventory coins;

    public Player()
    {
        name = "unknown";
        health = 0;
        potions = new Inventory();
        coins = new Inventory();
    }


    public Player (String newName, int newHealth, Inventory newPotions, Inventory newCoins)
    {
        this.name = newName;
        this.health = newHealth;
        potions = new Inventory();
        coins = new Inventory();
    }

    public static int playerHit()
    {
        int playerHit = RNG.returnRNG(0, 20);
        return playerHit;
    }

    public String display()
    {
        return "Adventurer " + name + " with " + health + " heath points.";
    }

    public String getName()
    {
        return name;
    }

    public int getHealth()
    {
        return health;
    }

    public Inventory getPotions()
    {
        return potions;
    }

    public Inventory getCoins()
    {
        return coins;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public void setHealth(int newHealth)
    {
        this.health = newHealth;
    }

    public void setPotions(Inventory newPotions)
    {
        potions = newPotions;
    }

    public void setCoins(Inventory newCoins)
    {
        coins = newCoins;
    }

}
