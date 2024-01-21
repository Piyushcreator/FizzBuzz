package com.rocheproject.ApiTest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rocheproject.ApiTest.controller.util.Statistics;
import com.rocheproject.ApiTest.controller.util.StatisticsResponse;
import com.rocheproject.ApiTest.controller.util.RequestParams;

@CrossOrigin(origins = "*")
@RestController
public class ApiController {

	private static final Statistics statistics = new Statistics();
	
	@GetMapping("/fizzbuzzapi")
	public ResponseEntity<Object> fizzbuzzgenerator(
			@RequestParam(defaultValue = "") Integer int1,
            @RequestParam(defaultValue = "") Integer int2,
            @RequestParam(defaultValue = "") Integer limit,
            @RequestParam(defaultValue = "") String str1,
            @RequestParam(defaultValue = "") String str2)
	{
		
		if (int1 == null || int2 == null || limit == null || str1 == "" || str2 == "") {
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("All parameters are required");
		}
		 List<String> result = new ArrayList<>();
	        for (int i = 1; i <= limit; i++) {
	        	  if (i % (int1 * int2) == 0) {
	                  result.add(str1 + str2);
	              } else if (i % int1 == 0) {
	                  result.add(str1);
	              } else if (i % int2 == 0) {
	                  result.add(str2);
	              } else {
	                  result.add(String.valueOf(i));
	              }
	        }
	        
	        statistics.updateStatistics(int1, int2, limit, str1, str2);
	        return ResponseEntity.ok(result);
	}
	
	  @GetMapping("/statistics")
	    public ResponseEntity<Object> getStatistics() {
		  Map<RequestParams, Integer> requestStatistics = statistics.getRequestStatistics();
		  try {
			  if (requestStatistics.isEmpty()) {
		            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No statistics available");
		        }

		        Entry<RequestParams, Integer> mostUsedEntry = requestStatistics.entrySet().stream()
		                .max(Map.Entry.comparingByValue())
		                .orElse(null);

		        if (mostUsedEntry != null) {
		            RequestParams requestParams = mostUsedEntry.getKey();
		            int maxHits = mostUsedEntry.getValue();
		            String response= requestParams.toString() +" Maximum Hits:" +maxHits;
		            return ResponseEntity.ok(response);
		        } else {
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving statistics");
		        }
		  }
		  catch (Exception ex) {
			  System.out.println(ex);
			  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving statistics");
		  }
		 
	    }
}
