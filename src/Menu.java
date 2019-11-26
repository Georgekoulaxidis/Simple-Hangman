import java.util.Scanner;
public class Menu {
	
	
	
	Scanner input = new Scanner(System.in);
	boolean check = false;
	private char answer;
	
	//This class prints the Menu and check the user's input to start or to exit
	public void choice()
	{
		
		
		
		System.out.print("MAIN MENU\n");
		System.out.print("-  Start a new Game (S)\n");
		System.out.print("-  Exit (E)\n");
		System.out.print("Please enter your choice: ");
		
		
		do
		{
			answer = input.next().charAt(0);
		}while((answer != 'S') && (answer != 's') && (answer != 'E') && (answer != 'e'));
		
		
	}
	
	public boolean choice1()
	{
		if(answer == 'S' || answer == 's')
			return true;
		else
			return false;
	}

}
