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

		ArrayList<Integer> primes = new ArrayList<Integer>();
		findPrimes(primes);
		
		for(int i = 0; i < 25; i++)
		{
			System.out.println(primes.get(i));
		}
		
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

	public static ArrayList<Integer> findFactors(int number, ArrayList<Integer> primes)
	{		
		ArrayList<Integer> factors = new ArrayList<Integer>();

		return null;
	}
	
	/**
	 * fills an array with all primes less than 100
	 * @param primes
	 */
	public static void findPrimes(ArrayList<Integer> primes)
	{
		primes.add(2);
		
		// current index of the prime array
		int count = 1;
		
		// possible prime number
		int number = 3;
		
		while(count < 25)
		{
			// checks if a number is prime
			if(isPrime(number))
			{
				// number is prime and is added to array
				primes.add(number);
				count++;
			}
			
			number += 2;
		}
	}

	/**
	 * calculates if a given number is prime or not
	 * @param number 			value to be tested
	 * @return					true if the number is prime, false if not
	 */
	public static boolean isPrime(int number)
	{
		if(number % 2 == 0)
		{
			return false;
		}

		for(int i = 3; i < number; i+= 2)
		{
			if(number % i == 0)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * recursive function that calculates the factorial of a given number
	 * @param n number given for factorial
	 * @param product value of factorial
	 * @return factorial of n
	 */
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
}

