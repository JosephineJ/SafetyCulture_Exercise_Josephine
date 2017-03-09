/**
 *
 * Created by Josie on 9/03/2017
 *
 */

package TrafficLightSimulator;

import org.junit.Test;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TrafficLightControllerTest {

    @Test
    public void shouldChangeDisplayColourToGreenOnGo() {
        TrafficLightController trafficLightController = mock(TrafficLightController.class);
        TrafficLight trafficLight = mock(TrafficLight.class);

        when(trafficLight.getPosition()).thenReturn(Direction.N);
        when(trafficLight.getState()).thenReturn(DisplayColour.RED);

        trafficLightController.update(singletonList(trafficLight));

        verify(trafficLight).go();
    }

    @Test
    public void shouldChangeColour() {
        TrafficLightController trafficLightController = new TrafficLightController();
        TrafficLight trafficLight = new TrafficLight(Direction.N);

        trafficLightController.initialise(singletonList(trafficLight));

        assertEquals(trafficLight.getState(), DisplayColour.GREEN);
    }
}
