package dio.springboot.iocdi_beans_autowired;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    @Bean
    public Gson gson(){
        return new Gson();
    }
}
