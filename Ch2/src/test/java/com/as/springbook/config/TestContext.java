/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @author komatsu
 *
 */
@Configuration
public class TestContext {

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
}
