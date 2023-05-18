package com.ferrari.Facturacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ferrari.Facturacion.model.Client;
import com.ferrari.Facturacion.model.Invoice;
import com.ferrari.Facturacion.model.InvoiceDetail;
import com.ferrari.Facturacion.model.Product;
import com.ferrari.Facturacion.repository.ClientRepository;
import com.ferrari.Facturacion.repository.InvoiceDetailRepository;
import com.ferrari.Facturacion.repository.ProductRepository;
import com.ferrari.Facturacion.repository.InvoiceRepository;

@SpringBootApplication
public class FacturacionApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clienteRepository;

	@Autowired
	private ProductRepository productoRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private InvoiceDetailRepository invoiceDetailRepository;

	public static void main(String[] args) {
		SpringApplication.run(FacturacionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on http://localhost:8888/h2-console");

		try {

			// We add clients to the DB
			Client cliente1 = new Client();
			cliente1.setName("Charles");
			cliente1.setLastname("Leclerc");
			cliente1.setDocnumber("19971016");
			this.clienteRepository.save(cliente1);

			Client cliente2 = new Client();
			cliente2.setName("Carlos");
			cliente2.setLastname("Sainz");
			cliente2.setDocnumber("19940901");
			this.clienteRepository.save(cliente2);

			// Search clients in the DB with custom query
			List<Client> clientesObtenidos = this.clienteRepository.findByNameLike("%arl%");
			System.out.println(clientesObtenidos.size());
			printClients(clientesObtenidos);

			List<Client> clientes2 = this.clienteRepository.getByNameOrderedByLastnameJPQL("Sebas");
			System.out.println(clientes2.size());
			printClients(clientes2);

			List<Client> clientes3 = this.clienteRepository.getByNameOrderedByLastnameNativeQuery("Sebas");
			System.out.println(clientes3.size());
			printClients(clientes3);

			// Add Products to DB
			Product gorra = new Product();
			gorra.setCode("codigoGorra");
			gorra.setDescription("Tamaño M");
			gorra.setPrice(5);
			gorra.setStock(10);
			this.productoRepository.save(gorra);

			Product vasoTermico = new Product();
			vasoTermico.setCode("codigoVasoTermico");
			vasoTermico.setDescription("500ml");
			vasoTermico.setPrice(10);
			vasoTermico.setStock(15);
			this.productoRepository.save(vasoTermico);

			// Query products from DB
			Optional<Product> productoObtenido1 = this.productoRepository.findById(1);
			Optional<Product> productoObtenido2 = this.productoRepository.findById(2);

			if (productoObtenido1.isPresent())
				System.out.println(productoObtenido1.get());
			if (productoObtenido2.isPresent())
				System.out.println(productoObtenido2.get());

			// Create invoices
			Optional<Client> client1 = this.clienteRepository.findById(1);

			Invoice invoice1 = new Invoice();
			client1.ifPresent(invoice1::setClient);
			invoice1.setCreated_at("18-05");
			invoice1.setTotal(100);
			this.invoiceRepository.save(invoice1);

			Invoice invoice2 = new Invoice();
			client1.ifPresent(invoice2::setClient);
			invoice2.setCreated_at("18-05");
			invoice2.setTotal(300);
			this.invoiceRepository.save(invoice2);

			Optional<Client> client2 = this.clienteRepository.findById(2);

			Invoice invoice3 = new Invoice();
			client2.ifPresent(invoice3::setClient);
			invoice3.setCreated_at("18-05");
			invoice3.setTotal(200);
			this.invoiceRepository.save(invoice3);

			// Query invoices from specific client from DB
			client1 = this.clienteRepository.findById(1);
			client2 = this.clienteRepository.findById(2);
			System.out.println(client1.get().getInvoice());
			System.out.println(client2.get().getInvoice());

			// Create invoice details
			Optional<Product> product1 = this.productoRepository.findById(1);
			Optional<Invoice> invoiceObtenida1 = this.invoiceRepository.findById(1);
			
			InvoiceDetail invoiceDetail1 = new InvoiceDetail();
			invoiceObtenida1.ifPresent(invoiceDetail1::setInvoice);
			product1.ifPresent(invoiceDetail1::setProduct);
			invoiceDetail1.setQuantity(2);
			invoiceDetail1.setPrice(50);
			this.invoiceDetailRepository.save(invoiceDetail1);

			// Query invoice details from specific invoice from DB
			invoiceObtenida1 = this.invoiceRepository.findById(1);
			System.out.println(invoiceObtenida1.get().getInvoiceDetail());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	static void printClients(List<Client> clientsList) {
		for (Client client : clientsList) {
			System.out.println(client);
		}
	}

	static void printInvoices(List<Invoice> invoicesList) {
		for (Invoice invoice : invoicesList) {
			System.out.println(invoice);
		}
	}

}
