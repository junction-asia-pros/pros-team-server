package com.pros.pick.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
		info = @Info(title = "App",
				description = "개발 API",
				version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

	private static final String API_NAME = "Swagger Test API";
	private static final String API_VERSION = "1.0";
	private static final String API_DESCRIPTION = "Swagger API 명세서";

	@Bean
	public GroupedOpenApi chatOpenApi() {
		String[] paths = {"/*","/**"};

		return GroupedOpenApi.builder()
				.group("API v1")
				.pathsToMatch(paths)
				.build();
	}
}
