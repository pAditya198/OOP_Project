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
        // ob.findDefaulters(3, "CS201");
        // AttendanceWriter ob=new AttendanceWriter();
        // ob.writeAttendance(3, "CS201");
        //ob.writeAttendance(3, "SC201");
        // Professor ob = new Professor();
        // ProfessorRegistration obj = new ProfessorRegistration(ob);
        // obj.setVisible(true);
        // ob.readDetails(1299);
        // AdminStudentRegistration ob = new AdminStudentRegistration();
        // ob.setVisible(true);
        Student ob = new Student(2018);
        Student obj = ob.getStudent(201851001);
        new StudentEditProfile(obj).setVisible(true); 

    }
}
