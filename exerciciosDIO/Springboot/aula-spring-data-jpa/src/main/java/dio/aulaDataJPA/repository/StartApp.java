package dio.aulaDataJPA.repository;

import dio.aulaDataJPA.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("Samuel");
        user.setUsername("sml");
        user.setPassword("54321");

        repository.save(user);

       for(User u : repository.findAll()) {
           System.out.println(u);
       }
    }
}
