package edu.miu.membership;

import edu.miu.membership.modelmapper.MapStruct;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("edu.miu.membership.domain")
@SpringBootApplication

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public MapStruct getMapStruct(){
        return new MapStruct();
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(getDataSource());
//    }

}
