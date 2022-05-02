package anderson.dev.produceravro.repositories;

import anderson.dev.produceravro.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
