package com.BusiWave.ChallengingHacks;

public class Prime 
{
    public static void main(String[] args) 
    {
       for(int i = 1; i <= 100; i++)
       {
         if (isPrimeNumber(i))
         {
            System.out.println(i);
         }
       }
    }


    public static boolean isPrimeNumber(int i) {
        int factors = 0;
        int j = 1;

        while(j <= i)
        {
            if(i % j == 0)
            {
                factors++;
            }
            j++;
        }
        return (factors == 2);
  }
}