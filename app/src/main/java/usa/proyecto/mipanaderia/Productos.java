package usa.proyecto.mipanaderia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class Productos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.pan10, getTheme());

        ImageView pan1 = findViewById(R.id.pan1);
        pan1.setImageDrawable(drawable);
    }
}