package com.iAnatoly.multiplication.helpers;

import java.util.Scanner;

public class InputHelper
{
    private static Scanner keyboard = new Scanner(System.in);
    public static int getNumber(String message)
    {
        System.out.print(message+" ");
        int result = keyboard.nextInt();
        keyboard.nextLine(); // consume \n. Java is ridiculous.
        return result;
    }

	public static int getNumberWithDefault(String message,int defaultValue)
    {
        while (true)
        {
            try
            {
                System.out.print(String.format("%s [default=%s] ",message, defaultValue));
                String nextLine = keyboard.nextLine();
                if (nextLine.trim().isEmpty())
                    return defaultValue;
                else
                    return Integer.parseInt(nextLine);
            }
            catch (NumberFormatException e)
            {
                System.out.println("That is not a number");
            }
        }
    }

    public static boolean getBooleanAnswerWithDefault(String message, boolean defaultValue)
    {
        while (true)
        {
            System.out.print(String.format("%s [default=%s] ",message,defaultValue?"yes":"no"));
            String response = keyboard.nextLine();
            if ("yes".equalsIgnoreCase(response))
            {
                return true;
            }
            else if ("no".equalsIgnoreCase(response))
            {
                return false;
            }
            else if (response.isEmpty())
            {
                return defaultValue;
            }
            System.out.println("Please answer 'yes' or 'no'");
        }
    }

    public static int getSelection (int max)
    {
        while(true)
        {
            int result = InputHelper.getNumber("Please enter your choice: ");
            if (result>0 && result<=max)
            {
                return result;
            }
            System.out.println(String.format("Incorrect selection. Expecting a number [1...%s]",max));
        }
    }

    public static void pause()
    {
        System.out.print("Press [ENTER] to end the session");
        keyboard.nextLine();
    }
}
