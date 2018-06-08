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
import pondcat.commons.combine.Result;
import pondcat.commons.combine.exception.BusinessException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gejian at 2018/5/13 21:55
 */
@RestController
@ControllerAdvice
public class GlobalControllerConfig {

	private static final Logger log = LoggerFactory
			.getLogger(GlobalControllerConfig.class);

	@ExceptionHandler(AsyncRequestTimeoutException.class)
	private Result handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex) {
		// http status 503
		return Result.error(Result.CODE_NOT_AVAILABLE, ex.getMessage());
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	private Result handleNoHandlerFoundException(NoHandlerFoundException ex) {
		// http status 404
		return null;
	}

	@ExceptionHandler(BindException.class)
	private Result<Void> handleBindException(BindException ex,
			HttpServletRequest request) {
		// 只记录第一个参数错误
		FieldError fieldError = ex.getFieldError();
		if (fieldError == null) {
			if (log.isDebugEnabled()) {
				log.debug("bindException but no fieldError: " + ex.getMessage());
			}
			return Result.error(ex.getMessage());
		}
		if (log.isDebugEnabled()) {
			log.debug("bindException: " + fieldError.getObjectName() + '.'
					+ fieldError.getField() + ':' + fieldError.getRejectedValue() + ", "
					+ fieldError.getDefaultMessage());
		}
		return Result.error(fieldError.getDefaultMessage());
	}

	@ExceptionHandler(MissingServletRequestPartException.class)
	private Result handleMissingServletRequestPartException(
			MissingServletRequestPartException ex) {
		log.debug("missing part exception: {}", ex.getMessage());
		return Result.error(ex.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	private Result handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex) {
		return null;
	}

	@ExceptionHandler(HttpMessageNotWritableException.class)
	private Result handleHttpMessageNotWritable(HttpMessageNotWritableException ex) {
		return null;
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	private Result handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
		return null;
	}

	@ExceptionHandler(TypeMismatchException.class)
	private Result handleTypeMismatch(TypeMismatchException ex) {
		return null;
	}

	@ExceptionHandler(ConversionNotSupportedException.class)
	private Result handleConversionNotSupported(ConversionNotSupportedException ex) {
		return null;
	}

	@ExceptionHandler(ServletRequestBindingException.class)
	private Result handleServletRequestBindingException(
			ServletRequestBindingException ex) {
		return null;
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	private Result handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex) {
		return null;
	}

	@ExceptionHandler(MissingPathVariableException.class)
	private Result handleMissingPathVariable(MissingPathVariableException ex) {
		return null;
	}

	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	private Result handleHttpMediaTypeNotAcceptable(
			HttpMediaTypeNotAcceptableException ex) {
		return null;
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	private Result handleHttpMediaTypeNotSupported(
			HttpMediaTypeNotSupportedException ex) {
		return null;
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	private Result handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex) {
		return null;
	}

	@ExceptionHandler(BusinessException.class)
	private Result handleBusinessException(BusinessException ex) {
		return null;
	}

	@ExceptionHandler(Exception.class)
	private Result handleException(Exception ex) {
		ex.printStackTrace();
		System.out.println("handleException");
		return null;
	}

	private String traceRequest(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		return "";
	}

}
