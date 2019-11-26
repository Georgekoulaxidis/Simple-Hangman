import java.util.Scanner;


public class HangMan {
	
	//variables for the Hangman game
	String MysteryWord=" ";
	boolean finished = false;
	boolean [] FoundLetters;
	String EntryWord =" " ;
	Scanner input = new Scanner(System.in);
	Menu answer = new Menu();
	Lexicon W = new Lexicon();
	String Word = " ";
	char[] EnteredLetters = new char[26];
	char[] WordLetters;
	char[] Alhabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	
	
	
	
	int CurrentTry = 0;
	
	
	//Starting the Game
	public void PlayAGame(int number)
	{
		
		
		
		
		System.out.println("\n----------HANGMAN GAME----------");
		 MysteryWord = W.getWord(number);
		 WordLetters = new char[MysteryWord.length()];
		 
		
		FoundLetters = new boolean[MysteryWord.length()];
		
		
		
		
		while(!finished)
		{
			
			ShowWord();
			if(!(MysteryWord.equals(new String(WordLetters))))
				GetGuess();
			CheckGuess(); 
			if(CurrentTry==8)
			{
				System.out.println("Sorry, but you lost");
				System.out.println("The word was: " +  MysteryWord + "\n");
				finished = true;
			}
		}
		ClearGame();
		
		
	}
	
	//Prints the letters of the word and the -
	public boolean ShowWord()
	{
		
		boolean GoodGuess = false;
		char ch = EntryWord.charAt(0);
		System.out.print("The random word is now: ");
		for(int x = 0; x < MysteryWord.length(); x++)
		{
			if(FoundLetters[x] == true)
			{
				System.out.print(MysteryWord.charAt(x) + " ");
				WordLetters[x] = MysteryWord.charAt(x);
				
			}
			else if(MysteryWord.charAt(x) == ch)
			{
				System.out.print(MysteryWord.charAt(x) + " " );
				WordLetters[x] = MysteryWord.charAt(x);
				FoundLetters[x] = true;
				GoodGuess = true;
				
				
			}
			else
			{
				System.out.print("_ ");
			}
			
		}
		return GoodGuess;
				
	}

	//Gets a Letter from the user 
	public void GetGuess()
	{
		
		System.out.println("\nYou have " + (8-CurrentTry) + " guesses left" );
		System.out.print("Your guess: ");
		do
		{
			Word = input.nextLine();
			EntryWord = Word.toUpperCase();
		}while(CheckLetters(EntryWord));
	
		
		
		
		
	}
	
	//Checks the input of the user
	public void CheckGuess()
	{
		
		boolean GoodGuess;
		
		
		if(MysteryWord.equals(new String(WordLetters)))
		{
				System.out.println("\nCongratulations! You guessed the word: " + MysteryWord + "\n");
				finished = true;
		}
		else
		{
			
			GoodGuess = ShowWord1();
			if(GoodGuess)
			{
				System.out.println("The guess is CORRECT!");
				
			}
			else
			{
				CurrentTry++;
				System.out.println("There are no " + (EntryWord) + "'s in the word.");
			}
		}
	}
	
	//Checks the if the input is not a letter or if it's alerady given 
	public boolean CheckLetters(String text)
	{
		if(new String(Alhabet).indexOf(text.charAt(0)) == -1)
		{
			System.out.println("Wrong insert, try again: ");
			return true;
		}
		
		
		if(new String(EnteredLetters).indexOf(text.charAt(0)) == -1)
		{
			
			for(int i=0; i<26;i++)
			{
				if(EnteredLetters[i] == '\u0000')
				{
					EnteredLetters[i] = text.charAt(0);
					return false;
				}
			}
			
			
		}
		System.out.println("Sorry the letter " + (text) + " is already guessed");
		return true;
		
		
		
		
			
	}
	// This method checks again the GoodGuess variable almost just like ShowWord but it doesn't print anything
	public boolean ShowWord1()
	{
		
		boolean GoodGuess = false;
		char ch = EntryWord.charAt(0);
		
		for(int x = 0; x < MysteryWord.length(); x++)
		{
			if(MysteryWord.charAt(x) == ch)
			{
				
				WordLetters[x] = MysteryWord.charAt(x);
				FoundLetters[x] = true;
				GoodGuess = true;
				
			}
		}
		return GoodGuess;
				
	}
	//This method clears the variables and tables, for a new game
	public void ClearGame()
	{
		for(int i = 0; i < WordLetters.length; i++)
		{
			
			FoundLetters[i] = false;
			WordLetters[i] = '\u0000';
		}
		
		for(int i = 0; i<26;i++)
		{
			EnteredLetters[i] = '\u0000';
			
		}
		MysteryWord = " ";
		finished = false;
		Word = " ";
		CurrentTry = 0;
					
		
		
	}
	
	

	

}
