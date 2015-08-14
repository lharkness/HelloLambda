package com.amazon.pa.lambda;

public class Response {

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;

    public Response(String value) {
        this.value = value;
    }


}
