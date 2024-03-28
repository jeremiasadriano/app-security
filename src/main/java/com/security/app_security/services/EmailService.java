package com.security.app_security.services;

import com.security.app_security.models.infra.EmailModel;

public interface EmailService {
    void sendEmail(EmailModel emailModel);
}
