package com.rocheproject.ApiTest.controller.util;

public class StatisticsResponse {
    private int int1;
    private int int2;
    private int limit;
    private String str1;
    private String str2;
    private int maxHits;

   
    public StatisticsResponse(int int1, int int2, int limit, String str1, String str2, int maxHits) {
        this.int1 = int1;
        this.int2 = int2;
        this.limit = limit;
        this.str1 = str1;
        this.str2 = str2;
        this.maxHits = maxHits;
    }


	@Override
	public String toString() {
		return "StatisticsResponse [int1=" + int1 + ", int2=" + int2 + ", limit=" + limit + ", str1=" + str1 + ", str2="
				+ str2 + ", maxHits=" + maxHits + "]";
	}
    
}
