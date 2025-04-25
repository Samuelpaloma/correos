package com.example.emailSender.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emailSender.services.emailService;

@RestController
@RequestMapping("/api/v1/email") // Prefijo global para las rutas
public class emailController {

    @Autowired
    private emailService emailService;

    @GetMapping("/sendNewAccountEmail/{email}")
    public ResponseEntity<String> sendNewAccountEmail(@PathVariable String email) {
        try {
            emailService.newAccountEmail(email);
            return ResponseEntity.ok("Correo de cuenta nueva enviado con éxito!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("rror al enviar el correo de cuenta nueva: " + e.getMessage());
        }
    }

    @GetMapping("/sendForgotPasswordEmail/{email}")
    public ResponseEntity<String> sendForgotPasswordEmail(@PathVariable String email) {
        try {
            emailService.forgotPasswordEmail(email, "https://tusitio.com/reset-password?token=exampleToken");
            return ResponseEntity.ok("Correo de recuperación de contraseña enviado con éxito!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("rror al enviar el correo de recuperación de contraseña: " + e.getMessage());
        }
    }

    @GetMapping("/sendVerificationCodeEmail/{email}")
    public ResponseEntity<String> sendVerificationCodeEmail(@PathVariable String email) {
        try {
            emailService.sendVerificationCodeEmail(email);
            return ResponseEntity.ok("Correo con código de verificación enviado con éxito!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("rror al enviar el correo con código de verificación: " + e.getMessage());
        }
    }

    @GetMapping("/sendChangedPasswordEmail/{email}")
    public ResponseEntity<String> sendChangedPasswordEmail(@PathVariable String email) {
        try {
            emailService.sendPasswordChangedEmail(email);
            return ResponseEntity.ok("Correo de cambio de contraseña  con éxito!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al enviar el correo de cambio de contraseña: " + e.getMessage());
        }
    }

    @GetMapping("/sendStockUpdateEmail/{email}")
    public ResponseEntity<String> sendStockUpdateEmail(@PathVariable String email) {
        try {
            emailService.sendProductInStockEmail(email);
            return ResponseEntity.ok("Correo de actualización de stock enviado con éxito!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al enviar el correo de actualización de stock: " + e.getMessage());
        }
    }

    @GetMapping("/sendShoppingConfirmationEmail/{email}")
    public ResponseEntity<String> sendShoppingConfirmationEmail(@PathVariable String email) {
        try {
            emailService.sendShoppingConfirmationEmail(email);
            return ResponseEntity.ok("Correo de confirmación de compra enviado con éxito!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(" Error al enviar el correo de confirmación de compra: " + e.getMessage());
        }
    }
}