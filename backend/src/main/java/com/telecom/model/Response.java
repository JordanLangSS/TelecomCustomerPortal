package com.telecom.model;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.experimental.SuperBuilder;

//response to send to the user on each request
@Data
@SuperBuilder
// only include values that are not null
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

	protected LocalDateTime timeStamp;
	protected int statusCode;
	protected HttpStatus status;
	protected String reason; // could be null
	// possibly use on front end???
	protected String message; // notification for the user
	protected String devMessage; // could be null
	protected Map<?, ?> data;
}
