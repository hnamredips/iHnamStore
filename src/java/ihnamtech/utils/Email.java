/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihnamtech.utils;

/**
 *
 * @author LENOVO
 */
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author LENOVO
 */
public class Email {
    // Email: namnhse171194@fpt.edu.vn
    // Password: zgxejyvjbsdcohvi

    private static final String EMAIL = "nghnam265@gmail.com";
    private static final String PASSWORD = "09FF56B8A33AEB61D99185995E0B56FC7E2B";

    public static boolean sendEmail(String to, String title, String content) {
        String from = EMAIL;
        String password = PASSWORD;
        // Properties : khai báo các thuộc tính
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.elasticemail.com"); // SMTP HOST
        props.put("mail.smtp.port", "2525"); 
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // create Authenticator
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // TODO Auto-generated method stub
                return new PasswordAuthentication(from, password);
            }
        };

        // Phiên làm việc
        Session session = Session.getInstance(props, auth);

        // Tạo một tin nhắn
        MimeMessage msg = new MimeMessage(session);

        try {
            // Kiểu nội dung
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");

            // Người gửi
            msg.setFrom(from);

            // Người nhận
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            // Tiêu đề email
            msg.setSubject(title);

            // Quy đinh ngày gửi
            msg.setSentDate(new Date());

            // Quy định email nhận phản hồi
            // msg.setReplyTo(InternetAddress.parse(from, false))
            // Nội dung
            msg.setContent(content, "text/HTML; charset=UTF-8");

            // Gửi email
            Transport.send(msg);
            System.out.println("Gửi email thành công");
            return true;
        } catch (Exception e) {
            System.out.println("Gặp lỗi trong quá trình gửi email");
            e.printStackTrace();
            return false;
        }
    }


    public static String templateEmail(String username, String email) {
    return "<!DOCTYPE html>\n"
            + "<html>\n"
            + "<head>\n"
            + "    <meta charset=\"UTF-8\">\n"
            + "    <title>Email Template</title>\n"
            + "    <style>\n"
            + "        body {\n"
            + "            font-family: Arial, sans-serif;\n"
            + "            background-color: #f6f6f6;\n"
            + "        }\n"
            + "        .container {\n"
            + "            max-width: 600px;\n"
            + "            margin: 0 auto;\n"
            + "            padding: 20px;\n"
            + "            background-color: #ffffff;\n"
            + "        }\n"
            + "        h1 {\n"
            + "            color: #333333;\n"
            + "            text-align: center;\n"
            + "        }\n"
            + "        table {\n"
            + "            width: 100%;\n"
            + "            margin-bottom: 20px;\n"
            + "            border-collapse: collapse;\n"
            + "        }\n"
            + "        td {\n"
            + "            padding: 10px;\n"
            + "            border: 1px solid #dddddd;\n"
            + "        }\n"
            + "        td:first-child {\n"
            + "            font-weight: bold;\n"
            + "        }\n"
            + "        p {\n"
            + "            line-height: 1.5;\n"
            + "            margin-bottom: 15px;\n"
            + "        }\n"
            + "        .footer {\n"
            + "            color: #888888;\n"
            + "            font-size: 12px;\n"
            + "            text-align: center;\n"
            + "            margin-top: 30px;\n"
            + "        }\n"
            + "    </style>\n"
            + "</head>\n"
            + "<body>\n"
            + "    <div class=\"container\">\n"
            + "        <h1>Welcome to iHnamTech!</h1>\n"
            + "        <p>Dear " + username + ",</p>\n"
            + "        <p>Thank you for signing up. Your registration is successful.</p>\n"
            + "        <p>Please find below your login details:</p>\n"
            + "        <table>\n"
            + "            <tr>\n"
            + "                <td><strong>Username:</strong></td>\n"
            + "                <td>" + username + "</td>\n"
            + "            </tr>\n"
            + "            <tr>\n"
            + "                <td><strong>Email:</strong></td>\n"
            + "                <td>" + email + "</td>\n"
            + "            </tr>\n"
            + "        </table>\n"
            + "        <p>You can now log in to our website using the provided credentials.</p>\n"
            + "        <p class=\"footer\">\n"
            + "            Best regards,<br>\n"
            + "            The Website Team\n"
            + "        </p>\n"
            + "    </div>\n"
            + "</body>\n"
            + "</html>";
}

}

