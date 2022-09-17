package sn.amir.boss.restfullwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDAOService {
    // JPA/Hibernate > Database
    // UserDaoService > Static List
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;
    static {
        users.add(new User(++usersCount, "Amir", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Nabou", LocalDate.now().minusYears(20)));
        users.add(new User(++usersCount, "Boss", LocalDate.now().minusYears(15)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findById(Integer id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream()
                .filter(predicate)
                .findFirst().orElse(null);
    }

    public User saveUser(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void deleteById(Integer id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

}
