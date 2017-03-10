/**
 *
 * Created by Josephine Suwanto on 9/03/2017.
 *
 * Controller task is to manage the state of traffic light
 * given by the TrafficSimulator, so that the traffic can run
 * smoothly.
 *
 */

// do gradle file
package josephine.trafficlight;

import java.util.List;

public class TrafficLightController {

    // 1 cycle period (i.e: go -> stop or stop -> go) is 5 minutes
    private static final int DISPLAY_SEC = 300; // 5 minutes
    private static final int DISPLAY_SLOWDOWN_SEC = 270;
    private static final int TOTAL_TIME_SEC = 1800; // 30 minutes
    private static final int POLLING_INTERVAL_MILLIS = 1000;

    public TrafficLightController() {

    }

    // arbitrary assigning North and South as go, and East and West as stop.
    public void initialise(List<TrafficLight> trafficLights) {
        trafficLights.forEach(trafficLight -> {
            switch(trafficLight.getPosition()) {
                case N:
                case S:
                    trafficLight.go();
                    break;
                case E:
                case W:
                    trafficLight.stop();
                    break;
            }
            trafficLight.printTrafficLight();
        });
    }

    public void update(List<TrafficLight> trafficLights) {
        for(int totalCount = 0; totalCount < TOTAL_TIME_SEC; totalCount += DISPLAY_SEC) {
            for(int count = 0; count <= DISPLAY_SEC; count++) {
                waitForOneSecond();
                System.out.print("-");

                if(count == DISPLAY_SLOWDOWN_SEC) {
                    printTime(totalCount + count);
                    for(TrafficLight trafficLight : trafficLights) {
                        switch(trafficLight.getState()) {
                            case GREEN:
                                trafficLight.slowdown();
                                break;
                        }
                        trafficLight.printTrafficLight();
                    }
                } else if(count == DISPLAY_SEC) {
                    printTime(totalCount + count);
                    for(TrafficLight trafficLight : trafficLights) {
                        switch(trafficLight.getState()) {
                            case RED:
                                trafficLight.go();
                                break;
                            case YELLOW:
                                trafficLight.stop();
                                break;
                        }
                        trafficLight.printTrafficLight();
                    }
                }
            }
        }
    }

    protected void waitForOneSecond() {
        try {
            Thread.sleep(POLLING_INTERVAL_MILLIS);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printTime(int time) {
        System.out.println();
        System.out.println("Time elapsed: " + time + "s");
        System.out.println("Changing the state");
    }

}
