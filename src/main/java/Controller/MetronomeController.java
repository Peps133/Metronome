package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Service.MetronomeService;

@RestController
@RequestMapping("/metronome")
public class MetronomeController {

    @Autowired
    private MetronomeService metronomeService;

    @PostMapping("/start")
    public void startMetronome() {
        metronomeService.startMetronome();
    }

    @PostMapping("/stop")
    public void stopMetronome() {
        metronomeService.stopMetronome();
    }

    @PostMapping("/tempo/{newTempo}")
    public void adjustTempo(@PathVariable int newTempo) {
        metronomeService.adjustTempo(newTempo);
    }
}