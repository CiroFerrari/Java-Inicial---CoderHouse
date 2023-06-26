package com.ferrari.FacturacionEntrega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferrari.FacturacionEntrega.model.Client;
import com.ferrari.FacturacionEntrega.model.Invoice;
import com.ferrari.FacturacionEntrega.model.InvoiceDTO;
import com.ferrari.FacturacionEntrega.model.InvoiceDetail;
import com.ferrari.FacturacionEntrega.model.InvoiceDetailDTO;
import com.ferrari.FacturacionEntrega.model.InvoiceWithDetailsDTO;
import com.ferrari.FacturacionEntrega.model.Product;
import com.ferrari.FacturacionEntrega.model.RequestInvoice;
import com.ferrari.FacturacionEntrega.repository.InvoiceRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
  @Autowired
  private InvoiceRepository invoiceRepository;

  @Autowired
  private ProductService productService;

  @Autowired
  private InvoiceDetailService invoiceDetailService;

  @Autowired
  private ClientService clientService;

  // POST invoice with details
  public InvoiceDTO postInvoice(RequestInvoice requestInvoice) throws Exception {

    // Buscamos al cliente a través de su id
    Client clientExist = clientService.getClient(requestInvoice.getClient_id());
    if (clientExist == null) {
      throw new Exception("Client does not exist");
    }

    // Buscamos los productos
    List<Product> productList = productService.getProductsById(requestInvoice.getProduct_list());

    // Verificar que los productos existen
    if (productList.size() != requestInvoice.getProduct_list().size()) {
      throw new Exception("One or more products do not exist");
    }

    // Verificar la cantidad disponible en el stock de los productos
    for (int i = 0; i < productList.size(); i++) {
      Product product = productList.get(i);
      int requestedQuantity = requestInvoice.getProduct_list().get(i).getQuantity();
      if (requestedQuantity > product.getStock()) {
        throw new Exception("Insufficient stock for product: " + product.getTitle());
      }
    }

    // Calculo del total
    double total = 0;
    int i = 0;
    for (Product product : productList) {
      total += product.getPrice() *
          requestInvoice.getProduct_list().get(i).getQuantity();
      i++;
    }

    // Instanciamos un objeto invoice
    Invoice invoiceCreated = new Invoice();

    // Setteamos la fecha del invoice
    invoiceCreated.setCreated_at(new Date().toString());

    // Setteamos al cliente dentro del invoice
    invoiceCreated.setClient(clientExist);

    // Setteamos el total del invoice
    invoiceCreated.setTotal(total);

    // Guardamos el invoice antes de guardar el detalle
    invoiceCreated = invoiceRepository.save(invoiceCreated);

    // Settamos los invoice_details y los guardamos
    i = 0;
    for (Product productForDetail : productList) {
      InvoiceDetail newInvoiceDetail = new InvoiceDetail();
      newInvoiceDetail.setPrice(productForDetail.getPrice());
      newInvoiceDetail.setInvoice(invoiceCreated);
      newInvoiceDetail.setProduct(productForDetail);
      newInvoiceDetail.setQuantity(requestInvoice.getProduct_list().get(i).getQuantity());
      invoiceDetailService.saveInvoiceDetail(newInvoiceDetail);

      // Reducir la cantidad del producto en el stock
      productForDetail.setStock(productForDetail.getStock() - requestInvoice.getProduct_list().get(i).getQuantity());
      productService.saveProduct(productForDetail);

      i++;
    }

    // Por último retornamos el DTO
    return new InvoiceDTO(
        invoiceCreated.getId(),
        invoiceCreated.getCreated_at(),
        invoiceCreated.getTotal());
  }

  // GET invoices by client id
  public List<InvoiceDTO> getInvoicesByClientId(int clientId) throws Exception {
    System.out.println(clientId);
    return invoiceRepository.getInvoicesByClientById(clientId);
  }

  // GET invoice by id
  public InvoiceWithDetailsDTO getInvoiceById(int invoice_id) throws Exception {
    Optional<Invoice> invoiceFound = invoiceRepository.findById(invoice_id);
    if (invoiceFound.isEmpty()) {
      throw new Exception("Invoice not found");
    }

    List<InvoiceDetailDTO> invoice_details = invoiceDetailService.getInvoiceDetailsByInvoiceId(invoice_id);

    return new InvoiceWithDetailsDTO(
        invoiceFound.get().getId(),
        invoiceFound.get().getCreated_at(),
        invoiceFound.get().getTotal(),
        invoiceFound.get().getClient().getId(),
        invoice_details);
  }
}