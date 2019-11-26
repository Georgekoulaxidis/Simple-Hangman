
import java.util.Random;
//Main calls all the classes, make a random int and end the programm
public class Main {
	public static void main (String[] args)
	{
		
		Menu answer = new Menu();
		Random r = new Random();
		HangMan Word = new HangMan();
		int  w1;
		
		
		
		
		do
		{
			w1 = r.nextInt(21);
			answer.choice();
			if(!answer.choice1())
				break;
			Word.PlayAGame(w1);
			
			
			
			
			
			
		}while(answer.choice1() );
		
		System.out.print("\n----------THE END!----------");
	}
}
