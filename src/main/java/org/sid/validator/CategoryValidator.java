package org.sid.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.dto.CategoryDto;
import org.springframework.util.StringUtils;

public class CategoryValidator {

	public static List<String> validate (CategoryDto categoryDto){
		
		List<String> errors = new ArrayList<String>();
		
		if (categoryDto == null || !StringUtils.hasLength(categoryDto.getCodeCategory())) { //on va tester si le code est vide ou pas 
			errors.add("Veuillez saisir votre code correctement !!");
		}
		return errors;	
	}
}
