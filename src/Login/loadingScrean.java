package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Method.Method;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.util.concurrent.TimeUnit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;

public class loadingScrean extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loadingScrean frame = new loadingScrean();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loadingScrean() {
		setAlwaysOnTop(true);
		setBackground(Color.BLACK);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setType(Type.UTILITY);
//		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon icon=new ImageIcon(".\\asset\\loading.gif");
		Method method=new Method();
		method.resizeImage(icon, 434, 300, lblNewLabel);
		lblNewLabel.setBounds(0, 0, 434, 300);
		contentPane.add(lblNewLabel);
		
		
	}
}
