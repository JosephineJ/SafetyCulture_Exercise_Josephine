/**
 *
 * Created by Josephine Suwanto on 9/03/2017.
 *
 */

package TrafficLightSimulator;

import java.util.ArrayList;
import java.util.List;

public class TrafficSimulator {

    public static void main(String[] args) {
        List<TrafficLight> trafficLights = new ArrayList<>();

        // Create traffic lights in each direction.
        // Can update to a factory pattern if creation logic gets more complex
        for (Direction position : Direction.values()) {
            trafficLights.add(new TrafficLight(position));
        }

        TrafficLightController trafficLightController = new TrafficLightController();

        trafficLightController.initialise(trafficLights);
        trafficLightController.update(trafficLights);

    }
}
