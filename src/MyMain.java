
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyMain {

	public static void main(String[] args) throws InterruptedException {
		
		JFrame frame = new JFrame();
		
		//Se crearon variable final porque no lee getWidth dentro del 
		//constructor CarStage
		final int FRAME_WIDTH=400;
		final int FRAME_HEIGHT=600;
		
		CarStage theComponent = new CarStage(FRAME_HEIGHT);
		frame.add(theComponent);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Java Guru");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
		
		while(!theComponent.someCarWon()){
			frame.repaint();
			Thread.sleep(10);
		}
		
		JOptionPane.showMessageDialog(null, "END OF RACE\nCAR " +theComponent.winNum()+ " WON");
		
		System.exit(0);
	}

}
