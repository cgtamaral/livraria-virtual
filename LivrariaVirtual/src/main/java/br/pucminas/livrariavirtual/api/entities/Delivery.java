package br.pucminas.livrariavirtual.api.entities;

import br.pucminas.livrariavirtual.api.enums.DeliveryStatusEnum;
import br.pucminas.livrariavirtual.api.enums.DeliveryTypeEnum;

public class Delivery 
{
	private Address deliveryAddress;
	private DeliveryTypeEnum deliveryTypeEnum;
	private DeliveryStatusEnum deliveryStatusEnum;
	private Payment payment;
}
