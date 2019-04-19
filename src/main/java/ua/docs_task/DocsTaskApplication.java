package ua.docs_task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.docs_task.utils.StaticUtils;

@SpringBootApplication
public class DocsTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(DocsTaskApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> StaticUtils.printDoc();
    }


}
