package Service;

import Entity.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import Entity.Role;
import java.util.UUID;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optUser = userRepository.findByLoginOrEmail(username, username);
        return optUser.map(user -> org.springframework.security.core.userdetails.User.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .roles(user.getRole().getName()) // Assurez-vous que `Role` a un champ `name`
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur inconnu"));
    }

    public User createUser(String login, String email, Role role) {
        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        String password = generateRandomPassword();
        user.setPassword(password);
        user.setRole(role);
        encodePassword(user);
        return userRepository.save(user);
    }

    private String generateRandomPassword() {
        return UUID.randomUUID().toString();
    }

    public void encodePassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    public void registerUser(User user) {
    }
}
