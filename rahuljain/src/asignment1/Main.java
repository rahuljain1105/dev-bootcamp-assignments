package asignment1;

import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Ghost you are in Avenger's base\n Survive if you can");
        
        //enemy
        String[] enemies={"Ironman","Capt.America","Hulk","Black Widow","Hawkeye","Thor"};
        int enmAttackDamage = 35;
        int enmMaxHealth =80;
        
        //player
        int maxAttackDamage = 50;
        int health= 100;
        int healthPotionAmount = 4;
        int healthThroughPotion= 40;        
               
        boolean running=true;
        GAME :
        while(running)
        {
            System.out.println("\n......................................");
            int enmHealth = random.nextInt(enmMaxHealth);
            String enemy = enemies[random.nextInt(enemies.length)];
            System.out.println("\t###"+enemy+" has appeared!###\n");
            while(enmHealth>0)
            {
            System.out.println("\nYour Health "+health);
            System.out.println(enemy+"'s Health "+ enmHealth);
            System.out.println("What would you do?  \n1.Attack  \n2.Run  \n3.Use Health Potion\n");
            String input_taken1 =input.nextLine();
            while(!input_taken1.equals("1") && !input_taken1.equals("2") && !input_taken1.equals("3"))
            {
                System.out.println("Invalid input");
                input_taken1 =input.nextLine();
            }
            if(input_taken1.equals("1"))
            {
                int enmDamage = random.nextInt(maxAttackDamage);
                int damageTaken = random.nextInt(enmAttackDamage);
                health-=damageTaken;
                enmHealth-=enmDamage;
                System.out.println("You hit "+enemy+" with "+enmDamage);
                if(health < 1)
                break;
            }
            else if(input_taken1.equals("2"))
            {
                System.out.println("You ran away from "+enemy+"!!!");
                continue GAME;
            }
            else if(input_taken1.equals("3"))
            {
                if(healthPotionAmount > 0)
                {
                    healthPotionAmount--;
                    health+=healthThroughPotion;
                    System.out.println("You healed by "+healthThroughPotion+"\nYour health "+health+
                            "\nYou are left with "+healthPotionAmount+" health potions");
                }
                else
                    System.out.println("You are out of Health potions");
            }
            }
            if(health <1)
            {
                System.out.println("You can't go on!!!!! \nYou are taken down by mighty Avengers");
                break;
            }
            System.out.println("......................................");
            System.out.println("You have beaten "+enemy+"!!!");
            System.out.println("Your health "+health);
            healthPotionAmount++;
            System.out.println("What would you like to do now?"+
                    "\n1.Continue Fighting \n2.Leave the base\n");  
            String input_taken2 =input.nextLine();
            while(!input_taken2.equals("1") && !input_taken2.equals("2"))
            {
                System.out.println("Invalid input");
                input_taken2 =input.nextLine();
            }
            if(input_taken2.equals("1"))
                continue GAME;
            else if(input_taken2.equals("2"))
                break;
        }
        System.out.println("\n##########################################");
        System.out.println("DO VISIT THE BASE AGAIN ");
        System.out.println("##########################################");
    }
}