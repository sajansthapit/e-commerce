package com.sajan.order.util;

import com.sajan.order.util.dto.HeaderDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;

import java.util.Objects;

public final class HeaderUtil {

    private HeaderUtil() {
    }


    public static HttpHeaders createAlert(String message, boolean success) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", message);
        headers.add("success", String.valueOf(success));
        return headers;
    }

    public static HttpHeaders createEntityCreationAlert(String entityName) {
        return createAlert("A new " + entityName + " is created", true);
    }

    public static HttpHeaders getEntityAlert(String entityName){
        return createAlert(entityName + " has been fetched successfully", true);
    }

    public static HttpHeaders exceptionAlert(String message){
        return createAlert(message, false);
    }

    public static HeaderDto getHeaders(ResponseEntity<?> response){
        HeaderDto headerDto = new HeaderDto();
        headerDto.setMessage(Objects.requireNonNull(response.getHeaders().get("message")).get(0));
        headerDto.setSuccess(Boolean.valueOf(Objects.requireNonNull(response.getHeaders().get("success")).get(0)));
        return headerDto;
    }

    /*public static HttpHeaders createEntityUpdateAlert(String entityName, String param) {
        return createAlert("A " + entityName + " is updated with identifier " + param, param);
    }

    public static HttpHeaders createEntityDeletionAlert(String entityName, String param) {
        return createAlert("A " + entityName + " is deleted with identifier " + param, param);
    }

    public static HttpHeaders createFailureAlert(String entityName, String errorKey, String defaultMessage) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-srsApp-error", defaultMessage);
        headers.add("X-srsApp-params", entityName);
        return headers;
    }*/
}
