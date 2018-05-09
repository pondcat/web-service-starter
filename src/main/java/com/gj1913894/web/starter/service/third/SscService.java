package com.gj1913894.web.starter.service.third;

import com.gj1913894.web.starter.dto.CqSsc;
import feign.RequestLine;

//@FeignClient(value = "name", url = "http://f.apiplus.net")
public interface SscService {
    @RequestLine("GET /cqssc.json")
    CqSsc cqssc();
}
