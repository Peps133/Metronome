package Repository;

import Entity.MetronomeSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetronomeSessionRepository extends JpaRepository<MetronomeSession, Long> {
    List<MetronomeSession> findByUsername(String username);
    MetronomeSession findByIdAndUsername(Long id, String username);
}

