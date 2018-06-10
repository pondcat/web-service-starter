package com.gj1913894.web.starter.filter;

import org.slf4j.MDC;
import org.springframework.http.MediaType;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebFilter(filterName = "fequestLoggingFilter", urlPatterns = {"/api/*", "/openapi/*"})
public class RequestLoggingFilter extends AbstractRequestLoggingFilter {
	private HttpServletRequest request;

	private static final AtomicInteger atomInt = new AtomicInteger(0);

	@Override
	protected boolean shouldLog(HttpServletRequest request) {
		return logger.isInfoEnabled();
	}

	@Override
	protected void beforeRequest(HttpServletRequest request, String message) {
		MDC.put("traceId", Integer.toString(atomInt.get())); /// 多机部署时不能用本地自增
		/// MDC.put("spanId", ""); 单服务时用不到
		logger.info(message);
	}

	@Override
	protected void afterRequest(HttpServletRequest request, String message) {
		logger.debug(message);
		MDC.clear();
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		this.request = request;
		super.doFilterInternal(request, response, filterChain);
	}

	@Override
	protected boolean isIncludePayload() {
		String contentType = request.getContentType();
		return contentType != null && (contentType.startsWith(MediaType.APPLICATION_JSON_VALUE) || contentType.startsWith(MediaType.APPLICATION_XML_VALUE));
	}
}
