import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class Monster
{
    private String type;
    private int health;
    private int minDamage;
    private int maxDamage;

    public Monster()
    {
        type = "unknown";
        health = 0;
        minDamage = 0;
        maxDamage = 0;
    }

    public Monster(String newType, int newHealth, int newMinDamage, int newMaxDamage)
    {
        this.type = newType;
        this.health = newHealth;
        this.minDamage = newMinDamage;
        this.maxDamage = newMaxDamage;
    }

    public static String display(String type, int health, int minDamage, int maxDamage)
    {
        return type + " with " + health + " health points " + minDamage + " minimum damage and " + maxDamage + " maximum damage";
    }

    public static ArrayList<String[]> monsterSpawn()
    {
        ArrayList<String[]> monster = new ArrayList<String[]>();
       String line = "";
        try
        {
            
            BufferedReader br = new BufferedReader(new FileReader("monsters.txt"));

            while((line = br.readLine()) != null)
            {
                String[] monsterAr = line.split(",");
                monster.add(monsterAr);


            }

        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }



        return monster;
        

    }

    public static int monsterHit(int min, int max)
    {
        int monsterHit = RNG.returnRNG(min, max);
        return monsterHit;
    }


    public String getType()
    {
        return type;
    }

    public int getHealth()
    {
        return health;
    }

    public int getMinDamage()
    {
        return minDamage;
    }

    public int getMaxDamage()
    {
        return maxDamage;
    }

    public void setType(String newType)
    {
        type = newType;
    }

    public void setHealth(int newHealth)
    {
        health = newHealth;
    }

    public void setMinDamage(int newMinDamage)
    {
        minDamage = newMinDamage;
    }

    public void setMaxDamage(int newMaxDamage)
    {
        maxDamage = newMaxDamage;
    }

}
