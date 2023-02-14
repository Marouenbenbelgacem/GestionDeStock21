package org.sid.handlers;

import java.util.ArrayList;
import java.util.List;

import org.sid.exception.ErrorCodes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto { // l'objet que je veux evoyer l'orsque je catch (trouve) une exception

	private Integer httpCode;
	private ErrorCodes errorsCode;
	private String message;
	private List<String> errors = new ArrayList<String>();

}
