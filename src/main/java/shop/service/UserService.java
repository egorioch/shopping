package shop.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import shop.model.Role;
import shop.model.User;
import shop.repo.UserRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @PersistenceContext
    private final EntityManager entityManager;

    public UserService(UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder, EntityManager entityManager) {
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.entityManager = entityManager;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public User findById(long id) {
        Optional<User> user = userRepo.findById(id);

        return user.orElse(new User());
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public boolean deleteUser(long id) {
        if (userRepo.findById(id).isPresent()) {
            userRepo.deleteById(id);
            return true;
        }

        return false;
    }

    public boolean saveUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role("ordinary")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return true;
    }

    public List<User> getIdUpperThan(Long idMin) {
        return entityManager.createQuery("SELECT u FROM Person u WHERE u.id > :paramId", User.class)
                .setParameter("paramId", idMin).getResultList();
    }

}
