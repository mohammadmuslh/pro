package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Book extends JFrame implements ActionListener {
	private String ISBN;
	private String Title;
	private String Author;
	private int Edition;
	private boolean Borowed ;
	private int PubYear;
	
	public ArrayList<Book> bb = new ArrayList<Book>();
	
	public int getPubYear() {
		return PubYear;
	}
	public void setPubYear(int pubYear) {
		PubYear = pubYear;
	}
	public boolean isBorowed() {
		return Borowed;
	}
	public void setBorowed(boolean borowed) {
		Borowed = borowed;
	}
	public int getEdition() {
		return Edition;
	}
	public void setEdition(int edition) {
		Edition = edition;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	JLabel l1,l2,l3,l4,l5,I6;
	JButton insert,clear,f,b,r;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	JPanel p5=new JPanel();
	JPanel twoPanels = new JPanel();
	JPanel bigPanel = new JPanel();
	JPanel borrowPanel = new JPanel();
	JPanel borrowretrunPanel = new JPanel();
	JPanel findPanel = new JPanel();
	public JTextField dd ;
	JButton find;
	 JRadioButton I;
		JRadioButton T;
		JRadioButton A;
		JRadioButton P;
	
		ButtonGroup aa;
		
		public 	Book (String ISBN,String Title,String Author,int Edition,int PubYear) {
		this.ISBN=ISBN;
		this.Title=Title;
		this.Author=Author;
		this.Edition=Edition;
		this.PubYear=PubYear;
		this.setBorowed(true);
		}
	public 	Book () {
		l1 = new JLabel("ISBN");
		l2 = new JLabel("Title");
		l3 = new JLabel("Author");
		l4 = new JLabel("Edition");
		l5 = new JLabel("Published Year");
		I6 = new JLabel("ISBN");
		insert = new JButton("  insert   "); 
		insert.addActionListener(this);
		clear = new JButton("  clear   "); 
		clear.addActionListener(this);
		JTextArea a1 =new JTextArea();
		t1 = new JTextField(10);
		t2 = new JTextField(10);
		t3 = new JTextField(10);
		t4 = new JTextField(10);
		t5 = new JTextField(10);
		t7= new JTextField(10);
		t6 = new JTextField(60);
		I = new JRadioButton("ISBN",false);
		T = new JRadioButton("Title",false);
		A = new JRadioButton("Author",true);
		P = new JRadioButton("PublishedYear",false);
		find = new JButton("  find   ");
		find.addActionListener(this);
		aa = new ButtonGroup();
		dd = new JTextField("Deitel",25);
		f = new JButton("  Find  ");
		b = new JButton("  Borrow   ");
		r = new JButton("  Return  ");
		f.addActionListener(this);
		b.addActionListener(this);
		r.addActionListener(this);
		p1.setLayout( new GridLayout(2,5));
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
		
		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);

		 p2.add(insert);
		 p2.add(clear); 
         p3.add(find);
			p3.add(dd);
			p3.add(I);
			p3.add(T);
			p3.add(A);
			p3.add(P);
			
			aa.add(I);
			aa.add(T);
			aa.add(A);
			aa.add(P);
			
			JPanel textarea = new JPanel();
			textarea.setLayout(new BorderLayout());
			findPanel.add(I6);
			findPanel.add(t7);
			findPanel.add(f);
			p5.add(t6);
		    borrowretrunPanel.add(b);
		    borrowretrunPanel.add(r);
		    borrowPanel.setLayout(new BorderLayout());
		    textarea.add(a1,BorderLayout.CENTER);
		    textarea.add(findPanel,BorderLayout.SOUTH);
		    borrowPanel.add(p5,BorderLayout.CENTER);
		    borrowPanel.add(borrowretrunPanel,BorderLayout.SOUTH);
		    borrowPanel.add(textarea,BorderLayout.NORTH);
			add(p1,BorderLayout.NORTH);
			twoPanels.add(p1);
			twoPanels.add(p2);
			bigPanel.setLayout(new BorderLayout());
			bigPanel.add(twoPanels,BorderLayout.NORTH);
			bigPanel.add(p3,BorderLayout.CENTER);
			add(bigPanel,BorderLayout.CENTER);
			add(borrowPanel,BorderLayout.SOUTH);
		
		setSize(1000,700);
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==insert) {
			if(t1.equals("")&&t2.equals("")&&t3.equals("")&&t4.equals("")&&t5.equals("")) {
				insert.setEnabled(true);
				
				
			}
			else {
			boolean istwo = false;
				Book s ;
				String i=t1.getText();
				String t=t2.getText();
				String a=t3.getText();
				String ed=t4.getText();
				String p=t5.getText();
				int newed = Integer.parseInt(ed);
				int newp = Integer.parseInt(p);
				
				for(Book book : bb) {
					if(book.getISBN().equals(t1.getText())) {
						istwo=true;
					
					}
				}

				if(!istwo) {
				s = new Book(i,t,a,newed,newp);
				bb.add(s);
				}
				else {
					JOptionPane.showMessageDialog(null, "the book is exist");
				}
				

				
				
			}
			}
		
		if (e.getSource()==clear) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
		}
		if(e.getSource()==find) {
			if(I.isSelected()) {
				String ii = dd.getText();
				String ll ="";
				for(Book n : bb) {
				if(n.getISBN().contains(ii)) {
	
ll+=toStrings(n.getISBN(),n.getTitle(),n.getAuthor(),n.getEdition(),n.getPubYear())+"\n";
		

				}	
				}
				JFrame frame = new JFrame("Book We Found");
				JTextArea text =new JTextArea();
				text.setText(ll);
				frame.add(text);
				frame.setSize(500, 500);
				frame.setVisible(true);
				}
				if(T.isSelected()) {
					String ll ="";
					for(Book n : bb) {
						String ii = dd.getText();
						if(n.getTitle().contains(ii)) {
						
							ll+=toStrings(n.getISBN(),n.getTitle(),n.getAuthor(),n.getEdition(),n.getPubYear())+"\n";
							
						}
					}
					JFrame frame = new JFrame("Book We Found");
					JTextArea text =new JTextArea();
					text.setText(ll);
					frame.add(text);
					frame.setSize(500, 500);
					frame.setVisible(true);
				}
					if(A.isSelected()) {
						String ll ="";
						for(Book n : bb) {
							
							String ii = dd.getText();
							if(n.getAuthor().contains(ii)) {
								ll+=toStrings(n.getISBN(),n.getTitle(),n.getAuthor(),n.getEdition(),n.getPubYear())+"\n";
							
								
							}
						}
						JFrame frame = new JFrame("Book We Found");
						JTextArea text =new JTextArea();
						frame.setSize(500, 500);
						frame.setVisible(true);
						text.setText(ll);
						frame.add(text);
					}
						if(P.isSelected()) {
							String ll ="";
							for(Book n : bb) {
								String ii = dd.getText();
								int newii = Integer.parseInt(ii);
								if(n.getPubYear()==newii) {
									
									ll+=toStrings(n.getISBN(),n.getTitle(),n.getAuthor(),n.getEdition(),n.getPubYear())+"\n";
									
								}
							}
							JFrame frame = new JFrame("Book We Found");
							JTextArea text =new JTextArea();
							text.setText(ll);
							frame.add(text);
							frame.setSize(500, 500);
							frame.setVisible(true);
						}
		
		
	}
		if(e.getSource()==f) {
			
			String ii = t7.getText();
			for(Book n : bb) {
			if(n.getISBN().contains(ii)) {
				
				if(this.isBorowed())
				{
				r.setEnabled(true);
					b.setEnabled(false);
					String ll1 ="";
					
					ll1 =toStrings(n.getISBN(),n.getTitle(),n.getAuthor(),n.getEdition(),n.getPubYear());
							t6.setText(ll1);
				}
			else {
					b.setEnabled(true);
					r.setEnabled(false);
					String ll1 ="";
					ll1 =toStrings(n.getISBN(),n.getTitle(),n.getAuthor(),n.getEdition(),n.getPubYear());
							t6.setText(ll1);
					
				}
	
		}
			}
		}
		if(e.getSource()==r) { 
			
	this.setBorowed(false);
			}
		if(e.getSource()==b) {
			this.setBorowed(true);;
						}
		}
	
	public String toStrings(String s1,String s2,String s3,int s4,int s5) {
		
		String r ="";
		if(this.isBorowed()) {
		r=s1+"    "+s2+"    "+s3+"    "+s4+"    "+s5 +"   "+"not Available ";}
		else {
			r=s1+"    "+s2+"    "+s3+"    "+s4+"    "+s5 +"   "+"Available ";
		}
		
			
		return r;
	}
	}
	

	


