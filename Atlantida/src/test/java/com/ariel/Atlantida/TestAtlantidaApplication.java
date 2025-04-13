package com.ariel.Atlantida;

import org.springframework.boot.SpringApplication;

public class TestAtlantidaApplication {

	public static void main(String[] args) {
		SpringApplication.from(AtlantidaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
