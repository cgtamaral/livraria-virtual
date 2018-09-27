package br.pucminas.livrariavirtual.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.livrariavirtual.api.Response;
import br.pucminas.livrariavirtual.api.dtos.AddressDTO;
import br.pucminas.livrariavirtual.api.dtos.CustomerDTO;
import br.pucminas.livrariavirtual.api.dtos.OrderDTO;
import br.pucminas.livrariavirtual.api.dtos.PaymentOptionDTO;
import br.pucminas.livrariavirtual.api.dtos.ShoppingCartDTO;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v1/public")
@CrossOrigin(origins = "*")
@Api(value = "Customers", description = "Recurso para gerenciamento de clientes")
public class CustomerController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@GetMapping(value ="/Customers")
	public ResponseEntity<Response<List<CustomerDTO>>> findAllCustomers()
	{
		log.info("Buscando todos os clientes existentes na base de dados!");
		Response<List<CustomerDTO>> response = new Response<List<CustomerDTO>>();
		
		List<CustomerDTO> retornoFakeNull = new ArrayList<CustomerDTO>();
		retornoFakeNull.add(new CustomerDTO());
		response.setData(retornoFakeNull);

		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value ="/Customers/{customerId}")
	public ResponseEntity<Response<CustomerDTO>> findCustomerById(@PathVariable("customerId") Long customerId)
	{
		log.info("Buscando o cliente: {}" + customerId);
		Response<CustomerDTO> response = new Response<CustomerDTO>();

		response.setData(new CustomerDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value ="/Customers/{customerId}/addresses")
	public ResponseEntity<Response<List<AddressDTO>>> findAllAdressesForCustomer(@PathVariable("customerId") Long customerId)
	{
		log.info("Buscando endereços para o cliente: {}"+customerId);
		Response<List<AddressDTO>> response = new Response<List<AddressDTO>>();
		
		List<AddressDTO> retornoFakeNull = new ArrayList<AddressDTO>();
		retornoFakeNull.add(new AddressDTO());
		response.setData(retornoFakeNull);

		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value ="/Customers/{customerId}/addresses/{addressId}")
	public ResponseEntity<Response<AddressDTO>> findAddressById(@PathVariable("customerId") Long customerId, @PathVariable("addressId") Long addressId)
	{
		log.info("Buscando o endereço "+addressId+" para o cliente " + customerId);
		Response<AddressDTO> response = new Response<AddressDTO>();

		response.setData(new AddressDTO());
		
		return ResponseEntity.ok().body(response);
	}
	

	@GetMapping(value ="/Customers/{customerId}/paymentOptions")
	public ResponseEntity<Response<List<PaymentOptionDTO>>> findAllPaymentOptionsForCustomer(@PathVariable("customerId") Long customerId)
	{
		log.info("Buscando opções de pagamento do cliente: {}"+customerId);
		Response<List<PaymentOptionDTO>> response = new Response<List<PaymentOptionDTO>>();
		
		List<PaymentOptionDTO> retornoFakeNull = new ArrayList<PaymentOptionDTO>();
		retornoFakeNull.add(new PaymentOptionDTO());
		response.setData(retornoFakeNull);

		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value ="/Customers/{customerId}/paymentOptions/{paymentOptionId}")
	public ResponseEntity<Response<PaymentOptionDTO>> findPaymentOptionById(@PathVariable("customerId") Long customerId, @PathVariable("paymentOptionId") Long paymentOptionId)
	{
		log.info("Buscando a opção de pagamento "+paymentOptionId+" para o cliente " + customerId);
		Response<PaymentOptionDTO> response = new Response<PaymentOptionDTO>();

		response.setData(new PaymentOptionDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value ="/Customers/{customerId}/orders")
	public ResponseEntity<Response<List<OrderDTO>>> findAllOrderByCustomer(@PathVariable("customerId") Long customerId)
	{
		log.info("Buscando pedidos do cliente: {}"+customerId);
		Response<List<OrderDTO>> response = new Response<List<OrderDTO>>();
		
		List<OrderDTO> retornoFakeNull = new ArrayList<OrderDTO>();
		retornoFakeNull.add(new OrderDTO());
		response.setData(retornoFakeNull);

		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value ="/Customers/{customerId}/shoppingCarts")
	public ResponseEntity<Response<ShoppingCartDTO>> findActiveShoppingCartByCustomer(@PathVariable("customerId") Long customerId)
	{
		log.info("Buscando informações carrinho de compras do cliente: {}"+customerId);
		Response<ShoppingCartDTO> response = new Response<ShoppingCartDTO>();
		
		response.setData(new ShoppingCartDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping(value ="/Customers")
	public ResponseEntity<Response<CustomerDTO>> insertCustomer(@Valid @RequestBody CustomerDTO customerDTO,  BindingResult result)
	{
		log.info("Incluindo novo cliente!");
		Response<CustomerDTO> response = new Response<CustomerDTO>();

		response.setData(new CustomerDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping(value ="/Customers/{customerId}")
	public ResponseEntity<Response<CustomerDTO>> updateCustomer(@Valid @RequestBody AddressDTO addressDTO, @PathVariable("customerId") Long customerId,  BindingResult result)
	{
		log.info("Atualizando o cliente:{}"+customerId);
		Response<CustomerDTO> response = new Response<CustomerDTO>();

		response.setData(new CustomerDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	
	@DeleteMapping(value = "/Customers/{customerId}")
	public ResponseEntity<Response<String>> deleteCustomer(@PathVariable("customerId") Long customerId)
	{
		log.info("Removendo o cliente: {}" + customerId);
		Response<String> response = new Response<String>();
		
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping(value ="/Customers/{customerId}/addresses")
	public ResponseEntity<Response<AddressDTO>> insertAddressForCustomer(@Valid @RequestBody AddressDTO addressDTO, @PathVariable("customerId") Long customerId,  BindingResult result)
	{
		log.info("Incluindo novo endereço para o cliente:{}" +customerId);
		Response<AddressDTO> response = new Response<AddressDTO>();

		response.setData(new AddressDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping(value ="/Customers/{customerId}/addresses/{addressId}")
	public ResponseEntity<Response<AddressDTO>> updateAddressForCustomer(@Valid @RequestBody AddressDTO addressDTO, @PathVariable("customerId") Long customerId,
			 @PathVariable("addressId") Long addressId, BindingResult result)
	{
		log.info("Atualizando o endereço "+addressId + " para o cliente:{}" +customerId);
		Response<AddressDTO> response = new Response<AddressDTO>();

		response.setData(new AddressDTO());
		
		return ResponseEntity.ok().body(response);
	}

	@DeleteMapping(value ="/Customers/{customerId}/addresses/{addressId}")
	public ResponseEntity<Response<String>> deleteAddresForCustomer(@PathVariable("customerId") Long customerId, @PathVariable("addressId") Long addressId)
	{
		log.info("Removendo o enderço "+addressId+" para o cliente: {}" + customerId);
		Response<String> response = new Response<String>();
		
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping(value ="/Customers/{customerId}/paymentOptions")
	public ResponseEntity<Response<PaymentOptionDTO>> insertPaymentOptionForCustomer(@PathVariable("customerId") Long customerId,
			@Valid @RequestBody PaymentOptionDTO paymentOptionDTO,  BindingResult result)
	{
		log.info("Incluindo nova opção de pagamento para o cliente: {}" + customerId);
		Response<PaymentOptionDTO> response = new Response<PaymentOptionDTO>();

		response.setData(new PaymentOptionDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping(value ="/Customers/{customerId}/paymentOptions/{paymentOptionId}")
	public ResponseEntity<Response<PaymentOptionDTO>> updatePaymentOptionForCustomer(@PathVariable("customerId") Long customerId, @PathVariable("paymentOptionId") Long paymentOptionId,
			@Valid @RequestBody PaymentOptionDTO paymentOptionDTO,  BindingResult result)
	{
		log.info("Atualizando a opção de pagamento"+paymentOptionId+ "para o cliente: {}" + customerId);
		Response<PaymentOptionDTO> response = new Response<PaymentOptionDTO>();

		response.setData(new PaymentOptionDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping(value ="/Customers/{customerId}/paymentOptions/{paymentOptionId}")
	public ResponseEntity<Response<String>> deletePaymentOptionForCustomer(@PathVariable("customerId") Long customerId, @PathVariable("paymentOptionId") Long paymentOptionId)
	{
		log.info("Removendo a opção de pagamento "+paymentOptionId+" para o cliente: {}" + customerId);
		Response<String> response = new Response<String>();
		
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping(value ="/Customers/{customerId}/shoppingCarts")
	public ResponseEntity<Response<ShoppingCartDTO>> insertShoppingCartForCustomer(@PathVariable("customerId") Long customerId,
			@Valid @RequestBody ShoppingCartDTO shoppingCartDTO,  BindingResult result)
	{
		log.info("Incluindo carrinho de compras para o cliente: {}" + customerId);
		Response<ShoppingCartDTO> response = new Response<ShoppingCartDTO>();

		response.setData(new ShoppingCartDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping(value ="/Customers/{customerId}/shoppingCarts/{shoppingCartId}")
	public ResponseEntity<Response<ShoppingCartDTO>> updateShoppingCartForCustomer(@PathVariable("customerId") Long customerId,@PathVariable("shoppingCartId") Long shoppingCartId,
			@Valid @RequestBody ShoppingCartDTO shoppingCartDTO,  BindingResult result)
	{
		log.info("Atualizando o carrinho de compras "+shoppingCartId+" para o cliente: {}" + customerId);
		Response<ShoppingCartDTO> response = new Response<ShoppingCartDTO>();

		response.setData(new ShoppingCartDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping(value ="/Customers/{customerId}/shoppingCarts/{shoppingCartId}")
	public ResponseEntity<Response<String>> deleteShoppingCartForCustomer(@PathVariable("customerId") Long customerId, @PathVariable("shoppingCartId") Long shoppingCartId)
	{
		log.info("Removendo carrinho de compras  "+shoppingCartId+" para o cliente: {}" + customerId);
		Response<String> response = new Response<String>();
		
		return ResponseEntity.ok().body(response);
	}
}
