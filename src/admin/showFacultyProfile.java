package admin;

import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;

import faculty.FacultyProfile;

public class showFacultyProfile extends JDialog {


	/**
	 * Create the dialog.
	 */
	public showFacultyProfile(int serial) {
		setModalityType(ModalityType.TOOLKIT_MODAL);
		setModal(true);
		setBounds(50,50,1300,683);
		FacultyProfile profile=new FacultyProfile(serial);
		profile.setBounds(148,0,1300,683);
		getContentPane().add(profile);
		profile.setVisible(true);
	}

}
