package br.pucminas.livrariavirtual.api.entities;

import java.util.Calendar;
import java.util.Date;

import br.pucminas.livrariavirtual.api.enums.CardTypeEnum;

public class PaymentOption {
	
	private String nomeTitularCartao;
	private String numeroCartao;
	private Calendar dataVencimento;
	private CardTypeEnum tipoCartaoEnum;
	
	
}
