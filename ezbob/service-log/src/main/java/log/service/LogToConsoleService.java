package log.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Primary
public class LogToConsoleService implements LogService {

    @Override
    public void logArray(Integer[] array) {
        System.out.println(Arrays.toString(array));
    }
}
