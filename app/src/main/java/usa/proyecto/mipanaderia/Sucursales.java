package usa.proyecto.mipanaderia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

public class Sucursales extends AppCompatActivity {

    Drawable drawable1, drawable2, drawable3;
    ImageView desayuno1, pastel1, domicilio1;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucursales);

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_gingerbread);

        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.foto_centro, getTheme());
        desayuno1 = findViewById(R.id.sucImage1);
        desayuno1.setImageDrawable(drawable1);

        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.foto_kennedy, getTheme());
        pastel1 = findViewById(R.id.sucImage2);
        pastel1.setImageDrawable(drawable2);

        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.foto_chico, getTheme());
        domicilio1 = findViewById(R.id.sucImage3);
        domicilio1.setImageDrawable(drawable3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.productosId){
            Intent pantallaProductos = new Intent(this, Productos.class);
            startActivity(pantallaProductos);
        }
        if(id == R.id.serviciosId){
            Intent pantallaServicios = new Intent(this, Servicios.class);
            startActivity(pantallaServicios);
        }
        return super.onOptionsItemSelected(item);
    }
}