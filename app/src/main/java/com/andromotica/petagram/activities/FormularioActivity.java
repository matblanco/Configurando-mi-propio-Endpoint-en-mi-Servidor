package com.andromotica.petagram.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.andromotica.petagram.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class FormularioActivity extends AppCompatActivity {

    String correo;
    String contraseña;

    EditText nombre;
    EditText correousuario;
    EditText mensaje;
    Button enviar;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        nombre = findViewById(R.id.etNombre);
        correousuario = findViewById(R.id.etCorreo);
        mensaje = findViewById(R.id.etMensaje);
        enviar = findViewById(R.id.btnEnviar);

        // correo y contrasela para validar
        correo = "Amigo que esta revisando esta app aca pones tu correo para validar el envio de correo";
        contraseña = "Amigo que esta revisando esta tarea aca pones tu contraseña para validar el envio de correo";

        if(correo == "Amigo que esta revisando esta app aca pones tu correo para validar el envio de correo"){
            Toast.makeText(this, "recuerda poner tu correo antes de compilar en la actividad formulario para verificar el buen funcionamiento de mi app", Toast.LENGTH_SHORT).show();
        }else {
            enviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    Properties properties = new Properties();
                    properties.put("mail.smtp.host","smtp.googlemail.com");
                    properties.put("mail.smtp.socketFatory.port","465");
                    properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                    properties.put("mail.smtp.auth","true");
                    properties.put("mail.smtp.port","465");

                    try {

                        session = Session.getInstance(properties, new Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(correo, contraseña);
                            }
                        });

                        if (session != null){
                            Message message = new MimeMessage(session);
                            message.setFrom(new InternetAddress(correo));
                            message.setSubject("Pentagram");
                            message.setRecipient(Message.RecipientType.TO, new InternetAddress(correousuario.getText().toString()));
                            message.setContent(mensaje.getText().toString(), "text/html; chartset=utf-8");
                            Transport.send(message);
                        }

                        nombre.setText("");
                        correousuario.setText("");
                        mensaje.setText("");
                        Toast.makeText(getApplication(),"Se anvio correo", Toast.LENGTH_SHORT).show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}