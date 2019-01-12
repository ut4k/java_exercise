import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloJava3{

	public static void main(String[] args){
		JFrame frame = new JFrame("HelloJava3");

		HelloComponent3 c = new HelloComponent3();
		c.setMessage("konnichiwa!!");
		// frame.getContentPane().add( new HelloComponent3( "Hello Java!" ));
		//
		//
		frame.getContentPane().add(c);
		frame.getDefaultCloseOperation();
		// frame.getSize(300, 300);
		frame.setVisible(true);
	}
	
}

class HelloComponent3 extends JComponent
	implements MouseMotionListener, ActionListener{
	
	private static final long serialVersionUID = 1234L;
	String theMessage;
	int messageX = 125;
	int messageY = 95;

	JButton theButton;

	int colorIndex;

	static Color[] someColors = {
		Color.black,
		Color.red,
		Color.green,
		Color.blue,
		Color.magenta
	};

	public void Hellocomponent3(){
		theButton = new JButton("Change Color");
		setLayout( new FlowLayout() );
		add(theButton);
		theButton.addActionListener(this);
		addMouseMotionListener(this);
	}

	public void setMessage(String message){
		theMessage = message;
	}

	public void paintComponent(Graphics g){
		g.drawString(theMessage, messageX, messageY);
	}

	@Override	
	public void mouseDragged(MouseEvent e){
		messageX = e.getX();
		messageY = e.getY();
		repaint();
	}

	@Override	
	public void mouseMoved(MouseEvent e){}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == theButton)
			changeColor();
	}

	synchronized private void changeColor(){
		if(++colorIndex == someColors.length)
			colorIndex = 0;
		setForeground(currentColor());
		repaint();
	}

	synchronized private Color currentColor(){
		return someColors[colorIndex];
	}

}


