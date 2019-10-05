package com.aem.micro.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "exchange_value")
public class ExchangeValue {
	@Id
	private Long id;
	@Column(name = "currency_from")
	private String from;
	@Column(name = "currency_to")
	private String to;
	@Column(name = "conversion_multiple")
	private BigDecimal conversionMultiple;
	@Column(name = "port", nullable = true)
	private int port;

	@OneToMany(mappedBy = "exchangeValue")
	@JsonBackReference
	private List<ForeignTable1> foreignOnes;

	@OneToMany(mappedBy = "exchangeValue")
	@JsonBackReference
	private List<ForeignTable2> foreignTwos;

	public ExchangeValue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public List<ForeignTable1> getForeignOnes() {
		return foreignOnes;
	}

	public void setForeignOnes(List<ForeignTable1> foreignOnes) {
		this.foreignOnes = foreignOnes;
	}

	public List<ForeignTable2> getForeignTwos() {
		return foreignTwos;
	}

	public void setForeignTwos(List<ForeignTable2> foreignTwos) {
		this.foreignTwos = foreignTwos;
	}

	@Override
	public String toString() {
		return "ExchangeValue [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", port=" + port + "]";
	}

}
