/**
 *
 * Created by Josie on 9/03/2017
 *
 */

package test;

import josephine.trafficlight.DisplayColour;
import josephine.trafficlight.TrafficLight;
import josephine.trafficlight.TrafficLightController;
import org.junit.Test;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TrafficLightControllerTest {

    @Test
    public void shouldChangeDisplayColourToGreenOnGo() {
        TrafficLightController trafficLightController = new TrafficLightController();
        TrafficLight trafficLight = mock(TrafficLight.class);
        when(trafficLight.getState()).thenReturn(DisplayColour.RED);

        trafficLightController.update(singletonList(trafficLight));

        verify(trafficLight).go();
    }

    @Test
    public void shouldInitialiseTrafficLight() {

    }
}
