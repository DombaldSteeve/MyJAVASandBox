package testBoris;

public class Entier {
	public static void main(String[] args) 
    {
        int max = Integer.parseInt(args[0]);    
        int n = 1;
        int count = 0;
        while (true)
        {
            n++;
            boolean found = false;
            for (int i = 2; i<n; i++)
            {
                if (n % i == 0)
                {
                    found = true;
                    break;
                }
            }
            if (!found)
            {
                System.out.println("N° "+(count+1)+ " = "+n);
                count++;
            }
            if (count >= max)
            {
                break;
            }
        }
         
    }

}

