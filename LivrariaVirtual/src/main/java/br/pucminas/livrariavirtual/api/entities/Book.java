package br.pucminas.livrariavirtual.api.entities;

import java.util.List;

import br.pucminas.livrariavirtual.api.dtos.BookDTO;

public class Book 
{
	private String title;
	private String language;
	private String ISBN10Code;
	private String ISBN13Code;
	private Author author;
	private Publisher publisher;
	private String edition;
	private String productDimensions;
	private Double shippingWeight;
	private Integer averageCustomerReview;
	private Double bestSellerRank;
	private Double price; 
	
	public static List<BookDTO> convertToDTO(List<Book> livros) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
