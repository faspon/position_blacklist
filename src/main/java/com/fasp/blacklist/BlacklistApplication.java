package com.fasp.blacklist;

import com.fasp.blacklist.entity.BlockedPosition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = BlockedPosition.class)
public class BlacklistApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlacklistApplication.class, args);
    }

}
