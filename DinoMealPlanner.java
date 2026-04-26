// Programmer: Jason Ash
// Discription: Learn Java With Projects,  Chapter 5 Project: Dino Meal Planner
// Filename: DinoMealPlanner.java
// Creation date: 25, April 2026

import java.util.Scanner;
import java.util.InputMismatchException;
public class DinoMealPlanner
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		boolean validHourInput = true, validDinoQtyInput = true;
		String mealName = "";
		final int BRACHIOSAURUS_KG_PER_MEAL = 250;
		final int T_REX_KG_PER_MEAL = 100;
		char anotherSelection;
		
		do
		{
			int numberOfBrachiosaurus = 0, numberOfTRex = 0, hour = 0, totalMealKg = 0;
			do
			{
				System.out.print("Enter the hour in military time to find out if it\'s feeding time and for which dinosaur --> ");
				try
				{
            				hour = sc.nextInt();	
					if((hour >= 0) && (hour <= 24))
					{
						validHourInput = true;	
					}
					else
					{
						System.out.println("You must enter a valid time between 0 and 24.");
						validHourInput = false;
						sc.nextLine();
					}
				} // end try block
				catch (InputMismatchException e)
 				{
    					sc.nextLine(); // Discard the invalid input from the buffer
					System.out.println("Invalid input. Please enter a number.");
					validHourInput = false;
				} // end try-catch block for obtaining the hour
			} while(!validHourInput); // end do-while to get the hour from user input block
			
			// Determining which string will be displayed for the meal name
			if(hour == 7 || hour == 8)
			{
				mealName = "breakfast";
			}
			else if(hour == 11)
			{
				mealName = "brunch";
			}
			else if(hour == 14)
			{
				mealName = "Lunch";
			}
			else if(hour == 15)
			{
				mealName = "mid-afternoon snack";
			}
			else if((hour == 19) || (hour == 20))
			{
				mealName = "Dinner";
			}
			/* else
			{
				System.out.println("A serious error has occurred in determining which name to assign to which meal based on the hour.");
			}*/

			switch(hour)
			{
				case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 9: case 10: case 12: case 13: case 16: case 17: case 18: case 21: case 22: case 23: case 24:
					System.out.println("No dinosaur feedings are scheduled at this hour.");
					break;
				case 7: case 11: case 15: case 19:
					System.out.println("It is time for the Brachiosaurus\' " + mealName + ".");
					do
					{
						System.out.print("How many Brachiosaurus do you need to feed? --> ");
						try
						{
            						numberOfBrachiosaurus = sc.nextInt();	
							if(numberOfBrachiosaurus >= 0)
							{
								validDinoQtyInput = true;	
							}
							else
							{
								System.out.println("You must enter a valid number of Brachiosaurus greater than or equal to 0.");
								validDinoQtyInput = false;
								sc.nextLine();
							}
						} // end try block to obtain number of Brachiosaurus
						catch (InputMismatchException e1)
 						{
    							sc.nextLine(); // Discard the invalid input from the buffer
							System.out.println("Invalid input. Please enter a number.");
							validDinoQtyInput = false;
						} // end try-catch block for obtaining number of Brachiosaurus
					} while(!validDinoQtyInput); // end do-while for obtaining number of Brachiosaurus

					totalMealKg = BRACHIOSAURUS_KG_PER_MEAL * numberOfBrachiosaurus;	
				
					System.out.println("At " + BRACHIOSAURUS_KG_PER_MEAL + "Kg per Brachiosaur per meal, please prepare " + totalMealKg + " for the Branchiosaurus for their feeding this hour.");
					break;
				case 8: case 14: case 20:
					System.out.println("It is time for the T-Rex\'s " + mealName + ".");
					do
					{
						System.out.print("How many T-Rex do you need to feed? --> ");
						try
						{
            						numberOfTRex = sc.nextInt();	
							if(numberOfTRex >= 0)
							{
								validDinoQtyInput = true;	
							}
							else
							{
								System.out.println("You must enter a valid number of T-Rex greater than or equal to 0.");
								validDinoQtyInput = false;
								sc.nextLine();
							}
						} // end try block to obtain number of T-Rex
						catch (InputMismatchException e2)
 						{
    							sc.nextLine(); // Discard the invalid input from the buffer
							System.out.println("Invalid input. Please enter a number.");
							validDinoQtyInput = false;
						} // end try-catch block for obtaining number of T-Rex
					} while(!validDinoQtyInput); // end do-while for obtaining number of Brachiosaurus

					totalMealKg = T_REX_KG_PER_MEAL * numberOfTRex;	
				
					System.out.println("At " + T_REX_KG_PER_MEAL + "Kg per T-Rex per meal, please prepare " + totalMealKg + " for the T-Rex for their feeding this hour.");
					break;
				default:
					break;					
			} // end swtich for matching hour to dinosaur feeding time and meal

			System.out.println("Would you like to enter another hour?");
			System.out.print("Y or y for yes, anything else for no --> ");
			anotherSelection = sc.next().charAt(0);
		} while(anotherSelection == 'Y' || anotherSelection == 'y'); // end main do-while loop for making an hour selection 		
	} // end main
} // end class DinoMealPlanner