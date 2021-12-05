package usa.proyecto.mipanaderia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;


public class Servicios extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.buffet, getTheme());

        ImageView buffet1 = findViewById(R.id.buffet1);
        buffet1.setImageDrawable(drawable);



    }
}