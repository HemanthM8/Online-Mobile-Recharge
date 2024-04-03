package Pack;
import java.io.*;
import java.util.*;
public class DisplayPlans
{
    public int Services()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Our service Providers");
        System.out.println("1.Airtel\n2.VI\n3.Jio");
        System.out.println();
        int choice=0;
        boolean flag=true;
        while(flag)
        {
            choice=Input();
            switch (choice)
        {
            case 1:
                Plans("Pack\\Airtelpre.txt");
                flag=false;
                break;
            case 2:
                Plans("Pack\\Vipre.txt");
                flag=false;
                break;
            case 3:
                Plans("Pack\\Jiopre.txt");
                flag=false;
                break;
            default:
                System.out.println();
                System.out.println("Service not available");
                flag=true;
                break;
        }
    }
    return choice;
}

private int Input()
{
    Scanner sc=new Scanner(System.in);
    int choice=0;
    boolean flag=true;
    while(flag)
    {
        try
        {
            System.out.print("Enter your choice ");
            choice=sc.nextInt();
            flag=false;
        }
        catch (Exception e)
        {
            System.out.println();
            System.out.println("Not a Valid option");
            sc.nextLine();
            flag=true;
        }
    }
    return choice;
}

    public void Plans(String f)
    {
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String s=br.readLine();
            while(s!=null)
            {
                System.out.println(s);
                s=br.readLine();
            }
            System.out.println();
            br.close();
        } 
        catch (Exception e)
        {
            System.out.println("File not found");
        }       
    }
}