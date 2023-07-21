package lt.monikos.bookeeplibrary.repository;

import lt.monikos.bookeeplibrary.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
