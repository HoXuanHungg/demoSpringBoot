package com.example.demo_Spring.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
// để định dạng ví dụ như sdt có 10 số thì nhập đúng 10 hk thể ít hơn.
public class PhoneValidator implements ConstraintValidator<Phone, String>{
	public void initialize(Phone paramA) {
		
	}

	@Override
	public boolean isValid(String phoneNo, ConstraintValidatorContext constraintValidatorContext) {
		if(phoneNo == null) {
			return false;
		}
		return phoneNo.matches("\\d{10}");
	}
	
}


