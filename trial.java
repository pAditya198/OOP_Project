public class trial
{
    public static void main(String args[])
    {
        /*AdminModule ob = new AdminModule();
        ob.deleteFolder("iiitv\\student\\"+2018+"\\1");
        ob.deleteFolder("iiitv\\student\\"+2018+"\\2");
        ob.deleteFolder("iiitv\\student\\"+2018+"\\3");
        *///ob.writeNoOfStudents(2, 2019);
        //System.out.println(ob.readNoOfStudents(2019));
        AttendanceWriter ob=new AttendanceWriter();
        ob.writeAttendance(3, "CS201");
        //ob.writeAttendance(3, "SC201");
    }
}
