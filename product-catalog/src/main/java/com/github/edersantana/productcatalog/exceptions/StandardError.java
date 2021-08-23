package com.github.edersantana.productcatalog.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {
	
    private String timestamp;
    private int status;
    private String error;
    private String trace;
    private String message;
    private String path;
	

}
