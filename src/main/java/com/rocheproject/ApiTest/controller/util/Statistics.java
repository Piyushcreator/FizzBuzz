package com.rocheproject.ApiTest.controller.util;
import java.util.HashMap;
import java.util.Map;

public class Statistics {

    private Map<RequestParams, Integer> requestStatistics = new HashMap<>();

    public void updateStatistics(int int1, int int2, int limit, String str1, String str2) {
        RequestParams requestParams = new RequestParams(int1, int2, limit, str1, str2);
        requestStatistics.put(requestParams, requestStatistics.getOrDefault(requestParams, 0) + 1);
    }

    public Map<RequestParams, Integer> getRequestStatistics() {
        return requestStatistics;
    }
}
