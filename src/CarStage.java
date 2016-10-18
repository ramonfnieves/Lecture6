
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class CarStage extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9032539863554018689L;
	int counter = 0;
	int n;

	MutableCar [] cars;

	boolean someCarWon = false;

	Random r = new Random();

	public boolean someCarWon(){
		return someCarWon;
	}

	public int winNum(){
		return n;
	}

	public CarStage(int frameHeight){
		int laneHeight = 50;
		int numberOfLanes = Math.round(frameHeight/laneHeight);
		
		cars= new MutableCar[numberOfLanes];

		int nextYPos = 0;
		for (int i = 0; i < numberOfLanes; i++) {
			cars[i] = new MutableCar(0,nextYPos,Color.BLUE, 5, 1, i+1);
			nextYPos += laneHeight;
		}
	}

	public void paintComponent(Graphics g){

		for (MutableCar car : cars) {
			car.draw(g);
			int deltaXCar = r.nextInt(car.getHorizontalSpeed());
			car.moveInX(deltaXCar);

			if((car.getXPos()+60)>=this.getWidth()){
				n = car.getNumber();
				winNum();
				car.setPosition(this.getWidth()-60, car.getYPos());
				someCarWon=true;
			} 
		} 

		System.out.println(counter++);
	}
}
