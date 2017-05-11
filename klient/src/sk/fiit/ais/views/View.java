package sk.fiit.ais.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import sk.fiit.ais.beans.LoginBeanRemote;
import sk.fiit.ais.entity.Student;
import sk.fiit.ais.remote.RemoteConnetion;

public class View extends JFrame implements ActionListener {
	
	private JButton login = new JButton("Prihlasenie");
	private JButton show = new JButton("Zobraz rozvrh");
	private JButton print = new JButton("Tlac rozvrh");
	private JTextField id = new JTextField();
	private JTable table = new JTable();
	private JLabel desc = new JLabel("Zadaj ID");
	
	public View(){
		JPanel panel  = new JPanel();
		
		this.setTitle("Akademicky informacny system");
		this.setSize(800,600);
		
		panel.add(id);
		panel.add(show);
		panel.add(desc);
		panel.add(login);
		panel.add(print);
		
		login.addActionListener(this);
		print.addActionListener(this);
		show.addActionListener(this);
		
		this.add(panel);
		
		panel.setLayout(null);
		
		desc.setBounds(40, 20, 100, 15);
		id.setBounds(40, 40, 100, 25);
		login.setBounds(40, 75, 100, 25);
		show.setBounds(40, 110, 100, 25);
		print.setBounds(40, 145, 100, 25);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Student student = null;
		
		if (e.getSource() == login){
			Context context = null;
			try {
				context = RemoteConnetion.createRemoteEjbContext("localhost", "8080");
			} catch (NamingException e1) {
				e1.printStackTrace();
			}
			
			LoginBeanRemote remote = null;
			
			try {
				remote = (LoginBeanRemote)context.lookup("ejb:/server//LoginBean!sk.fiit.ais.beans.LoginBeanRemote");
			} catch (NamingException e1) {
				e1.printStackTrace();
			}
			
			try {
				student = remote.logOn(getId());
			} catch (SQLException e1) {
				e1.printStackTrace();
				student = null;
			}
		}
		
        if (e.getSource() == show)  {
			
		}
        
        if (e.getSource() == print) {
        	
        }
		
	}
	
	public int getId(){
		return Integer.parseInt(id.getText());
	}

}
