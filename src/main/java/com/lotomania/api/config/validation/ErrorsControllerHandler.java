package com.lotomania.api.config.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lotomania.api.exceptions.QuantidadeDeNumerosException;

@RestControllerAdvice
public class ErrorsControllerHandler {
@Autowired
private MessageSource message;
	
@ResponseStatus(code = HttpStatus.BAD_REQUEST)	
@ExceptionHandler(MethodArgumentNotValidException.class)
public List<ErrorMessagemForm> ErrosValidationHandler(MethodArgumentNotValidException ex){
	List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
	List<ErrorMessagemForm> errorsForm=new ArrayList<>();
	fieldErrors.forEach(e->{
		String msg=message.getMessage(e, LocaleContextHolder.getLocale());
		ErrorMessagemForm error=new ErrorMessagemForm(e.getField(), msg);
	    errorsForm.add(error);
	});
	
	return errorsForm;
}
@ResponseStatus(code = HttpStatus.BAD_REQUEST)	
@ExceptionHandler(QuantidadeDeNumerosException.class)
public ErrorMessagemForm  ErrosValidationHandler(QuantidadeDeNumerosException ex){
   String msg=ex.getMessage();
   String campo="qtdNumApostas";
  ErrorMessagemForm error=new ErrorMessagemForm(campo, msg);
  return error;
  
}

}
