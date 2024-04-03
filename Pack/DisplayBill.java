package Pack;
import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

interface DouAmt 
{
    double convert(int n);
}

class RThread extends Thread
{
    Thread t;
    public void run()
    {
        try
        {
            System.out.println("Your transaction is being processed");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}

public class DisplayBill 
{
    public Map<String,Double> map=new HashMap<>();
    public void Receipt(int ch,int amt,long ph)
    {
        DouAmt a=(n)->(double)n;
        switch (ch)
        {
            case 1:
                map.put("Airtel",a.convert(amt));
                BillFile(ph, "Airtel");
                break;
            case 2:
                map.put("Vi",a.convert(amt));
                BillFile(ph,"Vi");
                break;
            case 3:
                map.put("Jio",a.convert(amt));
                BillFile(ph, "Jio");
                break;
        }
    }

    public void BillFile(long ph,String prov)
    {
        RThread Rt = new RThread();
        Rt.start();
        try
        {
            Thread.sleep(5000);
            FileWriter fw=new FileWriter("Bill.txt",true);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            fw.write("--------------------------------------------------\n");
            fw.write("\t\t\t\t\tReceipt \t\t\t\n");
            fw.write("--------------------------------------------------\n");
            fw.write("\t\t\tService Provider:\t"+prov+"\n");
            fw.write("\t\t\tPhone Number\t:\t"+ph+"\n");
            fw.write("\t\t\tRecharge amount\t:\t"+map.get(prov)+"\n");
            fw.write("\t\t\tDate\t\t\t:\t"+LocalDate.now()+"\n");
            fw.write("\t\t\tTime\t\t\t:\t"+LocalTime.now().format(formatter)+"\n");
            fw.write("--------------------------------------------------\n");
            fw.close();

            System.out.println("-------------------------------------------------");
            Thread.sleep(3000);
            System.out.println("\t\t\tReceipt \t\t\t");
            System.out.println("--------------------------------------------------");
            Thread.sleep(3000);
            System.out.println("\t\tService Provider:\t"+prov);
            Thread.sleep(3000);
            System.out.println("\t\tPhone Number\t:\t"+ph);
            Thread.sleep(3000);
            System.out.println("\t\tRecharge amount\t:\t"+map.get(prov));
            Thread.sleep(3000);
            System.out.println("\t\tDate\t\t:\t"+LocalDate.now());
            Thread.sleep(3000);
            System.out.println("\t\tTime\t\t:\t"+LocalTime.now().format(formatter));
            Thread.sleep(3000);
            System.out.println("--------------------------------------------------");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}


