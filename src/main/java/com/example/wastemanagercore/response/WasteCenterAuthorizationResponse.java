package com.example.wastemanagercore.response;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class WasteCenterAuthorizationResponse {
	
	 @Getter @Setter private Long id;
	 @Getter @Setter private String authorizationNumber;
	 @Getter @Setter private Long wasteManagerId;

}
