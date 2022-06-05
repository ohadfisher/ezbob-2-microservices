package log.controller;

import log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/log/")
public class LogController {

    private LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }


    @PostMapping("/log-service")
    public ResponseEntity<Void> logService(@RequestBody Integer[] array) {
        logService.logArray(array);
        return new ResponseEntity(HttpStatus.OK);
    }

}

