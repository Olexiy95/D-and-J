import java.util.Scanner;
import java.io.FileWriter;

public class Dungeon
{
    private Player name;
    private int difficulty;

    public Dungeon()
    {
        name = new Player();
        difficulty = 0;
    }


    public static void main(String[] args)
    {
        Dungeon dungeon = new Dungeon();
        dungeon.start();
        
    }

    public void start()
    {
        Scanner console = new Scanner(System.in);
        
        int tempCoins = 0;
        int tempHealth = 100;
        int tempDifficultySelect = 0;
        int tempDungeonLength = 0;
        int tempMonsterCount = 0;
        int tempStartPotions = 0;

         System.out.println("Welcome adventurer, would you like to play a game of Dungeons and Java?" + 
                            "\n Select yes or no");
        char start = console.nextLine().charAt(0);
        if (start == 'y')
        {   
            String tempName = "";
            boolean flag = true;
            do
            {
                try
                {
                    
                    System.out.println("Please enter your name, it must be between 3 and 12 characters long.");
                    tempName = console.nextLine();
                    int nameCheck = tempName.length();
                    if ((nameCheck >= 3) && (nameCheck <= 12))
                    {
                        flag = false;
                    }
                    else
                {
                    flag = true;
                   System.out.println("Try again.");
                }
                    
                }
                
            
        
        catch(Exception e)
        {
            System.out.println("Please make sure name format is correct.");
        }
        }
        while(flag);

            
            boolean diffFlag = true;
            do
            {
                try
            {
                System.out.println("Welcome " + tempName + "! " + "Please select the difficulty: Easy, Moderate or Hard...");
                char response = console.nextLine().toLowerCase().charAt(0);
                tempDifficultySelect = difficultySelect(response);
                if (response == 'e' || response == 'm' || response == 'h')
                {
                    diffFlag = false; 
                }
                else
                {   System.out.println("Difficulty selection not recognised please try again.");
                    diffFlag = true;
                }
                  
            }
                catch(Exception e)
                {
                    System.out.println("Please select one of the difficulties.");
                }
            } while(diffFlag);
            
            

            tempDungeonLength = RNG.dungeonLength(tempDifficultySelect);

            tempMonsterCount = RNG.monsterCount(tempDifficultySelect);

            tempStartPotions = Inventory.startPotions(tempDifficultySelect); 
            
            

            System.out.println(starting(tempName, tempStartPotions, tempDungeonLength, tempMonsterCount));
            int tiles = tempDungeonLength;
            while (tiles > 0 && tempHealth > 0)
            {
                System.out.println("Would you like to roll the dice? Type in yes to roll or anything else to exit game.");
                char choice = console.nextLine().charAt(0);

                if (choice == 'y')
                {
                    int rolling = 0;
                    rolling = RNG.dice(); 

                    tiles -= rolling;

                    
                    System.out.println(progress(tiles, tempMonsterCount, tempCoins, tempStartPotions));

                    int event = RNG.chance();
                    if ((event >= 1) && (event <= 2) && (tiles > 0)) //item
                    {
                                int item = RNG.chance();
                                if ((item >= 1) && (item <= 5)) //potion found
                                {
                                        System.out.println("You found a health potion!");
                                        if (tempStartPotions <5)
                                        {
                                            System.out.println("Would you like to add the potion to your inventory?");
                                            char potPick = console.nextLine().charAt(0);
                                            if (potPick == 'y')
                                            {
                                                tempStartPotions += 1;
                                            }
                                            
                                        }
                                        else if (tempStartPotions >= 5)
                                        {
                                        System.out.println("You found a health potion, but your inventory is full!");
                                        }
                                    
                                }

                                else if ((item >= 6) && (item <= 9) && (tiles > 0)) //coins found
                                        {
                                            System.out.println("You found some coins!");
                                            tempCoins += 1000;
                                        }

                                else if (item == 10) //nothing found
                                        {
                                        System.out.println("You found nothing!"); 
                                        }
                                
                    }

                    else if ((event >= 3) && (event <= 6) && (tempMonsterCount > 0) && (tiles > 0)) //monster
                    {
                        System.out.println("You encounter a Monster! Time to fight!");
                        tempMonsterCount -= 1;
                        String[] monster = Monster.monsterSpawn().get(RNG.returnRNG(0, Monster.monsterSpawn().size()));
                        
                        String tempMonsterType = monster[0];
                        int tempMonsterHealth = Integer.parseInt(monster[1]);
                        int tempMonsterMinHit = Integer.parseInt(monster[2]);
                        int tempMonsterMaxHit = Integer.parseInt(monster[3]);
                        System.out.println(Monster.display(tempMonsterType, tempMonsterHealth, tempMonsterMinHit, tempMonsterMaxHit));
                        while(tempMonsterHealth > 0 && tempHealth > 0)
                            {
                                int playerHit = Player.playerHit();
                                int monsterHit = Monster.monsterHit(tempMonsterMinHit, tempMonsterMaxHit);
                                System.out.println("Type in a to attack!");
                                char attack = console.nextLine().charAt(0);
                                if (attack == 'a')
                                    {
                                        tempMonsterHealth -= playerHit;
                                        System.out.println(playerDamage(playerHit, tempMonsterHealth));
                                        tempHealth -= monsterHit;
                                        System.out.println(monsterDamage(monsterHit, tempHealth));
                                        if (tempStartPotions > 0 && tempHealth < 100 && tempHealth > 0)
                    {
                        System.out.println(healthCheck(tempHealth, tempStartPotions));
                        char potChoice = console.nextLine().charAt(0);
                            if (potChoice == 'y')
                            {
                                tempStartPotions -= 1;
                                tempHealth += 15;
                                    if (tempHealth > 100)
                                    {
                                        tempHealth = tempHealth - (tempHealth - 100);
                                    }
                            }

                    }
                                    }

                            }
                        
                    }

                    else if  ((event >= 7) && (event <= 10) || (tempMonsterCount == 0)) //nothing
                    {
                        System.out.println("Nothing happens!");
                        if ((tempStartPotions > 0 && tempHealth < 100 && tempHealth > 0))
                    {
                        System.out.println(healthCheck(tempHealth, tempStartPotions));
                        char potChoice = console.nextLine().charAt(0);
                            if (potChoice == 'y')
                            {
                                tempStartPotions -= 1;
                                tempHealth += 15;
                                    if (tempHealth > 100)
                                    {
                                        tempHealth = tempHealth - (tempHealth - 100);
                                    }
                            }

                    }
                    }


                    }
                else 
                {
                    System.out.println(exit());
                    tiles = 0;
                }
            }
            if ((tiles <= 0) && (tempHealth > 0))
            {
                System.out.println(win(tempName, tempStartPotions, tempCoins));
                try
                {
                    FileWriter write = new FileWriter("/home/Outcome.txt", true);
                    String score = tempName + " won with " + tempStartPotions + " potions and " + tempCoins + " coins!";
                    score += "\n";
                    write.append(score);
                    write.close();
                    
                }
                catch(Exception e)
                {
                    System.out.println("Failed to write to outcome file.");
                }

            }

            else if ((tiles > 0) || (tempHealth <= 0))
            {
                System.out.println(loss(tempName, tempStartPotions, tempCoins));

                try
                {
                    FileWriter write = new FileWriter("/home/Outcome.txt", true);
                    String score = tempName + " lost with " + tempStartPotions + " potions and " + tempCoins + " coins.";
                    write.append(score);
                    score += "\n";
                    write.close();
                    
                }
                catch(Exception e)
                {
                    System.out.println("Failed to write to outcome file.");
                }
            }
            }

        else 
        {
            System.out.println(exit());
        }
    }
            public static int difficultySelect(char select)
            {           
                int difficultySelect = 0;
                switch(select)
                {
                    case 'e':
                    difficultySelect = 0;
                    break;
                
                    case 'm':
                    difficultySelect = 1;
                    break;

                    case 'h':
                    difficultySelect = 2;
                    break;
                }

                return difficultySelect;
            }

            public static String dungeonStart(int difficulty, int length, int count )
            {
                return "The dungeon is " + length + " tiles long\n" +
                       " and will contain up to " + count + " monsters. Good luck!";
            }

            

            public String starting(String name, int pots, int length, int count)
            {
                return "Welcome to the dungeon " + name + " you are entering with 100 health points\n " +
                        " and " + pots + " health potions! The dungeon is " + length + " tiles long\n" +
                       " and will contain up to " + count + " monsters. Good luck!";
            }

            public String exit()
            {
                return "Goodbye! Please come back when you are feeling brave.";
            }

            public static String playerDamage(int hit, int health)
            {
                return "You hit the monster for " + hit + " damage, it has " + health + " hitpoints remaining.";
            }

            public static String monsterDamage(int hit, int health)
            {
                return "The monster hits you for " + hit + " damage, you have " + health + " healthpoints remaining.";
            }

            public static String healthCheck(int health, int potions)
            {
                return "You have " + health + " health points and \n" + 
                                            potions + " health potions remaining. Would you like to drink one?";
            }

            public static String progress(int tiles, int monsterCount, int coinCount, int potionCount)
                    {
                        return tiles + " tiles left, " + monsterCount + " monsters left. " + coinCount + " coins and " + potionCount + " potions in inventory.";
                    }

            public static String win(String name, int potionCount, int coinCount)
            {
                return "Congratulations " + name + " you completed the dungeon! You finished with " + potionCount + " potions and " + coinCount + " gold coins!" ;

            }

            public static String loss(String name, int potionCount, int coinCount)
            {
                return "Better luck next time " + name + " you did not complete the dungeon! You finished with " + potionCount + " potions and " + coinCount + " gold coins." ;

            }






                

        public Player getName()
        {
            return name;
        }

        public int getDifficulty()
        {
            return difficulty;
        }

        public void setName(Player newName)
        {
            this.name = newName;
        }

        public void setDifficulty(int newDifficulty)
        {
            this.difficulty = newDifficulty;
        }

}
