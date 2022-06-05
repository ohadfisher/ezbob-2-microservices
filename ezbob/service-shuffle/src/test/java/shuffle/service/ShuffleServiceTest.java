package shuffle.service;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;


@ExtendWith(MockitoExtension.class)
class ShuffleServiceTest {

    @Mock
    private LogService logService;

    @InjectMocks
    private ShuffleService shuffleService;

    private static Set convertIntArrayToSet(int[] intArrayInput) {
        return IntStream.of(intArrayInput).boxed().collect(Collectors.toSet());
    }


    @Test
    public void testShuffleInput0EmptyArray() throws InterruptedException {
        int amount = 0;
        doNothing().when(logService).logArray(any(int[].class));
        Assert.assertEquals(shuffleService.Shuffle(amount).length, 0);
    }

    @Test
    public void testShuffleInput1001EmptyArray() throws InterruptedException {
        int amount = 1001;
        doNothing().when(logService).logArray(any(int[].class));
        Assert.assertEquals(shuffleService.Shuffle(amount).length, 0);
    }

    @Test
    public void testShuffleInput1() throws InterruptedException {
        int amount = 1;
        doNothing().when(logService).logArray(any(int[].class));
        Set setChecking = convertIntArrayToSet(shuffleService.Shuffle(amount));

        Assertions.assertEquals(setChecking.size(), amount);
        Assertions.assertEquals(Collections.max(setChecking), amount);
        Assertions.assertEquals(Collections.min(setChecking), 1);
    }

    @Test
    public void testShuffleInput3() throws InterruptedException {
        int amount = 3;
        doNothing().when(logService).logArray(any(int[].class));
        Set setChecking = convertIntArrayToSet(shuffleService.Shuffle(amount));

        Assertions.assertEquals(setChecking.size(), amount);
        Assertions.assertEquals(Collections.max(setChecking), amount);
        Assertions.assertEquals(Collections.min(setChecking), 1);
    }

    @Test
    public void testShuffleInput1000() throws InterruptedException {
        int amount = 1000;
        doNothing().when(logService).logArray(any(int[].class));
        Set setChecking = convertIntArrayToSet(shuffleService.Shuffle(amount));

        Assertions.assertEquals(setChecking.size(), amount);
        Assertions.assertEquals(Collections.max(setChecking), amount);
        Assertions.assertEquals(Collections.min(setChecking), 1);
    }

}