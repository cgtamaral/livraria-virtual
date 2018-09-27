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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/public")
@CrossOrigin(origins = "*")
@Api(value = "customers", description = "Recurso para gerenciamento de clientes", tags={ "customers"})
public class CustomerController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@ApiOperation(value = "Recupera todos os clientes", nickname = "findAllCustomers", notes = "", tags={ "customers"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		   	@ApiResponse(code = 404, message = "Nenhum cliente foi encontrado na base de dados!") })
	@GetMapping(value ="/Customers", produces = "application/json")
	public ResponseEntity<Response<List<CustomerDTO>>> findAllCustomers()
	{
		log.info("Buscando todos os clientes existentes na base de dados!");
		Response<List<CustomerDTO>> response = new Response<List<CustomerDTO>>();
		
		List<CustomerDTO> retornoFakeNull = new ArrayList<CustomerDTO>();
		retornoFakeNull.add(new CustomerDTO());
		response.setData(retornoFakeNull);

		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Recupera um cliente especifico", nickname = "findCustomerById", notes = "", tags={ "customers"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 400, message = "O request informado é inválido!"),
			@ApiResponse(code = 404, message = "Nenhum cliente foi encontrado para o id informado!")})
	@GetMapping(value ="/Customers/{customerId}", produces = "application/json")
	public ResponseEntity<Response<CustomerDTO>> findCustomerById(@ApiParam(value = "Identificador do cliente a ser consultado", required = true) @PathVariable("customerId") Long customerId)
	{
		log.info("Buscando o cliente: {}" + customerId);
		Response<CustomerDTO> response = new Response<CustomerDTO>();

		response.setData(new CustomerDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Recupera todos os endereços de entrega cadastrados para um cliente especifico", nickname = "findAllAdressesForCustomer", notes = "", tags={ "customers"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 400, message = "O request informado é inválido!"),
			@ApiResponse(code = 404, message = "Nenhum registro foi encontrado para requisição!")})
	@GetMapping(value ="/Customers/{customerId}/addresses", produces = "application/json")
	public ResponseEntity<Response<List<AddressDTO>>> findAllAdressesForCustomer(@ApiParam(value = "Identificador do cliente a ter os endereços consultados", required = true) @PathVariable("customerId") Long customerId)
	{
		log.info("Buscando endereços para o cliente: {}"+customerId);
		Response<List<AddressDTO>> response = new Response<List<AddressDTO>>();
		
		List<AddressDTO> retornoFakeNull = new ArrayList<AddressDTO>();
		retornoFakeNull.add(new AddressDTO());
		response.setData(retornoFakeNull);

		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Recupera um determinado endereço para um cliente especifico", nickname = "findAddressById", notes = "", tags={ "customers"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 400, message = "O request informado é inválido!"),
			@ApiResponse(code = 404, message = "Nenhum registro foi encontrado para requisição!")})
	@GetMapping(value ="/Customers/{customerId}/addresses/{addressId}", produces = "application/json")
	public ResponseEntity<Response<AddressDTO>> findAddressById(@ApiParam(value = "Identificador do cliente a ter o endereço consultado", required = true) @PathVariable("customerId") Long customerId, 
			@ApiParam(value = "Identificador do endereço a ser consultado", required = true) @PathVariable("addressId") Long addressId)
	{
		log.info("Buscando o endereço "+addressId+" para o cliente " + customerId);
		Response<AddressDTO> response = new Response<AddressDTO>();

		response.setData(new AddressDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Recupera todos as formas de pagamento cadastradas para um cliente especifico", nickname = "findAllPaymentOptionsForCustomer", notes = "", tags={ "customers"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 400, message = "O request informado é inválido!"),
			@ApiResponse(code = 404, message = "Nenhum registro foi encontrado para requisição!")})
	@GetMapping(value ="/Customers/{customerId}/paymentOptions", produces = "application/json")
	public ResponseEntity<Response<List<PaymentOptionDTO>>> findAllPaymentOptionsForCustomer(@ApiParam(value = "Identificador do cliente a ter as opções de pagamento consultadas", required = true) @PathVariable("customerId") Long customerId)
	{
		log.info("Buscando opções de pagamento do cliente: {}"+customerId);
		Response<List<PaymentOptionDTO>> response = new Response<List<PaymentOptionDTO>>();
		
		List<PaymentOptionDTO> retornoFakeNull = new ArrayList<PaymentOptionDTO>();
		retornoFakeNull.add(new PaymentOptionDTO());
		response.setData(retornoFakeNull);

		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Recupera uma forma especifica de pagamento cadastrada para um cliente especifico", nickname = "findPaymentOptionById", notes = "", tags={ "customers"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 400, message = "O request informado é inválido!"),
			@ApiResponse(code = 404, message = "Nenhum registro foi encontrado para requisição!")})
	@GetMapping(value ="/Customers/{customerId}/paymentOptions/{paymentOptionId}", produces = "application/json")
	public ResponseEntity<Response<PaymentOptionDTO>> findPaymentOptionById(@ApiParam(value = "Identificador do cliente a ter a opção de pagamento consultada", required = true) @PathVariable("customerId") Long customerId, 
			@ApiParam(value = "Identificador da opção de pagamento a ser consultada", required = true) @PathVariable("paymentOptionId") Long paymentOptionId)
	{
		log.info("Buscando a opção de pagamento "+paymentOptionId+" para o cliente " + customerId);
		Response<PaymentOptionDTO> response = new Response<PaymentOptionDTO>();

		response.setData(new PaymentOptionDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Recupera todos os pedidos existentes para um cliente especifico", nickname = "findAllOrderByCustomer", notes = "", tags={ "customers"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 400, message = "O request informado é inválido!"),
			@ApiResponse(code = 404, message = "Nenhum registro foi encontrado para requisição!")})
	@GetMapping(value ="/Customers/{customerId}/orders", produces = "application/json")
	public ResponseEntity<Response<List<OrderDTO>>> findAllOrderByCustomer(@ApiParam(value = "Identificador do cliente a ter os pedidos consultados", required = true) @PathVariable("customerId") Long customerId)
	{
		log.info("Buscando pedidos do cliente: {}"+customerId);
		Response<List<OrderDTO>> response = new Response<List<OrderDTO>>();
		
		List<OrderDTO> retornoFakeNull = new ArrayList<OrderDTO>();
		retornoFakeNull.add(new OrderDTO());
		response.setData(retornoFakeNull);

		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Recupera as informações do carrinho de compras para um cliente especifico", nickname = "findActiveShoppingCartByCustomer", notes = "", tags={ "customers"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 400, message = "O request informado é inválido!"),
			@ApiResponse(code = 404, message = "Nenhum cliente ou carrinho de compras foi encontrado para requisição!")})
	@GetMapping(value ="/Customers/{customerId}/shoppingCarts", produces = "application/json")
	public ResponseEntity<Response<ShoppingCartDTO>> findActiveShoppingCartByCustomer(@ApiParam(value = "Identificador do cliente a ter o carrinho de compras consultado", required = true) @PathVariable("customerId") Long customerId)
	{
		log.info("Buscando informações carrinho de compras do cliente: {}"+customerId);
		Response<ShoppingCartDTO> response = new Response<ShoppingCartDTO>();
		
		response.setData(new ShoppingCartDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Insere um novo cliente", nickname = "insertCustomer", notes = "", tags={ "customers"})
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Operação bem sucessida e um novo cliente foi incluido na base de dados"),
		    @ApiResponse(code = 400, message = "O objeto de request possui informações inválidas para a inclusão do cliente!"),
		    @ApiResponse(code = 404, message = "Nenhum usuário encontrado para requisição!")})
	@PostMapping(value ="/Customers", produces = "application/json")
	public ResponseEntity<Response<CustomerDTO>> insertCustomer(@ApiParam(value = "Objeto do cliente que precisa ser incluido na base de dados", required = true) @Valid @RequestBody CustomerDTO customerDTO,  BindingResult result)
	{
		log.info("Incluindo novo cliente!");
		Response<CustomerDTO> response = new Response<CustomerDTO>();

		response.setData(new CustomerDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Atualiza as informações de um cliente especifico", nickname = "updateCustomer", notes = "", tags={ "customers"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e o cliente foi atualizado na base de dados"),
		    @ApiResponse(code = 400, message = "O objeto de request possui informações inválidas para a atualização do cliente!"),
		    @ApiResponse(code = 404, message = "Algum objeto do request não encontrado para requisição de atualização!")})
	@PutMapping(value ="/Customers/{customerId}", produces = "application/json")
	public ResponseEntity<Response<CustomerDTO>> updateCustomer(@ApiParam(value = "Objeto de cliente que precisa ser atualizado na base de dados", required = true)  @Valid @RequestBody CustomerDTO customerDTO,
			@ApiParam(value = "Identificador do cliente a ser atualizado", required = true) @PathVariable("customerId") Long customerId,  BindingResult result)
	{
		log.info("Atualizando o cliente:{}"+customerId);
		Response<CustomerDTO> response = new Response<CustomerDTO>();

		response.setData(new CustomerDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Remove um cliente especifico", nickname = "deleteCustomer", notes = "", tags={ "customers"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e o cliente foi removido na base de dados!"),
   			@ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@DeleteMapping(value = "/Customers/{customerId}", produces = "application/json")
	public ResponseEntity<Response<String>> deleteCustomer(@ApiParam(value = "Identificador do cliente a ser removido", required = true) @PathVariable("customerId") Long customerId)
	{
		log.info("Removendo o cliente: {}" + customerId);
		Response<String> response = new Response<String>();
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Insere um novo endereço de entrega para um cliente especifico", nickname = "insertAddressForCustomer", notes = "", tags={ "customers"})
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Operação bem sucessida e um novo endereço foi incluido na base de dados"),
		    @ApiResponse(code = 400, message = "O objeto de request possui informações inválidas para a inclusão do endereço!"),
		    @ApiResponse(code = 404, message = "Nenhum cliente encontrado para requisição!")})
	@PostMapping(value ="/Customers/{customerId}/addresses", produces = "application/json")
	public ResponseEntity<Response<AddressDTO>> insertAddressForCustomer(@ApiParam(value = "Objeto de endereço que precisa ser incluido na base de dados", required = true)  @Valid @RequestBody AddressDTO addressDTO,
			@ApiParam(value = "Identificador do cliente a ter um endereço incluido", required = true)  @PathVariable("customerId") Long customerId,  BindingResult result)
	{
		log.info("Incluindo novo endereço para o cliente:{}" +customerId);
		Response<AddressDTO> response = new Response<AddressDTO>();

		response.setData(new AddressDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Atualiza um determinado endereço de entrega de cliente especifico", nickname = "updateAddressForCustomer", notes = "", tags={ "customers"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e o endereço foi atualizado na base de dados"),
		    @ApiResponse(code = 400, message = "O request possui informações inválidas para a atualização do endereço!"),
		    @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@PutMapping(value ="/Customers/{customerId}/addresses/{addressId}", produces = "application/json")
	public ResponseEntity<Response<AddressDTO>> updateAddressForCustomer(@ApiParam(value = "Objeto de endereço que precisa ser atualizado na base de dados", required = true)  @Valid @RequestBody AddressDTO addressDTO, 
			@ApiParam(value = "Identificador do cliente a ter um endereço atualizado", required = true)  @PathVariable("customerId") Long customerId,
			@ApiParam(value = "Identificador do endereço a ser atualizado", required = true)  @PathVariable("addressId") Long addressId, BindingResult result)
	{
		log.info("Atualizando o endereço "+addressId + " para o cliente:{}" +customerId);
		Response<AddressDTO> response = new Response<AddressDTO>();

		response.setData(new AddressDTO());
		
		return ResponseEntity.ok().body(response);
	}

	@ApiOperation(value = "Remove um determinado endereço de entrega de cliente especifico", nickname = "deleteAddresForCustomer", notes = "", tags={ "customers"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e o endereço foi removido na base de dados!"),
   			@ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@DeleteMapping(value ="/Customers/{customerId}/addresses/{addressId}", produces = "application/json")
	public ResponseEntity<Response<String>> deleteAddresForCustomer(@ApiParam(value = "Identificador do cliente a ter um endereço removido", required = true)@PathVariable("customerId") Long customerId,
			@ApiParam(value = "Identificador do endereço a ser removido", required = true) @PathVariable("addressId") Long addressId)
	{
		log.info("Removendo o enderço "+addressId+" para o cliente: {}" + customerId);
		Response<String> response = new Response<String>();
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Insere uma forma de pagamento para um cliente especifico", nickname = "insertPaymentOptionForCustomer", notes = "", tags={ "customers"})
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Operação bem sucessida e uma nova opçao de pagamento foi incluida na base de dados"),
		    @ApiResponse(code = 400, message = "O objeto de request possui informações inválidas para a inclusão da opção de pagamento!"),
		    @ApiResponse(code = 404, message = "Nenhum cliente encontrado para requisição!")})
	@PostMapping(value ="/Customers/{customerId}/paymentOptions", produces = "application/json")
	public ResponseEntity<Response<PaymentOptionDTO>> insertPaymentOptionForCustomer(@ApiParam(value = "Identificador do cliente a ter uma opção de pagamento incluido", required = true) @PathVariable("customerId") Long customerId,
			@ApiParam(value = "Objeto de opção de pagamento que precisa ser incluida na base de dados", required = true) @Valid @RequestBody PaymentOptionDTO paymentOptionDTO,  BindingResult result)
	{
		log.info("Incluindo nova opção de pagamento para o cliente: {}" + customerId);
		Response<PaymentOptionDTO> response = new Response<PaymentOptionDTO>();

		response.setData(new PaymentOptionDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Atualiza uma determinada forma de pagamento para um cliente especifico", nickname = "updatePaymentOptionForCustomer", notes = "", tags={ "customers"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e a opção de pagamento foi atualizado na base de dados"),
		    @ApiResponse(code = 400, message = "O request possui informações inválidas para a atualização da opção de pagamento!"),
		    @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@PutMapping(value ="/Customers/{customerId}/paymentOptions/{paymentOptionId}", produces = "application/json")
	public ResponseEntity<Response<PaymentOptionDTO>> updatePaymentOptionForCustomer(@ApiParam(value = "Identificador do cliente a ter uma opção de pagamento atualizado", required = true) @PathVariable("customerId") Long customerId, 
			@ApiParam(value = "Identificador da opção de pagamento a ser atualizado", required = true) @PathVariable("paymentOptionId") Long paymentOptionId,
			@ApiParam(value = "Objeto de opção de pagamento que precisa ser atualizado na base de dados", required = true)  @Valid @RequestBody PaymentOptionDTO paymentOptionDTO,  BindingResult result)
	{
		log.info("Atualizando a opção de pagamento"+paymentOptionId+ "para o cliente: {}" + customerId);
		Response<PaymentOptionDTO> response = new Response<PaymentOptionDTO>();

		response.setData(new PaymentOptionDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Deleta uma determinada forma de pagamento para um cliente especifico", nickname = "deletePaymentOptionForCustomer", notes = "", tags={ "customers"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e a opção de pagamento foi removida na base de dados!"),
   			@ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@DeleteMapping(value ="/Customers/{customerId}/paymentOptions/{paymentOptionId}", produces = "application/json")
	public ResponseEntity<Response<String>> deletePaymentOptionForCustomer(@ApiParam(value = "Identificador do cliente a ter uma opção de pagamento removida", required = true) @PathVariable("customerId") Long customerId, 
			@ApiParam(value = "Identificador da opção de pagamento a ser removida", required = true) @PathVariable("paymentOptionId") Long paymentOptionId)
	{
		log.info("Removendo a opção de pagamento "+paymentOptionId+" para o cliente: {}" + customerId);
		Response<String> response = new Response<String>();
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Insere itens no carrinho de compras de um cliente especifico", nickname = "insertShoppingCartForCustomer", notes = "", tags={ "customers"})
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Operação bem sucessida e o carrinho de compras foi incluido na base de dados"),
		    @ApiResponse(code = 400, message = "O objeto de request possui informações inválidas para a inclusão do carrinho de compras!"),
		    @ApiResponse(code = 404, message = "Nenhum cliente encontrado para requisição!")})
	@PostMapping(value ="/Customers/{customerId}/shoppingCarts", produces = "application/json")
	public ResponseEntity<Response<ShoppingCartDTO>> insertShoppingCartForCustomer(@ApiParam(value = "Identificador do cliente a ter um carrinho de compras incluido", required = true) @PathVariable("customerId") Long customerId,
			@ApiParam(value = "Objeto de carrinho de compras que precisa ser incluido na base de dados", required = true)  @Valid @RequestBody ShoppingCartDTO shoppingCartDTO,  BindingResult result)
	{
		log.info("Incluindo carrinho de compras para o cliente: {}" + customerId);
		Response<ShoppingCartDTO> response = new Response<ShoppingCartDTO>();

		response.setData(new ShoppingCartDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Atualiza os itens do carrinho de compras de um cliente especifico", nickname = "updateShoppingCartForCustomer", notes = "", tags={ "customers"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e o carrinho de compras foi atualizado na base de dados"),
		    @ApiResponse(code = 400, message = "O request possui informações inválidas para a atualização do carrinho de compras!"),
		    @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@PutMapping(value ="/Customers/{customerId}/shoppingCarts/{shoppingCartId}", produces = "application/json")
	public ResponseEntity<Response<ShoppingCartDTO>> updateShoppingCartForCustomer(@ApiParam(value = "Identificador do cliente a ter um carrinho de compras atualizado", required = true) @PathVariable("customerId") Long customerId,
			@ApiParam(value = "Identificador do carrinho de compras  a ser atualizado", required = true) @PathVariable("shoppingCartId") Long shoppingCartId,
			@ApiParam(value = "Objeto de carrinho de compras que precisa ser atualizado na base de dados", required = true)  @Valid @RequestBody ShoppingCartDTO shoppingCartDTO,  BindingResult result)
	{
		log.info("Atualizando o carrinho de compras "+shoppingCartId+" para o cliente: {}" + customerId);
		Response<ShoppingCartDTO> response = new Response<ShoppingCartDTO>();

		response.setData(new ShoppingCartDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Remove os itens do carrinho de compras de um cliente especifico", nickname = "updateShoppingCartForCustomer", notes = "", tags={ "customers"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e o carrinho de compras foi removido na base de dados!"),
   			@ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@DeleteMapping(value ="/Customers/{customerId}/shoppingCarts/{shoppingCartId}", produces = "application/json")
	public ResponseEntity<Response<String>> deleteShoppingCartForCustomer(@ApiParam(value = "Identificador do cliente a ter um carrinho de compras removido", required = true) @PathVariable("customerId") Long customerId, 
			@ApiParam(value = "Identificador do carrinho de compras  a ser removido", required = true) @PathVariable("shoppingCartId") Long shoppingCartId)
	{
		log.info("Removendo carrinho de compras  "+shoppingCartId+" para o cliente: {}" + customerId);
		Response<String> response = new Response<String>();
		
		return ResponseEntity.ok().body(response);
	}
}
