package anderson.dev.consumeravro.repositories;

import anderson.dev.consumeravro.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
