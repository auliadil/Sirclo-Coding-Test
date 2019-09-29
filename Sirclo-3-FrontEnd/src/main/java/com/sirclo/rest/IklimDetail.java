package com.sirclo.rest;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IklimDetail {
	private String kota;
	
	@JsonProperty("suhu")
	private String suhu;
	
	@JsonProperty("perbedaan")
	private String perbedaan;

}
