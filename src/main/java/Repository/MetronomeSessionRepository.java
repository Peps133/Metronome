package Repository;

import Entity.MetronomeSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetronomeSessionRepository extends JpaRepository<MetronomeSession, Long> {
}
