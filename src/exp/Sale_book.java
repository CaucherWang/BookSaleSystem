package exp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dialog.WarningDialog;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Sale_book extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private static final int WIDTH = 500;
	 
	private static final int HEIGHT = 350;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Sale_book();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sale_book() {
		final JFrame frame = new JFrame("Sale_book");
		frame.setVisible(true);
		frame.setSize(500, 421);
		int size=2000;
	    
	      String[] a2=new String[size];
	      String[] a3=new String[size];
	      String[] a4=new String[size];
	      String[] a5=new String[size];
	      String[] a6=new String[size];
	      String[] a7=new String[size];
	     
	      int a12=0;
	      int a13=0;
	      int a14=0;
	      int a15=0;
	      int a16=0;
	      int a17=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 45, 398, 155);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		try {  
	          Class.forName("com.mysql.cj.jdbc.Driver");  //加载MYSQL JDBC驱动程序  
	          //Class.forName("org.gjt.mm.mysql.Driver");  
	          System.out.println("Success loading Mysql Driver!");  
	         }catch (Exception e) {  
	          System.out.print("Error loading Mysql Driver!");  
	          e.printStackTrace();  
	     }  
	     try{  
	          Connection connect = DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/bookshop?user=root&password=123456&useUnicode=true&useSSL=false&serverTimezone=GMT%2B8&characterEncoding=utf-8");  
	           //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码  
	          System.out.println("Success connect Mysql server!");  
	          Statement stmt = connect.createStatement();  
	          //String sql="insert into test1 values('2','张伟','110')";   //SQL语句
	          //stmt.executeUpdate(sql);         //将sql语句上传至数据库执行
	           
	          ResultSet rs = stmt.executeQuery("select * from books where price != 0");
	          while (rs.next()) {  
                  a2[a12]=rs.getString("ISBN");  
                  a3[a13]=rs.getString("book_name");  
                  a4[a14]=rs.getString("price");
                  a5[a15]=rs.getString("stock");
                  a6[a16]=rs.getString("publisher");
                  a7[a17]=rs.getString("author");
                  
                  a12+=20;
                  a13+=10;
                  a14+=10;
                  a15+=10;
                  a16+=10;
                  a17+=10;
	          }
	          table.setModel(new DefaultTableModel(
	          	new Object[][] {
	          		{a2[0], a3[0],a7[0],a4[0],a5[0],a6[0]},
      				{a2[20], a3[10],a7[10],a4[10],a5[10],a6[10]},
      				{a2[40], a3[20],a7[20],a4[20],a5[20],a6[20]},
      				{a2[60], a3[30],a7[30],a4[30],a5[30],a6[30]},
      				{a2[80], a3[40],a7[40],a4[40],a5[40],a6[40]},
      				{a2[100], a3[50],a7[50],a4[50],a5[50],a6[50]},
      				{a2[120], a3[60],a7[60],a4[60],a5[60],a6[60]},
      				{a2[140], a3[70],a7[70],a4[70],a5[70],a6[70]},
	  	          	},
	  	          	new String[] {
	  	          		"ISBN", "\u4E66\u540D","作者", "\u5355\u4EF7", "\u6570\u91CF","出版社"
	          	}
	          ));
	          table.addMouseListener(new  MouseListener() {
	        	  public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应

	                  //得到选中的行列的索引值

	                 int r= table.getSelectedRow();

	                 int c= table.getSelectedColumn();

	                 //得到选中的单元格的值，表格中都是字符串

	                 Object value= table.getValueAt(r, c);

	                 String info=value.toString();
	                 textField.setText(info);
	               //  javax.swing.JOptionPane.showMessageDialog(null,info);

	               }
	          

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
	          });
	          table.getColumnModel().getColumn(0).setPreferredWidth(60);
		         // table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		      DefaultTableModel model = (DefaultTableModel) table.getModel();
		      for(int i = 1; i < 15; i ++)
	        	  model.addRow(new Object[]{a2[140+20*i],a3[70 + 10*i], a7[70 + 10*i],a4[70 + 10*i],a5[70 + 10*i],a6[70 + 10*i]});
	          table.getColumnModel().getColumn(1).setPreferredWidth(88);
	          table.getColumnModel().getColumn(4).setMinWidth(20);
	          
	          JButton btnNewButton_1 = new JButton("exit");
	          btnNewButton_1.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		frame.dispose();
	          		new Book_function();
	          	}
	          });
	          btnNewButton_1.setBounds(352, 351, 70, 23);
	          contentPane.add(btnNewButton_1);
	          
	          JLabel lblUnpaid = new JLabel("\u4E66\u7C4D");
	          lblUnpaid.setFont(new Font("华文楷体", Font.PLAIN, 18));
	          lblUnpaid.setBounds(200, 10, 97, 25);
	          contentPane.add(lblUnpaid);
	          
	          textField = new JTextField();
	          textField.setBounds(183, 217, 66, 21);
	          contentPane.add(textField);
	          textField.setColumns(10);
	          
	          JComboBox comboBox = new JComboBox();
	          comboBox.setModel(new DefaultComboBoxModel(new String[] {"ISBN", "book_name","author","publisher"}));
	          comboBox.setBounds(64, 216, 84, 23);
	          contentPane.add(comboBox);
	          
	          JButton order_2 = new JButton("\u67E5\u8BE2");
	          order_2.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		String choice =""+comboBox.getSelectedItem();
	          		String a = ""+textField.getText();
	          		  int size=2000;
	          		 String[] a2=new String[size];
	          		 String[] a3=new String[size];
	          		 String[] a4=new String[size];
	          		 String[] a5=new String[size];
	          		 String[] a6=new String[size];
	          		 String[] a7=new String[size];
	       	     
	          		 int a12=0;
	          		 int a13=0;
	          		 int a14=0;
	          		 int a15=0;
	          		 int a16=0;
	          		 int a17=0;
	       	      try {  
		  	          Class.forName("com.mysql.cj.jdbc.Driver");  //加载MYSQL JDBC驱动程序  
		  	          //Class.forName("org.gjt.mm.mysql.Driver");  
		  	          System.out.println("Success loading Mysql Driver!");  
		  	         }catch (Exception e1) {  
		  	          System.out.print("Error loading Mysql Driver!");  
		  	          e1.printStackTrace();  
		  	     }  
		  	     try{  
		  	          Connection connect = DriverManager.getConnection(  
		  "jdbc:mysql://localhost:3306/bookshop?user=root&password=123456&useUnicode=true&useSSL=false&serverTimezone=GMT%2B8&characterEncoding=utf-8");  
		  	           //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码  
		  	          System.out.println("Success connect Mysql server!");  
		  	          Statement stmt = connect.createStatement();  
		  	          //String sql="insert into test1 values('2','张伟','110')";   //SQL语句
		  	          //stmt.executeUpdate(sql);         //将sql语句上传至数据库执行
		  	           
		  	          ResultSet rs = stmt.executeQuery("select * from books where position('"+a+"' in "+choice+") and  price != 0");
		  	          while (rs.next()) {  
		  	        	 a2[a12]=rs.getString("ISBN");  
		                  a3[a13]=rs.getString("book_name");  
		                  a4[a14]=rs.getString("price");
		                  a5[a15]=rs.getString("stock");
		                  a6[a16]=rs.getString("publisher");

		                  a7[a17]=rs.getString("author");
		                  
		                  a12+=20;
		                  a13+=10;
		                  a14+=10;
		                  a15+=10;
		                  a16+=10;
		                  a17+=10;
		  	          }
		  	          table.setModel(new DefaultTableModel(
		  	          	new Object[][] {
		  	          	{a2[0], a3[0],a7[0],a4[0],a5[0],a6[0]},
	      				{a2[20], a3[10],a7[10],a4[10],a5[10],a6[10]},
	      				{a2[40], a3[20],a7[20],a4[20],a5[20],a6[20]},
	      				{a2[60], a3[30],a7[30],a4[30],a5[30],a6[30]},
	      				{a2[80], a3[40],a7[40],a4[40],a5[40],a6[40]},
	      				{a2[100], a3[50],a7[50],a4[50],a5[50],a6[50]},
	      				{a2[120], a3[60],a7[60],a4[60],a5[60],a6[60]},
	      				{a2[140], a3[70],a7[70],a4[70],a5[70],a6[70]},
		  	          	},
		  	          	new String[] {
		  	          		"ISBN", "\u4E66\u540D","作者",
		  	          		"\u5355\u4EF7", "\u6570\u91CF","出版社"
		  	          	
		  	          }
		 			          ));
		  	        table.getColumnModel().getColumn(0).setPreferredWidth(60);
			         // table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			      DefaultTableModel model = (DefaultTableModel) table.getModel();
			      for(int i = 1; i < 15; i ++)
		        	  model.addRow(new Object[]{a2[140+20*i],a3[70 + 10*i], a7[70 + 10*i],a4[70 + 10*i],a5[70 + 10*i],a6[70 + 10*i]});
					         }catch(Exception e1) {  
					          System.out.print("get data error!");  
					          e1.printStackTrace();  
					         }  

		          	}
		          });
	          order_2.setBounds(271, 216, 84, 23);
	          contentPane.add(order_2);
	          
	          textField_1 = new JTextField();
	          textField_1.setBounds(145, 264, 66, 21);
	          contentPane.add(textField_1);
	          textField_1.setColumns(10);
	          
	          JButton btnHome = new JButton("Home");
	          btnHome.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		frame.dispose();
	          		new function();
	          	}
	          });
	          btnHome.setBounds(64, 351, 77, 23);
	          contentPane.add(btnHome);
	          
	          JButton button = new JButton("\u5356\u4E66");
	          button.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent arg0) {
	          		String t1=""+textField.getText();//ISBN
	    			int t2=Integer.parseInt(textField_3.getText());//number
	    			//float t3=Float.parseFloat(textField_2.getText());//price
	    			float t3=0;
	    			float price = 0;
	    			//String t4=""+textField_3.getText();//order_ID
	    			String t4=order_bill.random_bill();//order_ID
	    			String t_4=order_bill.trans(t4);
	    			String t5=""+textField_2.getText();//工号person_ID
	    			float discount = Float.parseFloat(""+textField_1.getText());
	    			int size=2000;
	    			String[] a1=new String[size];//售价
	    			String[] a2=new String[size];//库存
	    			int a11=0;
	    			int a12=0;
	    		//	String t5=""+textField_4.getText();//time
	    			try {  
	    		          Class.forName("com.mysql.cj.jdbc.Driver");  //加载MYSQL JDBC驱动程序  
	    		          //Class.forName("org.gjt.mm.mysql.Driver");  
	    		          System.out.println("Success loading Mysql Driver!");  
	    		         }catch (Exception e1) {  
	    		          System.out.print("Error loading Mysql Driver!");  
	    		          e1.printStackTrace();  
	    		     }  
	    		     try{  
	    		          Connection connect = DriverManager.getConnection(  
	    "jdbc:mysql://localhost:3306/bookshop?user=root&password=123456&useUnicode=true&useSSL=false&serverTimezone=GMT%2B8&characterEncoding=utf-8");  
	    		           //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码  
	    		           
	    		          System.out.println("Success connect Mysql server!");
	    		          Statement stmt = connect.createStatement(); 
	    		          ResultSet rs = stmt.executeQuery("select * from books where ISBN='"+t1+"'");
	    		  	        while (rs.next()) {  
	    	  	        	  	a1[a11]=rs.getString("price");  
	    	  	        	  	a2[a12]=rs.getString("stock");
	    	                    a11+=10;
	    	                    a12+=10;
	    	  	          }
	    		  	      int stock=Integer.parseInt(a2[0]);
	    		  	      if(stock < t2) {
	    		  	    	  WarningDialog warning = new WarningDialog();
	    			      	  warning.WarningDialog("库存不足");
	    			      	  return;
	    		  	      }
	    		  	      t3=Float.parseFloat(a1[0]);
	    		  	      price=t2*t3*discount;
	    		          //String sql="insert into test1 values('2','张伟','110')";   //SQL语句
	    		          //stmt.executeUpdate(sql);         //将sql语句上传至数据库执行
	    		          String sql_1="insert into order_list values('"+t4+"','"+t1+"','"+t2+"')";
	    		          String sql_2="insert into sales_order values('"+t4+"','"+t3+"')";
	    		          String sql="insert into bill_order values('"+t_4+"','"+t4+"')";
	    		          String sql_3="update books set stock = stock - "+t2+" where ISBN = '"+t1+"'";//SQL语句
	    		          String sql_5="insert into bill values('"+t_4+"',(select now()),'"+price+"')";
	    		          String sql_4="insert into sales_bill values('"+t_4+"')";
	    		          String sql_6="insert into operation values('"+t5+"','"+t4+"')";
	    		          stmt.executeUpdate(sql_1);
	    		          stmt.executeUpdate(sql_2);
	    		          stmt.executeUpdate(sql_3);
	    		          stmt.executeUpdate(sql_5);
	    		          stmt.executeUpdate(sql_4);
	    		          stmt.executeUpdate(sql_6);
	    		          stmt.executeUpdate(sql);
	    		                        //user 为你表的名称 
	    		          WarningDialog warning = new WarningDialog();
    			      	  warning.WarningDialog("销售成功");
	    		         }catch(Exception e1) {  
	    		          System.out.print("get data error!");  
	    		          e1.printStackTrace();  
	    		         }  
	    		}
	    	});
	          button.setBounds(200, 330, 97, 23);
	          contentPane.add(button);
	          
	          JLabel label = new JLabel("\u5DE5\u53F7");
	          label.setBounds(65, 306, 58, 15);
	          contentPane.add(label);
	          
	          textField_2 = new JTextField();
	          textField_2.setBounds(145, 303, 66, 21);
	          contentPane.add(textField_2);
	          textField_2.setColumns(10);
	          
	          JLabel lblNewLabel = new JLabel("\u6570\u91CF");
	          lblNewLabel.setBounds(246, 267, 58, 15);
	          contentPane.add(lblNewLabel);
	          
	          textField_3 = new JTextField();
	          textField_3.setBounds(314, 264, 66, 21);
	          contentPane.add(textField_3);
	          textField_3.setColumns(10);
	          
	          JLabel label_1 = new JLabel("\u6298\u6263");
	          label_1.setBounds(65, 267, 58, 15);
	          contentPane.add(label_1);
	          
	         
	         }catch(Exception e) {  
	          System.out.print("get data error!");  
	          e.printStackTrace();  
	         }  
	}
}
