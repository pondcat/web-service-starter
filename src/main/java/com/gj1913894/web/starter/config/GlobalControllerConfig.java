package com.gj1913894.web.starter.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author gejian at 2018/5/13 21:55
 */
@RestController
@ControllerAdvice(basePackages = "com.gj1913894.web.starter.ctrl")
public class GlobalControllerConfig {
	private static final Logger log = LoggerFactory.getLogger(GlobalControllerConfig.class);

	@ExceptionHandler(AsyncRequestTimeoutException.class)
	private ErrorResponse handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex) {
		return null;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	private ErrorResponse handleNoHandlerFoundException(NoHandlerFoundException ex) {
		return null;
	}

	@ExceptionHandler(BindException.class)
	private ErrorResponse handleBindException(BindException ex) {
		// 只记录第一个参数错误
		FieldError fieldError = ex.getFieldError();
		if (log.isDebugEnabled()) {
			log.debug("bindException: {}.{}:{}, {}", fieldError.getObjectName(), fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage());
		}
		return new ErrorResponse(null, fieldError.getDefaultMessage(), fieldError.getField());
	}

	@ExceptionHandler(MissingServletRequestPartException.class)
	private ErrorResponse handleMissingServletRequestPartException(MissingServletRequestPartException ex) {
		return null;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	private ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		return null;
	}

	@ExceptionHandler(HttpMessageNotWritableException.class)
	private ErrorResponse handleHttpMessageNotWritable(HttpMessageNotWritableException ex) {
		return null;
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	private ErrorResponse handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
		return null;
	}

	@ExceptionHandler(TypeMismatchException.class)
	private ErrorResponse handleTypeMismatch(TypeMismatchException ex) {
		return null;
	}

	@ExceptionHandler(ConversionNotSupportedException.class)
	private ErrorResponse handleConversionNotSupported(ConversionNotSupportedException ex) {
		return null;
	}

	@ExceptionHandler(ServletRequestBindingException.class)
	private ErrorResponse handleServletRequestBindingException(ServletRequestBindingException ex) {
		return null;
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	private ErrorResponse handleMissingServletRequestParameter(MissingServletRequestParameterException ex) {
		return null;
	}

	@ExceptionHandler(MissingPathVariableException.class)
	private ErrorResponse handleMissingPathVariable(MissingPathVariableException ex) {
		return null;
	}

	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	private ErrorResponse handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex) {
		return null;
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	private ErrorResponse handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex) {
		return null;
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	private ErrorResponse handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
		return null;
	}

	public void init() {

	}

	public static final class ErrorResponse {
		private String code;

		private String message;

		private String field;

		public ErrorResponse(String code, String message) {
			this.code = code;
			this.message = message;
		}

		public ErrorResponse(String code, String message, String field) {
			this.code = code;
			this.message = message;
			this.field = field;
		}

		public String getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

		public String getField() {
			return field;
		}
	}
}
