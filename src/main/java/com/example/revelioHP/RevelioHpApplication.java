package com.example.revelioHP;

import com.example.revelioHP.model.DadosHp;
import com.example.revelioHP.principal.Principal;
import com.example.revelioHP.service.ConsumoApi;
import com.example.revelioHP.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RevelioHpApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RevelioHpApplication.class, args);
	}

	public void run(String...args) throws Exception {
		Principal principal = new Principal();
		principal.roda();
	}
}
