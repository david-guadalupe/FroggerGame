import objectdraw.*;

import java.awt.*;

/**
 * The Frog is a visible image on the screen that moves in response to user
 * input, and dies if it comes into contact with a Vehicle.
 */
public class Frog {
	private static final double FROG_HEIGHT = 40;
	private static final double FROG_WIDTH = 83;

	/**
	 * This should refer to the image of the frog. Note that it is not
	 * initialized by the code we have provided.
	 */
	private VisibleImage frogImage;


	// TODO DESIGN: specify Frog instance variables
	// FROG LOCATION
	private Location frogLoc;
	// IS FROG ALIVE
	private boolean isAlive;
	// HOP DISTANCE
	private double hopDistance;
	// ?OTHERS?
	private Text message;

	/**
	 * Instantiate a Frog to start a new game
	 * <ul>
	 * <li>create the Frog visibleImage
	 * <li>determine the initial position
	 * <li>place the image in that position
	 * </ul>
	 *
	 * TODO DESIGN: identify and describe all Frog constructor parameters
	 * 
	 * @param frog
	 *            image to display the frog
	 * @param frog
	 *            starting position at the middle bottom of the screen
	 * @param lane
	 *            width kept constant for all the lanes
	 * @param canvas
	 *            for everything to be drawn on
	 * 
	 */
	public Frog( Image frog, Location loc, double laneWidth,DrawingCanvas canvas ) {
		/*
		 * The constructor does: the frog image is loaded and then initialized
		 * with the frog's starting location, the distance of the lane, and the
		 * canvas it is drawn on. isAlive should be set to true because at the
		 * start of running, the frog is alive.
		 */
		hopDistance = laneWidth;
		frogLoc = loc;
		frogImage = new VisibleImage(frog,frogLoc, FROG_WIDTH,FROG_HEIGHT,canvas);
		message = new Text( "", 350, 500, canvas);
		isAlive = true;
	}

	/**
	 * Determine whether or not the Frog overlaps (has come into contact with) a
	 * Vehicle.
	 * 
	 * @param vehicleImage
	 *            the Vehicle we should check against.
	 * 
	 * @return true if the Frog and Vehicle overlap.
	 */
	public boolean overlaps(VisibleImage vehicleImage) {
		// TODO DESIGN: missing pieces of overlaps
		// Write a paragraph of text or pseudo code describing
		// how you will implement these steps, what conditional
		// decisions you will make, and what objects, methods
		// and variables you will use to perform these operations.
		/*
		 * In order to check whether any part of the frog has come into contact
		 * with a vehicle, then the left and right x coordinate of the frog must
		 * be checked with the right and left x coordinate of the vehicle. The
		 * top and bottom of
		 */
		if(frogImage.overlaps(vehicleImage)){
			isAlive = false;
			return isAlive;
		}
		return isAlive; // FIXME - overlaps to return correct value
	}

	/**
	 * Kill the Frog. <br>
	 * Stop him from moving and display an "OUCH!" message.
	 */
	public void kill() {
			message.setText("OUCH!");
	}

	/**
	 * Bring the frog back to life.
	 * <p>
	 * <ul>
	 * <li>determine whether or not the frog is currently dead
	 * <li>bring him back to life
	 * <li>move him back to the starting place
	 * <li>clear the ouch message
	 * </ul>
	 */
	public void reincarnate() {
		// TODO DESIGN: missing pieces of reincarnate
		// Write a paragraph of text or pseudo code describing
		// how you will implement these steps, what conditional
		// decisions you will make, and what objects, methods
		// and variables you will use to perform these operations.
		/*
		 * isAlive should be checked and if it is false, then a new Frog is
		 * created only when point is outside of the playing area.
		 */
		if(!isAlive){
			frogImage.moveTo(frogLoc);
			message.hide();
			isAlive = true;
		}
	}

	/**
	 * Move the Frog one "hop" towards the specified point
	 * <P>
	 * <UL>
	 * <LI>determine point he should hop to
	 * <LI>determine whether or not that hop is legal
	 * <LI>determine whether or not that place overlaps a vehicle
	 * 
	 * @param point
	 *            location, indicating relative direction of hop.
	 */
	public void hopToward(Location point) {
		// TODO DESIGN: missing pieces of hopToward
		// Write a paragraph of text or pseudo code describing
		// how you will implement these steps, what conditional
		// decisions you will make, and what objects, methods
		// and variables you will use to perform these operations.
		/*
		 * The frog is only allowed to hope if isAlive is set to true.
		 * If the x coordinate of point is less than the x coordinate of the
		 * frog, then the frog hops left. If the x coordinate of point is more
		 * than the x coordinate of the frog plus the width of the image, then
		 * the frog jumps right. If the y coordinate of the point is less than
		 * the y coordinate of the frog, then the frog hops forward. If the y
		 * coordinate of the point is more the y coordinate of the frog plus the
		 * height then the frog hops backward
		 */
		if(point.getX() < frogImage.getX()){
			frogImage.moveTo(frogImage.getX()-hopDistance, frogImage.getY());
		}
		else if(point.getX() > frogImage.getX() + FROG_WIDTH){
			frogImage.moveTo(frogImage.getX() + hopDistance, frogImage.getY());
		}
		else if(point.getY() < frogImage.getY()){
			frogImage.moveTo(frogImage.getX(), frogImage.getY()-hopDistance);
		}
		else if(point.getY() > frogImage.getY() + FROG_HEIGHT){
			frogImage.moveTo(frogImage.getX(), frogImage.getY() + hopDistance);
		}
	}

	/**
	 * Determine whether or not the Frog is still alive.
	 * 
	 * @return true if the Frog is still alive.
	 */
	public boolean isAlive() {
		// TODO DESIGN: missing pieces of isAlive
		// Write a paragraph of text or pseudo code describing
		// how you will implement these steps, what conditional
		// decisions you will make, and what objects, methods
		// and variables you will use to perform these operations.
		/*
		 * if kill() is called on the frog, meaning the frog was hit by a car,
		 * then isAlive is set to false.
		 */
		return isAlive; // FIXME - change isAlive to return correct value
	}

}
