import java.awt.*;
import java.awt.event.*;
class frame1 extends Frame
{
	public frame1()
	{
	super("My Frame");
	setSize(300,300);
	setLayout(new FlowLayout());
	addWindowListener(new WindowAdapter()
	{
	public void windowClosing(WindowEvent we){
	System.exit(0);

	}});
	setVisible(true);
	}
}
class hello
{
	pulic static void main(String args[])
	{
	new frame1();
	}
}
