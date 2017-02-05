package core;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class PlayersIdExtractor {
	public static void main(String ar[] ) throws Exception {
		String[] args= {"[nba.p.1234] shoots the ball.  Assist by [nba.p.4533]","[nba.p.4567] offensive rebound"}; 
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        while (stdin.hasNextLine()) {
        	String string = stdin.nextLine();
			String names = null;
			while(string.contains("[") && string.contains("]")){
				String name = string.substring(string.indexOf("[") +1, string.indexOf("]") );
				if(names == null){
					names = name;
				}else{
					names = names + ","+ name ;
				}
				string = string.substring(string.indexOf("]") + 1);
			}
			if(names != null){
				System.out.println(names);
			}
		}
     }
}
