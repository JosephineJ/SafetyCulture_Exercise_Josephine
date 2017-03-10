/**
 *
 * Created by Josephine Suwanto on 9/03/2017
 *
 */

package josephine.trafficlight;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.*;

public class TrafficLightControllerTest {

    // total number of cycle within 30 minutes
    private static final int TOTAL_CYCLE = 6;

    private TrafficLightController trafficLightController = spy(new TrafficLightController());

    @Before
    public void setup() {
        Mockito.doNothing().when(trafficLightController).waitForOneSecond();
    }

    @Test
    public void shouldInitialiseTrafficLightsGivenByTrafficSimulator() {
        TrafficLight trafficLight1 = mock(TrafficLight.class);
        when(trafficLight1.getPosition()).thenReturn(Direction.N);
        TrafficLight trafficLight2 = mock(TrafficLight.class);
        when(trafficLight2.getPosition()).thenReturn(Direction.S);
        List<TrafficLight> trafficLights = Arrays.asList(trafficLight1, trafficLight2);

        trafficLightController.initialise(trafficLights);

        verify(trafficLight1).go();
        verify(trafficLight2).go();
    }

    @Test
    public void shouldChangeToGoIfCurrentDisplayColourIsRed() {
        TrafficLight trafficLight = mock(TrafficLight.class);
        when(trafficLight.getState()).thenReturn(DisplayColour.RED);

        trafficLightController.update(singletonList(trafficLight));

        verify(trafficLight, times(TOTAL_CYCLE)).go();
    }

    @Test
    public void shouldChangeToSlowDownIfCurrentDisplayColourIsGreen() {
        TrafficLight trafficLight = mock(TrafficLight.class);
        when(trafficLight.getState()).thenReturn(DisplayColour.GREEN);

        trafficLightController.update(singletonList(trafficLight));

        verify(trafficLight, times(TOTAL_CYCLE)).slowdown();
    }

    @Test
    public void shouldChangeToStopIfCurrentDisplayColourIsYellow() {
        TrafficLight trafficLight = mock(TrafficLight.class);
        when(trafficLight.getState()).thenReturn(DisplayColour.YELLOW);

        trafficLightController.update(singletonList(trafficLight));

        verify(trafficLight, times(TOTAL_CYCLE)).stop();
    }

    @Test
    public void shouldNotChangeToStopIfCurrentDisplayColourIsRed() {
        TrafficLight trafficLight = mock(TrafficLight.class);
        when(trafficLight.getState()).thenReturn(DisplayColour.RED);

        trafficLightController.update(singletonList(trafficLight));

        verify(trafficLight, times(0)).stop();
    }
}
