package com.dnabrd04.apiserver;

import com.dnabrd04.apiserver.utils.InitFirebase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        try {
            InitFirebase.initFirebase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SpringApplication.run(Application.class, args);
	}

}
