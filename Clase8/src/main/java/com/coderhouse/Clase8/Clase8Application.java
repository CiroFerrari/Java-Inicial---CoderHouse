package com.coderhouse.Clase8;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.Clase8.model.Product;
import com.coderhouse.Clase8.repository.ProductRepository;

@SpringBootApplication
public class Clase8Application implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(Clase8Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on http://localhost:8888/h2-console");
		// Product taza = new Product();
		// taza.setCode("codigoTaza");
		// taza.setDescription("400ml");
		// taza.setPrice(10);
		// taza.setStock(100);
		// this.productRepository.save(taza);
		Optional<Product> productoObtenido = this.productRepository.findById(1);

		if(productoObtenido.isPresent()) System.out.println(productoObtenido.get());

	}

}
