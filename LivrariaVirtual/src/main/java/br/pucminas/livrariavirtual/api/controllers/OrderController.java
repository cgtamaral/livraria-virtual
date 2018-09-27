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
import br.pucminas.livrariavirtual.api.dtos.DeliveryDTO;
import br.pucminas.livrariavirtual.api.dtos.OrderDTO;
import br.pucminas.livrariavirtual.api.dtos.PaymentDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/public")
@CrossOrigin(origins = "*")
@Api(value = "orders", description = "Recurso para gerenciamento de pedidos", tags={ "orders"})
public class OrderController 
{
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@ApiOperation(value = "Recupera todos os pedidos existentes", nickname = "findAllOrders", notes = "", tags={ "orders"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		   				@ApiResponse(code = 404, message = "Nenhum pedido foi encontrado na base de dados!") })
	@GetMapping(value ="/orders", produces = "application/json")
	public ResponseEntity<Response<List<OrderDTO>>> findAllOrders()
	{
		log.info("Buscando todos os pedidos existentes na base de dados!");
		Response<List<OrderDTO>> response = new Response<List<OrderDTO>>();
		
		List<OrderDTO> retornoFakeNull = new ArrayList<OrderDTO>();
		retornoFakeNull.add(new OrderDTO());
		response.setData(retornoFakeNull);

		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Recupera um pedido especifico", nickname = "findOrderById", notes = "", tags={ "orders"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 400, message = "O id informado é inválido!"),
			@ApiResponse(code = 404, message = "Nenhum pedido foi encontrado para o id informado!")})
	@GetMapping(value ="/orders/{orderId}", produces = "application/json")
	public ResponseEntity<Response<OrderDTO>> findOrderById(@ApiParam(value = "Identificador do pedido a ser consultado", required = true) @PathVariable("orderId") Long orderId)
	{
		log.info("Buscando o pedido: {}" + orderId);
		Response<OrderDTO> response = new Response<OrderDTO>();

		response.setData(new OrderDTO());
		
		return ResponseEntity.ok().body(response);
	}

	@ApiOperation(value = "Recupera as informações de pagamento de um pedido especifico", nickname = "findPaymentByOrderId", notes = "", tags={ "orders"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 400, message = "O id informado é inválido!"),
			@ApiResponse(code = 404, message = "Nenhum registro foi encontrado para a requisição!")})
	@GetMapping(value ="/orders/{orderId}/Payments", produces = "application/json")
	public ResponseEntity<Response<PaymentDTO>> findPaymentByOrderId(@ApiParam(value = "Identificador do pedido a ter o pagamento consultado", required = true) @PathVariable("orderId") Long orderId)
	{
		log.info("Buscando pagamento para o pedido: {}" + orderId);
		Response<PaymentDTO> response = new Response<PaymentDTO>();

		response.setData(new PaymentDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Recupera as informações de entrega de um pedido especifico", nickname = "findDeliveyByOrderId", notes = "", tags={ "orders"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 400, message = "O id informado é inválido!"),
			@ApiResponse(code = 404, message = "Nenhum registro foi encontrado para a requisição!")})
	@GetMapping(value ="/orders/{orderId}/Deliverys", produces = "application/json")
	public ResponseEntity<Response<DeliveryDTO>> findDeliveyByOrderId(@ApiParam(value = "Identificador do pedido a ter a entrega consultada", required = true) @PathVariable("orderId") Long orderId)
	{
		log.info("Buscando dados de entrega do pedido: {}" + orderId);
		Response<DeliveryDTO> response = new Response<DeliveryDTO>();

		response.setData(new DeliveryDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Insere um novo pedido", nickname = "insertOrder", notes = "", tags={ "orders"})
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Operação bem sucessida e um novo pedido foi incluido na base de dados"),
		    @ApiResponse(code = 400, message = "O objeto de request possui informações inválidas para a inclusão do pedido!"),
		    @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@PostMapping(value ="/orders", produces = "application/json")
	public ResponseEntity<Response<OrderDTO>> insertOrder(@ApiParam(value = "Objeto do pedido que precisa ser incluido na base de dados", required = true) @Valid @RequestBody OrderDTO orderDTO,  BindingResult result)
	{
		log.info("Incluindo novo pedido para o cliente{} " + (orderDTO!=null ? orderDTO.getCustomerId() : "?"));
		Response<OrderDTO> response = new Response<OrderDTO>();

		response.setData(new OrderDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Atualiza as informações de um pedido especifico", nickname = "updateOrder", notes = "", tags={ "orders"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e o pedido foi atualizado na base de dados"),
		    @ApiResponse(code = 400, message = "O request possui informações inválidas para a atualização do pedido!"),
		    @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@PutMapping(value ="/orders/{orderId}", produces = "application/json")
	public ResponseEntity<Response<OrderDTO>> updateOrder(@ApiParam(value = "Objeto do pedido que precisa ser atualizado na base de dados", required = true)  @Valid @RequestBody OrderDTO orderDTO, 
			@ApiParam(value = "Identificador do pedido a ser atualizado", required = true) @PathVariable("orderId") Long orderId,  BindingResult result)
	{
		log.info("Atualizando o pedido: {}"+orderId);
		Response<OrderDTO> response = new Response<OrderDTO>();

		response.setData(new OrderDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Remove um pedido especifico", nickname = "updateOrder", notes = "", tags={ "orders"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e o pedido foi removido na base de dados!"),
   			@ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@DeleteMapping(value ="/orders/{orderId}", produces = "application/json")
	public ResponseEntity<Response<String>> deleteOrder(@ApiParam(value = "Identificador do pedido a ser removido", required = true) @PathVariable("orderId") Long orderId)
	{
		log.info("Removendo o pedido: {}" + orderId);
		Response<String> response = new Response<String>();
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Insere informações de pagamento para um pedido especifico", nickname = "updateOrder", notes = "", tags={ "orders"})
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Operação bem sucessida e a forma de pagamento do pedido foi incluida na base de dados"),
		    @ApiResponse(code = 400, message = "O request informado é inválido!"),
		    @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@PostMapping(value ="/orders/{orderId}/Payments", produces = "application/json")
	public ResponseEntity<Response<PaymentDTO>> insertPaymentForOrder(@ApiParam(value = "Identificador do pedido a ter a forma de pagamento incluida", required = true) @PathVariable("orderId") Long orderId, 
			@ApiParam(value = "Objeto de forma de pagamento que precisa ser incluida na base de dados", required = true) @Valid @RequestBody PaymentDTO paymentDTO,  BindingResult result)
	{
		log.info("Incluindo informações de pagamento para o pedido: {} " + orderId);
		Response<PaymentDTO> response = new Response<PaymentDTO>();

		response.setData(new PaymentDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Atualiza as informações de pagamento de um pedido especifico", nickname = "updateOrder", notes = "", tags={ "orders"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e a forma de pagamento foi atualizada na base de dados"),
		    @ApiResponse(code = 400, message = "O request informado é inválido!"),
		    @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@PutMapping(value ="/orders/{orderId}/Payments/{paymentId}", produces = "application/json")
	public ResponseEntity<Response<OrderDTO>> updatePaymentForOrder(@ApiParam(value = "Objeto de forma de pagamento que precisa ser atualizaod na base de dados", required = true) @Valid @RequestBody PaymentDTO paymentDTO, 
			@ApiParam(value = "Identificador do pedido a ter a forma de pagamento atualizada", required = true) @PathVariable("orderId") Long orderId,
			@ApiParam(value = "Identificador da forma de pagamento a ser atualizada", required = true) @PathVariable("paymentId") Long paymentId, BindingResult result)
	{
		log.info("Atualizando a forma de pagamento "+paymentId+" do pedido:{}"+orderId);
		Response<OrderDTO> response = new Response<OrderDTO>();

		response.setData(new OrderDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Remove as informações de pagamento de um pedido especifico", nickname = "updateOrder", notes = "", tags={ "orders"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e a forma de pagamento foi removida na base de dados!"),
			   @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@DeleteMapping(value ="/orders/{orderId}/Payments/{paymentId}", produces = "application/json")
	public ResponseEntity<Response<String>> deletePaymentForOrder(@ApiParam(value = "Identificador do pedido a ter a forma de pagamento removida", required = true) @PathVariable("orderId") Long orderId, 
			@ApiParam(value = "Identificador da forma de pagamento a ser removida", required = true) @PathVariable("paymentId") Long paymentId)
	{
		log.info("Removendo a forma de pagamento "+paymentId+" do pedido " + orderId);
		Response<String> response = new Response<String>();
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Insere as informações de entrega de um pedido especifico", nickname = "updateOrder", notes = "", tags={ "orders"})
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Operação bem sucessida e uma entrega foi incluida para o pedido na base de dados"),
		    @ApiResponse(code = 400, message = "O request informado é inválido!"),
		    @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@PostMapping(value ="/orders/{orderId}/Deliverys", produces = "application/json")
	public ResponseEntity<Response<DeliveryDTO>> insertDeliveryForOrder(@ApiParam(value = "Identificador do pedido a ter uma entrega incluida", required = true) @PathVariable("orderId") Long orderId, 
			@ApiParam(value = "Objeto de entrega que precisa ser incluido na base de dados", required = true)  @Valid @RequestBody DeliveryDTO deliveryDTO,  
			BindingResult result)
	{
		log.info("Incluindo informações de entrega para o pedido: {} " + orderId);
		Response<DeliveryDTO> response = new Response<DeliveryDTO>();

		response.setData(new DeliveryDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Atualiza as informações de entrega de um pedido especifico", nickname = "updateOrder", notes = "", tags={ "orders"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e a entrega foi atualizada na base de dados"),
		    @ApiResponse(code = 400, message = "O request informado é inválido!"),
		    @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@PutMapping(value ="/orders/{orderId}/Deliverys/{deliveryId}", produces = "application/json")
	public ResponseEntity<Response<OrderDTO>> updateDeliveryForOrder(@ApiParam(value = "Objeto de entrega que precisa ser atualizado na base de dados", required = true)   @Valid @RequestBody DeliveryDTO deliveryDTO, 
			@ApiParam(value = "Identificador do pedido a ter a entrega atualizada", required = true) @PathVariable("orderId") Long orderId,
			@ApiParam(value = "Identificador da entrega a ser atualizada", required = true) @PathVariable("deliveryId") Long deliveryId, BindingResult result)
	{
		log.info("Atualizando informações de entraga "+deliveryId+" do pedido:{}"+orderId);
		Response<OrderDTO> response = new Response<OrderDTO>();

		response.setData(new OrderDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Remove as informações de entrega de um pedido especifico", nickname = "updateOrder", notes = "", tags={ "orders"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e as informações de entrega foram removidas na base de dados!"),
			   @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@DeleteMapping(value ="/orders/{orderId}/Deliverys/{deliveryId}", produces = "application/json")
	public ResponseEntity<Response<String>> deleteDeliveryForOrder(@ApiParam(value = "Identificador do pedido a ter as informações de entrega removidas", required = true)  @PathVariable("orderId") Long orderId,
			@ApiParam(value = "Identificador da entrega a ser removida", required = true)  @PathVariable("deliveryId") Long deliveryId)
	{
		log.info("Removendo dados de entrega "+deliveryId+" do pedido " + orderId);
		Response<String> response = new Response<String>();
		
		return ResponseEntity.ok().body(response);
	}
}
