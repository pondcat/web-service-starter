package com.gj1913894.web.starter.service.http;

import com.gj1913894.web.starter.config.FeignClient;
import com.gj1913894.web.starter.dto.CqSsc;
import feign.RequestLine;

/**
 * @author gejian
 */
@FeignClient(value = "name", url = "http://f.apiplus.net")
public interface SscService {
	@RequestLine("GET /cqssc.json")
	CqSsc<CqSsc.Result> cqssc();
}
