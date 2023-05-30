package com.example.kplc2

import java.util.Properties
import javax.mail.Message
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

object EmailSender {
    fun sendEmail(report: PowerOutageReport) {
        val properties = Properties().apply {
            put("mail.smtp.host", "your_host_name") //  SMTP server host name
            put("mail.smtp.port", "your_port_number") //SMTP server port number
                                              //  To Add any additional properties as needed
        }

        val session = Session.getDefaultInstance(properties)

        try {
            val message = MimeMessage(session).apply {
                setFrom(InternetAddress("your_email_address")) // Replace with your email address
                addRecipient(Message.RecipientType.TO, InternetAddress("admin_email_address")) // Replace with your admin email address
                subject = "Power Outage Report"
                setText("Location: ${report.location}\nDescription: ${report.description}")
            }

            Transport.send(message)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
