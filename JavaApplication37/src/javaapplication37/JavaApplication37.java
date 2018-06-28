package courseproject;
import  java.util.Scanner;

class MinimumMarks extends Exception
{
    MinimumMarks()
    {
    }
}    

class Sgpa
{
     Scanner s1=new Scanner(System.in);
     int n=8,i;
    double marks[]=new double[n];
    double eval[]=new double[n];
    double credits[]=new double[n];
    double cigi=0,csum=0;
    double SGPA;
    
    void enterData()
    {        
        //Scanner s1=new Scanner(System.in);
        for(i=0;i<n;i++)
        {
             int j;
             double ciem=0,seem=0;
             j=i+1;
             System.out.println("Enter the credits for the subject"+j+":") ;
             credits[i]=s1.nextDouble();
                
             System.out.println("Enter the CIE marks of the subject"+j+":");
             ciem=s1.nextDouble(); 
             System.out.println("Enter the expected SEE marks of the subject"+j+":");
             seem=s1.nextDouble(); 
             marks[i]=ciem+(seem/2);
             if(credits[i]==2)
              {
                 marks[i]=marks[i]*2;
             }
             System.out.println("m=" +marks[i]);
         }
    }
    
    void evaluate()
    {
        
        for(i=0;i<8;i++)
        {
        
        
            if(marks[i]>=90)
                eval[i]=10;
            else if(marks[i]>=80)
                eval[i]=9;
            else if(marks[i]>=70)
                eval[i]=8;
            else if(marks[i]>=60)
                eval[i]=7;
            else if(marks[i]>=50)
                eval[i]=6; 
            else if(marks[i]>=45)
                eval[i]=5;
            else if(marks[i]>=40)
                eval[i]=4;        
            else 
                eval[i]=0;
        
            cigi=cigi+credits[i]*eval[i];     
            csum=csum+credits[i];
        }
        SGPA=cigi/csum;
        
    }   
    
    void printResult() throws MinimumMarks
    {
        int flag=0;
        System.out.println("Your Results are");
        System.out.println("SGPA= " + SGPA);
        
        try
        {
            for(i=0;i<8;i++)
            {
                if(eval[i]==0)
                {
                    flag=1;
                    throw new MinimumMarks();
                    
                }
            }   
            if(flag==0)
            {
                System.out.println("Status is PASS");
            }
        }
        catch(Exception e)
        {
            System.out.println("Status is FAIL");
        }
    }
}

class Cgpa extends Sgpa
{
    double CGPA;
    
    void enterData()
    {        
        System.out.println("Enter the no. of semesters completed:");
        n=s1.nextInt();
        for(i=0;i<n;i++)
        {
             int j;
             j=i+1;
             System.out.println("Enter the credits for the year"+j+":") ;
             credits[i]=s1.nextDouble();
                
             System.out.println("Enter the SGPA secured of the year"+j+":");
             marks[i]=s1.nextDouble();

         }
    }
    
    void evaluate()
    {
        double cisi=0;
        for(i=0;i<n;i++)
        {
            cisi=cisi+credits[i]*marks[i];
            csum=csum+credits[i];
        }   
        CGPA=cisi/csum;
    }    
    
    void printResult()
    {
        System.out.println("Results are \n");
        System.out.println("CGPA= "+CGPA );
    }
}    
    
            
    
public class Courseproject {
    
    public static void main(String[] args) throws MinimumMarks {
        
        Scanner s1=new Scanner(System.in);
        System.out.println("Select your branch::");
        System.out.println("1.CSE");
        System.out.println("2.ECE");
        System.out.println("3.MECH");
        System.out.println("4.ISE");
        System.out.println("5.Civil");
        System.out.println("6.ELE");

        int branch=s1.nextInt();

        switch(branch)
        {
            case 1 :  System.out.println("Student of Computer Science Engineering");
                        break;
                        
            case 2:  System.out.println("Student of Electronics and Communication Engineering");
                            break;
                   
            case 3: System.out.println("Student of Mechanical Engineering");
                            break;
                            
            case 4: System.out.println("Student of Information Science Engineering");
                            break;
                           
            case 5: System.out.println("Student of Civil Engineering");
                            break;
                            
             case 6: System.out.println("Student of Electrical Engineering");
                            break;
        }
        
        System.out.println("What are you interested to calculate ???");
        System.out.println("           \"Be ready with your data\"            ");
        System.out.println("Enter your choice:\n 1.SGPA \n 2.CGPA");
        int choice=s1.nextInt();
        
        switch(choice)
        {
            case 1: Sgpa s=new Sgpa();
                         s.enterData();
                         s.evaluate();
                         s.printResult();
                         break;
                         
            case 2: Cgpa c=new Cgpa();
                         c.enterData();
                         c.evaluate();
                         c.printResult();
                         break;
                         
        }                
    }
}
