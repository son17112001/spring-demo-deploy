package com.example.springdeployapi.controller;

public class ResponseEntity {
    private Boolean result = true;
    private String code = null;
    private String data = "";

    public ResponseEntity(Boolean result, String code, String data) {
        this.result = result;
        this.code = code;
        this.data = data;
    }
}
