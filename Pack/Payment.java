package Pack;
import java.util.*;
public class Payment
{
    ArrayList<Integer> Airtel = new ArrayList<>(Arrays.asList(239,265,299,2999,3359));
    ArrayList<Integer> Vi = new ArrayList<>(Arrays.asList(299,399,601,719,839,1066,2899,3099));
    ArrayList<Integer> Jio = new ArrayList<>(Arrays.asList(239,299,666,749,808,1099,2999,3227));
    public int RechargeAmt(int ch)
    {
        int Amt=0;
        boolean flag=true;
        while(flag)
        {
            try
            {
                Amt=Input();
                switch(ch)
                {
                    case 1:
                    if(!Airtel.contains(Amt))
                    {
                        System.out.println();
                        throw new MyException("This recharge plan is not available");
                    }
                    flag=false;
                    break;
                    case 2:
                    if(!Vi.contains(Amt))
                    {
                        System.out.println();
                        throw new MyException("This recharge plan is not available");
                    }
                    flag=false;
                    break;
                    case 3:
                        if(!Jio.contains(Amt))
                        {
                            System.out.println();
                            throw new MyException("This recharge plan is not available");
                        }
                    flag=false;
                    break;
                }
            }
            catch(MyException e)
            {
                flag=true;
            }
        }
        return Amt;
    }

    private int Input()
    {
        Scanner sc=new Scanner(System.in);
        int amt=0;
        boolean flag=true;
        while(flag)
        {
            try
            {
                System.out.print("Enter your Recharge amount ");
                amt=sc.nextInt();
                flag=false;
            }
            catch (Exception e)
            {
                System.out.println("Not a Valid option");
                System.out.println();
                sc.nextLine();
                flag=true;
            }
        }
        return amt;
    }
}
