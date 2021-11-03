/*
Program Name:       Palandrome
Date:               July 6th 2018
Author:             Trishal Varma

Program Purpose:   Create a program with palindromes so the program and read and find which words are palindrome.
*/


package bicyclerentalstorepackage;

        import java.io.BufferedReader;

        import java.io.File;

        import java.io.FileInputStream;

        import java.io.FileReader;

        import java.io.InputStreamReader;

        import java.util.Scanner;

public class PalindromeFileExceptionMainClass
{

    public static void main(String[] args)
    {

        FileInputStream fileInputStreamObj = null;

        BufferedReader bufferedReaderObj = null;

        int palindromeCount =0,

                nonpalindromeCount =0;

        try

        {


            fileInputStreamObj = new FileInputStream(new File("words.txt"));

            bufferedReaderObj = new BufferedReader( new InputStreamReader( fileInputStreamObj )) ;

            String wordStrObj;

            while (( wordStrObj = bufferedReaderObj.readLine()) != null)

            {

                if(isPalindrome(wordStrObj))

                {

                    System.out.println("\""+wordStrObj+"\""+" is palindrome.");

                    palindromeCount++;

                }

                else

                {

                    System.out.println("\""+wordStrObj+"\""+" is not palindrome.");

                    nonpalindromeCount++;

                }

            }//while

        }//try

        catch(Exception e)

        {

            System.out.println("Exception");

        }

        System.out.println("\nTotal words read: "+(palindromeCount+nonpalindromeCount));

        System.out.println("Palindrome Words Count: "+palindromeCount);

        System.out.println("Non palindrome Count: "+nonpalindromeCount);

    }

    public static boolean isPalindrome(String s)

    {

        String copy=s.toLowerCase();

        int i=0;

        int j=copy.length()-1;

        while(i<j)

        {

            if(copy.charAt(i)!=copy.charAt(j))

                return false;

            i++;

            j--;

        }

        return true;

    }
}
