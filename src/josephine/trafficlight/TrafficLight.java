/**
 *
 * Created by Josephine Suwanto on 9/03/2017.
 *
 * The task of a traffic light is to display one element of DisplayColour
 * that represents it's current state
 *
 */

package josephine.trafficlight;

public class TrafficLight {

    private Direction position;

    private DisplayColour state;

    public TrafficLight(Direction position) {
        this.position = position;
    }

    public void go() {
        updateTrafficLight(DisplayColour.GREEN);
    }

    public void slowdown() {
        updateTrafficLight(DisplayColour.YELLOW);
    }

    public void stop() {
        updateTrafficLight(DisplayColour.RED);
    }

    private void updateTrafficLight(DisplayColour colour) {
        this.state = colour;
    }

    public Direction getPosition() {
        return position;
    }

    public DisplayColour getState() {
        return state;
    }

    public void printTrafficLight() {
        System.out.println(position.toString() + " = " + state.toString());
    }
}
