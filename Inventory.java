public class Inventory
{
        private int coins;
        private String[] potions;

        public Inventory()
        {
            coins = 0;
            potions = new String[5];
        }

        public Inventory(int newCoins, String[] newPotions)
        {
            this.coins = newCoins;
            this.potions = newPotions;
        }

        public String display()
        {
            return "Inventory contains: " + coins + " and " + potions + "/5 potions!";
        }

        public static int startPotions(int difficulty)
            {
                int startPotions = 0;

                if (difficulty == 0)
                {
                    startPotions = 3;
                }

                else if (difficulty == 1)
                {
                    startPotions = 2;
                }

                else if (difficulty == 2)
                {
                    startPotions = 1;
                }

                return startPotions;
            }

        public int getCoins()
        {
            return coins;
        }

        public String[] getPotions()
        {
            return potions;
        }

        public void setCoins(int newCoins)
        {
            this.coins = newCoins;
        }

        public void setPotions(String[] newPotions)
        {
            this.potions = newPotions;
        }

}
