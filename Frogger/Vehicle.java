import objectdraw.*;
import java.awt.*;

/**
 * A Vehicle is an ActiveObject that moves along a designated lane at a constant
 * speed, until it reaches the end.
 */
public class Vehicle extends ActiveObject {

	private static final int MAX_VEHICLE_SIZE = 139;
	private static final int MAX_VEHICLE_HEIGHT = 66;
	private static final int END_OF_LANE = 700;
	private static final int DELAY = 100;

	// TODO DESIGN: declare/describe all instance variables
	private boolean killedFrog;
	private Frog refFrog;
	private long currentTime;
	private VisibleImage vehicleImage;
	private double carSpeed;

	private long time;
	private Location startLoc;

	/**
	 * Instantiate a new vehicle, with a specified position and speed
	 * 
	 * TODO DESIGN: describe all Vehicle constructor variables
	 * 
	 * @param vehicle
	 *            image to display the vehicle
	 * @param starting
	 *            location on the lane
	 * @param travel
	 *            speed and direction
	 * @param where
	 *            it disappears when reaching the end of the lane
	 * @param frog
	 *            (so we can check for overlap)
	 * @param ... ?others?
	 */
	public Vehicle(Image car, Location loc, double speed,
			double distanceTraveled, Frog frog, DrawingCanvas canvas) {
		// TODO DESIGN: missing pieces of Vehicle constructor
		// Write a paragraph of text or pseudo code describing
		// how you will implement these steps, what conditional
		// decisions you will make, and what objects, methods
		// and variables you will use to perform these operations.
		/*
		 * The constructor first loads the image of the vehicle and then gives
		 * it a starting location. It should also give the vehicle a speed and
		 * the direction it is going in.
		 */
		vehicleImage = new VisibleImage(car, loc, MAX_VEHICLE_SIZE,
				MAX_VEHICLE_HEIGHT, canvas);
		startLoc = loc;
		carSpeed = speed;
		refFrog = frog;
		start();
	}

	/**
	 * Active Object (thread) routine for a vehicle
	 * <p>
	 * Move vehicle along the lane until it reaches the end, checking to see if
	 * we have hit the frog.
	 * <UL>
	 * <LI>after each iteration of the loop, pause for at least 30ms.
	 * <LI>we may pause longer than the requested time. To achieve smooth
	 * movement we should check the time when we resume, determine how long we
	 * actually paused, and compute the distance the vehicle should have moved
	 * during that time.
	 * <LI>after we move the vehicle to its new position, see if we hit the
	 * frog. If so, call his kill method.
	 * <LI>after the vehicle reaches the end of the lane, we should remove the
	 * vehicle from the canvas and exit.
	 * </UL>
	 */
	public void run() {

		time = System.currentTimeMillis();
		//System.out.println(time);
		while (vehicleImage.getX() < END_OF_LANE) { // FIXME - test if vehicle
													// has reached end of lane
		
			currentTime = System.currentTimeMillis() - time;
			time = System.currentTimeMillis();
			vehicleImage.move(carSpeed * currentTime, 0);
			if(refFrog.overlaps(vehicleImage)){
				refFrog.kill();
			}
			System.out.println(carSpeed * currentTime);
			pause(100);

		}
		vehicleImage.removeFromCanvas();
	}
}
