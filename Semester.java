import java.util.*;
import java.io.*;

public class Semester
{
    static Scanner in = new Scanner(System.in);
    public void writeSemester(int rollNo, int sem,String subjectCode) throws IOException
	{
        FileWriter cs = null;
        Process PR = null;
		try
		{
<<<<<<< HEAD
            PR=Runtime.getRuntime().exec("attrib " +  "iiitv\\emester\\"+sem+"\\"+subjectCode+"Attendance.csv" + " -R");
			PR.waitFor();
			FileReader f=new FileReader("iiitv/semester/"+sem+"/"+subjectCode+"Attendance.csv");
			cs=new FileWriter("iiitv/semester/"+sem+"/"+subjectCode+"Attendance.csv",true);
            PR=Runtime.getRuntime().exec("attrib " +  "iiitv\\emester\\"+sem+"\\"+subjectCode+"Attendance.csv" + " +R");
=======
            FileReader f=new FileReader("iiitv/semester/"+sem+"/"+subjectCode+"Attendance.csv");
            PR=Runtime.getRuntime().exec("attrib " +  "iiitv\\semester\\"+sem+"\\"+subjectCode+"Attendance.csv" + " -R");
>>>>>>> d8628c56b2238a09853a03263d3b6ab52d930e98
			PR.waitFor();
            cs=new FileWriter("iiitv/semester/"+sem+"/"+subjectCode+"Attendance.csv",true);
		}
		catch(FileNotFoundException e)
		{
			new File("iiitv/Semester/"+sem).mkdirs();
			cs=new FileWriter("iiitv/semester/"+sem+"/"+subjectCode+"Attendance.csv",true);
            cs.append("ID,\n");
		}
        catch(InterruptedException e)
        {}
		cs.append(rollNo+",\n");
        cs.flush();
        cs.close();
        PR=Runtime.getRuntime().exec("attrib " +  "iiitv\\semester\\"+sem+"\\"+subjectCode+"Attendance.csv" + " +R");
        try
        {
            PR.waitFor();
        }
        catch(InterruptedException f)
        {}
    }
    public void sortRollNo(int sem, String subjectCode)
    {
        Process PR=null;
        try(FileReader f=new FileReader("iiitv/semester/"+sem+"/"+subjectCode+"Attendance.csv"))
        {
            PR=Runtime.getRuntime().exec("attrib " +  "iiitv\\semester\\"+sem+"\\"+subjectCode+"Attendance.csv" + " -R");
            PR.waitFor();
            BufferedReader csv=new BufferedReader(f);
            String header = csv.readLine();
            List<String> ID= new ArrayList<String>();
            String x="";
            while((x=csv.readLine())!=null)
                ID.add(x);
            sort(ID);
            csv.close();
            FileWriter wri=new FileWriter("iiitv/semester/"+sem+"/"+subjectCode+"Attendance.csv");
            wri.append(header+"\n");
            for(String i:ID)
                wri.append(i+"\n");
            PR=Runtime.getRuntime().exec("attrib " +  "iiitv\\semester\\"+sem+"\\"+subjectCode+"Attendance.csv" + " +R");
			PR.waitFor();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(InterruptedException e)
        {}
    }
    private void sort(List<String> ID)
    {
        for(int i=0;i<ID.size();i++)
        {
            for(int j=0;j<ID.size()-i-1;j++)
            {
                if(ID.get(j).compareTo(ID.get(j+1))>0)
                {
                    String temp=ID.get(j);
                    ID.set(j,ID.get(j+1));
                    ID.set(j+1,temp);
                }
            }
        }
    }
}
