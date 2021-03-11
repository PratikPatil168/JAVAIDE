class splashwww extends JWindow
{
	splashwww()
	{
		setSize(1280,768);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		JLabel pic = new JLabel(new ImageIcon("pro.png"));
		add(pic,"Center");
		setVisible(true);

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ss");
				LocalDateTime now = LocalDateTime.now();
				int sec = Integer.parseInt(dtf.format(now))+5;

				while(true)
				{
					DateTimeFormatter df = DateTimeFormatter.ofPattern("ss");
					LocalDateTime noww = LocalDateTime.now();
					int ss = Integer.parseInt(dtf.format(noww));


					if(sec ==ss)
					{
						dispose();

						break;

					}

				}
	}

public static void main(String [] args)
	{

		 new splashwww();
	}
}