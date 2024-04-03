import Pack.*;
import java.util.*;

class Recharge
{
    public static void main(String[] args) 
    {
        DisplayPlans obj = new DisplayPlans();
        Payment pay = new Payment();
        DisplayBill b=new DisplayBill();
        System.out.println("******************************");
        System.out.println("Welcome to Online Recharge");
        System.out.println("------------------------------");
        System.out.println();
        long number=Input();
        System.out.println();
        int choice = obj.Services();
        System.out.println();
        int rechargeAmt=pay.RechargeAmt(choice);
        b.Receipt(choice, rechargeAmt,number);
        System.out.println("*******************************");
    }

    private static long Input()
    {
        Scanner sc=new Scanner(System.in);
        long num=0;
        boolean flag=true;
        while(flag)
        {
            try
            {
                System.out.print("Enter your mobile number ");
                num=sc.nextLong();
                flag=false;
                try
                {
                    if(Long.toString(num).length()!=10)
                    {
                        throw new MobileNumExe();
                    }
                } 
                catch (MobileNumExe e)
                {
                    System.out.println();
                    System.out.println(e);
                    sc.nextLine();
                    flag=true;
                }
            }
            catch (Exception e)
            {
                System.out.println();
                System.out.println("Not a Valid mobile number");
                sc.nextLine();
                flag=true;
            }
        }
        return num;
    }
}