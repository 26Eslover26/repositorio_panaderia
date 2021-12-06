package usa.proyecto.mipanaderia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class Productos extends AppCompatActivity {

    Drawable drawable, drawable1, drawable2, drawable3;
    ImageView pan1, pan2, pan3, pan4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        Resources res = getResources();
        drawable = res.getDrawable(R.drawable.pan10, getTheme());
        pan1 = findViewById(R.id.domicilio1);
        pan1.setImageDrawable(drawable);

        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.pan20, getTheme());
        pan2 = findViewById(R.id.buffet1);
        pan2.setImageDrawable(drawable1);

        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.pan30, getTheme());
        pan3 = findViewById(R.id.desayuno1);
        pan3.setImageDrawable(drawable2);

        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.pan40, getTheme());
        pan4 = findViewById(R.id.pastel1);
        pan4.setImageDrawable(drawable3);
    }
}