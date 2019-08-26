package com.huang.pims.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.huang.pims.**.repository")
public class JpaConfiguration {
}
