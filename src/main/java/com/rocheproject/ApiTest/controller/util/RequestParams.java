package com.rocheproject.ApiTest.controller.util;

import java.util.Objects;

public class RequestParams {

    private int int1;
    private int int2;
    private int limit;
    private String str1;
    private String str2;
    
	public RequestParams(int int1, int int2, int limit, String str1, String str2) {
		super();
		this.int1 = int1;
		this.int2 = int2;
		this.limit = limit;
		this.str1 = str1;
		this.str2 = str2;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        
        if (o == null || getClass() != o.getClass()) return false;
        
        RequestParams that = (RequestParams) o;
        
        return int1 == that.int1 &&
                int2 == that.int2 &&
                limit == that.limit &&
                Objects.equals(str1, that.str1) &&
                Objects.equals(str2, that.str2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(int1, int2, limit, str1, str2);
    }

	@Override
	public String toString() {
		return "RequestParams [int1=" + int1 + ", int2=" + int2 + ", limit=" + limit + ", str1=" + str1 + ", str2="
				+ str2 + "]";
	}
	
    
}

