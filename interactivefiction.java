import java.util.*;
public class InteractiveFiction {
	public static void main(String[] args) {
		//EC Split method and Equals method on Keywords 
		String[] common = {"also", "bad", "because", "but", "by", "crazy", "day", "for", "from", "good", "how", "just", "most", "no", "other", "people", "some", "speak", "speech", "strange", "talk", "them", "then", "think", "way", "what", "where", "who", "why", "with", "yes", "you"};
		String[] jabber = {"ancient", "ballerina", "banana", "bankroll", "berserker", "birthplace", "blathering", "bouncy", "boutique", "candelabra", "cannibal", "capacitor", "circuit", "crash", "craven", "creepy", "dance", "dangerous", "daring", "dastardly", "download", "dragon", "ego", "evaluate", "feudal", "fiery", "flux", "funky", "ghostly", "glass", "gold", "grizzly", "hatch", "Hogwarts", "horn", "impure", "jump", "muscle", "near", "nicest", "omnivore", "parasite", "patronus", "punch", "salad", "savage", "seven", "shameful", "since", "slither", "sonic", "spaceship", "square", "tango", "tape", "throughout", "upon", "volcano"};
		String[] keywords = {"north", "south", "east", "west", "look", "map", "help", "Quit", "love", "weather", "name", "beautiful", "hello", "hi"};
		Scanner hello = new Scanner(System.in);
		System.out.println("interactive-fiction 1.0");
		System.out.print("Name: ");
		
		String playername = hello.nextLine();
		String[][] descriptions = initdescriptions(playername);
		System.out.println("Welcome to Illyria, " + playername);
		
		int playerrow = 1; 
		int playercolumn = 1; 
		printMap(playerrow, playercolumn);
		String line = getUserInput(hello);
		String keyword = getKeyword(line, keywords); 
		System.out.println(common.length + " " + jabber.length);
		while((keyword == null) || !keyword.equalsIgnoreCase("Quit")) {
			if (keyword.equalsIgnoreCase("North")) {
				if(playerrow != 0) {
					playerrow--;
					System.out.println(descriptions[playerrow][playercolumn]);
					printMap(playerrow, playercolumn);
				} 
			} else if (keyword.equalsIgnoreCase("South")) {
				if(playerrow != 2) {
					playerrow++; 
					System.out.println(descriptions[playerrow][playercolumn]);
					printMap(playerrow, playercolumn);
				}
			} else if (keyword.equalsIgnoreCase("East")) {
				if(playercolumn != 2) {
					playercolumn++; 
					System.out.println(descriptions[playerrow][playercolumn]);
					printMap(playerrow, playercolumn);
				}
			} else if (keyword.equalsIgnoreCase("West")) {
				if(playercolumn != 0) {
					playercolumn--;
					System.out.println(descriptions[playerrow][playercolumn]);
					printMap(playerrow, playercolumn);
					
				}
			} else if (keyword.equalsIgnoreCase("Look")) { 
				System.out.println(descriptions[playerrow][playercolumn]);
			} else if (keyword.equalsIgnoreCase("Map")) {
				printMap(playerrow, playercolumn);
			} else if (keyword.equalsIgnoreCase("Help")) {
				getHelp(keywords);
			} else if ((playerrow == 2) && (playercolumn == 1)) {
				getJabberwordyResponse(line);
			}
			
			
			else {
				ArrayList<String> responses = getTalkResponses(keyword, playername, playerrow, playercolumn);
				System.out.println(getRandomElement(responses));
			}
			
		 line = getUserInput(hello);
		 keyword = getKeyword(line, keywords); 
			
			
		}
		
		
		
		
		
		
	}
	public static String[][] initdescriptions(String playername) {
		String[][] desc = new String[3][3];
		desc[0][0] = "Wind blows over your face, as the grass sways beside you. As you look around, you see buildings not far away.";
		desc[0][1] = "You arrive at a small cliffside town of Dewsbury, which thrives off fishing and trade. ";
		desc[0][2] = "The countryside is hilly and rough, you see a cave not far off and wander inside for warmth and rest.";
		desc[1][1] = "You arrive at the rural town of Gilramore, you see an old man sitting on his porch as a tumbleweed crosses the road.";
		desc[1][2] = "A small lake laies up ahead, and a few people seem to be sunbathing around it.";
		desc[2][0] = "A large town laies up ahead, with tall buildings, perhaps the town you saw earlier, you realize it's Illyria's capital, Craydon";
		desc[2][1] = "A thick forest laies ahead, it looks dark and ominous, but you carry on anyways.";
		desc[2][2] = "A scorching desert, wind and sand whip across your face, it stings.";
		return desc; 
		
	}
	public static void printMap(int playerrow, int playercolumn) {
		//nested for loops to print a map 
		for(int i = 0; i < 3; i++) { //This for loop, makes the rows 
			printMapSeperator();
			for(int j = 0; j < 3; j++) { //This for loop makes a specific square for current row and column 
				System.out.print("| ");
				if ((i == playerrow) && (j == playercolumn)) { //This prints the X (character) or the space's (empty space) 
					System.out.print("X "); 
				} else {
					System.out.print("  ");
				}
			}
			System.out.println("|");
		}
		printMapSeperator();
	
}
	public static void printMapSeperator() {
		System.out.println("*------------*");
	}
	
	public static String getUserInput(Scanner hello) {
		System.out.print(">");
		String input = hello.nextLine();
		return input;  
	}
	public static String getKeyword(String line, String[] keywords) {
		//Look into cutting un-needed return statements 
		for(String value : keywords) {
			if (line.toLowerCase().contains(value)) {
				return value; 
			}
		}
		return null;
	}
	public static void getHelp(String[] key) { //If time allows reformat output to single line. 
		System.out.println("Keywords: ");
		for(int i = 0; i < key.length; i++) {
			System.out.println(key[i].toString());
			
		}
		
	}
	public static ArrayList<String> getTalkResponses(String key, String name, int row, int column ) {
		ArrayList<String> loveresponses = new ArrayList<String>(
				Arrays.asList("Oh shucks.", "I'm flattered!", "I love you too!", "Get outta my face", "Whatever floats your boat"));
		ArrayList<String> helloresponses = new ArrayList<String>(
				Arrays.asList("Hello!", "What's up!", "Have I met you before?", "Um.. hi?", "Get out of my face!"));
		ArrayList<String> weatherresponses = new ArrayList<String>(
				Arrays.asList("Looks pretty rough today", "Beautiful isn't it?", "Quite the storm we got.", "Hail the size of my fist!", "Finally some Sun."));
		ArrayList<String> beautifulresponses = new ArrayList<String>(
				Arrays.asList("Why thank you!", "You're right, it is a beautiful area huh?", "Creep, get away", "Your right I am beautiful.", "It is a rather pretty rock huh?"));
		ArrayList<String> nameresponses = new ArrayList<String>(
				Arrays.asList("Isn't your name" + name + "?", "My name? It's hard to pronounce", "Your name is beautiful", "His name is Jeff", "Names hold power. Do not utter them unless need be."));
		if(key.equalsIgnoreCase("love")) {
			return loveresponses; 
		} else if ((key.equalsIgnoreCase("hello")) || (key.equalsIgnoreCase("hi"))) {
			return helloresponses;
		} else if (key.equalsIgnoreCase("beautiful")) {
			return beautifulresponses; 
		} else if (key.equalsIgnoreCase("name")) {
			return nameresponses; 
		} else if (key.equalsIgnoreCase("weather")) {
			return weatherresponses; 
		} else {
			return null;
		}
	}
	public static String getRandomElement(ArrayList<String> list) {
		Random num = new Random();
		int rand = num.nextInt(5);
		return list.get(rand);
	}
	public static String getJabberwordyResponse(String line) {
		String[] common = {"also", "bad", "because", "but", "by", "crazy", "day", "for", "from", "good", "how", "just", "most", "no", "other", "people", "some", "speak", "speech", "strange", "talk", "them", "then", "think", "way", "what", "where", "who", "why", "with", "yes", "you"};
		String[] jabber = {"ancient", "ballerina", "banana", "bankroll", "berserker", "birthplace", "blathering", "bouncy", "boutique", "candelabra", "cannibal", "capacitor", "circuit", "crash", "craven", "creepy", "dance", "dangerous", "daring", "dastardly", "download", "dragon", "ego", "evaluate", "feudal", "fiery", "flux", "funky", "ghostly", "glass", "gold", "grizzly", "hatch", "Hogwarts", "horn", "impure", "jump", "muscle", "near", "nicest", "omnivore", "parasite", "patronus", "punch", "salad", "savage", "seven", "shameful", "since", "slither", "sonic", "spaceship", "square", "tango", "tape", "throughout", "upon", "volcano"};
		for(int i = 0; i < common.length; i++) {
			int j = (i >= jabber.length - 1) ? 0 : i;
			line.replace(common[i], jabber[i]);
			
		}
		return line;
	}
}
