package Component;

import javax.swing.JButton;
import Game.game;

public class RandomMole extends Image{
	public static  int index;
	public static  int index_old;
	
	public RandomMole(){
		
	}
	
	public static void  RandomInt() {
		 index=(int)(Math.random()*(mole_bt.length));//Explicit casting
		 if(game.t>2) {
			 if(index==game.index_list.get(game.t-2)) {
				 RandomInt();
				 
			    }
			 }
		 		
		 else if(game.t>1) {
			 if(index==game.index_list.get(0)) {
				 RandomInt();}	 
			 }
 
	}
	
	public static JButton Select () {
		return mole_bt[index];
	}
	
	public static JButton Select_old () {
		return mole_bt[index_old];
	}
	

}
