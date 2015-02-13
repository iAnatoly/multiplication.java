package com.iAnatoly.multiplication.helpers;

import com.iAnatoly.multiplication.Config.Config;
import java.security.Security;
import java.util.Properties;

/*import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/


public class EmailHelper
{
    private Config config;
    public EmailHelper(Config config)
    {
        this.config = config;
    }
/*
    private static String prepareMessage(String result)
    {
        // -- Create a new message --
        final MimeMessage msg = new MimeMessage(session);

        // -- Set the FROM and TO fields --
        msg.setFrom(new InternetAddress(username + "@gmail.com"));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, false));

        if (ccEmail.length() > 0) {
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail, false));
        }

        msg.setSubject(title);
        msg.setText(message, "utf-8");
        msg.setSentDate(new Date());
    }

    public void sendEmail(String result)
    {
        String message = this.prepareMessage(result);
    }
    public static void Send(final String username, final String password, String recipientEmail, String ccEmail, String title, String message) throws AddressException, MessagingException {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtps.auth", "true");

        /*
        If set to false, the QUIT command is sent and the connection is immediately closed. If set
        to true (the default), causes the transport to wait for the response to the QUIT command.

        ref :   http://java.sun.com/products/javamail/javadocs/com/sun/mail/smtp/package-summary.html
                http://forum.java.sun.com/thread.jspa?threadID=5205249
                smtpsend.java - demo program from javamail
        */
/*
        props.put("mail.smtps.quitwait", "false");

        Session session = Session.getInstance(props, null);



        SMTPTransport t = (SMTPTransport)session.getTransport("smtps");

        t.connect("smtp.gmail.com", username, password);
        t.sendMessage(msg, msg.getAllRecipients());
        t.close();
    }*/
}
/*
class EmailHelper:
	def __init__(self,config):
		self.config = config

	def prepareMessage(self,result,mode):
		msg = MIMEText(result,'plain');
		msg['Subject'] = '{0} report at {1}'.format(mode,datetime.now());
		msg['From'] = "'{0} Report' <{1}>".format(mode,self.config.sender);  
		msg['To'] = self.config.recipients;
		return msg;

	def sendEmail(self,result,mode):
		try:
			InputHelper.printNoCR("\nPlease wait - sending report to mom & dad...");
		
			server = smtplib.SMTP(self.config.smtpserver);
			server.set_debuglevel(False);
			server.ehlo();
			if self.config.smtptls:
				server.starttls();
			server.login(self.config.smtpuser, self.config.smtppassword);

			InputHelper.printNoCR('.'); 

			msg = self.prepareMessage(result, mode);
			server.sendmail(self.config.sender,self.config.recipients, msg.as_string());

			InputHelper.printNoCR('.'); 
			
			server.quit();
			print "done.\n";

		except Exception as e:
			print "\nError sending out email: {0}.".format(e);
		
*/