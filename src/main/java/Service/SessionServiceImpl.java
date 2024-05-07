package Service;

import Repository.MetronomeSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.MetronomeSession;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private MetronomeSessionRepository sessionRepository;

    @Override
    public void createSession(MetronomeSession session) {
        sessionRepository.save(session);
    }

}
