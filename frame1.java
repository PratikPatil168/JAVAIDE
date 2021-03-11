import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.undo.*;
import javax.swing.event.*;
import java.util.*;
import java.time.*;
import java.time.format.*;




class frame1 extends JFrame implements ActionListener,ItemListener,KeyListener
{

	JTextArea ta;
	JTextArea op;
	JTextField google;
	static int r,g,b,r1,g1,b1,ip;
	 JCheckBoxMenuItem full_screen;
	 JCheckBoxMenuItem output_window;
	 JScrollPane jp;
	 JScrollPane jp1;
	 JPanel Bottom;
	 JLabel line_no;
	 JComboBox cb;
	 UndoManager um;

	public void init()
	{

		setSize(1366,768);
		setLayout(null);
		setTitle("JPDK 1.8 - Untitled");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		try
		{
		UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		}catch(Exception e){System.out.println(e);}


	}


	frame1()
	{
		init();
		Vector v = new Vector();
		cb = new JComboBox(v);
		ta = new JTextArea();
		 op = new JTextArea();
		 google = new JTextField("Any query, Google here",20);
		 op.setEditable(false);

		JPanel lp = new JPanel(new GridLayout(0,1));
		JPanel rp = new JPanel(new GridLayout(0,1));
		JPanel top  = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
		Bottom  = new JPanel();
		jp = new JScrollPane(ta);
		jp1 = new JScrollPane(op);
		line_no = new JLabel("Total lines : 0");

		JMenuBar mb = new JMenuBar();

		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu format = new JMenu("Format");
		JMenu run = new JMenu("Run");
		JMenu window = new JMenu("Window");
		JMenu Help = new JMenu("Help");
		JMenu colors = new JMenu("Colors");
		JMenuItem New = new JMenuItem("New",KeyEvent.VK_N);
		JMenuItem open = new JMenuItem("Open",KeyEvent.VK_O);
		JMenuItem save = new JMenuItem("Save",KeyEvent.VK_S);
		JMenuItem save_as = new JMenuItem("Save As",KeyEvent.VK_A);
		JMenuItem close = new JMenuItem("Close");
		JMenuItem undo = new JMenuItem("Undo",KeyEvent.VK_U);
		JMenuItem redo = new JMenuItem("Redo",KeyEvent.VK_R);
		JMenuItem cut = new JMenuItem("Cut",KeyEvent.VK_X);
		JMenuItem copy = new JMenuItem("Copy",KeyEvent.VK_C);
		JMenuItem paste = new JMenuItem("Paste",KeyEvent.VK_V);
		JMenuItem clear = new JMenuItem("Clear");
		JMenuItem font = new JMenuItem("Font");
		JMenuItem forecolor = new JMenuItem("Forecolor");
		JMenuItem backcolor = new JMenuItem("Backcolor");
		JMenuItem compile = new JMenuItem("Compile",KeyEvent.VK_C);
		JMenuItem application = new JMenuItem("Application",KeyEvent.VK_A);
		JMenuItem applet = new JMenuItem("Applet");
		JMenuItem servlet_runner = new JMenuItem("Servlet",KeyEvent.VK_S);
		JMenuItem iExplorer = new JMenuItem("iExplorer",KeyEvent.VK_E);
		JMenuItem access = new JMenuItem("Ms-Access",KeyEvent.VK_M);
		full_screen = new JCheckBoxMenuItem("Fullscreen");
		output_window = new JCheckBoxMenuItem("Output Window",true);
		JMenuItem help = new JMenuItem("Help");
		JMenuItem about = new JMenuItem("About");
		JMenuItem print = new JMenuItem("Print");


		JButton bnew= new JButton("New",new ImageIcon("new.png"));
		JButton bopen= new JButton("Open",new ImageIcon("open.png"));
		JButton bsave= new JButton("Save",new ImageIcon("save.png"));
		JButton bundo= new JButton("Undo",new ImageIcon("undo.png"));
		JButton bredo= new JButton("Redo",new ImageIcon("redo.png"));
		JButton bcut= new JButton("Cut",new ImageIcon("cut.png"));
		JButton bcopy= new JButton("Copy",new ImageIcon("copy.png"));
		JButton bpaste= new JButton("Paste",new ImageIcon("paste.png"));
		JButton bcompile= new JButton("Compile",new ImageIcon("compile.png"));
		JButton brunapp= new JButton("Application",new ImageIcon("app.png"));
		JButton brunhtml= new JButton("iExplorer",new ImageIcon("html.png"));
		JButton brunapplet= new JButton("Applet",new ImageIcon("applet.jpg"));
		JButton bservletrunner= new JButton("Servlet",new ImageIcon("servlets.png"));
		JButton baccess= new JButton("Ms-Access",new ImageIcon("access.png"));
		JButton api = new JButton("Open Java Api....",new ImageIcon("JavaApiLogo.jpg"));
		JButton go  = new JButton("Search",new ImageIcon("search.png"));
		JButton Tomcat = new JButton("Open Xampp Server",new ImageIcon("Xampp.jpg"));

		bnew.setVerticalTextPosition(SwingConstants.BOTTOM);
 		bopen.setVerticalTextPosition(SwingConstants.BOTTOM);
        bsave.setVerticalTextPosition(SwingConstants.BOTTOM);
        bundo.setVerticalTextPosition(SwingConstants.BOTTOM);
        bcut.setVerticalTextPosition(SwingConstants.BOTTOM);
        bcopy.setVerticalTextPosition(SwingConstants.BOTTOM);
        bpaste.setVerticalTextPosition(SwingConstants.BOTTOM);
        bcompile.setVerticalTextPosition(SwingConstants.BOTTOM);
        brunapp.setVerticalTextPosition(SwingConstants.BOTTOM);
        brunapplet.setVerticalTextPosition(SwingConstants.BOTTOM);
        bservletrunner.setVerticalTextPosition(SwingConstants.BOTTOM);
		bnew.setVerticalTextPosition(SwingConstants.BOTTOM);
		bredo.setVerticalTextPosition(SwingConstants.BOTTOM);
		brunhtml.setVerticalTextPosition(SwingConstants.BOTTOM);
		baccess.setVerticalTextPosition(SwingConstants.BOTTOM);

		bnew.setHorizontalTextPosition(SwingConstants.CENTER);
		bopen.setHorizontalTextPosition(SwingConstants.CENTER);
		bsave.setHorizontalTextPosition(SwingConstants.CENTER);
		bundo.setHorizontalTextPosition(SwingConstants.CENTER);
		bcut.setHorizontalTextPosition(SwingConstants.CENTER);
		bcopy.setHorizontalTextPosition(SwingConstants.CENTER);
		bpaste.setHorizontalTextPosition(SwingConstants.CENTER);
		bcompile.setHorizontalTextPosition(SwingConstants.CENTER);
		brunapp.setHorizontalTextPosition(SwingConstants.CENTER);
        bservletrunner.setHorizontalTextPosition(SwingConstants.CENTER);
        brunapplet.setHorizontalTextPosition(SwingConstants.CENTER);
		bredo.setHorizontalTextPosition(SwingConstants.CENTER);
		brunhtml.setHorizontalTextPosition(SwingConstants.CENTER);
		baccess.setHorizontalTextPosition(SwingConstants.CENTER);


		New.setAccelerator(KeyStroke.getKeyStroke("control N"));
		open.setAccelerator(KeyStroke.getKeyStroke("control O"));
		save.setAccelerator(KeyStroke.getKeyStroke("control S"));
		undo.setAccelerator(KeyStroke.getKeyStroke("control Z"));
		redo.setAccelerator(KeyStroke.getKeyStroke("control Y"));
		cut.setAccelerator(KeyStroke.getKeyStroke("control X"));
		copy.setAccelerator(KeyStroke.getKeyStroke("control C"));
		paste.setAccelerator(KeyStroke.getKeyStroke("control P"));
		compile.setAccelerator(KeyStroke.getKeyStroke("control 1"));
		application.setAccelerator(KeyStroke.getKeyStroke("control 2"));

		applet.setAccelerator(KeyStroke.getKeyStroke("control 3"));
		servlet_runner.setAccelerator(KeyStroke.getKeyStroke("control 4"));
		iExplorer.setAccelerator(KeyStroke.getKeyStroke("control 5"));
		access.setAccelerator(KeyStroke.getKeyStroke("control 6"));
		iExplorer.setAccelerator(KeyStroke.getKeyStroke("control 8"));
		help.setAccelerator(KeyStroke.getKeyStroke("control H"));
		save_as.setAccelerator(KeyStroke.getKeyStroke("control A"));

		New.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		save_as.addActionListener(this);
		undo.addActionListener(this);
		redo.addActionListener(this);
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		clear.addActionListener(this);
		font.addActionListener(this);
		forecolor.addActionListener(this);
		backcolor.addActionListener(this);
		compile.addActionListener(this);
		application.addActionListener(this);
		applet.addActionListener(this);
		servlet_runner.addActionListener(this);
		iExplorer.addActionListener(this);
		print.addActionListener(this);

		access.addActionListener(this);
		help.addActionListener(this);
		about.addActionListener(this);
		bnew.addActionListener(this);
		bopen.addActionListener(this);
		bsave.addActionListener(this);
		bundo.addActionListener(this);
		bredo.addActionListener(this);
		bcut.addActionListener(this);
		bcopy.addActionListener(this);
		bpaste.addActionListener(this);
		bcompile.addActionListener(this);
		brunapp.addActionListener(this);
		brunhtml.addActionListener(this);

		brunapplet.addActionListener(this);
		bservletrunner.addActionListener(this);
		baccess.addActionListener(this);
		api.addActionListener(this);
		close.addActionListener(this);
		Tomcat.addActionListener(this);

		full_screen.addItemListener(this);
		output_window.addItemListener(this);

		ta.addKeyListener(this);

		go.addActionListener(this);
		google.addActionListener(this);
		cb.addActionListener(this);

		Tomcat.addItemListener(this);

		google.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(google.getText().equals("Any query, Google here"))
				{
					google.setText("");
				}
			}

		});

		ta.setFont(new Font ("CourierNew",Font.PLAIN,20));
		google.setFont(new Font ("CourierNew",Font.PLAIN,18));
		um = new UndoManager();
   		 ta.getDocument().addUndoableEditListener(um);

		v.addElement("AcrylLookAndFeel");
		v.addElement("AeroLookAndFeel");
		v.addElement("AluminiumLookAndFeel");
		v.addElement("BernsteinLookAndFeel");
		v.addElement("FastLookAndFeel");
		v.addElement("HiFiLookAndFeel");
		v.addElement("McWinLookAndFeel");
		v.addElement("MintLookAndFeel");
		v.addElement("NoireLookAndFeel");
		v.addElement("SmartLookAndFeel");
		v.addElement("LunaLookAndFeel");
		v.addElement("TextureLookAndFeel");

		top.setBounds(05,05,1366,45);
		Bottom.setBounds(05,650,1366,30);
		jp.setBounds(90,50,1165,430);
		jp1.setBounds(90,490,1165,160);
		lp.setBounds(05,50,80,600);
		rp.setBounds(1260,50,80,600);

		file.add(New);
		file.add(open);
		file.add(save);
		file.add(save_as);
		file.add(close);
		file.add(print);

		edit.add(undo);
		edit.add(redo);
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(clear);


		format.add(font);
		format.add(colors);

		run.add(compile);
		run.add(application);
		run.add(applet);
		run.add(servlet_runner);
		run.add(iExplorer);
		run.add(access);

		window.add(full_screen);
		window.add(output_window);

		Help.add(help);
		Help.add(about);

		mb.add(file);
		mb.add(edit);
		mb.add(format);
		mb.add(run);
		mb.add(window);
		mb.add(Help);

		lp.add(bnew);
		lp.add(bopen);
		lp.add(bsave);
		lp.add(bundo);
		lp.add(bredo);
		lp.add(bcut);
		lp.add(bcopy);

		rp.add(bpaste);
		rp.add(bcompile);
		rp.add(brunapp);
		rp.add(brunhtml);

		rp.add(brunapplet);
		rp.add(bservletrunner);
		rp.add(baccess);

		Bottom.add(line_no);

		top.add(Tomcat);
		top.add(new JLabel("                      "));
		top.add(api);
		top.add(new JLabel("                      "));
		top.add(google);
		top.add(go);
		top.add(new JLabel("         Themes :"));
		top.add(cb);

		colors.add(forecolor);
		colors.add(backcolor);

		setJMenuBar(mb);
		add(jp);
		add(jp1);
		add(lp);
		add(rp);
		add(top);
		add(Bottom);

	}
	public void keyTyped(KeyEvent e)
	{
		line_no.setText("Total lines : "+ta.getLineCount());
	}
	public void keyPressed(KeyEvent e){};
	public void keyReleased(KeyEvent e){};
	public void actionPerformed(ActionEvent e)
	{
		String s=e.getActionCommand();
		if(s=="New")
		{
			callnew();

    	}

		else
		if(s=="Open")
		{
			callopen();

  		}

		else
		if(s=="Save")
			callsave();

		else
		if(s=="Save As")
			callsaveas();
		else
		if(s=="Undo")
			callundo();
		else
		if(s=="Redo")
			callredo();
		else
		if(s=="Cut")
			ta.cut();
		else
		if(s=="Copy")
			ta.copy();
		else
		if(s=="Paste")
			ta.paste();
		else
		if(s=="Clear")
			ta.setText("");

		if(s=="Font")
			callfont();
		else
		if(s=="Print")
			try{ta.print();}catch(Exception p){}
		else
		if(s=="Forecolor")
			callforecolor();
		else
		if(s=="Backcolor")
			callbackcolor();
		else
		if(s=="Compile")
			callcompile();
		else
		if(s=="Application")
			callapplication();
		else
		if(s=="Applet")
			callapplet();
		else
		if(s=="Servlet")
			callservlet();
		else
		if(s=="iExplorer")
			calliExplorer();
		else
		if(s=="Ms-Access")
			callaccess();
		else

		if(s=="Help")
			callhelp();
		else
		if(s=="About")
			callabout();
		else
		if(s=="Open Java Api...")
			callapi();
		else
		if(s=="Search")
			callsearch();
		if(s=="Open Xampp Server")
			callXampp();
		else
		if(s=="Close")
			System.exit(0);
		else
		{
			 String theme = cb.getSelectedItem().toString();
			try
			{
			switch(theme)
			{
				case "AcrylLookAndFeel": UIManager.setLookAndFeel("com.jtattoo.plaf.acryl."+theme); break;
				case "AeroLookAndFeel": UIManager.setLookAndFeel("com.jtattoo.plaf.aero."+theme);break;
				case "AluminiumLookAndFeel": UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium."+theme);break;
				case "BernsteinLookAndFeel": UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein."+theme);break;
				case "FastLookAndFeel": UIManager.setLookAndFeel("com.jtattoo.plaf.fast."+theme);break;
				case "HiFiLookAndFeel": UIManager.setLookAndFeel("com.jtattoo.plaf.hifi."+theme);         ; break;
				case "McWinLookAndFeel": UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin."+theme);break;
				case "MintLookAndFeel": UIManager.setLookAndFeel("com.jtattoo.plaf.mint."+theme);break;
				case "NoireLookAndFeel": UIManager.setLookAndFeel("com.jtattoo.plaf.noire."+theme);break;
				case "SmartLookAndFeel": UIManager.setLookAndFeel("com.jtattoo.plaf.smart."+theme);break;
				case "LunaLookAndFeel": UIManager.setLookAndFeel("com.jtattoo.plaf.luna."+theme);break;
				case "TextureLookAndFeel": UIManager.setLookAndFeel("com.jtattoo.plaf.texture."+theme);break;
			}
			}catch(Exception edfg) {System.out.println(edfg);}
			SwingUtilities.updateComponentTreeUI( this );
		}
	}
	public void itemStateChanged(ItemEvent e)
	{

		if(full_screen.getState())
		{
			jp.setBounds(90,50,1165,640);
			validate();
		}
		else
		{
			jp.setBounds(90,50,1165,430);
			validate();
		}
		if(output_window.getState())
		{
			jp1.setVisible(true);
			validate();
		}

		else
		{
			jp1.setVisible(false);
			validate();
		}

	}
	public void callnew()
	{
			  ta.setText("");
		      JDialog d1=new JDialog(this,"New ... ",true);
		      d1.setBounds(550,300,250,120);
		      d1.setLayout(new FlowLayout());
		      d1.add(new JLabel("Select the File Type"));
		      JComboBox c=new JComboBox();
		      c.addItem("Application");
		      c.addItem("Applet");
		      c.addItem("Frame");
		      c.addItem("Swing");
		      c.addItem("JDBC");
		      c.addItem("Servlet");
		      c.addItem("HTML");
		      d1.add(c);
		      JButton b1=new JButton("Start");
		      JButton b2=new JButton("Cancel");
		      d1.add(b1);
		      d1.add(b2);

		      b1.addActionListener(new ActionListener()
		      {
		      public void actionPerformed(ActionEvent v)
		      {
		      String xx=c.getSelectedItem().toString();
		      String title=getTitle().substring(11,getTitle().length()-5);

		      if(xx=="Application")
		      {
		         FileDialog fd=new FileDialog(new frame1(),"Save Application",FileDialog.SAVE);
		         fd.setVisible(true);

		         File f = new File(fd.getDirectory()+fd.getFile());
		         if(fd.getFile().toString()==("null")){}
		         else
		         {
		         setTitle("JPDK 1.8 - " + f.getPath()+ ".java");
		         String s1="\nclass " + fd.getFile();
		         s1+="\n{\n\tpublic static void main(String args[])";
		         s1+="\n\t{\n\n\n\t}\n}";
		         ta.setText(s1);
			 	}

        	  }
		       if(xx=="Frame")
		       {
		          String s1="import java.awt.*;";
		          s1+="\nimport java.awt.event.*;";
		          s1+="\nclass frame1 extends Frame";
		          s1+="\n{\n\tpublic frame1()\n\t{";
		          s1+="\n\tsuper(\"My Frame\");";
		          s1+="\n\tsetSize(300,300);";
		          s1+="\n\tsetLayout(new FlowLayout());";
		          s1+="\n\taddWindowListener(new WindowAdapter()";
		          s1+="\n\t{\n\tpublic void windowClosing(WindowEvent we){";
		          s1+="\n\tSystem.exit(0);";
		          s1+="\n\n\t}});";
		          s1+="\n\tsetVisible(true);\n\t}\n}";
		          FileDialog fd=new FileDialog(new frame1(),"Save Frame",FileDialog.SAVE);
		          fd.setVisible(true);
		          if(fd.getFile().toString()==("null")){}
				  else
		          {
		          setTitle("JPDK 1.8 - " + new File(fd.getDirectory()+fd.getFile()) + ".java");
		          title=getTitle().substring(11,getTitle().length()-5);
		          s1+="\nclass " + fd.getFile();
		          s1+="\n{\n\tpublic static void main(String args[])";
		          s1+="\n\t{\n\tnew frame1();\n\t}\n}";
		          ta.setText(s1);
			  	  }
		       }

		       if(xx=="Applet")
		       {
		          String s1="import java.awt.*;";
		          s1+="\nimport java.awt.event.*;";
		          s1+="\nimport java.applet.*;";
		          FileDialog fd=new FileDialog(new frame1(),"Save Applet",FileDialog.SAVE);
		          fd.setVisible(true);
		          if(fd.getFile().toString()==("null")){}
				  else
		          {
		          setTitle("JPDK 1.0 - " + new File(fd.getDirectory()+fd.getFile()) + ".java");
		          title=getTitle().substring(11,getTitle().length()-5);
		          s1+="\npublic class " + fd.getFile() + " extends Applet";	          s1+="\n{\n\tpublic void init()\n\t{\n\n\n\t}";
		          s1+="\n\tpublic void start()\n\t{\n\n\n\t}";
		          s1+="\n\tpublic void paint(Graphics g)\n\t{\n\n\n\t}";
		          s1+="\n\tpublic void stop()\n\t{\n\n\n\t}";
		          s1+="\n\tpublic void destroy()\n\t{\n\n\n\t}\n}";
		          ta.setText(s1);
			  	  }
		       }

		       if(xx=="Swing")
		       {
		          String s1="import javax.swing.*;";
		          s1+="\nimport java.applet.*;";
		          s1+="\nimport java.awt.*;";
		          s1+="\nimport javax.swing.event.*;\n";
		          FileDialog fd=new FileDialog(new frame1(),"Save Swings",FileDialog.SAVE);
		          fd.setVisible(true);
		          if(fd.getFile().toString()==("null")){}
				  else
		          {
		          setTitle("JPDK 1.0 - " +fd.getDirectory()+fd.getFile() + ".java");
		          title=getTitle().substring(11,getTitle().length()-5);
		          s1+="\nimport java.awt.event.*;";
				  s1+="\nclass frame1 extends JFrame";
				  s1+="\n{\n\tpublic frame1()\n\t{";
				  s1+="\n\tsuper(\"My Frame\");";
				  s1+="\n\tsetSize(300,300);";
				  s1+="\n\tsetLayout(new FlowLayout());";
				  s1+="\n\taddWindowListener(new WindowAdapter()";
				  s1+="\n\t{\n\tpublic void windowClosing(WindowEvent we){";
				  s1+="\n\tSystem.exit(0);";
				  s1+="\n\n\t}});";
		          s1+="\n\tsetVisible(true);\n\t}\n}";
		          s1+="\nclass " + fd.getFile();
				  s1+="\n{\n\tpublic static void main(String args[])";
		          s1+="\n\t{\n\tnew frame1();\n\t}\n}";
		          ta.setText(s1);
			  	  }
		       }


		       if(xx=="JDBC")
		       {
		          String s1="import java.sql.*;";
		          s1+="\nimport java.io.*;";
		          FileDialog fd=new FileDialog(new frame1(),"Save JDBC",FileDialog.SAVE);
		          fd.setVisible(true);
		          if(fd.getFile().toString()==("null")){}
				  else
		          {
		          setTitle("JPDK 1.0 - " + fd.getDirectory()+fd.getFile() + ".java");
		          s1+="\npublic class " + fd.getFile();
		          s1+="\n{\n\tpublic static void main(String ar[]) throws Exception";
		          s1+="\n\t{\n\tClass.forName(\"sun.jdbc.odbc.JdbcOdbcDriver\");";
		          s1+="\n\tConnection cn=DriverManager.getConnection(\"jdbc:odbc:dsnname\");";
		          s1+="\n\tStatement st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);";
		          s1+="\n\tResultSet rs=st.executeQuery(\"select * from tablename\");";
		          s1+="\n\n\n\t}\n}";
		          ta.setText(s1);
			  	  }
		       }
		       if(xx=="Servlet")
		       {
		          String s1="import javax.servlet.*;";
		          s1+="\nimport javax.servlet.http.*;";
		          s1+="\nimport java.io.*;\n";
		          FileDialog fd=new FileDialog(new frame1(),"Save Servlet",FileDialog.SAVE);
		          fd.setVisible(true);
		          if(fd.getFile().toString()==("null")){}
				  else
		          {
		          setTitle("JPDK 1.8 - " + fd.getDirectory()+fd.getFile() + ".java");
		          s1+="\npublic class " + fd.getFile() + " extends HttpServlet";
		          s1+="\n{\n\tpublic void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException";
		          s1+="\n\t{\n\n\n\t}\n}";
		          ta.setText(s1);
			  	  }
		       }

		       if(xx=="HTML")
		       {
		          FileDialog fd=new FileDialog(new frame1(),"Save HTML",FileDialog.SAVE);
		          fd.setVisible(true);
		          if(fd.getFile().toString()==("null")){}
				  else
		          {
		          setTitle("JPDK 1.0 - " + fd.getDirectory()+fd.getFile() + ".html");
		          String s1="<html>";
		          s1+="\n<head>";
		          s1+="\n<title> Web page </title>";
		          s1+="\n</head>";
		          s1+="\n<body>";
		          s1+="\n\n\n\n";
		          s1+="\n</body>";
		          s1+="\n</html>";
		          ta.setText(s1);
			  	  }
		       }


		       ta.requestFocus();
		       d1.dispose();
		       }
		       });
		       b2.addActionListener(new ActionListener()
		       {
		      	 public void actionPerformed(ActionEvent v)
		       		{
		      			d1.dispose();
		       		}
		       });

		       d1.setVisible(true);
	}
	public void callopen()
	{
		FileDialog fd=new FileDialog(this,"File Open ...",FileDialog.LOAD);
		fd.setVisible(true);
		File f = new File(fd.getDirectory()+fd.getFile());
		if(fd.getFile()!=null)
		{
			setTitle("JPDK 1.8 - " + f);
			try{
				FileInputStream ds=new FileInputStream(f);
				int c;
				ta.setText("");
				String sx="";
				while((c=ds.read())!=-1)
				sx=sx+(char)c;
				ta.setText(sx);
  			}catch(Exception se){}
		}
	}
	public void callsave()
	{
		String t=getTitle();
    	File ff;
    	FileDialog fd;
    	if(t=="JPDK 1.8 - Untitled")
    	{
    	   fd=new FileDialog(this,"File Saving...",FileDialog.SAVE);
    	   fd.setVisible(true);
    	   ff=new File(fd.getDirectory()+fd.getFile());
    	}
    	else
    	{
    	   ff=new File(t.substring(11,t.length()));
    	}
    		try{

    		PrintWriter pw = new PrintWriter(new FileOutputStream(ff),true);
    		pw.println(ta.getText());
    		 setTitle("JPDK 1.8 - " + ff);
    		}catch(Exception fe){};
	}
	public void callsaveas()
	{
		String t=getTitle();
    	File ff;
    	FileDialog fd;

    	if (t=="JPDK 1.8 - Untitled")
    	   fd=new FileDialog(this,"Save...",FileDialog.SAVE);
    	else
    	   fd=new FileDialog(this,"Save As ...",FileDialog.SAVE);

    	fd.setVisible(true);
    	ff=new File(fd.getDirectory()+fd.getFile());
    	try{
    		PrintWriter pw = new PrintWriter(new FileOutputStream(ff),true);
    		pw.println(ta.getText());
    		setTitle("JPDK 1.8 - " + ff);
    		}catch(Exception fe){};
	}

	public void callundo()
	{
		um.undo();
	}
	public void callredo()
		{
			um.redo();
		}


	public void callfont()
	{
		JDialog d1=new JDialog(this,"Fonts .... ",true);
     	d1.setLocation(250,200);
     	d1.setSize(300,100);
     	d1.setLayout(new FlowLayout());
    	Choice c1=new Choice();
    	String FontList[];
     	GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
     	FontList=ge.getAvailableFontFamilyNames();
     	for(int i=0;i<FontList.length;i++)
        c1.add(FontList[i]);
     	d1.add(c1);
     	Choice c2=new Choice();
     	for(int i=8;i<=60;i+=2)
       		c2.add(i+"");
     	d1.add(c2);
     	Choice c3=new Choice();
     	c3.add("Normal");
    	c3.add("Bold");
     	c3.add("Italic");
     	c3.add("Both");
     	d1.add(c3);
     	Button b1=new Button("OK");
     	Button b2=new Button("Cancel");
     	d1.add(b1);
     	d1.add(b2);
     	b1.addActionListener(new ActionListener()
   			  {
        		public void actionPerformed(ActionEvent e)
        		{
        			d1.dispose();
        			String s1=c1.getSelectedItem();
        			int s2=Integer.parseInt(c2.getSelectedItem());
        			String s3=c3.getSelectedItem();
        			String s4="";
        			if (s3=="Normal")
        			{
        				ta.setFont(new Font(s1,Font.PLAIN,s2));
       					op.setFont(new Font(s1,Font.PLAIN,s2));
        			}
        			else if(s3=="Bold")
       				{
        				ta.setFont(new Font(s1,Font.BOLD,s2));
        				op.setFont(new Font(s1,Font.BOLD,s2));
        			}
        			else if(s3=="Italic")
        			{
        				ta.setFont(new Font(s1,Font.ITALIC,s2));
        				op.setFont(new Font(s1,Font.ITALIC,s2));
        			}
        			else if(s3=="Both")
        			{
        				ta.setFont(new Font(s1,Font.ITALIC+Font.BOLD,s2));
        				op.setFont(new Font(s1,Font.ITALIC+Font.BOLD,s2));
        			}
        		}
     		});
     b2.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
        d1.dispose();
        }
     });
     d1.setVisible(true);
    }

    public void callforecolor()
    {

			 JDialog d1=new JDialog(this,"Colors .... ",true);
		     d1.setBounds(550,250,300,250);
		     d1.setLayout(null);
		     JSlider s1=new JSlider(0,0,255,0);
		     JSlider s2=new JSlider(0,0,255,0);
		     JSlider s3=new JSlider(0,0,255,0);
		     JLabel l1=new JLabel("Red");
		     JLabel l2=new JLabel("Green");
		     JLabel l3=new JLabel("Blue");
		     JTextField t1=new JTextField(10);
		     t1.setFont(new Font("Impact",Font.BOLD,30));
		     t1.setText("Aa");
		     l1.setBounds(10,37,100,10);
		     s1.setBounds(10,50,150,25);
		     l2.setBounds(10,77,100,10);
		     s2.setBounds(10,90,150,25);
		     l3.setBounds(10,117,100,10);
		     s3.setBounds(10,130,150,25);
		     s1.addChangeListener(new ChangeListener()
		     {
		        public void stateChanged(ChangeEvent e)
		        {
		        r1=s1.getValue();
		        t1.setForeground(new Color(r1,g1,b1));
		        }
		     });
		     s2.addChangeListener(new ChangeListener()
		     {
		        public void stateChanged(ChangeEvent e)
		        {
		        g1=s2.getValue();
		        t1.setForeground(new Color(r1,g1,b1));
		        }
		     });
		     s3.addChangeListener(new ChangeListener()
		     {
		        public void stateChanged(ChangeEvent e)
		        {
		        b1=s3.getValue();
		        t1.setForeground(new Color(r1,g1,b1));
		        }
		     });
		     t1.setBounds(165,75,75,60);
		     t1.setEditable(false);
		     d1.add(l1);
		     d1.add(l2);
		     d1.add(l3);
		     d1.add(s1);
		     d1.add(s2);
		     d1.add(s3);
		     d1.add(t1);
		     JButton b11=new JButton("OK");
		     JButton b2=new JButton("Cancel");
		     b11.setBounds(60,180,80,20);
		     b2.setBounds(150,180,80,20);
		     d1.add(b11);
		     d1.add(b2);
		     b11.addActionListener(new ActionListener()
		     {
		        public void actionPerformed(ActionEvent e)
		        {
		        ta.setForeground(new Color(r1,g1,b1));
		        op.setForeground(new Color(r1,g1,b1));
		        d1.dispose();
		        }
		     });
		     b2.addActionListener(new ActionListener()
		     {
		        public void actionPerformed(ActionEvent e)
		        {
		            d1.dispose();
		        }
		     });
		      s1.requestFocus();
		      d1.setVisible(true);
     }


 	public void callbackcolor()
    {
		JDialog d1=new JDialog(this,"Colors .... ",true);
		d1.setBounds(550,250,300,250);
     	d1.setLayout(null);
		JSlider s1=new JSlider(0,0,255,0);
		JSlider s2=new JSlider(0,0,255,0);
		JSlider s3=new JSlider(0,0,255,0);
     	JLabel l1=new JLabel("Red");
     	JLabel l2=new JLabel("Green");
     	JLabel l3=new JLabel("Blue");
     	JTextField t1=new JTextField("Sample",10);
     	l1.setBounds(10,37,100,10);
     	s1.setBounds(10,50,150,25);
     	l2.setBounds(10,77,100,10);
     	s2.setBounds(10,90,150,25);
     	l3.setBounds(10,117,100,10);
     	s3.setBounds(10,130,150,25);
     	s1.addChangeListener(new ChangeListener()
     	{
        	public void stateChanged(ChangeEvent e)
        	{
        		r=s1.getValue();
        		t1.setBackground(new Color(r,g,b));
        	}
     	});
    	s2.addChangeListener(new ChangeListener()
     	{
        	public void stateChanged(ChangeEvent e)
        	{
        		g=s2.getValue();
        		t1.setBackground(new Color(r,g,b));
        	}
     	});
     	s3.addChangeListener(new ChangeListener()
     	{
        	public void stateChanged(ChangeEvent e)
        	{
        		b=s3.getValue();
        		t1.setBackground(new Color(r,g,b));
        	}
     	});
     	t1.setBounds(165,75,75,60);
     	t1.setEnabled(false);
     	d1.add(l1);
     	d1.add(l2);
     	d1.add(l3);
     	d1.add(s1);
     	d1.add(s2);
     	d1.add(s3);
     	d1.add(t1);
     	JButton b1=new JButton("OK");
     	JButton b2=new JButton("Cancel");
     	b1.setBounds(60,180,80,20);
		b2.setBounds(150,180,80,20);
     	d1.add(b1);
     	d1.add(b2);
     	b1.addActionListener(new ActionListener()
     	{
        	public void actionPerformed(ActionEvent e)
        	{
        		ta.setBackground(new Color(r,g,b));
        		op.setBackground(new Color(r,g,b));
        		d1.dispose();
        	}
     	});
     	b2.addActionListener(new ActionListener()
     	{
        	public void actionPerformed(ActionEvent e)
        	{
           		d1.dispose();
        	}
     	});
      	d1.setVisible(true);
	}

	public void callcompile()
    {
		try{
    		String r = getTitle().substring(11,getTitle().length());

    		Runtime rt =Runtime.getRuntime();
    		Process p =rt.exec("javac "+"\""+r+"\"");
    		p.waitFor();
    		int i =p.exitValue();
    		InputStream ip =p.getErrorStream();
    		int a =ip.available();
    		op.setText("");
    		op.setText("Compiling ...."  +"\n\n");
    		if(a==0)
    			op.setText(op.getText()+"Congrats !!... There are no errors in your Program\n");
    		else
    		{
       			int c;
       			String ts=op.getText();
       			while((c =ip.read()) != -1)
       			{
       				ts=ts+(char) c;
       			}
       		op.setText(ts);
    		}
    }catch(Exception ex){}

	}

	public void callapplication()
    {
		String r = getTitle().substring(11,getTitle().length()-5);
		try
		{
			String path = r.substring(1,r.lastIndexOf("\\"));
			String drive = r.substring(0,1);


			String classname = r.substring(r.lastIndexOf("\\")+1,r.length());
			Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"java -cp \""+drive+path+"\" "+classname+" && pause && exit\"");

		    }catch(Exception eq){
				System.out.println(eq);
				}


	}

	public void callapplet()
    {
		try
			{
					String r = getTitle().substring(11,getTitle().length()-5);
					File f = new File(r+".html");
					String drive = r.substring(0,1);
		    		PrintWriter pw = new PrintWriter(new FileOutputStream(f),true);
		    		String filename = r.substring(r.lastIndexOf("\\")+1);
		    		String path = r.substring(1,r.lastIndexOf("\\"));
					String classname = r.substring(r.lastIndexOf("\\")+1,r.length());
		    		pw.println("<html>");
		    		pw.println("<applet code = "+filename+".class"+" width = 700 height = 700 codebase="+drive+path+filename+">");
		    		pw.println("</applet>");
		    		pw.println("/html>");

					System.out.println("appletviewer /"+drive+path+"/"+filename);
					filename = filename+".html";
					Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"appletviewer "+drive+path+"/"+filename+"&& pause && exit\"");


			}catch(Exception eq)
			{
				System.out.println(eq);
			}


	}

	public void callservlet()
    {
		String r = getTitle().substring(11,getTitle().length());
		String ah=r;
		StringBuffer st1 = new StringBuffer(r);
		String a =st1.toString();
		String aa1 = a.replace('\\', '/');
		StringTokenizer st=new StringTokenizer(aa1,".");
		String s1=st.nextToken();
		String s2 = s1.substring(24,29);
		String s3 = s1.substring(45);
		String result ="C:/Program Files/Internet Explorer/IEXPLORE.EXE  http://localhost:8080/"+s2+s3;
		try
		{
			Process p=Runtime.getRuntime().exec(result);
		}catch(Exception ew){}


	}

	public void calliExplorer()
    {
		try{
			String r = getTitle().substring(11,getTitle().length()-5);
		    Runtime t =Runtime.getRuntime();
		    String drive = r.substring(0,1);
		    String filename = r.substring(r.lastIndexOf("\\")+1);
			String path = drive+r.substring(1,r.lastIndexOf("\\"))+"/"+filename+".html";
		    Process p=t.exec("C:/Program Files/Internet Explorer/IEXPLORE.EXE "+path);
		    p.waitFor();
		    int i =p.exitValue();
		    }catch(Exception ip){System.out.println(ip);}

	}

	public void callaccess()
    {
		try{
			System.out.println("ip");
		    Runtime t =Runtime.getRuntime();
		    Process p=t.exec("c:/Program files/Microsoft Office/Office16/MSACCESS.exe");
		    p.waitFor();
		    int i =p.exitValue();
		    }catch(Exception ip){System.out.println(ip);}

	}



	public void callapi()
    {
		try
		{
			Runtime rTime = Runtime.getRuntime();
			String current = new File(".").getCanonicalPath();
			String url = current+"/JavaApi.html";
			String browser = "C:/Program Files/Internet Explorer/iexplore.exe ";
			Process pc = rTime.exec(browser + url);
			pc.waitFor();
		}catch(Exception e){}
	}

	public void callhelp()
    {
	try
	{
		Runtime rTime = Runtime.getRuntime();
		String current = new File( "." ).getCanonicalPath();
		String url = current+"/help/index.html";
		String browser = "C:/Program Files/Internet Explorer/iexplore.exe ";
		Process pc = rTime.exec(browser + url);
		pc.waitFor();
		}catch(Exception e){}


	}
	public void callXampp()
	{
		try
		{
			Runtime r = Runtime.getRuntime();
			Process p = r.exec("C:/xampp/xampp-control.exe");
		}catch(Exception e){}

	}

	public void callabout()
    {
	 JDialog d1=new JDialog(this,"About Project",true);
	 d1.setBounds(550,250,340,300);
     JButton b1=new JButton("OK");

     d1.setLayout(null);
     JLabel l1=new JLabel("Project Created By:");
     JLabel l2=new JLabel("\t\t\tPratik Patil");
     JLabel l3=new JLabel("\t\t\tShreyas Joshi");
     JLabel l4=new JLabel("\t\t\tRohit Pawar");
     JLabel l5=new JLabel("*******************   Under The Guidance of   ******************");
     JLabel l6=new JLabel("Mr Tushar Wagh");
     JLabel l7=new JLabel("(HOD)");
     JLabel icon = new JLabel(new ImageIcon("logoicon.png"));

	 l1.setBounds(20,0,120,40);
	 l2.setBounds(100,5,120,80);
	 l3.setBounds(100,25,120,80);
	 l4.setBounds(100,45,120,80);
	 l5.setBounds(0,100,340,80);
	 l6.setBounds(120,120,120,80);
	 l7.setBounds(140,140,120,80);
	 b1.setBounds(130,210,80,30);
	 icon.setBounds(200,5,100,125);

     d1.add(l1);
     d1.add(l2);
     d1.add(l3);
     d1.add(l4);
     d1.add(l5);
     d1.add(l6);
     d1.add(l7);
     d1.add(icon);

	 d1.add(b1);
     b1.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent we)
        {
        d1.dispose();
        }
      });
     d1.setVisible(true);

	}
	public void callsearch()
	{
		String url ="C:/Program Files/Internet Explorer/IEXPLORE.EXE  https://www.google.com/search?q="+google.getText();
		try
		{
			Process p = Runtime.getRuntime().exec(url);
			google.setText("Any query, Google here");
		}catch(Exception ew)
		{
			System.out.println(ew);
		}

	}


	public static void main(String [] args)
	{

		 		new splashwww();

				 frame1 f = new frame1();
				 		f.setVisible(true);
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("logoicon1.png"));






	}
}