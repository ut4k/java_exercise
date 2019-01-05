import javax.swing.*;
import java.awt.*;

public class HelloJava {
	public static void main( String[] args ) {
		JFrame frame = new JFrame("Hello Java!");
		JLabel label = new JLabel("Hello Java!", JLabel.CENTER);
		HelloComponent hello = new HelloComponent();
		// frame.getContentPane().add(label);
		frame.getContentPane().add(hello);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}

class HelloComponent extends JComponent{
//動かなかった
	public void paintComponent(Graphics g){
		g.drawString("Hello, Java!", 125, 95);
	}
}
