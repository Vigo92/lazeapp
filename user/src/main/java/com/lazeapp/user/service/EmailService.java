package com.lazeapp.user.service;

import javax.mail.MessagingException;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 21/10/2022
 **/
public interface EmailService {


    void sendEmail(String recipient, String message) throws MessagingException;
}
