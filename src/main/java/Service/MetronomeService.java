package Service;

import org.springframework.stereotype.Service;

@Service
public class MetronomeService {

    private boolean running;
    private int tempo;

    public void startMetronome() {
        running = true;

    }

    public void stopMetronome() {
        running = false;
    }

    public void adjustTempo(int newTempo) {
        tempo = newTempo;
    }

}
