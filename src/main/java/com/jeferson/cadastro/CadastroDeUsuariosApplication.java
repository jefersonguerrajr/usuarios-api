package com.jeferson.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class CadastroDeUsuariosApplication{

	public static void main(String[] args) {
		Environment env = SpringApplication.run(CadastroDeUsuariosApplication.class, args).getEnvironment();
		String serverAddress = "http://" + env.getProperty("server.address") + ":" + env.getProperty("server.port");
		System.out.println("\n");
		System.out.println("URLs de acesso:");
		System.out.printf("\033[32mAPI\033[0m:     %s\n", serverAddress);
		System.out.printf("\033[34mSwagger\033[0m: %s\n", serverAddress + "/cadastro/swagger-ui.html");
		System.out.println("\n");
	}

}
