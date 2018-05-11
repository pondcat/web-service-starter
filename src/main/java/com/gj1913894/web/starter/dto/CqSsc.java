package com.gj1913894.web.starter.dto;


public class CqSsc {
    private Integer rows;
    private String code;
    private String info;
    private Result[] data;

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Result[] getData() {
        return data;
    }

    public void setData(Result[] data) {
        this.data = data;
    }

    public static class Result {
        private String expect;
        private String opencode;
        private String opentime;
        private Long opentimestamp;

        public String getExpect() {
            return expect;
        }

        public void setExpect(String expect) {
            this.expect = expect;
        }

        public String getOpencode() {
            return opencode;
        }

        public void setOpencode(String opencode) {
            this.opencode = opencode;
        }

        public String getOpentime() {
            return opentime;
        }

        public void setOpentime(String opentime) {
            this.opentime = opentime;
        }

        public Long getOpentimestamp() {
            return opentimestamp;
        }

        public void setOpentimestamp(Long opentimestamp) {
            this.opentimestamp = opentimestamp;
        }
    }

}
