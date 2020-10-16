package com.andromotica.petagram.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.andromotica.petagram.R;
import com.andromotica.petagram.presentador.IPresentadorNotificaciones;
import com.andromotica.petagram.presentador.PersentadorNotificaciones;
import com.andromotica.petagram.restApi.EndpointApi;
import com.andromotica.petagram.restApi.adapter.RestApiAdapter;
import com.andromotica.petagram.restApi.model.RegistroResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecibirNotificacionesActivity extends AppCompatActivity implements IRecibirNotificacionesActivity {
    private IPresentadorNotificaciones iPresentadorNotificaciones;
    private TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibir_notificaciones);
        username = findViewById(R.id.username);

        iPresentadorNotificaciones = new PersentadorNotificaciones(this);
        recibirToken();
    }

    @Override
    public void recibirToken() {

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w("token", "getInstanceId failed", task.getException());
                            return;
                        }
                        // Get new Instance ID token
                        String token = task.getResult().getToken();
                        iPresentadorNotificaciones = new PersentadorNotificaciones(token,username);
                        //iPresentadorNotificaciones.registrarDispositivo(token);
                        // Log and toast
                        //String msg = getString(R.string.msg_token_fmt, token);
                        Log.d("token", token);
                        // Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }

}