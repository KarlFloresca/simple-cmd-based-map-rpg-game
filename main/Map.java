package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Map{
    public int locationNum;
    public static String location;
    static Distance dis = new Distance();
    static Scanner sc = new Scanner(System.in);
    static Main main = new Main();

    String[] locationarray = {"capital", "market","fields","well","southwest","rockymountains","northwest"};

    int route1,route2,route3;
    String time1,time2;

    static int gem;
    static int sword;
    static int talisman;
    static int boots;

    public static boolean alive = true;
    public static boolean game = true;
    static boolean combat = true;

    static int bossHealth = 10;
    static int health = 10;

    static int key = 0;
    static int coins = 0;
    static int relics = 2;
    
    public void userSpawn(){
            locationNum = dis.location();
            switch (locationNum) {
                case 1:
                    location = locationarray[0];
                    break;
                case 2:
                    location = locationarray[1];
                    break;
                case 3:
                    location = locationarray[2];
                    break;
                case 4:
                    location = locationarray[3];
                    break;
                case 5:
                    location = locationarray[4];
                    break;
                case 6:
                    location = locationarray[5];
                    break;
                case 7:
                    location = locationarray[6];
                    break;
            
                default:
                    break;
            }
            map();
        }

    static String[] position = new String[7];
    public static void localMap(){
        switch (location) {
            case "capital":
                position[0]= ">(you)<";
                break;
            case "market":
                position[1]= ">(you)<";
                break;
            case "fields":
                position[2]= ">(you)<";
                break;
            case "well":
                position[3]= ">(you)<";
                break;
            case "southwest":
                position[4]= ">(you)<";
                break;
            case "rockymountains":
                position[5]= ">(you)<";
                break;
            case "northwest":
                position[6]= ">(you)<";
                break;
            default:
                break;
        }
        for(int i = 0; i<=position.length-1;i++){
            if (position[i] == null) {
                position[i] = "       ";
            }
        }

        System.out.println("############################################################################## ");
            System.out.println("#     / \\   capital                            northwest village___          # ");
            System.out.println("#    /___\\      ^       /\\    /\\                        /\\     /___\\         # "+"RELICS FOUND: "+relics+"/4");
            System.out.println("#   _||_||___  / \\      /\\    /\\                       /__\\   _|| ||         # "+"CURRENT LOCATION: "+location);
            System.out.println("#  | 0  0  0 |_|^|      ||    ||                       |__|  |____||         # " +"KEYS: "+key);
            System.out.println("#  |_________|_|^|__________"+Main.capital+"m____interscection__"+Main.northwestvillage+"m_       "+position[6]+"         # "+"COINS: "+coins);
            System.out.println("#  --"+position[0]+"------___________________    _____________     ____              # ");
            System.out.println("#      |  |                          |  |                 /____\\             # ");
            System.out.println("#      "+Main.market+"m     ==============        |  |        /\\        |__|              # ");
            System.out.println("#      |  |    ==============        |  |      /    \\                /\\      # ");
            System.out.println("#      |  |    ==============        "+Main.rockyMountains2+"m      /        \\            /   \\    # ");
            System.out.println("#     market                         |  |   / \\          \\         /      \\  # ");
            System.out.println("# /__\\       /__\\____________________|  |  /    \\          \\     /\\          # ");
            System.out.println("# |__| |  |  |__| ___________________   | /      \\           \\ /             # ");
            System.out.println("# [==] |  |  [==] ---------"+Main.market2+"m-------   |    Rocky mountains                 # ");
            System.out.println("#      "+position[1]+"    /^^\\               |  |             "+position[5]+"                # ");
            System.out.println("# [==] |  |  [==] |__|               |  |                                    # ");
            System.out.println("# _____|  |________________          "+Main.rockyMountains+"m                            /\\       # ");
            System.out.println("# _____"+Main.fields+"m______________   |         |  |                     ^    /__\\      # ");
            System.out.println("#        fields         |  |   well  |  |        __   __     /_\\   |__|      # ");
            System.out.println("#  ///////    ///////   |  | "+position[3]+" |  |       /__\\ /__\\  __| |             # ");
            System.out.println("# //////"+position[2]+"/////     "+Main.well+"m |-|-|-| |  |       |__| |__| |____|   ____      # ");
            System.out.println("#///////    ///////     |  |_________|  |              "+position[4]+"    /____\\     # ");
            System.out.println("#//////    ///////      |________"+Main.southwestvillage+"m_____        southwest village |__|      # ");
            System.out.println("############################################################################## ");
            for(int i = 0;i<position.length;i++){
                if (position[i]!=null) {
                    position[i] = null;
                }
            }
    }

    
    public static void map(){
        if (location == "capital") {
            // loads current state of the map
            localMap();
            
            System.out.println("welcome to the capital of prelict");            

            if (relics != 4) {
                if (sword != 1) {
                    System.out.println("this is the main city of the kingdom maybe there are clues if you ask around...");
                    System.out.println("\n[you've encountered a merchant...]");
                    System.out.print("\nwould you like to ask him about the relics[yes or no]? ");
                    String decision = sc.next();
                    switch (decision) {
                    case "yes":
                        System.out.println("""

                            [merchant:]
                            there were rumors going around that merchants have
                            been keeping an item undisclosed to the royal records
                            """);
                        System.out.println("Maybe if you visit the market you might find something interesting\n");
                        break;
                    case "no":
                        System.out.println("the merchant went on his way to the northern road\n");
                        break;
                    default:
                    }
                }
            }
            if (relics == 4) {
                System.out.println("""
                        
                    Congratulations!!! the king is very pleased with your hard work,
                    he had dubbed you as a royal retainer and loyal servant to the kingdom...
                        
                    you lived your life with wealth, fame and power
                        
                    [end]""");
                    Map.game = false;
            }
            if (Map.game == true) {
                route();
            }
        }
        
        if (location == "market") {
            localMap();

            System.out.println("you've entered the community market");
            if (key != 1) {
                if (sword!=1) {
                    System.out.println("""

                        There are a bunch of people gathering around
                        try and find out about the relics

                        why not try searching the shops?[yes or no]""");
                    String decision = sc.next();
                    switch (decision) {
                        case "yes":
                            System.out.println("""

                            you've found an illegal auction house operating inside the market
                            they are offering a rusty old key to the audience...

                            none had taken an interest but you've noticed that the center of the
                            key has the old emblem of the empire

                                                                 ▓▓▓▓▓▓████    
                                                               ▓▓    ░░    ▓▓█
                                                              ▓▓  ░░▓▓▓▓    ▓▓██ 
                                                            ▓▓  ░░▓▓    ▓▓    ▓▓    
                                                          ▓▓░░  ▓▓    ░░░░▓▓    ▓▓  
                                                          ▓▓  ▓▓    ░░░░░░      ▓▓  
                                                          ▓▓    ▓▓░░░░░░    ▓▓░░  ▓▓
                                                          ▓▓░░    ▓▓░░    ▓▓░░    ▓▓
                                                            ▓▓      ▓▓  ▓▓░░    ▓▓  
                                                          ██▓▓▓▓      ▓▓    ▓▓▓▓    
                                                        ██▓▓░░▓▓▓▓░░    ░░▓▓        
                                                    ██░░░░░░  ██  ▓▓▓▓▓▓▓▓          
                                                  ██░░░░    ██                      
                                      ████    ██░░░░      ██                        
                                ████    ░░████░░░░      ██                          
                            ████░░████░░░░██░░░░      ██                            
                            ██  ████░░    ██░░░░    ██                              
                            ██░░  ██    ██░░░░    ██                                
                            ████  ░░░░██░░░░    ██                                  
                                ████░░██░░░░  ██                                    
                                ████░░░░    ██                                      
                                    ██░░  ██                                        
                                      ████                                         
                            
                                            
                        █░█░█ █▀█ █░█ █░░ █▀▄   █▄█ █▀█ █░█   █░░ █ █▄▀ █▀▀   ▀█▀ █▀█   █▄▄ █ █▀▄ ▀█  
                        ▀▄▀▄▀ █▄█ █▄█ █▄▄ █▄▀   ░█░ █▄█ █▄█   █▄▄ █ █░█ ██▄   ░█░ █▄█   █▄█ █ █▄▀ ░▄   

                        █▄█ █▀▀ █▀   █▀█ █▀█   █▄░█ █▀█ 
                        ░█░ ██▄ ▄█   █▄█ █▀▄   █░▀█ █▄█
                        """);
                                String bid = sc.next();
                                switch (bid) {
                                    case "yes":
                                        System.out.println("\n<you have acquired the rusty key>");
                                        key +=1;
                                        System.out.println("maybe there is a use to this later on...\n");
                                        break;
                                    case "no":
                                        System.out.println("the key was taken back into storage for the next bidding\n");
                                    default:
                                        break;
                                }
                            break;
                        case "no":
                            System.out.println("");
                            break;              
                        default:
                            break;
                    }
                }
            }
            route();
        }
        
        if (location == "fields") {
            localMap();

            System.out.println("you've stumbled upon the bountiful fields of prelict");

            if (talisman != 1) {
                System.out.println("""
                    
                    a humble farmer has greeted you...
                    [FARMER]
                    hello there friend what brought you to the fields of prelict?
                    
                    [ask about the relics? yes or no]""");
                String decision = sc.next();
                switch (decision) {
                    case "yes":
                        System.out.println("""
                                
                                [FARMER]
                                I see try looking around down the road you'll find a village in the south
                                i think the chief of the village has something interesting, and
                                also i heard that he loves elephants
                                """);
                        break;
                    case "no":
                        System.out.println("""
                                
                                [FARMER]
                                a i see your just sight seeing, have a nice day
                                check out the mountains it is a great spot for sight
                                seing
                                """);
                        break;
                    default:
                        break;
                }
            }
            route();
        }
        
        if (location == "well") {
            localMap();

            System.out.println("an old well has caught your attention");
            if (coins == 0) {
                if (boots != 1) {
                    System.out.println("""

                        i wonder if this is an ancient well
                        there are sparkles within the waters...
                        """);
                }
            }
            if(coins > 0){
                System.out.println("""
                        
                        You see bright sparks within the well...
                        
                        as you went closer the light grew brighter...
                        
                        [would you like to toss in a coin? yes or no]""");
                    
                String toss = sc.next();
                switch (toss) {
                    case "yes":
                        System.out.println("""
                                
                                [you tossed in the only coin you have]

                                \tThe light had quickly dispersed around the area
                                as you loo upon the well the sparkles have dissapeared
                                but in your hands you have the great hermes boots one
                                of the lost relics used by the messengers of old
                                
                                            ====
                                         ___|  |
                                        (______/ 
                                        """);
                        coins -=1;
                        relics += 1;
                        boots +=1;
                        break;
                    case "no":
                        System.out.println("\n[you felt that there is something that you have missed]");
                        break;
                    default:
                        break;
                }
            }
            route();
        }

        if (location == "southwest") {
            if (alive) {
            localMap();

            System.out.println("you have found the village in the south");

            if (talisman != 1) {
                System.out.println("""
                        
                        seems that this village is ranned by one of the villagers...

                        [would you like to speak to the village chieften?yes or no]""");

                    String talk = sc.next();
                    switch (talk) {
                        case "yes":
                            System.out.println("""
                                    
                                    [CHIEF]
                                    HA HA i see so you would like to have the relic
                                    i knew it was only a matter of time before someone
                                    would discover that i own the talisman of the holy
                                    order...
                                    
                                    why would i give this to you?""");
                                    System.out.println("""
                                            
                                            [choose a dialogue]
                                            
                                            1. how about a bet, You can erase evidence of you owning the relics if i fail, however if i win you will surrender the talisman.
                                            2. would you rather have the army trample this town""");

                                    System.out.print("\nenter here: ");
                                    int dialogue = sc.nextInt();
                                    while (dialogue > 2 || dialogue < 1 ) {
                                        System.out.println("That is not an option[try again]: ");
                                        dialogue = sc.nextInt();
                                    }
                                    switch (dialogue) {
                                        case 1:
                                            System.out.println("""

                                                    [CHIEF]
                                                    HA HA HA i like your style, lets keep it simple guess my favorite animal!""");
                                                    System.out.print("[Enter guess{lower caps}]:");
                                                    String guess = sc.next();
                                                    switch (guess) {
                                                        case "elephant":
                                                            System.out.println("""

                                                            [CHIEF]
                                                            How did you know that...tsk, as per tradition 
                                                            we of the north never break our promises
                                                            i present to you the talisman of prelict
                                                                ______
                                                                \\\\__//      
                                                                 \\\\//                   
                                                                 {{}}        
                                                                    """);
                                                            relics +=1;
                                                            talisman +=1;
                                                            break;
                                                        default:
                                                            break;
                                                    }
                                                if (talisman!=1) {
                                                    System.out.println("""

                                                                    HA HA HA Incorrect too bad for you youngster
                                                                    
                                                                    [you have been ambushed by the chief's guards]
                                                                    """);
                                                    Map.alive = false;
                                                    break;
                                                }
                                            break;
                                        case 2:
                                            System.out.println("[you have been shot by a deligate of the chieften for threathening him...]");
                                            Map.alive = false;
                                            break;
                                        default:
                                            break;
                                    }
                            break;
                        case "no":
                            break;
                    
                        default:
                            break;
                    }
                }
            }
            if (alive) {
                route();
            }         
        }

        if (location == "rockymountains") {
            localMap();

            System.out.println("these mountains looks dangerous");
            if (sword != 1) {
                if (key == 0) {
                    System.out.println("""
                        
                        There is an old looking door beside the mountain
                        i wonder if there is something i can use to open it with...
                        """);
                }
                if (key > 0) {
                    System.out.println("""
    
                            there is a door beside the mountains but it seems to be locked
    
                            [you used the key you obtained to open the door]
                            
                            a loud crackle has passed the winds as the doors opened, inside
                            you have found an old sword belonging to the right hand man of
                            the first king of prelict one of the four relics!
                                   0=={======> 
                                    """);
                    relics +=1;
                    sword+=1;
                    key-=1;
                }
            }
            route();
        }

        if (location == "northwest") {
            if (alive) {
                localMap();
            
                System.out.println("you have located the settlement in the north");

                if (gem != 1) {
                        System.out.println("""
                        
                        The village is being attacked by bandits                    ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                                                                                    ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                                                                                    ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                        !!!the leader has directed his attention to you!!!          ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                                                                                    ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒░░░░░
                                                                                    ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▓█▓▓▓▓▓███▓░░░░░░░░░░░▒░░░░░░░░░░░░░░░░░░░░░░░░░░
                                                                                    ░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▒░░░░░░░░░░░▒░░░░░░░░░░░░░░░░░▒░░▒░░░░
                                                                                    ░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▓███████████▓▓▓████████▓▒▒░░░░░░░▒░░░░░░░░░░░░░░░░░░░░▒░░░░░
                        █▀▀ █ █ █▀█ █▀█ █▀ █▀▀   ▄▀█ █▄ █   ▄▀█ █▀▀ ▀█▀ █ █▀█ █▄ █  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▓██▓▓█▓▓▓█████▓▓▓▓▓▓█▓▓▒▒░░░▒▒▒░░░░░░░░░░░░░░░░░░▒░░░░░░
                        █▄▄ █▀█ █▄█ █▄█ ▄█ ██▄   █▀█ █ ▀█   █▀█ █▄▄  █  █ █▄█ █ ▀█  ░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░░░░░░▒▓▓▓▓▓▓▓▓▓▓▓▓██████████▓▓▓▒▒▒▒░░░░░░░░░░░░░░▒░░▒▒░░▒░░
                                                                                    ░░░░░░░░░░░░░░░░░░░░░░░░▒░░▒▒▒░░░░░░░▒▓ ▓-|-▓▒▓▓▓ ▓█▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░▒▒▒▒░░░░
                        ▄█     █▀▀ █ █▀▀ █ █ ▀█▀                                    ░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒░░▒▒▓ ▓▓▒▒▒▒▒▓▓ ▓▒▒░░░░░░░░▒░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒░░░░
                         █ ▄   █▀  █ █▄█ █▀█  █                                     ░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒░▒▓▓ ▓▓▓▓▓▓▓ █▓▒▒░░░░░░░▒▒▒░░░░░░░░░░░░░░░░░░▒▒▓▒░░░░░
                                                                                    ░░░░░░░░░░░░░░░░▒░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓█ ▓▓▓▓▓ ▓▓▓▓▓▒▒░░░▒▒▒▒▒░░░░░░░░░░░░░░░▒▒▓███▒░░░░░
                        ▀█     █▀█ █ █ █▄ █                                         ░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓     ▓▒▒▓▓▓▓▓▓▓▒▒▒▒▒▒▒░░░░░░░░░░░▒▓▓████▓░░░░░░░
                        █▄ ▄   █▀▄ █▄█ █ ▀█                                         ░░░░░░░░░░▒░░░░░░▒░░░░▒▒▒▒▒▒▓████▓▓▓▓▓▓▒▒▓▓▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒░░░░░░░▒▒▓███▓▒░░░░░░░░░░
                                                                                    ░░░░░░░░░░░░░░░░░░▒░░░▒▒▒▒▒▓██████▓▓▓██▓▒▒▒▓▓██▒▓▓▓█▓▓▓▓▓▓███▓▒▒▒▒░░░▒▒▓███▓▒░░░░░░░░░░░░░
                                                                                    ░░░░░░░░░░░▒░░░░░▒░░░░▒▒▓███████████▓███▓▓▒▓███▓▓▓██▓▓▓▓████████▓▒▒▓▓███▓▒▒░░░░░░░░░░░░░░░
                                                                                    ░░░░░░░░░░░░▒░░░▒▒▒░░▒▓█████████████████████████████▓▓██████████████▓▓▒▒░░░░░░░░░░░░░░░░░░
                                                                                    ░░░░░░░░░░░▒░░░░▒▒▒▒▓█████████████████████▓▓██▓▓▓▓▓▓███████████████▓▒░░░░░░░░░░░░░░░░░░░░░
                                                                                    ░░░░░░░░░░░▒░░░▒▒▒▓██████████████████████▓▓▓▓█▓▓▓▓▓▓▓▓██████████████▓▒░░░░░░░░░░░░░░░░░░░░
                                                                                    ░░░░░░░░░░▒▒▒░▒▒▓████████████████████████▓▓▓▓▓▓██▓▓▓▓▓██▓▓███████████▓▒░░░░░░░░░░░░░░░░░░░
                                                                                    ░░░░░░░░░▒▒▒▒▒▓██████████████████████████▓▓▓▓▓█▓▓▓▒▒▓▒▓▓▓██████████████▓▒░░░░░░░░░░░░░░░░░
                                                                                    
                        
                        
                                                            """);
                                             
                int act = sc.nextInt();
                while (act > 2|| act < 1) {
                    System.out.print("that is not an option![try again]: ");
                    act = sc.nextInt();
                }
                
                
                switch (act){
                    case 1: 
                        while (combat == true) {

                            if (health == 0) {
                                alive = false;
                                combat = false;  
                                break;
                            }

                            System.out.print("pick a move\n1.stab[2 damage] \n2.gun[5 damage]\n");
                            int move = sc.nextInt();
                            switch (move) {
                                case 1:
                                    bossHealth -=2;
                                    if (bossHealth <= 0) {
                                        bossHealth = 0;
                                    }
                                    System.out.println("\nyou slashed the leader");
                                    System.out.println("ramaining boss health: "+bossHealth+"/10\n");

                                    if (bossHealth>0) {
                                        health -=dis.damage();
                                        System.out.println("you have been damage");
                                        System.out.println("ramaining health: "+health+"/10\n");
                                        if (health < 1) {
                                            Map.health = 0;
                                            break;
                                        }
                                    }   
                                    break;
                                        
                                case 2:
                                    bossHealth -=5;
                                    if (bossHealth <= 0) {
                                        bossHealth = 0;
                                    }
                                    System.out.println("\nyou shot the bandit!");
                                    System.out.println("ramaining boss health: "+bossHealth+"/10\n");

                                    if (bossHealth>0) {
                                        health -=dis.damage();
                                        System.out.println("you have been damage");
                                        System.out.println("ramaining health: "+health+"/10\n");
                                        if (health < 1) {
                                            Map.health = 0;
                                            break;
                                        }
                                    }
                                    break;
                                default:
                                    break;
                                }

                                if(bossHealth <= 0) {
                                    System.out.println("you have won the duel against the bandit leader");
        
                                    System.out.println("""
                                            you have found the red gem of prelict, the jewl
                                            worn by the high queen of prelict in the year 1020-1065
                                                    /\\
                                                   //\\\\
                                                   \\\\//
                                                    \\/  
                                                    
                                            [you also found a golden coin, maybe you can use this somewhere]""");
        
                                        coins +=1;
                                        relics +=1;
                                        gem+=1;
                                        break;
                                }
                            }
                    break;
                    case 2:
                        System.out.println("you fled the scene\n");
                        break;
                    }
                }
            }
            
            if (alive) {
                route();
            }
        }         
    }
    
    public static String travelTime(int meter){
        int hours = 0;
        int minutes = 0;
        String time = "";
        if (meter >= 60) {
            hours = meter/60;
            minutes = meter%60;
            time = "Travel Time: "+hours+" hours "+minutes+" minutes\n";
            return time;
        }
        else if (meter<60) {
            minutes = meter;
            time  = "Travel Time: "+ minutes+"minutes\n";
        }
        return time;
    }

    public static void route() {
        System.out.println("""
        {please continue on your journey}
        
        choose a location to investigate""");
        System.out.println("1. capital ");
        System.out.println("2. market ");
        System.out.println("3. fields ");
        System.out.println("4. well ");
        System.out.println("5. southwest village ");
        System.out.println("6. rockymountains ");
        System.out.println("7. northwest village \n");

        System.out.print("enter here: ");

        String destination = "";
        int intDest = sc.nextInt();
        switch (intDest) {
            case 1:
                destination = "capital";
                break;
            case 2:
                destination = "market";
                break;
            case 3:
                destination = "fields";
                break;
            case 4:
                destination = "well";
                break;
            case 5:
                destination = "southwest";
                break;
            case 6:
                destination = "rockymountains";
                break;
            case 7:
                destination = "northwest";
                break;
            default:
                break;
        }
        if (destination == location) {
            System.out.println("[that is your current location, try again]");
            route();
        }
        while(intDest < 1 || intDest > 7) {
            System.out.println("\n[that is not an option, try again]");
            route();
        }

        HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();

        HashMap<String, Integer> capitalEdges = new HashMap<>();
        capitalEdges.put("intersection", Main.capital);
        capitalEdges.put("market", Main.market);
        graph.put("capital", capitalEdges);

        HashMap<String, Integer> intersectionEdges = new HashMap<>();
        intersectionEdges.put("capital", Main.capital);
        intersectionEdges.put("rockymountains", Main.rockyMountains2);
        intersectionEdges.put("northwest", Main.northwestvillage);
        graph.put("intersection", intersectionEdges);

        HashMap<String, Integer> marketEdges = new HashMap<>();
        marketEdges.put("capital", Main.market);
        marketEdges.put("fields", Main.fields);
        marketEdges.put("rockymountains", Main.market2);
        graph.put("market", marketEdges);

        HashMap<String, Integer> fieldsEdges = new HashMap<>();
        fieldsEdges.put("market", Main.fields);
        fieldsEdges.put("well", Main.well);
        graph.put("fields", fieldsEdges);

        HashMap<String, Integer> wellEdges = new HashMap<>();
        wellEdges.put("fields", Main.well);
        wellEdges.put("southwest", Main.southwestvillage);
        graph.put("well", wellEdges);

        HashMap<String, Integer> rockyMountainsEdges = new HashMap<>();
        rockyMountainsEdges.put("intersection", Main.rockyMountains2);
        rockyMountainsEdges.put("market", Main.market2);
        rockyMountainsEdges.put("southwest", Main.rockyMountains);
        graph.put("rockymountains", rockyMountainsEdges);

        HashMap<String, Integer> southwestVillageEdges = new HashMap<>();
        southwestVillageEdges.put("rockymountains", Main.rockyMountains);
        southwestVillageEdges.put("well", Main.southwestvillage);
        graph.put("southwest", southwestVillageEdges);

        HashMap<String, Integer> northwestVillageEdges = new HashMap<>();
        northwestVillageEdges.put("intersection", Main.northwestvillage);
        graph.put("northwest", northwestVillageEdges);

        Set<String> visited = new HashSet<>();
        List<String> path = new ArrayList<>();
        List<List<String>> routes = new ArrayList<>();
        List<Integer> distances = new ArrayList<>();

        // Start DFS from the capital
        DFS(graph, location, destination, visited, path, routes, distances);

        // Print all possible routes with distances
        System.out.println("{{{ Here are the available routes }}}\n");
        for (int i = 0; i < routes.size(); i++) {
            System.out.println(""+(i+1)+". "+routes.get(i) + " - Distance: " + distances.get(i)+"m");
            System.out.println(travelTime(distances.get(i)));
        }

        shortest(routes, distances);

        System.out.print("Please choose a route:");
        int route = sc.nextInt();
        while (route > routes.size()|| route < routes.size() - (routes.size()-1) ) {
            System.out.print("\n[not an option] try again:");
            route = sc.nextInt();
        }
        location = destination;
        map();     
    }

    public static void DFS(HashMap<String, HashMap<String, Integer>> graph, String current, String destination,
                           Set<String> visited, List<String> path, List<List<String>> routes, List<Integer> distances) {
        visited.add(current);
        path.add(current);

        if (current.equals(destination)) {
            routes.add(new ArrayList<>(path));
            distances.add(calculateDistance(path, graph));
        } else {
            HashMap<String, Integer> neighbors = graph.get(current);
            if (neighbors != null) {
                for (String neighbor : neighbors.keySet()) {
                    if (!visited.contains(neighbor)) {
                        DFS(graph, neighbor, destination, visited, path, routes, distances);
                    }
                }
            }
        }
        visited.remove(current);
        path.remove(path.size() - 1);
    }

    public static int calculateDistance(List<String> path, HashMap<String, HashMap<String, Integer>> graph) {
        int distance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            String current = path.get(i);
            String next = path.get(i + 1);
            distance += graph.get(current).get(next);
        }
        return distance;
    }
    public static void shortest(List<List<String>> routes, List<Integer> distances) {

        if (routes.isEmpty() || distances.isEmpty()) {
            System.out.println("No routes available.");
            return;
        }
    
        int shortestDistance = distances.get(0);
        int shortestIndex = 0;
    
        // Find the index of the route with the shortest distance
        for (int i = 1; i < distances.size(); i++) {
            if (distances.get(i) < shortestDistance) {
                shortestDistance = distances.get(i);
                shortestIndex = i;
            }
        }
        // Print the fastest/shortest route
        System.out.println("\n{========[ Shortest route ]========}");
        System.out.println((shortestIndex + 1) + ". " + routes.get(shortestIndex) + " - Distance: " + shortestDistance + "m");
        System.out.println(travelTime(shortestDistance));
    }
    
}