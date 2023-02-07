package com.ltmg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Singleton;

@Singleton
public class FallbackEmailDigestService implements EmailDigestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FallbackEmailDigestService.class);

    public void sendEmail(String email) {
        LOGGER.info("Sending email to {}", email);
    }

}