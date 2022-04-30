package com.parqueadero.uts;

import com.parqueadero.uts.models.dao.IUsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication

public class ApiParqueaderoApplication implements CommandLineRunner{
    
         @Autowired
        private BCryptPasswordEncoder passwordEncoder;

    
        public static void main(String[] args) {
                SpringApplication.run(ApiParqueaderoApplication.class, args);
        }

     @Override
        public void run(String... args) throws Exception {
                String password = "12345";

                for (int i = 0; i < 4; i++) {
                        String passwordBcrypt = passwordEncoder.encode(password);
                        System.out.println(passwordBcrypt);
                }

        }



}
