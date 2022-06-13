package student;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Method.Method;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import ConnectionPackage.Connector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.DropMode;
import javax.swing.JComboBox;

public class MessageUs extends JPanel implements ActionListener {
	private JTable tableRecieved;
	private JTextField recField;
	public static int startingMessage=Method.countTotalMessage();
	public MessageUs(int serial,JFrame frame) {
		setBounds(0,0,1440,883);
		setLayout(null);
		setBackground(new Color(0,0,0,80));
		Method method=new Method();
		
		JLabel background = new JLabel("");
		background.setForeground(new Color(0, 128, 128));
		background.setBounds(0, 0, 1301, 683);
		ImageIcon icon=new ImageIcon(".\\asset\\panelback.jpg");
		method.resizeImage(icon, 1400, 683, background);
		add(background);
	
	JPanel panelRec = new JPanel();
	panelRec.setBackground(new Color(0,0,0,78));
	background.add(panelRec);
	panelRec.setLayout(null);
	panelRec.setBounds(134, 152, 992, 488);
	
	JButton sendButton = new JButton("SEND");
	
	sendButton.setFocusable(false);
	sendButton.setBackground(SystemColor.activeCaption);
	sendButton.setBounds(825, 402, 107, 38);
	panelRec.add(sendButton);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(56, 29, 874, 336);
	scrollPane.setAutoscrolls(true);
	panelRec.add(scrollPane);
	
	
	
	JTextArea chatBox = new JTextArea();
	chatBox.setEditable(false);
	chatBox.setWrapStyleWord(true);
	chatBox.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
	scrollPane.setViewportView(chatBox);
	
	refreshRecievedMessage(serial,chatBox);
	chatBox.setLayout(null);
	chatBox.setBorder(new LineBorder(Color.cyan,1));
	

	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(56, 376, 590, 112);
	panelRec.add(scrollPane_1);
	
//	JScrollPane scroll=new JScrollPane(chatBox,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//	panelRec.add(scroll);
	
	JTextArea textArea = new JTextArea();
	scrollPane_1.setViewportView(textArea);
	textArea.setFont(new Font("Bookman Old Style", Font.PLAIN, 21));
	
	String comboItem[]={"admin","student","faculty"};
	
	JComboBox senderCombo = new JComboBox(comboItem);
	senderCombo.setBounds(656, 402, 140, 38);
	panelRec.add(senderCombo);
	
	recField = new JTextField();
	recField.setBounds(795, 451, 140, 27);
	panelRec.add(recField);
	recField.setColumns(10);
	
	JLabel lblNewLabel = new JLabel("Unique Id");
	lblNewLabel.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setBounds(656, 451, 95, 26);
	panelRec.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("if you want to send message to all just leave blank unique id");
	lblNewLabel_1.setForeground(Color.WHITE);
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
	lblNewLabel_1.setBounds(656, 376, 275, 14);
	panelRec.add(lblNewLabel_1);
	
	JButton btnInbox = new JButton("Refresh Message");
	background.add(btnInbox);
	
	btnInbox.setFont(new Font("Nirmala UI", Font.PLAIN, 19));
	btnInbox.setFocusable(false);
	btnInbox.setBackground(SystemColor.activeCaption);
	btnInbox.setBounds(500, 76, 215, 71);
//	chatBox.setAutoscrolls(getAutoscrolls());
	
//	JLabel lblNewLabel = new JLabel("Good Morning Guys................");
//	lblNewLabel
//	lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//	lblNewLabel.setBounds(10, 36, 546, 28);
//	panelRec.add(lblNewLabel);
	
//	JLabel lblNewLabel = new JLabel("New label");
//	lblNewLabel.setBounds(10, 11, 274, 28);
//	panelRec.add(lblNewLabel);
	
	
		
		btnInbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chatBox.setVisible(false);
				refreshRecievedMessage(serial,chatBox);
				chatBox.setVisible(true);
//				System.out.println("I am working");
			}
		});

		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message="";
				if(textArea.getText().equals("")) {
					message=message.concat("<empty message>");
				}else {
					message=message.concat(textArea.getText());
				}
				String Reciever="";
				if(recField.getText().equals("")) {
					Reciever=Reciever.concat("all");
				}else {
					Reciever=Reciever.concat(recField.getText());
				}
				try {
					Connection con=Connector.connect();
					String query="insert into message(message,sender,senderId,reciever,recId) values(?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, message);
					ps.setString(2, "student");
					ps.setString(3, Method.usernameBySerial(serial));
					ps.setString(4, senderCombo.getSelectedItem().toString());
					ps.setString(5, Reciever);
					ps.executeUpdate();
					con.close();
					textArea.setText("");
//					chatBox.setVisible(false);
//					refreshRecievedMessage(serial,chatBox);
//					chatBox.setVisible(true);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});	
		Timer timer=new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				if(startingMessage<Method.countTotalMessage() ||startingMessage>Method.countTotalMessage()) {
					chatBox.setVisible(false);
					refreshRecievedMessage(serial,chatBox);
					chatBox.setVisible(true);
//					System.out.println("run");
					startingMessage=Method.countTotalMessage();
//					JOptionPane.showMessageDialog(null, "New Message Received","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
			
		}, 0,1000);
		

	}
	
	public void refreshRecievedMessage(int serial,JTextArea panel2) {
//		DefaultTableModel model=(DefaultTableModel) tableRecieved.getModel();
//		String head[]={"Recived From","Message"};
//		model.setColumnIdentifiers(head);
//		tableRecieved.getColumnModel().getColumn(0).setPreferredWidth(20);
//		tableRecieved.getColumnModel().getColumn(1).setPreferredWidth(180);
//		int y=0;
//		JLabel label=new JLabel();
//		label.setBounds(0, y, 100, 20);
//		panel.add(label);
		
		JLabel arr[]=new JLabel[Method.countTotalMessage()];
		JLabel array[]=new JLabel[Method.countTotalMessage()];
		try {
			Connection con=Connector.connect();
			String query="select senderId,message,sender,time from message where (reciever=? and (recId=? or recId=?)) or senderId=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, "student");
			ps.setString(2, Method.usernameBySerial(serial));
			ps.setString(3, "all");
			ps.setString(4, Method.usernameBySerial(serial));
			ResultSet rs=ps.executeQuery();
			ArrayList list=new ArrayList();
			int x=0;
			int y=22;
			int z=0;
			while(rs.next()) {
			
//				list.removeAll(list);
				String name=Method.nameByUsername(rs.getString(1), rs.getString(3))+"("+rs.getString(3)+")";
//				list.add(name);
//				list.add(rs.getString(2));
//				list.add(rs.getString(4));
//				model.addRow(list.toArray());
				if(rs.getString(1).equalsIgnoreCase(Method.usernameBySerial(serial))) {
					arr[x]=new JLabel(rs.getString(2));
					arr[x].setBounds(10, y, 803, 23);
					arr[x].setHorizontalAlignment(SwingConstants.RIGHT);
//					arr[x].setBorder(new LineBorder(Color.black));
					arr[x].setFont(new Font("Segoe UI Semilight", Font.PLAIN, 21));
					array[x]=new JLabel("( Message from "+rs.getString(3)+" id "+rs.getString(1)+" )");
					array[x].setBounds(10, y+21, 803, 9);
					array[x].setHorizontalAlignment(SwingConstants.RIGHT);
					array[x].setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
					arr[x].setForeground(SystemColor.activeCaption);
					array[x].setForeground(SystemColor.activeCaption);
					panel2.add(array[x]);
					panel2.add(arr[x]);
					panel2.setRows(z);
					
				}else {
					arr[x]=new JLabel(rs.getString(2));
					arr[x].setBounds(10, y, 1020, 23);
//					arr[x].setBorder(new LineBorder(Color.black));
					arr[x].setFont(new Font("Segoe UI Semilight", Font.PLAIN, 21));
					array[x]=new JLabel("( Message from "+rs.getString(3)+" id "+rs.getString(1)+" )");
					array[x].setBounds(10, y+21, 803, 9);
//					array[x].setHorizontalAlignment(SwingConstants.RIGHT);
					array[x].setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
					panel2.add(array[x]);
					panel2.add(arr[x]);
					panel2.setRows(z);
				}
				
				
				x++;
				y=y+34;
//				panel2.setRows(z-1);
				z=z+2;
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(panel2.getRows());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
