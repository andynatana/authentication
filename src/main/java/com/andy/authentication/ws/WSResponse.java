package com.andy.authentication.ws;

public record WSResponse(Integer statusCode, String message, Object body) {
}
