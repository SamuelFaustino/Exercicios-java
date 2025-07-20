package dio.aulaDataJPA.repository;

import dio.aulaDataJPA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


}
