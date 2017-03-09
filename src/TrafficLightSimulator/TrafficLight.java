/**
 *
 * Created by Josephine Suwanto on 9/03/2017.
 *
 * The task of a traffic light is to display one element of DisplayColour
 * that represents it's current state
 *
 */

package TrafficLightSimulator;

public class TrafficLight {

    private TrafficLightPosition position;

    private DisplayColour state;

    public TrafficLight(TrafficLightPosition position) {
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
        System.out.println(position.toString() + " = " + state.toString());
    }

    public TrafficLightPosition getPosition() {
        return position;
    }

    public DisplayColour getState() {
        return state;
    }
}
