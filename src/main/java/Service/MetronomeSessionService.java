package Service;

import Entity.MetronomeSession;
import Repository.MetronomeSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetronomeSessionService {

    private final MetronomeSessionRepository metronomeSessionRepository;

    @Autowired
    public MetronomeSessionService(MetronomeSessionRepository metronomeSessionRepository) {
        this.metronomeSessionRepository = metronomeSessionRepository;
    }

    public MetronomeSession save(MetronomeSession metronomeSession) {
        return metronomeSessionRepository.save(metronomeSession);
    }

    public List<MetronomeSession> findByUsername(String username) {
        return metronomeSessionRepository.findByUsername(username);
    }

    public void deleteByIdAndUsername(Long id, String username) {
        MetronomeSession session = metronomeSessionRepository.findByIdAndUsername(id, username);
        if (session != null) {
            metronomeSessionRepository.delete(session);
        }
    }
}
