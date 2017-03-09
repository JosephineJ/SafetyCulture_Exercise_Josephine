/**
 *
 * Created by Josephine Suwanto on 9/03/2017.
 *
 * Controller task is to manage the state of traffic light
 * given by the Intersection, so that the traffic can run
 * smoothly.
 *
 */

package TrafficLightSimulator;

import com.oracle.tools.packager.Log;
import java.util.List;

public class TrafficLightController {

    private List<TrafficLight> trafficLights;

    // 1 cycle period (i.e: go -> stop or stop -> go) is 5 minutes
    private static final int DISPLAY_MILLIS = 300; // 5 minutes
    private static final int DISPLAY_SLOWDOWN_MILLIS = 30;
    private static final int TOTAL_TIME = 60000; // 30 minutes

    public TrafficLightController(List<TrafficLight> trafficLights) {
        this.trafficLights = trafficLights;
    }

    public void update() {
        try {
            initialize();
            int totalCount = 0;
            while(totalCount < TOTAL_TIME) {
                for(int count = DISPLAY_MILLIS; count >= 0; count--) {
                    Thread.sleep(1000);
                    System.out.print("-");
                    if(count == DISPLAY_SLOWDOWN_MILLIS) {
                        updateGreenTrafficLights();
                    } else if(count == 0) {
                        updateTrafficLights();
                    }
                }
                totalCount += DISPLAY_MILLIS;
            }
        } catch(InterruptedException e) {
            Log.info("exception occurs");
        }
    }

    private void updateTrafficLights() {
        System.out.println();
        for(TrafficLight trafficLight : trafficLights) {
            switch(trafficLight.getState()) {
                case RED:
                    trafficLight.go();
                    break;
                case YELLOW:
                    trafficLight.stop();
                    break;
            }
        }
    }

    private void updateGreenTrafficLights() {
        System.out.println();
        for(TrafficLight trafficLight : trafficLights) {
            switch(trafficLight.getState()) {
                case GREEN:
                    trafficLight.slowdown();
                    break;
                default:
                    System.out.println(trafficLight.getPosition().toString() + " = " +
                            trafficLight.getState().toString());
                    break;
            }
        }
    }

    private void initialize() {
        trafficLights.forEach(trafficLight -> {
            if(trafficLight.getPosition().equals(TrafficLightPosition.N) ||
                    trafficLight.getPosition().equals(TrafficLightPosition.S)) {
                trafficLight.go();
            } else if(trafficLight.getPosition().equals(TrafficLightPosition.E) ||
                    trafficLight.getPosition().equals(TrafficLightPosition.W)) {
                trafficLight.stop();
            }
        });
    }

}
