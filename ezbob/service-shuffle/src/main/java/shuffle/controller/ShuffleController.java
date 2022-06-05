package shuffle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shuffle.service.ShuffleService;


@RestController
@RequestMapping("/shuffle/")
public class ShuffleController {

    private ShuffleService shuffleServices;


    @Autowired
    public ShuffleController(ShuffleService shuffleServices) {
        this.shuffleServices = shuffleServices;
    }


    @PostMapping("/border-limit")
    public ResponseEntity<int[]> ShuffleBorder(@RequestBody Integer maxBorder) {
        return new ResponseEntity<>(shuffleServices.Shuffle(maxBorder), HttpStatus.OK);
    }

}
