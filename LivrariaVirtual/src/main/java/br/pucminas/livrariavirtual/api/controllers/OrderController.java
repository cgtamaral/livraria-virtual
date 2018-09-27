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

@RestController
@RequestMapping("/v1/public")
@CrossOrigin(origins = "*")
@Api(value = "Orders", description = "Recurso para gerenciamento de pedidos")
public class OrderController 
{
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@GetMapping(value ="/orders")
	public ResponseEntity<Response<List<OrderDTO>>> findAllOrders()
	{
		log.info("Buscando todos os pedidos existentes na base de dados!");
		Response<List<OrderDTO>> response = new Response<List<OrderDTO>>();
		
		List<OrderDTO> retornoFakeNull = new ArrayList<OrderDTO>();
		retornoFakeNull.add(new OrderDTO());
		response.setData(retornoFakeNull);

		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value ="/orders/{orderId}")
	public ResponseEntity<Response<OrderDTO>> findOrderById(@PathVariable("orderId") Long orderId)
	{
		log.info("Buscando o pedido: {}" + orderId);
		Response<OrderDTO> response = new Response<OrderDTO>();

		response.setData(new OrderDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value ="/orders/{idOrder}/Payments")
	public ResponseEntity<Response<PaymentDTO>> findPaymentByOrderId(@PathVariable("orderId") Long orderId)
	{
		log.info("Buscando pagamento para o pedido: {}" + orderId);
		Response<PaymentDTO> response = new Response<PaymentDTO>();

		response.setData(new PaymentDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value ="/orders/{idOrder}/Deliverys")
	public ResponseEntity<Response<DeliveryDTO>> findDeliveyByOrderId(@PathVariable("orderId") Long orderId)
	{
		log.info("Buscando dados de entrega do pedido: {}" + orderId);
		Response<DeliveryDTO> response = new Response<DeliveryDTO>();

		response.setData(new DeliveryDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping(value ="/orders")
	public ResponseEntity<Response<OrderDTO>> insertOrder(@Valid @RequestBody OrderDTO orderDTO,  BindingResult result)
	{
		log.info("Incluindo novo pedido para o cliente{} " + (orderDTO!=null ? orderDTO.getCustomerId() : "?"));
		Response<OrderDTO> response = new Response<OrderDTO>();

		response.setData(new OrderDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping(value ="/orders/{orderId}")
	public ResponseEntity<Response<OrderDTO>> updateOrder(@Valid @RequestBody OrderDTO orderDTO, @PathVariable("orderId") Long orderId,  BindingResult result)
	{
		log.info("Atualizando o pedido: {}"+orderId);
		Response<OrderDTO> response = new Response<OrderDTO>();

		response.setData(new OrderDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping(value ="/orders/{orderId}")
	public ResponseEntity<Response<String>> deleteOrder(@PathVariable("orderId") Long orderId)
	{
		log.info("Removendo o pedido: {}" + orderId);
		Response<String> response = new Response<String>();
		
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping(value ="/orders/{idOrder}/Payments")
	public ResponseEntity<Response<PaymentDTO>> insertPaymentForOrder(@PathVariable("orderId") Long orderId, @Valid @RequestBody OrderDTO orderDTO,  BindingResult result)
	{
		log.info("Incluindo informações de pagamento para o pedido: {} " + orderId);
		Response<PaymentDTO> response = new Response<PaymentDTO>();

		response.setData(new PaymentDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping(value ="/orders/{idOrder}/Payments/{paymentId}")
	public ResponseEntity<Response<OrderDTO>> updatePaymentForOrder(@Valid @RequestBody OrderDTO orderDTO, @PathVariable("orderId") Long orderId,
			 @PathVariable("paymentId") Long paymentId, BindingResult result)
	{
		log.info("Atualizando a forma de pagamento "+paymentId+" do pedido:{}"+orderId);
		Response<OrderDTO> response = new Response<OrderDTO>();

		response.setData(new OrderDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping(value ="/orders/{idOrder}/Payments/{paymentId}")
	public ResponseEntity<Response<String>> deletePaymentForOrder(@PathVariable("orderId") Long orderId, @PathVariable("paymentId") Long paymentId)
	{
		log.info("Removendo a forma de pagamento "+paymentId+" do pedido " + orderId);
		Response<String> response = new Response<String>();
		
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping(value ="/orders/{idOrder}/Deliverys")
	public ResponseEntity<Response<DeliveryDTO>> insertDeliveryForOrder(@PathVariable("orderId") Long orderId, @Valid @RequestBody DeliveryDTO deliveryDTO,  
			BindingResult result)
	{
		log.info("Incluindo informações de entrega para o pedido: {} " + orderId);
		Response<DeliveryDTO> response = new Response<DeliveryDTO>();

		response.setData(new DeliveryDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping(value ="/orders/{idOrder}/Deliverys/{deliveryId}")
	public ResponseEntity<Response<OrderDTO>> updateDeliveryForOrder(@Valid @RequestBody DeliveryDTO deliveryDTO, @PathVariable("orderId") Long orderId,
			 @PathVariable("deliveryId") Long deliveryId, BindingResult result)
	{
		log.info("Atualizando informações de entraga "+deliveryId+" do pedido:{}"+orderId);
		Response<OrderDTO> response = new Response<OrderDTO>();

		response.setData(new OrderDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping(value ="/orders/{idOrder}/Deliverys/{deliveryId}")
	public ResponseEntity<Response<String>> deleteDeliveryForOrder(@PathVariable("orderId") Long orderId,
			@PathVariable("deliveryId") Long deliveryId)
	{
		log.info("Removendo dados de entrega "+deliveryId+" do pedido " + orderId);
		Response<String> response = new Response<String>();
		
		return ResponseEntity.ok().body(response);
	}
}
