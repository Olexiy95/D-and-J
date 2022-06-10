public class RNG
{
    public RNG()
    {

    }

    public static int returnRNG(int lowNum, int highNum)
    {
        int random = (int) (Math.random() * (highNum - lowNum)) + lowNum;
        return random;
    }

    public static int dungeonLength(int difficulty)
            {   
                int dungeonLength = 0;
                switch(difficulty)
                    {
                        case 0:
                        dungeonLength = returnRNG(30, 50);
                        break;

                        case 1:
                        dungeonLength = returnRNG(50, 80);
                        break;

                        case 2:
                        dungeonLength = returnRNG(100, 150);
                        break;

                    }
                return dungeonLength;
            }

            public static int monsterCount(int difficulty)
            {
                int monsterCount = 0;
                switch(difficulty)
                    {
                        case 0:
                        monsterCount = returnRNG(1, 5);
                        break;

                        case 1:
                        monsterCount = returnRNG(1, 10);
                        break;

                        case 2:
                        monsterCount = returnRNG(1, 20);
                        break;

                    }
                return monsterCount;
                
            }

            public static int dice()
            {
                int roll = returnRNG(2, 12);

                return roll;
            }

            public static int chance()
            {
                int chance = 0;
                chance = returnRNG(1, 10);
                return chance;
            }


    

    
    
}
