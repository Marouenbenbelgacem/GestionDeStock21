package org.sid.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthentificationResponse {

	private String accessToken;
	
}
