import objectdraw.*;
import java.awt.*;

/**
 * An ActiveObject that periodically creates new Vehicles.
 */
public class Lane extends ActiveObject {

	// TODO DESIGN: declare/describe all instance variables
	/**
	 * Distance from front bumper to back bumper of the longest vehicle (in
	 * pixels)
	 */
	private static final int MAX_VEHICLE_SIZE = 139;
	private static final int MAX_VEHICLE_HEIGHT = 66;
	private static final double HIGHWAY_LENGTH = 700;
	// ?others?
	
	private static final double CARLENGTH = 126;

	private Vehicle carImage;
	private boolean continous;
	private Image aCar;
	private Location aLoc;
	private double aSpeed;
	private Frog aFrog;
	private DrawingCanvas aCanvas;

	/**
	 * Instantiate a new Lane, and determine inter-vehicle pause
	 * 
	 * TODO DESIGN: identify/define Lane constructor parameters
	 * 
	 * @param Vehicle
	 *            image(s) 4 vehicle images for the different type of cars
	 * @param location
	 *            of this lane
	 * @param speed
	 *            and direction for this lane
	 * @param Frog
	 *            (to be passed to Vehicles)
	 * @param ... ?others?
	 */
	public Lane(double speed, Location loc, Image car, Frog frog,
			DrawingCanvas canvas) {

		// TODO DESIGN: missing pieces of Lane constructor
		// Write a paragraph of text or pseudo code describing
		// how you will implement these steps, what conditional
		// decisions you will make, and what objects, methods
		// and variables you will use to perform these operations.
		/*
		 * First 4 vehicle objects must be made and each type of car has a
		 * different location, speed, and direction according to the lane it is
		 * in.Each car type still accepts the Frog as a param4ter in order to
		 * reference it.
		 */
		continous = true;
		aCar = car;
		aLoc = loc;
		aSpeed = speed;
		aFrog = frog;
		aCanvas = canvas;
		
		carImage = new Vehicle(car, loc, speed, HIGHWAY_LENGTH, frog, canvas);
		start();
	}

	/**
	 * Active Object (thread) routine (main loop) for a Lane
	 * <p>
	 * <UL>
	 * <li>instantiate a new vehicle
	 * <li>decide how long to wait before creating next one (1-4 car lengths)
	 * <li>pause for that period
	 * </ul>
	 */
	public void run() {

		// Loop until the program stops.
		while (continous) {
			/*
			 * A new car is initialized. The car moves down the lane at a
			 * specific speed and direction, and then pauses. After the pause, a
			 * new car is initialized and the previous car continues to move
			 * until it reaches the end of the lane.
			 */
			double distance = CARLENGTH/aSpeed;
			pause(distance * 3);
			new Vehicle(aCar, aLoc, aSpeed, HIGHWAY_LENGTH, aFrog, aCanvas);
			
			
	
		}
	}

}
