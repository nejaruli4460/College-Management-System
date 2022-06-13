package admin;

import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;

import student.StudentProfile;

public class showStudentProfile extends JDialog {


	/**
	 * Create the dialog.
	 */
	public showStudentProfile(int serial) {
		setModalityType(ModalityType.TOOLKIT_MODAL);
		setModal(true);
		setBounds(50,50,1300,683);
		StudentProfile profile=new StudentProfile(serial);
		profile.setBounds(148,0,1300,683);
		getContentPane().add(profile);
		profile.setVisible(true);
		

	}

}
