package uz.bakhromjon.digitalocean.user;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author : Bakhromjon Khasanboyev
 * @username: @xbakhromjon
 * @since : 17/10/22, Mon, 19:40
 **/
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Cacheable(value = "users", key = "#userId",  unless = "#result.followers < 12000")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Users getUser(@PathVariable String userId) {
        LOG.info("Getting user with ID {}.", userId);
        Optional<Users> optional =
                userRepository.findById(Long.valueOf(userId));
        return optional.orElseThrow(() -> {
            throw new IllegalStateException("User not found");
        });
    }

    @CachePut(value = "users", key = "#user.id")
    @PutMapping("/update")
    public Users updatePersonByID(@RequestBody Users user) {
        return userRepository.save(user);
    }

    @CacheEvict(value = "users", allEntries=true)
    @DeleteMapping("/{id}")
    public void deleteUserByID(@PathVariable Long id) {
        LOG.info("deleting person with id {}", id);
        userRepository.deleteById(id);
    }


}
