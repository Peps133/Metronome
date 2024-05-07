package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Service.SoundService;

@RestController
@RequestMapping("/sound")
public class SoundController {

    @Autowired
    private SoundService soundService;

    @PostMapping("/load/{soundFilePath}")
    public void loadSound(@PathVariable String soundFilePath) {
        soundService.loadSound(soundFilePath);
    }

}