/**
 *
 * Created by Josephine Suwanto on 9/03/2017.
 *
 */

package TrafficLightSimulator;

import java.util.ArrayList;
import java.util.List;

public class Intersection {

    private static TrafficLightController trafficLightController;

    public static void main(String[] args) {
        List<TrafficLight> trafficLights = new ArrayList<>();

        for (TrafficLightPosition position : TrafficLightPosition.values()) {
            trafficLights.add(new TrafficLight(position));
        }

        trafficLightController = new TrafficLightController(trafficLights);

        trafficLightController.update();
    }
}
