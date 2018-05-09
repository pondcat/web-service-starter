package com.gj1913894.web.starter.dto;

import lombok.Data;

@Data
public class CqSsc {
    private Integer rows;
    private String code;
    private String info;
    private Result[] data;

    @Data
    public static class Result {
        private String expect;
        private String opencode;
        private String opentime;
        private Long opentimestamp;
    }
}
