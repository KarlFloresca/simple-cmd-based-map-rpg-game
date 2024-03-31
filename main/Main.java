package main;

import java.util.Scanner;

public class Main {
    static Distance dis = new Distance();
    public static Map mp = new Map();
    static Scanner sc = new Scanner(System.in);

    public static boolean run = false;
    public static int capital, market,market2, southwestvillage, northwestvillage, well, rockyMountains,rockyMountains2, fields;
    public static void main(String[] args){

                System.out.println("""

                    \tWelcome to the land of prelict renowned traveller of the northern regions
                    you have been tasked by the king himself to obtain the lost relics throughout 
                    the history of his ancestor's empire.
                    """);
                System.out.println("""
                    \tThere are many locations you should investigate in order to find these relics
                    visit those locations in order to find clues of their whereabouts
                    there are a total of 4 relics to be found

                                     /\\      ______         ====
                      0=={======>   //\\\\     \\\\__//      ___|  |
                                    \\\\//      \\\\//      (______/              
                                     \\/       {{}}      
                                         
                    \tYou can find out more about them as you go on.
                    onced you gathered all 4 of the relics return them
                    to the royal palice in the capital city

                    {== [there are 5 endings to this game however only one ends in success] ==}
                    """);

                System.out.println("will you accept this quest?[yes or no]");
                String start = sc.next();

                switch (start) {
                    case "yes":
                        run = true;
                        // gets the random distances of each location
                        locationDistance();
                        // initializes the game loop
                        runTime(run);
        
                        break;
                    case "no":
                        System.out.println("""

                            [una palang mali kana agad:/]

                            the king is very dissapointed in you
                            you have been dubbed as a failure
                            """);
                            end();
                        run = false;
                        break;
                    default:
                        System.out.println("\nAayusin mo naman ang spelling >:/");
                        break;
                }
        }


    public static void runTime(boolean loop){
        mp.userSpawn();
        while (loop == true) {
            if (Map.alive == false) {
                System.out.println("You have died during your quest...");
                end();
                run = false;
                break;
            }
            else if (Map.location=="capital") {
                if (Map.relics==4){
                    end();
                    break;
                }
            }
        }
    }

    public static void locationDistance(){
        
        capital = dis.distanceGenerator();
        market = dis.distanceGenerator();
        market2 = dis.distanceGenerator();
        fields = dis.distanceGenerator();
        well = dis.distanceGenerator();
        southwestvillage = dis.distanceGenerator();
        northwestvillage = dis.distanceGenerator(); 
        rockyMountains = dis.distanceGenerator(); 
        rockyMountains2 = dis.distanceGenerator();
    }
    public static void end(){
        System.out.println("""
                
          #####    ####    ##     ##   ######
        ###       ##  ##  ## ## ## ##  ##
        ##   ###  ######  ##  ###  ##  ####
        ###   ##  ##  ##  ##   #   ##  ##
          #####   ##  ##  ##       ##  ######
                       
                        ####    ##   ##  ######  #####
                       ##  ##   ##   ##  ##      ##  ##
                      ##    ##  ##   ##  ####    #####
                       ##  ##    ## ##   ##      ##  ##
                        ####      ###    ######  ##   ##
                """);
    }
}
