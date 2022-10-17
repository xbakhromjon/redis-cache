package uz.bakhromjon.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Bakhromjon Khasanboyev
 * @username: @xbakhromjon
 * @since : 17/10/22, Mon, 19:38
 **/
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
