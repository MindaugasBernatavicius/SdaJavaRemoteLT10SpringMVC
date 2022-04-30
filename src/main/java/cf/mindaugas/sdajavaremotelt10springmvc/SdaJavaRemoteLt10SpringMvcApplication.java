package cf.mindaugas.sdajavaremotelt10springmvc;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SdaJavaRemoteLt10SpringMvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(SdaJavaRemoteLt10SpringMvcApplication.class, args);
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
