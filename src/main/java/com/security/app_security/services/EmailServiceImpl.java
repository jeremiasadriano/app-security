package com.security.app_security.services;

import com.security.app_security.models.infra.EmailModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    @Override
    public void sendEmail(EmailModel emailModel) {

    }
}
