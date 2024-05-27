package Repository;

import Entity.TempoRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempoRecordRepository extends JpaRepository<TempoRecord, Long> {
}
