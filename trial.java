public class trial
{
    public static void main(String args[])
    {
        // AdminModule ob = new AdminModule();
        // ob.assignRollNo(2018);
        //ob.writeNoOfStudents(2, 2019);
        /*AdminModule ob = new AdminModule();
        ob.deleteFolder("iiitv\\student\\"+2018+"\\1");
        ob.deleteFolder("iiitv\\student\\"+2018+"\\2");
        ob.deleteFolder("iiitv\\student\\"+2018+"\\3");
        *///ob.writeNoOfStudents(2, 2019);
        //System.out.println(ob.readNoOfStudents(2019));
        // AttendanceWriter ob=new AttendanceWriter();
        // ob.openAttendance(3, "CS201");
        // AttendanceWriter ob=new AttendanceWriter();
        // ob.writeAttendance(3, "CS201");
        //ob.writeAttendance(3, "SC201");
        Professor ob = new Professor();
        TeacherRegistration obj = new TeacherRegistration(ob);
        obj.setVisible(true);
    }
}
