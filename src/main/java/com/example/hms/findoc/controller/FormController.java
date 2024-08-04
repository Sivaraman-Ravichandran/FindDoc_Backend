package com.example.hms.findoc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class FormController {
    @Autowired
    JavaMailSender mailSender;
    @PostMapping("/send")
    public String sendEmail(@RequestBody ContactForm contactForm) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("disruptorstech@gmail.com");
        message.setSubject("New Contact Form Submission");
        //  message.setText("Name: " + contactForm.getName() + "\nEmail: " + contactForm.getEmail() + "\nPhone Number: " + contactForm.getPhone());
        String emailContent = String.format(
                "Dear Admin,%n%n" +
                        "You have received a new contact form submission. Here are the details:%n%n" +
                        "Name: %s%n" +
                        "Email: %s%n" +
                        "Phone: %s%n%n" +
                        "Please reach out to the individual at your earliest convenience.%n%n" +
                        "Best Regards,%n" +
                        "Amazing Hospitals",
                contactForm.getName(), contactForm.getEmail(), contactForm.getPhone()
        );

        message.setText(emailContent);
        mailSender.send(message);
        return "Email Sent Successfully";
    }
    public static class ContactForm {
        private String name;
        private String email;
        private String phone;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}