package com.ferrari.Facturacion;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ferrari.Facturacion.model.Cliente;
import com.ferrari.Facturacion.model.Producto;
import com.ferrari.Facturacion.repository.ClienteRepository;
import com.ferrari.Facturacion.repository.ProductoRepository;

@SpringBootApplication
public class FacturacionApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ProductoRepository productoRepository;

	public static void main(String[] args) {
		SpringApplication.run(FacturacionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on http://localhost:8888/h2-console");

		// Agregamos un cliente a la DB
		Cliente cliente = new Cliente();
		cliente.setName("Charles");
		cliente.setLastname("Leclerc");
		cliente.setDocnumber("36006369");
		this.clienteRepository.save(cliente);

		// Consultamos un cliente de la DB
		Optional<Cliente> clienteObtenido = this.clienteRepository.findById(1);

		if (clienteObtenido.isPresent())
			System.out.println(clienteObtenido.get());

		// Agregamos un producto a la DB
		Producto gorra = new Producto();
		gorra.setCode("codigoGorra");
		gorra.setDescription("Tamaño M");
		gorra.setPrice(5);
		gorra.setStock(10);
		this.productoRepository.save(gorra);

		// Consultamos un producto de la DB
		Optional<Producto> productoObtenido = this.productoRepository.findById(1);

		if (productoObtenido.isPresent())
			System.out.println(productoObtenido.get());
	}

}
