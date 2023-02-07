package com.ltmg;

import com.agorapulse.worker.annotation.Cron;
import com.agorapulse.worker.annotation.FixedRate;
import jakarta.inject.Singleton;

import java.util.Collections;

@Singleton
public class EmailDigestDistributedJob {

    private final EmailDigestService emailDigestService;

    public EmailDigestDistributedJob(EmailDigestService emailDigestService) {
        this.emailDigestService = emailDigestService;
    }

    @Cron("45 6 * * *")
    public Iterable<String> generateEmailsForDigest() {
        return Collections.singleton("user@example.com");
    }

    @FixedRate("1s")
    public void sendEmail(String email) {
        emailDigestService.sendEmail(email);
    }

}