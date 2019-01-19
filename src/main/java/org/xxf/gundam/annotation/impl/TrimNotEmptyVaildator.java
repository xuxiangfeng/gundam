package org.xxf.gundam.annotation.impl;


import org.xxf.gundam.annotation.TrimNotEmpty;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TrimNotEmptyVaildator implements ConstraintValidator<TrimNotEmpty, String> {
	@Override
	public void initialize(TrimNotEmpty constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.equals("") || value.trim().length() == 0){
			return false;
		}
		
		return true;
	}
}
