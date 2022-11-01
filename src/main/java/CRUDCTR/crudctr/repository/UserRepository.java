package CRUDCTR.crudctr.repository;

import CRUDCTR.crudctr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
