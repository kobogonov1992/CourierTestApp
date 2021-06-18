package megacom.kg.test.Config;

import megacom.kg.test.model.Courier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {

    @Bean
    public List<Courier> getCouriers(){
        return new ArrayList<>();
    }
}
