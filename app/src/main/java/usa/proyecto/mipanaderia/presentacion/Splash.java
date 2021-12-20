package usa.proyecto.mipanaderia.presentacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

import usa.proyecto.mipanaderia.R;

public class Splash extends AppCompatActivity {

    ProgressBar progressBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 5000);

        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        Drawable draw=getResources().getDrawable(R.drawable.custom_progess);
        progressBar.setProgressDrawable(draw);
        progressBar.setVisibility(View.VISIBLE);

    }




}