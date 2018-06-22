import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program takes in an integer between 2 and 100 from the user and will calculate
 * the value of its factorial in terms of the number of primes it contains
 * @author Jacob Parcell
 *
 */
public class FactorsAndFactorials 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);

		ArrayList<Integer> userInput = new ArrayList<Integer>();

		while(true)
		{
			int input = in.nextInt();

			if(input == 0)
			{
				break;
			}
			
			userInput.add(input);
		}

		for(int input : userInput)
		{
			System.out.println(factorial(input, 1));
		}
	}

	public static int factorial(int n, int product)
	{
		if(n == 1)
		{
			return product;
		}
		else
		{
			product = factorial(n - 1, n * product);
		}

		return product;
	}

	public static ArrayList<Integer> findFactors(int number)
	{



		return null;
	}

	public static boolean isPrime(int number)
	{
		if(number % 2 == 0)
		{
			return false;
		}

		for(int i = 3; i < number; i+= 2)
		{

		}
		return false;
	}

}

