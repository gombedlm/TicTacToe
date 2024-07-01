
// Just to help me remember the return types.

// input.hasNextInt() - This input is of type Integer.
// input.hasNextFloat() - This input is of type Float.
// input.hasNextLine() - This input is of type String.
// input.hasNextDouble() - This input is of type Double.
// hasNextBoolean() - This input is of type Boolean.

// Start of file

// Imports
import java.util.Scanner;
public class SafeInput
{

    // Get a String that is not a length equal to zero from the user
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length loop runs until the user enters something (so it != 0)
        do
        {
            String trash = "";
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextInt())
            {
                trash = pipe.nextLine();
                System.out.println("Denied Input: " + trash);
            } else if (pipe.hasNextDouble())
            {
                trash = pipe.nextLine();
                System.out.println("Denied Input: " + trash);
            }else
            {
                retString = pipe.nextLine();
            }
        }
        while (retString.length() == 0);

        return retString;
    }

    // Get an Integer from the user
    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt = 0;
        String trash;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                System.out.print("Accepted Input: ");
                break;

            } else
            {
                trash = pipe.nextLine();
                System.out.println("Denied Input: " + trash);
            }
        } while (true);

        return retInt;
    }

    // Get a Double from the user
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retDouble;
        String trash;
        do {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextDouble())
            {
                retDouble = pipe.nextDouble();
                System.out.println("Accepted Input: " + retDouble);
                break;

            } else
            {
                trash = pipe.nextLine();
                System.out.print("Denied Input: " + trash);
            }
        }
        while (true);

        return retDouble;
    }

    // Get an Integer that is within a set range from the user (the range used is a pre-set variable set by the developer)
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        String trash;
        int retInt = 0;

        do
        {
            System.out.print("\n" + prompt + " " + low + " - " + high + ": ");


            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();

                if (retInt == low - 1 || retInt == high + 1)
                {
                    trash = pipe.nextLine();
                    System.out.print("Denied Input: " + trash);
                } else
                {
                    System.out.print("Accepted Input: " + retInt);
                    break;
                }
            } else
            {
                if(pipe.next().equalsIgnoreCase("quit")){
                    return -1;
                } else {
                    trash = pipe.nextLine();
                    System.out.print("Denied Input: " + trash);
                }

            }
        }
        while (true);
        return retInt;
    }

    // Get a Double that is within a set range from the user (the range used is a pre-set variable set by the developer)
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        String trash;
        double retDouble = 0;

        do
        {
            System.out.print("\n" + prompt + " " + low + " - " + high + ": ");

            if (pipe.hasNextDouble())
            {
                retDouble = pipe.nextDouble();

                if (retDouble == low - 1 || retDouble == high + 1)
                {
                    trash = pipe.nextLine();
                    System.out.println("Denied Input: " + trash);

                } else
                {
                    System.out.println("Accepted Input: " + retDouble + "\n");
                    break;

                }
            } else
            {
                trash = pipe.nextLine();
                System.out.print("Denied Input: " + trash);
            }

        } while (true);

        return retDouble;
    }

    // Get a yes / no response from the user and return a true / false value
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retBoolean = false;
        String trash = "";


        do
        {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextLine())
            {

                String input = pipe.next();

                if (input.equalsIgnoreCase("y"))
                {
                    retBoolean = true;
                    System.out.print("Accepted Input: " + input);
                    break;

                } else if (input.equalsIgnoreCase("n"))
                {
                    System.out.print("Accepted Input: " + input);
                    break;

                } else
                {
                    trash = pipe.nextLine();
                    System.out.print("Denied Input: " + trash);
                }

            } else
            {
                trash = pipe.nextLine();
                System.out.print("Denied Input: " + trash);
            }
        }
        while (true);

        return retBoolean;
    }

    // Get a String that is in a specific pattern utilizing the regEx packages
    public static String getRegExString(Scanner pipe, String prompt, String regExPattern)
    {
        String value = "";
        boolean gotAValue = false;

        do
        {
            System.out.println(prompt + ": ");

            value = pipe.nextLine();

            if (value.matches(regExPattern))
            {
                gotAValue = true;
            } else
            {
                System.out.println("\nInvalid input: " + value);
            }

        }
        while (!gotAValue);

        return value;
    }
}