package com.batuta.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.batuta.config.database.PersistenceConfig;
import com.batuta.config.security.SecurityConfig;

@Configuration
@ComponentScan(basePackageClasses = {PersistenceConfig.class, SecurityConfig.class})
public class RootContextConfig {

}
