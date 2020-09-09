package com.example.easyapply.models;

import org.springframework.http.HttpStatus;

/**
 * Response object which wraps the application reponse
 */
public class Response {
    private HttpStatus httpStatus;
    private Object response;

    public Response(HttpStatus httpStatus, Object response){
        this.httpStatus = httpStatus;
        this.response = response;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Object getResponse() {
        return response;
    }
}
