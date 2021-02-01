package com.sajan.product.util;

import org.springframework.http.HttpHeaders;

public final class HeaderUtil {

    private HeaderUtil() {
    }


    public static HttpHeaders createAlert(String message, boolean success) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", message);
        headers.add("success", String.valueOf(success));
        return headers;
    }

    public static HttpHeaders createEntityCreationAlert(String entityName, boolean success) {
        return createAlert("A new " + entityName + " is created", success);
    }

    public static HttpHeaders getEntityAlert(String entityName, boolean success){
        return createAlert(entityName + " has been fetched successfully", success);
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
