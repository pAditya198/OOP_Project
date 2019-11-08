import java.util.*;
import java.time.*;
public class LogFile<Type>
{
	Type ID;
	String change;
	LocalDateTime date;
	LogFile(Type ID, String change,String change)
	{
		this.ID=ID;
		this.change=change;
		this.date=LocalDateTime.now();
	}
	void writeChange()
	{
		if (ID instanceof Student)
		{
			File f=new File("iiitv\\student\\"+ID.getBatch()+"\\"+ID.getRollNo()+"log.txt");
			FileOutputStream ob=new FileOutputStream(f,true);
	}
}
}