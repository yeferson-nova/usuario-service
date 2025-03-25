package com.ynova.msvc.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UsuarioServiceApplication {

	@Autowired
	private Environment environment; // Para obtener el valor real del puerto

	public static void main(String[] args) {
		SpringApplication.run(UsuarioServiceApplication.class, args);
	}

	@Bean
	public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inetUtils) {
		EurekaInstanceConfigBean instance = new EurekaInstanceConfigBean(inetUtils);

		// Obtiene el valor real del puerto
		int port = Integer.parseInt(environment.getProperty("local.server.port", "0"));
		instance.setInstanceId("USUARIO-SERVICE:" + port);
		instance.setNonSecurePort(port);

		return instance;
	}

	@PostConstruct
	public void logPort() {
		int port = Integer.parseInt(environment.getProperty("local.server.port", "0"));
		System.out.println("✅ Usuario Service is running on port: " + port);
	}
}
