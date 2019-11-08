import java.util.*;
import java.io.*;

public class Semester 
{
    static Scanner in = new Scanner(System.in);
    public void writeSemester(int rollNo, int sem,String subjectCode) throws IOException 
	{    
		FileWriter cs = null;
		try
		{
			FileReader f=new FileReader("iiitv/Semester/"+sem+"/"+subjectCode+".csv");
			cs=new FileWriter("iiitv/Semester/"+sem+"/"+subjectCode+".csv",true);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("XYZ");
			new File("iiitv/Semester/"+sem).mkdirs();
			cs=new FileWriter("iiitv/Semester/"+sem+"/"+subjectCode+".csv",true);
			cs.append("ID,\n");
		}
		cs.append(rollNo+",\n");
        cs.flush();
        cs.close();
    }
    public static void main(String args[]) throws IOException 
	{
        Semester ob = new Semester();
        ob.writeSemester(201851018,1,"CS201");
    }
}