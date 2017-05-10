package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame implements ActionListener {
	
	private JButton login = new JButton("Prihlasenie");
	private JButton show = new JButton("Zobraz rozvrh");
	private JButton print = new JButton("Tlac rozvrh");
	private JTextField id = new JTextField();
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
		if (e.getSource() == login){
			Context context = null;
			try {
				context = createRemoteEjbContext("localhost", "8080");
			} catch (NamingException e1) {
				e1.printStackTrace();
			}
			TestBeanRemote remote = null;
			try {
				remote = (TestBeanRemote)context.lookup("ejb:/gg//TestBean!test.TestBeanRemote");
			} catch (NamingException e1) {
				e1.printStackTrace();
			}
			System.out.println(remote.test2(getId()));
			String text = remote.testMe("Hello");
			System.out.println(text);
			System.out.println(remote.test1("X"));
		}
		
        if (e.getSource() == show)  {
			
		}
        
        if (e.getSource() == print) {
        	
        }
		
	}
	
	private static Context createRemoteEjbContext(String host, String port) throws NamingException {
		Hashtable<Object, Object> props = new Hashtable<Object, Object>();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		
		props.put("jboss.naming.client.ejb.context", false);
		props.put("org.jboss.ejb.client.scoped.context", true);
 
		props.put("endpoint.name", "client-endpoint");
		props.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", false);
		props.put("remote.connections", "default");
		props.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", false);
 
        props.put(Context.PROVIDER_URL, "http-remoting://" + host + ":" + port);
        props.put("remote.connection.default.host", host);
        props.put("remote.connection.default.port", port);
 
        return new InitialContext(props);
    }
	
	public int getId(){
		return Integer.parseInt(id.getText());
	}

}
