package com.xbook.xbookstore.builders;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {

    private RequestSpecification requestSpec;
    private Map<String, Object> queryParams;
    private Map<String, String> headers;
    private String basePath;
    private String method;
    private String body;

    // Constructor initializes default values
    public RequestBuilder() {
        this.requestSpec = RestAssured.given();
        this.queryParams = new HashMap<>();
        this.headers = new HashMap<>();
    }

    public RequestBuilder setBaseUri(String baseUri) {
        this.requestSpec.baseUri(baseUri);
        return this;
    }

    public RequestBuilder setBasePath(String basePath) {
        this.basePath = basePath;
        return this;
    }

    public RequestBuilder addHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public RequestBuilder addQueryParam(String key, Object value) {
        this.queryParams.put(key, value);
        return this;
    }

    public RequestBuilder setMethod(String method) {
        this.method = method;
        return this;
    }

    public RequestBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public RequestSpecification build() {
        // Apply base path and headers if provided
        if (basePath != null) {
            this.requestSpec.basePath(basePath);
        }
        if (!headers.isEmpty()) {
            this.requestSpec.headers(headers);
        }
        if (!queryParams.isEmpty()) {
            this.requestSpec.queryParams(queryParams);
        }
        if (body != null && !body.isEmpty()) {
            this.requestSpec.body(body);
        }
        // Return the configured RequestSpecification
        return this.requestSpec;
    }

    public io.restassured.response.Response sendRequest() {
        switch (method.toUpperCase()) {
            case "GET":
                return this.requestSpec.get();
            case "POST":
                return this.requestSpec.post();
            case "PUT":
                return this.requestSpec.put();
            case "DELETE":
                return this.requestSpec.delete();
            default:
                throw new IllegalStateException("Unexpected method: " + method);
        }
    }
}
