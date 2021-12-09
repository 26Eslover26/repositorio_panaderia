package usa.proyecto.mipanaderia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;


public class Servicios extends AppCompatActivity {

    Drawable drawable, drawable1, drawable2, drawable3;
    ImageView buffet1, desayuno1, pastel1, domicilio1;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_gingerbread);

        Resources res = getResources();
        drawable = res.getDrawable(R.drawable.buffet, getTheme());
        buffet1 = findViewById(R.id.domicilio1);
        buffet1.setImageDrawable(drawable);

        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.desayuno, getTheme());
        desayuno1 = findViewById(R.id.buffet1);
        desayuno1.setImageDrawable(drawable1);

        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.pastel, getTheme());
        pastel1 = findViewById(R.id.desayuno1);
        pastel1.setImageDrawable(drawable2);

        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.domicilio, getTheme());
        domicilio1 = findViewById(R.id.pastel1);
        domicilio1.setImageDrawable(drawable3);


    }
}