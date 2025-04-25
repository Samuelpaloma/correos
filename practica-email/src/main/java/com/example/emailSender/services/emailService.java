package com.example.emailSender.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {

    @Autowired
    private JavaMailSender javaMailSender;

    // Método para enviar correo de bienvenida
    public void newAccountEmail(String addressMail) {
        String subject = "Holiiii";
        String bodyMail = """
                 <!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <style>
    body {
      font-family: Arial, sans-serif;
      background: #f9fafc;
      margin: 0;
      padding: 0;
      color: #333;
    }
    .email-container {
      max-width: 600px;
      margin: 40px auto;
      background: #fff;
      border-radius: 8px;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
      border: 1px solid #e5e7eb;
      overflow: hidden;
    }
    .header {
      background:rgb(74, 226, 74);
      color: #fff;
      padding: 20px;
      text-align: center;
    }
    .content {
      padding: 20px;
      line-height: 1.6;
    }
    .footer {
      background: #f4f4f5;
      padding: 10px;
      font-size: 12px;
      text-align: center;
      color: #6b7280;
    }
    .btn {
      display: inline-block;
      margin-top: 20px;
      padding: 12px 20px;
      background:rgb(57, 122, 37);
      color: #fff;
      text-decoration: none;
      border-radius: 6px;
      font-weight: bold;
      transition: 0.3s;
    }
    .btn:hover {
      background:rgb(26, 121, 138);
    }
  </style>
</head>
<body>
  <div class="email-container">
    <div class="header">
      <h1>¡Bienvenido!</h1>
    </div>
    <div class="content">
      <h2>Good</h2>
      <p>Estamos encantados de tenerte en nuestra page. Tu cuenta ha sido creada exitosamente.</p>
      <p>Haz clic en el siguiente botón para acceder a tu cuenta:</p>
      <a href="https://paloma.com/login" class="btn">Iniciar</a>
    </div>
    <div class="footer">
      © 2025 Tu Empresa. Todos los derechos reservados.<br/>
      ¿Preguntas? Contáctanos en soporte@tusitio.com
    </div>
  </div>
</body>
</html>
                """;
        try {
            emailSender(addressMail, subject, bodyMail);
        }  catch (Exception e) {
        
        }
    }

    // Método para enviar correo de recuperación de contraseña
    public void forgotPasswordEmail(String addressMail, String resetLink) {
        String subject = "Recupera tu contraseña";
        String bodyMail = """
                <!DOCTYPE html>
                <html lang="es">
                <head>
                  <meta charset="UTF-8">
                  <style>
                    body {
                      font-family: 'Arial', sans-serif;
                      background: #f3f4f6;
                      margin: 0;
                      padding: 0;
                    }
                    .email-container {
                      max-width: 600px;
                      margin: 40px auto;
                      background: #ffffff;
                      border-radius: 10px;
                      box-shadow: 0 4px 15px rgba(245, 113, 113, 0.1);
                      overflow: hidden;
                    }
                    .header {
                      background-color: #FF6F61;
                      color: white;
                      padding: 20px;
                      text-align: center;
                    }
                    .content {
                      padding: 20px;
                      color:rgb(128, 11, 11);
                      line-height: 1.6;
                    }
                    .btn {
                      display: inline-block;
                      margin-top: 20px;
                      padding: 10px 15px;
                      background-color:rgb(206, 35, 19);
                      color: white;
                      text-decoration: none;
                      border-radius: 5px;
                    }
                  </style>
                </head>
                <body>
                  <div class="email-container">
                    <div class="header">
                      <h1>Recuperación de Contraseña</h1>
                    </div>
                    <div class="content">
                      <p>Holii</p>
                      <p>Hemos recibido una solicitud para restablecer tu contraseña. Por favor, haz clic en el botón de abajo para cambiar la password.</p>
                      <a href="%s" class="btn">Restablecer contraseña</a>
                    </div>
                    <div class="footer">
                      Si no solicitaste este correo, ignóraloooo o contacta con soportee.
                    </div>
                  </div>
                </body>
                </html>
                """.formatted(resetLink);
        try {
            emailSender(addressMail, subject, bodyMail);
        } catch (Exception e) {
            
        }
    }

    // Método para enviar correo con código de verificación quemado
    public void sendVerificationCodeEmail(String addressMail) {
        String subject = "Código de Verificación";
        String bodyMail = """
                <!DOCTYPE html>
                <html lang="es">
                <head>
                  <meta charset="UTF-8">
                  <style>
                    body {
                      font-family: 'Arial', sans-serif;
                      background: #f3f4f6;
                      margin: 0;
                      padding: 0;
                    }
                    .email-container {
                      max-width: 600px;
                      margin: 40px auto;
                      background: #ffffff;
                      border-radius: 10px;
                      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
                      overflow: hidden;
                    }
                    .header {
                      background-color:rgb(4, 156, 9);
                      color: white;
                      padding: 20px;
                      text-align: center;
                    }
                    .content {
                      padding: 20px;
                      color:rgb(133, 24, 24);
                      line-height: 1.6;
                    }
                    .footer {
                      background-color: #f7f7f7;
                      padding: 10px;
                      font-size: 12px;
                      text-align: center;
                      color:rgb(133, 113, 113);
                    }
                  </style>
                </head>
                <body>
                  <div class="email-container">
                    <div class="header">
                      <h1>Tu Código de Verificación</h1>
                    </div>
                    <div class="content">
                      <p>Hol</p>
                      <p>Tu código de verificación es:</p>
                      <h2 style="color: #4CAF50;">45649</h2>
                      <p>Por favor, ingresa este código en la page para continuar.</p>
                    </div>
                    <div class="footer">
                      © 2025 Tu Empresa. Todos los derechos reservados.
                    </div>
                  </div>
                </body>
                </html>
                """;
        try {
            emailSender(addressMail, subject, bodyMail);
        } catch (Exception e) {

        }
    }

    // Método para enviar correo de confirmación de cambio de contraseña
    public void sendPasswordChangedEmail(String addressMail) {
        String subject = "Tu contraseña ha sido cambiada xitosamente";
        String bodyMail = """
                <!DOCTYPE html>
                <html lang="es">
                <head>
                  <meta charset="UTF-8">
                  <style>
                    body {
                      font-family: 'Arial', sans-serif;
                      background: #f3f4f6;
                      margin: 0;
                      padding: 0;
                    }
                    .email-container {
                      max-width: 600px;
                      margin: 40px auto;
                      background: #ffffff;
                      border-radius: 10px;
                      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
                      overflow: hidden;
                    }
                    .header {
                      background-color:rgb(192, 147, 80);
                      color: white;
                      padding: 20px;
                      text-align: center;
                    }
                    .content {
                      padding: 20px;
                      color:rgb(150, 49, 49);
                      line-height: 1.6;
                    }
                    .footer {
                      background-color: #f7f7f7;
                      padding: 10px;
                      font-size: 12px;
                      text-align: center;
                      color: #999999;
                    }
                  </style>
                </head>
                <body>
                  <div class="email-container">
                    <div class="header">
                      <h1>¡Cambio de Contraseña Exitoso!</h1>
                    </div>
                    <div class="content">
                      <p>Hol</p>
                      <p>Tu contraseña ha sido cambiada exitosamente. Si no realizaste este cambio, por favor contacta a nuestro soporte inmediatamente.</p>
                    </div>
                    <div class="footer">
                      © 2025 Tu Empresa. Todos los derechos reservados.
                    </div>
                  </div>
                </body>
                </html>
                """;
        try {
            emailSender(addressMail, subject, bodyMail);
        } catch (Exception e) {

        }
    }

    // Método para enviar correo cuando un producto está en stock
    public void sendProductInStockEmail(String addressMail) {
        String subject = "Producto Disponible  Stock";
        String bodyMail = """
                <!DOCTYPE html>
                <html lang="es">
                <head>
                  <meta charset="UTF-8">
                  <style>
                    body {
                      font-family: 'Arial', sans-serif;
                      background: #f3f4f6;
                      margin: 0;
                      padding: 0;
                    }
                    .email-container {
                      max-width: 600px;
                      margin: 40px auto;
                      background: #ffffff;
                      border-radius: 10px;
                      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
                      overflow: hidden;
                    }
                    .header {
                      background-color:rgb(45, 156, 73);
                      color: white;
                      padding: 20px;
                      text-align: center;
                    }
                    .content {
                      padding: 20px;
                      color:rgb(150, 31, 31);
                      line-height: 1.6;
                    }
                    .btn {
                      display: inline-block;
                      margin-top: 20px;
                      padding: 10px 15px;
                      background-color:rgb(11, 139, 65);
                      color: white;
                      text-decoration: none;
                      border-radius: 5px;
                    }
                  </style>
                </head>
                <body>
                  <div class="email-container">
                    <div class="header">
                      <h1>¡Producto en Stock!</h1>
                    </div>
                    <div class="content">
                      <p>Hola</p>
                      <p>El producto que estabas esperando ya está disponible en stock. ¡No pierdas la oportunidad de adquirirloooooooo!</p>
                      <a href="https://paloma.com/producto" class="btn">Ver Producto</a>
                    </div>
                    <div class="footer">
                      © 2025 Tu Empresa. Todos los derechos reservados.
                    </div>
                  </div>
                </body>
                </html>
                """;
        try {
            emailSender(addressMail, subject, bodyMail);
        } catch (Exception e) {
        }
    }

    // Método para enviar correo de confirmación de compra
    public void sendShoppingConfirmationEmail(String addressMail) {
        String subject = "Gracias por tu compreishon";
        String bodyMail = """
                <!DOCTYPE html>
                <html lang="es">
                <head>
                  <meta charset="UTF-8">
                  <style>
                    body {
                      font-family: 'Arial', sans-serif;
                      background: #f3f4f6;
                      margin: 0;
                      padding: 0;
                    }
                    .email-container {
                      max-width: 600px;
                      margin: 40px auto;
                      background: #ffffff;
                      border-radius: 10px;
                      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
                      overflow: hidden;
                    }
                    .header {
                      background-color:rgb(72, 224, 108);
                      color: white;
                      padding: 20px;
                      text-align: center;
                    }
                    .content {
                      padding: 20px;
                      color:rgb(126, 10, 10);
                      line-height: 1.6;
                    }
                    .footer {
                      background-color: #f7f7f7;
                      padding: 10px;
                      font-size: 12px;
                      text-align: center;
                      color:rgb(150, 127, 127);
                    }
                  </style>
                </head>
                <body>
                  <div class="email-container">
                    <div class="header">
                      <h1>¡Compra Exitosa!</h1>
                    </div>
                    <div class="content">
                      <p>Hellooo</p>
                      <p>Gracias por tu compra. Tu pedido se ha procesado exitosamente y pronto te llegará a tu penthouse.</p>
                    </div>
                    <div class="footer">
                      © 2025 Tu Empresa. Todos los derechos reservados.
                    </div>
                  </div>
                </body>
                </html>
                """;
        try {
            emailSender(addressMail, subject, bodyMail);
        } catch (Exception e) {

        }
    }

    // Método genérico para enviar correos
    public boolean emailSender(String addressMail, String subject, String bodyMail) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(addressMail);
            helper.setSubject(subject);
            helper.setText(bodyMail, true); // true para HTML
            javaMailSender.send(message);
            return true;
        } catch (MessagingException e) {
            System.out.println("Error al enviar correo: " + e.getMessage());
            return false;
        }
    }
}