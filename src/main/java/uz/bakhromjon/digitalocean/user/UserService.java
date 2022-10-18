package uz.bakhromjon.digitalocean.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : Bakhromjon Khasanboyev
 * @username: @xbakhromjon
 * @since : 17/10/22, Mon, 19:41
 **/
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


}
