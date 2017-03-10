/**
 *
 * Created by Josephine Suwanto on 9/03/2017
 *
 */

package josephine.trafficlight;

import josephine.trafficlight.DisplayColour;
import josephine.trafficlight.TrafficLight;
import josephine.trafficlight.TrafficLightController;
import org.junit.Test;
import org.mockito.Mockito;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.spy;

public class TrafficLightControllerTest {

    @Test
    public void shouldChangeDisplayColourToGreenOnGo() {
        TrafficLightController trafficLightController = spy(new TrafficLightController());
        Mockito.doNothing().when(trafficLightController)
        TrafficLight trafficLight = mock(TrafficLight.class);
        when(trafficLight.getState()).thenReturn(DisplayColour.RED);

        trafficLightController.update(singletonList(trafficLight));

        verify(trafficLight).go();
    }

    @Test
    public void shouldInitialiseTrafficLight() {

    }
}
