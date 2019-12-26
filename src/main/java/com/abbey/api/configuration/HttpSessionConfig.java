package com.abbey.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.session.data.mongo.JdkMongoSessionConverter;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;
import org.springframework.session.web.http.DefaultCookieSerializer;

import java.time.Duration;

@EnableMongoHttpSession
public class HttpSessionConfig {

    private int maxAgeInMinutes = 20;

    @Bean
    public JdkMongoSessionConverter jdkMongoSessionConverter() {
        return new JdkMongoSessionConverter(Duration.ofMinutes(this.maxAgeInMinutes));
    }

    @Bean
    public DefaultCookieSerializer customCookieSerializer() {
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();

        cookieSerializer.setCookieName("ABBEY-SESSION");
        cookieSerializer.setCookieMaxAge(1000 * 60 * this.maxAgeInMinutes);

        return cookieSerializer;
    }

}
