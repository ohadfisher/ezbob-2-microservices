package shuffle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.IntStream;

@Service
public class ShuffleService {

    private static final int MAX_BORDER = 1000;
    private static final int MIN_BORDER = 1;
    private static final Random random = new Random();

    private LogService logService;


    @Autowired
    public ShuffleService(LogService logService) {
        this.logService = logService;
    }


    public int[] Shuffle(Integer maxBorder) {
        int[] array;

        if (maxBorder < MIN_BORDER || maxBorder > MAX_BORDER) {
            array = new int[0];
        } else {
            //initialize array from 1 to maxBorder
            array = IntStream.rangeClosed(1, maxBorder).toArray();

            //Shuffle - O(n)
            for (int index = maxBorder - 1; index > 0; index--) {
                int randomReplaceIndex = random.nextInt(index + 1); // 0 <-> index(include);
                if (randomReplaceIndex != index) {
                    int temp = array[randomReplaceIndex];
                    array[randomReplaceIndex] = array[index];
                    array[index] = temp;
                }
            }
        }
        //Send to log service (Async)
        logService.logArray(array);
        return array;
    }


}
