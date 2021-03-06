import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateCustomer implements ActionListener ,ItemListener
{
	
	JButton ad,clear,search;
	Connection con;
	PreparedStatement stm;
	Statement stm2;
	ResultSet rs2;
	String 	s1,s2,s3,s4,s5,s6,s7,s8;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf6,ltf7,ltf8,ltf9;
	String user="system";
	String pass="system";
	int pass9,ph,ph2,ph3,ph4,ch1,de;
	JDialog jd;
	Main m1;
	String dl;
	private Pattern pattern;
	private Matcher matcher;
	String email;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	
	public UpdateCustomer(Main m)
	{
		pattern = Pattern.compile(EMAIL_PATTERN);
		jd = new JDialog(m);
		jd.setIconImage(new ImageIcon("image/logo.png").getImage());
		JPanel p1=new JPanel();
		p1.setBounds(0,0,500,500);	
		p1.setLayout(null);
		jd.add(p1);
		JLabel tl=new JLabel("Update Customer");
		Font font= new Font("Algerian",Font.BOLD,15);
		tl.setBounds(150,20,250,30);
		tl.setFont(font);
		p1.add(tl);


		l1 =new JLabel("Customer ID :");
		l1.setBounds(50,60,150,20);
		p1.add(l1);
		l2 =new JLabel("Customer Name :");
		l2.setBounds(50,100,150,20);
		p1.add(l2);
		l3 =new JLabel("Residential Address :");
		l3.setBounds(50,140,150,20);
		p1.add(l3);
		l4 =new JLabel("Gender :");
		l4.setBounds(50,180,150,20);
		p1.add(l4);
		l5 =new JLabel("City :");
		l5.setBounds(50,220,150,20);
		p1.add(l5);
		l6 =new JLabel("Email ID :");
		l6.setBounds(50,260,150,20);
		p1.add(l6);
		l7 =new JLabel("Contact No :");
		l7.setBounds(50,300,150,20);
		p1.add(l7);
		l8 =new JLabel("ID Proof :");
		l8.setBounds(50,340,150,20);
		p1.add(l8);


		ltf1= new JTextField();
		ltf1.setBounds(200,60,150,20);
		p1.add(ltf1);
		ltf2= new JTextField();
		ltf2.setBounds(200,100,150,20);
		p1.add(ltf2);
		ltf3= new JTextField();
		ltf3.setBounds(200,140,150,20);
		p1.add(ltf3);
		ltf4= new JTextField();
		ltf4.setBounds(200,180,150,20);
		p1.add(ltf4);
		
		
		ltf5= new JTextField();
		ltf5.setBounds(200,220,150,20);
		p1.add(ltf5);


		ltf6= new JTextField();
		ltf6.setBounds(200,260,150,20);
		p1.add(ltf6);
		ltf7= new JTextField();
		ltf7.setBounds(200,300,150,20);
		p1.add(ltf7);
		ltf8= new JTextField();
		ltf8.setBounds(200,340,150,20);
		p1.add(ltf8);
	

		ad= new JButton("Update",new ImageIcon("image/add.png"));
		ad.setBounds(50,380,140,30);
		ad.addActionListener(this);
		p1.add(ad);
		clear= new JButton("Clear",new ImageIcon("image/clear.png"));
		clear.setBounds(220,380,100,30);
		clear.addActionListener(new ActionListener() {      
			public void actionPerformed(ActionEvent e)
					{
						ltf1.setText("");
						ltf2.setText("");
						ltf3.setText("");
						ltf4.setText("");
						ltf5.setText("");
						ltf6.setText("");
						ltf7.setText("");
						ltf8.setText("");
						
		
					}		

			
		});
		p1.add(clear);
		
		search = new JButton("Search",new ImageIcon("image/se.png"));
		search.setBounds(350,380,100,30);
		search.addActionListener(this);
		p1.add(search);
		
					ltf1.setEditable(false);
					ltf2.setEditable(false);
					ltf3.setEditable(false);
					ltf4.setEditable(false);
					ltf5.setEditable(false);
					ltf6.setEditable(false);
					ltf7.setEditable(false);
					ltf8.setEditable(false);
		jd.setSize(500,500);
		jd.setLayout(null);
		jd.setLocationRelativeTo(null);
		p1.setBackground(Color.orange);
		jd.setTitle("Update Customer");
		jd.setVisible(true);
	}


	public void itemStateChanged(ItemEvent e)
	{	ltf4.setText(((Checkbox)e.getItemSelectable()).getLabel());
		
			
				
	}

	public void actionPerformed(ActionEvent er)
		{

		ph=0;ph2=0; ph3=0; ph4=0; ch1=0;	
					s1=ltf1.getText();
					s2=ltf2.getText();
					s3=ltf3.getText();
					s4=ltf4.getText();
					s5=ltf5.getText();
					s6=ltf6.getText();
					s7=ltf7.getText();
					s8=ltf8.getText();
				if(er.getSource()==ad)
				{
					if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty()||s7.isEmpty()||s8.isEmpty())
					{    JOptionPane.showMessageDialog(jd,"Text Fields is empty","Error",JOptionPane.ERROR_MESSAGE); }
					else{
						pass9=0;
					   String i = ltf1.getText();
					   String i1=ltf7.getText();
					    String i2=ltf2.getText();
					 matcher = pattern.matcher(s6);
	       				if(matcher.matches()){ System.out.println("true"); } 
					else{ pass9=4; ph4=1; System.out.println("false");}
	
					for(int y=0;y<i.length(); ++y)
					{
						if(!Character.isDigit(i.charAt(y)))
							{  pass9=7; ph=1; }
					}
					for(int y2=0;y2<i2.length(); ++y2)
					{
						if(!Character.isDigit(i2.charAt(y2)))
							{   }
						else{ pass9=3; ph3=1; }
					}					

					for(int y1=0;y1<i1.length(); ++y1)
					{
						 if(i1.length()<=9){ pass9=7; ph2=1; }
						if(!Character.isDigit(i1.charAt(y1)))
						{  pass9=7; ph2=1; }
						if(i1.length()>10)
							{ pass9=7; ph2=1;  }
					}
						
						if(pass9==0)
						{
							try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
      						String query = "delete from customer where c_id = ?";
      						PreparedStatement preparedStmt = conn.prepareStatement(query);
      						preparedStmt.setString(1, s1);
      						preparedStmt.execute();
      						conn.close();
				   		}
						catch(Exception r){}
							

						   try        { Class.forName("oracle.jdbc.driver.OracleDriver");
							con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
							stm =  con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?)");
			                			stm.setString(1,ltf1.getText());
							stm.setString(2,ltf2.getText());
							stm.setString(3,ltf3.getText());	
							stm.setString(4,ltf4.getText());
							stm.setString(5,ltf5.getText());
							stm.setString(6,ltf6.getText());
							stm.setString(7,ltf7.getText());
							stm.setString(8,ltf8.getText());
							stm.executeUpdate();
							JOptionPane.showMessageDialog(jd,"Update Success","Success",JOptionPane.INFORMATION_MESSAGE);
							ltf1.setText("");	
				 			ltf2.setText("");
							ltf3.setText("");
							ltf4.setText("");
							ltf5.setText("");
							ltf5.setText("");
							ltf6.setText("");
							ltf7.setText("");
							ltf8.setText("");
							ltf1.setEditable(false);
					ltf2.setEditable(false);
					ltf3.setEditable(false);
					ltf4.setEditable(false);
					ltf5.setEditable(false);
					ltf6.setEditable(false);
					ltf7.setEditable(false);
					ltf8.setEditable(false);
							
							
											
			
							con.close();

							}
						catch(Exception e){ }
							}
							else { if(ph==1){JOptionPane.showMessageDialog(jd,"Customer ID or only Number accepted","Error",JOptionPane.ERROR_MESSAGE);}
								if(ph2==1){JOptionPane.showMessageDialog(jd,"Incorrect Contact No","Error",JOptionPane.ERROR_MESSAGE);}
								if(ph3==1){JOptionPane.showMessageDialog(jd,"Incorrect Name","Error",JOptionPane.ERROR_MESSAGE);}
								if(ph4==1){JOptionPane.showMessageDialog(jd,"Invalid Email","Error",JOptionPane.ERROR_MESSAGE);}
							          } 						
						
						}


				}
			if(er.getSource()==search)
				{   	de=0;
			 		dl=JOptionPane.showInputDialog(jd,"Enter Customer ID"); 
				        
					if(!dl.isEmpty())
					{
						try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select * from customer");
							while (rs2.next())
							{
								if(dl.equals(rs2.getString(1)))
								{
									de=1; 
									break;
								}
							} 
							con.close();
					}
							catch(Exception e){}	
					
					if(de==1){
				         try{	
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
					stm2=con.createStatement();
					rs2= stm2.executeQuery("SELECT  *  FROM customer WHERE c_id="+dl+" ");
						
				while(rs2.next())
					{
						
					ltf1.setEditable(false);
					ltf2.setEditable(true);
					ltf3.setEditable(true);
					ltf4.setEditable(true);
					ltf5.setEditable(true);
					ltf6.setEditable(true);
					ltf7.setEditable(true);
					ltf8.setEditable(true);
					ltf1.setText(rs2.getString(1));
					ltf2.setText(rs2.getString(2));
					ltf3.setText(rs2.getString(3));
					ltf4.setText(rs2.getString(4));
					ltf5.setText(rs2.getString(5));
					ltf6.setText(rs2.getString(6));
					ltf7.setText(rs2.getString(7));
					ltf8.setText(rs2.getString(8));
					}
				          }
				catch(Exception p){JOptionPane.showMessageDialog(jd,p,"Error",JOptionPane.ERROR_MESSAGE);}
					} else{ JOptionPane.showMessageDialog(jd,"Data not found","Error",JOptionPane.ERROR_MESSAGE);}
			        		 } else{ JOptionPane.showMessageDialog(jd,"Textfield is empty","Error",JOptionPane.ERROR_MESSAGE);}
		


		
				}


		
		}

	
}