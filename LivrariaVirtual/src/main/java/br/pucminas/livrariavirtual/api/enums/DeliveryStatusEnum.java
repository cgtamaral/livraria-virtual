package br.pucminas.livrariavirtual.api.enums;

public enum DeliveryStatusEnum {
	AGUARDANDO_APROVACAO_PAGAMENTO,
	EM_SEPARACAO,
	AGUARDANDO_ENVIO_A_TRANSPORTADORA,
	ENVIADO_A_TRANSPORTADORA,
	EM_TRANSPORTE,
	ENTREGUE,
	ENTREGA_RECUSADA
}
