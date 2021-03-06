import javax.swing.JOptionPane;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author prate
 */

public class AdminGUI extends javax.swing.JFrame {

    /**
     * Creates new form AdminGUI
     */
    public AdminGUI() {
        initComponents();
       setLocationRelativeTo(null);

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        StudentRegistration = new javax.swing.JLabel();
        ProfessorRegistrataion = new javax.swing.JLabel();
        Mail = new javax.swing.JLabel();
        EditStudentProfile = new javax.swing.JLabel();
        Assign = new javax.swing.JLabel();
        Marks = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setPreferredSize(new java.awt.Dimension(800, 400));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Admin Profile");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("270x270-male-avatar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel7)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(95, 95, 95))
        );

        StudentRegistration.setBackground(new java.awt.Color(0, 0, 153));
        StudentRegistration.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        StudentRegistration.setForeground(new java.awt.Color(255, 255, 255));
        StudentRegistration.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StudentRegistration.setText("Student Registration");
        StudentRegistration.setToolTipText("");
        StudentRegistration.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        StudentRegistration.setOpaque(true);
        StudentRegistration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentRegistrationMouseClicked(evt);
            }
        });

        ProfessorRegistrataion.setBackground(new java.awt.Color(0, 0, 153));
        ProfessorRegistrataion.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        ProfessorRegistrataion.setForeground(new java.awt.Color(255, 255, 255));
        ProfessorRegistrataion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProfessorRegistrataion.setText("Professor Registration");
        ProfessorRegistrataion.setToolTipText("");
        ProfessorRegistrataion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ProfessorRegistrataion.setOpaque(true);
        ProfessorRegistrataion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProfessorRegistrataionMouseClicked(evt);
            }
        });

        Mail.setBackground(new java.awt.Color(0, 0, 153));
        Mail.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        Mail.setForeground(new java.awt.Color(255, 255, 255));
        Mail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mail.setText("Mail Defaulters");
        Mail.setToolTipText("");
        Mail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Mail.setOpaque(true);
        Mail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MailMouseClicked(evt);
            }
        });

        EditStudentProfile.setBackground(new java.awt.Color(0, 0, 153));
        EditStudentProfile.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        EditStudentProfile.setForeground(new java.awt.Color(255, 255, 255));
        EditStudentProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EditStudentProfile.setText("Edit Student Profile");
        EditStudentProfile.setToolTipText("");
        EditStudentProfile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        EditStudentProfile.setOpaque(true);
        EditStudentProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditStudentProfileMouseClicked(evt);
            }
        });

        Assign.setBackground(new java.awt.Color(0, 0, 153));
        Assign.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        Assign.setForeground(new java.awt.Color(255, 255, 255));
        Assign.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Assign.setText("Assign Roll Numbers");
        Assign.setToolTipText("");
        Assign.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Assign.setOpaque(true);
        Assign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AssignMouseClicked(evt);
            }
        });

        Marks.setBackground(new java.awt.Color(0, 0, 153));
        Marks.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        Marks.setForeground(new java.awt.Color(255, 255, 255));
        Marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Marks.setText("Open Marks Sheet");
        Marks.setToolTipText("");
        Marks.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Marks.setOpaque(true);
        Marks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MarksMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StudentRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mail, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Assign, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProfessorRegistrataion, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditStudentProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Marks, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProfessorRegistrataion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Mail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditStudentProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Assign, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Marks, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void StudentRegistrationMouseClicked(java.awt.event.MouseEvent evt) {
     AdminStudentRegistration ob = new AdminStudentRegistration();
        ob.setVisible(true);
    }

    private void ProfessorRegistrataionMouseClicked(java.awt.event.MouseEvent evt) {
        new ProfessorRegistration(new Professor()).setVisible(true);
    }

    private void MailMouseClicked(java.awt.event.MouseEvent evt) {
        System.out.println("Mailing");
        try
        {
            String s="cmd /c start /wait \"python MailingScript/mail.py && exit\"";
            System.out.println(s);
            Process p=Runtime.getRuntime().exec(s);
            p.waitFor();
        }
        catch(IOException e)
        {}
        catch(InterruptedException e)
        {}
        // TODO add your handling code here:
    }

    private void EditStudentProfileMouseClicked(java.awt.event.MouseEvent evt) {
        String roll = JOptionPane.showInputDialog(null,"Enter Student ID");
        int batch  = Integer.parseInt(roll.substring(0,4));
        int rollnum = Integer.parseInt(roll);
        Student ob = new Student(batch);
        Student obj = ob.getStudent(rollnum);
        new StudentEditProfile(obj).setVisible(true);
       }

    private void AssignMouseClicked(java.awt.event.MouseEvent evt) {
        AdminModule ob = new AdminModule();
        int batch = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Batch"));
        ob.assignRollNo(batch);

    }

    private void MarksMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel Assign;
    private javax.swing.JLabel EditStudentProfile;
    private javax.swing.JLabel Mail;
    private javax.swing.JLabel Marks;
    private javax.swing.JLabel ProfessorRegistrataion;
    private javax.swing.JLabel StudentRegistration;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration
}
