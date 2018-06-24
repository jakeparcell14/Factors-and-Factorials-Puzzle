import java.util.ArrayList;
import java.util.Collections;
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

		//create arraylist of all primes less than 100
		ArrayList<Integer> primes = new ArrayList<Integer>();
		findPrimes(primes);

		//take in all user input before performing operations
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

		// iterate through user input to factor and print for each given number
		for(int input : userInput)
		{
			ArrayList<Integer> factors = findFactors(input, primes);

			printFactors(input, factors);
		}
	}

	/**
	 * prints all factors of a given number
	 * @param number	number who's factorial was calculated
	 * @param factors	factors of the number
	 */
	public static void printFactors(int number, ArrayList<Integer> factors)
	{
		String num = "";
		//format number
		if(number < 100)
		{
			num = " " + number;
			
			if(number < 10)
			{
				num = " " + num;
			}
		}
		else
		{
			num = Integer.toString(number);
		}
		System.out.print(num + "! = ");

		// print all factors and create a new line every fifteen numbers
		for(int i = 0; i < factors.size(); i++)
		{
			if(i % 15 == 0 && i > 0)
			{
				System.out.println();
				System.out.print("       ");
			}
			
			if(factors.get(i) != 0)
			{
				String fac = "";
				
				//format factor
				if(factors.get(i) < 100)
				{
					fac = " " + factors.get(i);
					
					if(factors.get(i) < 10)
					{
						fac = " " + fac;
					}
				}
				System.out.print(fac);
			}
			else
			{
				break;
			}
		}

		System.out.println();
	}

	/**
	 * finds all factors of a given number
	 * @param number	number to be factored
	 * @param primes	all prime numbers less than 100
	 * @return			arraylist of all factors
	 */
	public static ArrayList<Integer> findFactors(int number, ArrayList<Integer> primes)
	{		
		ArrayList<Integer> factors = new ArrayList<Integer>(Collections.nCopies(primes.size(), 0));

		// iterate through all numbers being multiplied in the factorial
		for(int i = 2; i <= number; i++)
		{
			if(primes.contains(i))
			{
				// i is a prime number
				factors.set(primes.indexOf(i), factors.get(primes.indexOf(i)) + 1);
			}
			else
			{
				int factorable = i;
				// i is not a prime number so reduce it using a prime less than the square root of the number
				for(int j = 0; primes.get(j) * primes.get(j) <= factorable; j++)
				{
					while(factorable % primes.get(j) == 0)
					{
						factorable = factorable / primes.get(j);
						factors.set(j, factors.get(j) + 1);

						if(primes.contains(factorable))
						{
							factors.set(primes.indexOf(factorable), factors.get(primes.indexOf(factorable)) + 1);
							break;
						}
					}
				}
			}
		}
		return factors;
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

		while(number <= 100)
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
			// number is even and therefore not prime
			return false;
		}

		// if given number is not even, check all odd numbers for factors
		for(int i = 3; i < number; i+= 2)
		{
			if(number % i == 0)
			{
				return false;
			}
		}
		return true;
	}
}

