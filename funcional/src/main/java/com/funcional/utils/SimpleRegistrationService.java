package com.funcional.utils;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.naming.Context;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.funcional.model.Profile;

public class SimpleRegistrationService {
	
	private JavaMailSender mailSender;
	private VelocityEngineUtils velocityEngine;
	
	public void setJavaMailSender (JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void setVelocutyEngineUtils(VelocityEngineUtils velocityEngine) {
		this.velocityEngine = velocityEngine;
	}
	
	public void registrer (Profile profile) {
		sendConfirmationEmail(profile);
	}

	 private void sendConfirmationEmail(final Profile profile) {
         MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
               message.setTo(profile.getEmail());
               message.setSubject("Confirmação de cadastro");
               message.setFrom("MyImage.com");
               Map<Object, Object> model = new HashMap<Object, Object>();
               model.put("profile", profile);
               model.put("context", Context.getContextPath());
               String text = VelocityEngineUtils.mergeTemplateIntoString(
               velocityEngine, "template/registration-confirmation.vm", model);
               message.setText(text, true);
            }
         };
         this.mailSender.send(preparator);
}
